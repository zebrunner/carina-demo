package koval.mobile.myfitnesspal.service.enums;

import com.zebrunner.carina.utils.resources.L10N;

public enum Meals {
    BREAKFAST(L10N.getText("breakfast"), 0),
    LUNCH(L10N.getText("lunch"), 1),
    DINNER(L10N.getText("dinner"), 2),
    SNACKS(L10N.getText("snacks"), 3);


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
