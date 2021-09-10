/*
 * Copyright 2021. Huawei Technologies Co., Ltd. All rights reserved.

   Licensed under the Apache License, Version 2.0 (the "License");
   you may not use this file except in compliance with the License.
   You may obtain a copy of the License at

     http://www.apache.org/licenses/LICENSE-2.0

   Unless required by applicable law or agreed to in writing, software
   distributed under the License is distributed on an "AS IS" BASIS,
   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
   See the License for the specific language governing permissions and
   limitations under the License.
*/

package com.huawei.hms.analytics.harmonyosdemo.slice;

import com.huawei.hms.analytics.harmonyosdemo.ResourceTable;
import ohos.aafwk.ability.AbilitySlice;
import ohos.aafwk.content.Intent;
import ohos.aafwk.content.Operation;
import ohos.agp.components.Button;
import ohos.agp.components.Text;
import ohos.agp.window.dialog.ToastDialog;
import ohos.utils.PacMap;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

// TODO: Import classes from Analytics Kit.
import com.huawei.hms.analytics.HiAnalytics;
import com.huawei.hms.analytics.HiAnalyticsInstance;
import com.huawei.hms.analytics.HiAnalyticsTools;
import static com.huawei.hms.analytics.type.HAEventType.SUBMITSCORE;
import static com.huawei.hms.analytics.type.HAParamType.SCORE;

public class MainAbilitySlice extends AbilitySlice {

    private Button btnSetting;

    private int[] questions = {ResourceTable.String_q1, ResourceTable.String_q2, ResourceTable.String_q3, ResourceTable.String_q4, ResourceTable.String_q5};
    private boolean[] answers = {true, true, false, false, true};

    private int curQuestionIdx = 0;

    private Text txtQuestion;

    private Button btnNext;

    private Button btnTrue;

    private Button btnFalse;

    private Button postScore;

    private int score = 0;

    // TODO: Define a variable for the Analytics Kit instance.
    HiAnalyticsInstance instance;

    @Override
    public void onStart(Intent intent) {
        super.onStart(intent);
        super.setUIContent(ResourceTable.Layout_ability_main);

        // TODO: Initialize Analytics Kit.
        // Enable Analytics Kit logging.
        HiAnalyticsTools.enableLog();

        // Generate an Analytics Kit instance.
        instance = HiAnalytics.getInstance(this);

        txtQuestion = (Text) findComponentById(ResourceTable.Id_question_text_view);
        txtQuestion.setText(questions[curQuestionIdx]);

        btnSetting = (Button) findComponentById(ResourceTable.Id_setting_button);
        btnSetting.setClickedListener(view -> {
            Intent secondIntent = new Intent();
            Operation operation = new Intent.OperationBuilder()
                    .withDeviceId("")
                    .withBundleName(this.getBundleName())
                    .withAbilityName("com.huawei.hms.analytics.harmonyosdemo.SettingAbility")
                    .build();
            secondIntent.setOperation(operation);
            startAbility(secondIntent);
        });

        btnNext = (Button) findComponentById(ResourceTable.Id_next_button);
        btnNext.setClickedListener(view -> {
            curQuestionIdx = (curQuestionIdx + 1) % questions.length;
            nextQuestion();
        });

        btnTrue = (Button) findComponentById(ResourceTable.Id_true_button);
        btnTrue.setClickedListener(view -> {
            checkAnswer(true);
            reportAnswerEvt("true");
        });

        btnFalse = (Button) findComponentById(ResourceTable.Id_false_button);
        btnFalse.setClickedListener(view -> {
            checkAnswer(false);
            reportAnswerEvt("false");
        });

        postScore = (Button) findComponentById(ResourceTable.Id_post_score_button);
        postScore.setClickedListener(view -> {
            postScore();
        });
    }

    @Override
    public void onActive() {
        super.onActive();
    }

    @Override
    public void onForeground(Intent intent) {
        super.onForeground(intent);
    }

    private void nextQuestion() {
        txtQuestion.setText(questions[curQuestionIdx]);
    }

    private void checkAnswer(boolean answer) {
        if (answer == answers[curQuestionIdx]) {
            score = score + 20;
            new ToastDialog(getApplicationContext()).setText("The answer is correct.").show();
        } else {
            new ToastDialog(getApplicationContext()).setText("The answer is wrong.").show();
        }
    }

    private void reportAnswerEvt(String answer) {
        // TODO: Report a custom event.
        // Event Name: Answer
        // Event Parameters:
        //  -- question: String
        //  -- answer: String
        //  -- answerTime: String

        // Initialize parameters.
        PacMap pacMap = new PacMap();
        pacMap.putString("question", txtQuestion.getText().trim());
        pacMap.putString("answer", answer);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.ENGLISH);
        pacMap.putString("answerTime", sdf.format(new Date()));

        // Report a custom event.
        instance.onEvent("Answer", pacMap);
    }

    private void postScore() {
        // TODO: Report the score by using the SUBMITSCORE event.
        // Initialize parameters.
        PacMap pacMap = new PacMap();
        pacMap.putLongValue(SCORE, score);

        // Report a predefined event.
        instance.onEvent(SUBMITSCORE, pacMap);
    }
}
