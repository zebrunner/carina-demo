package koval.mobile.myfitnesspal.service.enums;


public enum ActivityLevel {
    NOT_VERY_ACTIVE("NotVeryActive", 0),
    LIGHTLY_ACTIVE("LightlyActive", 1),
    ACTIVE("Active", 2),
    VERY_ACTIVE("VeryActive", 3);


    public final String activityLevel;
    public final int activityIndex;


    ActivityLevel(String activityLevel, int activtyIndex) {
        this.activityLevel = activityLevel;
        this.activityIndex = activtyIndex;
    }


    public String getActivityLevel() {
        return activityLevel;
    }

    public int getActivityIndex() {
        return activityIndex;
    }


}
