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
import ohos.agp.components.Button;
import ohos.agp.components.TextField;

// TODO: Import classes from Analytics Kit.
import com.huawei.hms.analytics.HiAnalytics;
import com.huawei.hms.analytics.HiAnalyticsInstance;

public class SettingAbilitySlice extends AbilitySlice {
    private Button btnSave;
    private TextField editFavorSport;
    private String strFavorSport;

    // TODO: Define a variable for the Analytics Kit instance.
    HiAnalyticsInstance instance;

    @Override
    public void onStart(Intent intent) {
        super.onStart(intent);
        super.setUIContent(ResourceTable.Layout_ability_setting);

        // TODO: Generate an Analytics Kit instance.
        instance = HiAnalytics.getInstance(this);

        btnSave = (Button) findComponentById(ResourceTable.Id_save_setting_button);
        editFavorSport = (TextField) findComponentById(ResourceTable.Id_edit_favorite_sport);

        btnSave.setClickedListener(view -> {
            strFavorSport = editFavorSport.getText().trim();
            // TODO: Set users' favorite sport using the setUserProfile API.
            instance.setUserProfile("favor_sport", strFavorSport);
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
}