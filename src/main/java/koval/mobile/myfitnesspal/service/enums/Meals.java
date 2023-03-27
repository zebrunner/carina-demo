package koval.mobile.myfitnesspal.service.enums;

public enum Meals {
    BREAKFAST("Breakfast", 0),
    LUNCH("Lunch", 1),
    DINNER("Dinner", 2),
    SNACKS("Snacks", 3);


    public final String meal;
    public final int mealIndex;

    private static final Meals[] values = values();

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

    public String getNext() {
        return values[(this.ordinal() + 1) % values.length].getMeal();
    }


}
