package koval.mobile.myfitnesspal.service.enums;

import com.zebrunner.carina.utils.resources.L10N;

public enum Meals {
    BREAKFAST("breakfast", 0),
    LUNCH("lunch", 1),
    DINNER("dinner", 2),
    SNACKS("snacks", 3);


    public final String meal;
    public final int mealIndex;

    private static final Meals[] values = values();

    Meals(String meal, int mealIndex) {
        this.meal = meal;
        this.mealIndex = mealIndex;
    }


    public String getMeal() {
        return L10N.getText(meal);
    }

    public int getMealIndex() {
        return mealIndex;
    }

    public String getNext() {
        return values[(this.ordinal() + 1) % values.length].getMeal();
    }


}
