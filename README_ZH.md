# 华为分析服务SDK HarmonyOS版本示例代码


## 目录

* [简介](#简介)
* [快速入门](#快速入门)
* [安装](#安装)
* [配置](#配置)
* [环境要求](#环境要求)
* [操作结果](#操作结果)
* [授权许可](#授权许可)


## 简介
AnalyticsKitDemo提供了华为分析服务（HUAWEI Analytics Kit）与`Hap`集成的示例代码。其演示了如何通过收集预定义事件和自定义事件以提高用户参与度和用户偏好。
[了解更多有关Hianalytics的信息](https://developer.huawei.com/consumer/cn/doc/development/HMSCore-Guides-V5/introduction-0000001050745149-V5).

## 快速入门

更多开发指导，请参考以下链接文档：

[开发指南](https://developer.huawei.com/consumer/cn/doc/development/HMSCore-Guides-V5/introduction-0000001050745149-V5)。

[API参考](https://developer.huawei.com/consumer/cn/doc/development/HMSCore-References-V5/overview-0000001077819400-V5)。

AnalyticsKitDemo以Gradle构建系统为例演示了如何使用HarmonyOS分析服务SDK。

首先，我们通过克隆此仓库或下载压缩包的方式来下载AnalyticsKitDemo。

在HUAWEI DevEco Studio中，点击“Open project”，选择“AnalyticsKitDemo”。

您可以直接运行gradlew build命令构建工程。

您需要在AppGallery Connect中创建应用，获取agconnect-services.json文件，并将文件添加到项目中。此外，您还需要生成签名证书指纹，在项目中添加证书文件，并将配置添加到build.gradle文件中。[进一步了解开发流程](https://developer.huawei.com/consumer/cn/doc/development/HMSCore-Guides-V5/introduction-0000001050745149-V5).


## 安装
使用HUAWEI DevEco Studio打开解压后的工程。

## 配置
1. 在AppGallery Connect中创建应用，并获取项目配置文件agconnect-services.json。在HUAWEI DevEco Studio中，切换到Project视图，将agconnect-services.json文件移动到`entry`的根目录下。
2. 修改`entry`的config.json文件中的`bundleName`为上一步申请的`Hap`包名。

## 环境要求
硬件要求：
1. 电脑（台式机或笔记本）
2. 华为手机，用于应用调试

软件要求：
1. 华为分析服务6.2.0
2. 适配HarmonyOS 2.0.0（API Level 4）及以上版本的设备
3. HUAWEI DevEco Studio
4. JDK 1.8及以上

## 操作结果
运行该app后，您将会看到如下页面：

<img src="https://github.com/HMS-Core/hms-ananlytics-demo-harmonyos/blob/master/images/screen_0.png" width=250 title="ID Photo DIY" div align=center border=5>

点击“True”或“False” 按钮进行答题；点击“Next” 按钮进入下一道题；点击“Post Score”按钮记录用户获得的分数。所有信息将被上传到Hianalytics控制台，您可以使用Debug View实时查看这些信息。

点击Settings按钮:

<img src="https://github.com/HMS-Core/hms-ananlytics-demo-harmonyos/blob/master/images/screen_1.png" width=250 title="ID Photo DIY" div align=center border=5>

当点击Settings按钮，设置您最喜欢的运动。您的选择将作为用户属性记录到Hianalytics中。

## 授权许可
AnalyticsKitDemo经过[Apache 2.0授权许可](http://www.apache.org/licenses/LICENSE-2.0).
