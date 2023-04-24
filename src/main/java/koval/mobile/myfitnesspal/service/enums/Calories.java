package koval.mobile.myfitnesspal.service.enums;

public enum Calories {
    CALS_REMAINING(""),

    FOOD("Food"),

    EXERCISE("Exercise");


    public final String caloriesType;

    Calories(String caloriesType) {
        this.caloriesType = caloriesType;
    }


    public String getCaloriesType() {
        return caloriesType;
    }

}
