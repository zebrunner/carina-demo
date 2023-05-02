package koval.mobile.myfitnesspal.service.enums;


import com.zebrunner.carina.utils.resources.L10N;

public enum AppAndWidgets {
    FITNESSPAL("MyFitnessPal", L10N.getText("calories"), "Macros");

    public final String appName;
    public final String firstWidget;
    public final String secondWidget;

    AppAndWidgets(String appName, String firstWidget, String secondWidget) {
        this.appName = appName;
        this.firstWidget = firstWidget;
        this.secondWidget = secondWidget;
    }


    public String getAppName() {
        return appName;
    }

    public String getFirstWidget() {
        return firstWidget;
    }


}
