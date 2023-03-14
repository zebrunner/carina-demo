package koval.mobile.myfitnesspal.service.enums;

public enum Meals {
    BREAKFAST("Breakfast", 0),
    LUNCH("Lunch", 1),
    DINNER("Dinner", 2),
    SNACKS("Snacks", 3);


    public final String meal;
    public final int mealIndex;

    Meals(String meal, int mealIndex) {
        this.meal = meal;
        this.mealIndex = mealIndex;
    }


    public String getMeal() {
        return meal;
    }

    public int getMealIndex() {
        return mealIndex;
    }
}
