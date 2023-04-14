package koval.mobile.myfitnesspal.service.enums;


public enum AppAndWidgets {
    FITNESSPAL("MyFitnessPal", "Calories", "Macros");

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
