package koval.web.myfitnesspal.service.enums;

public enum Meals {

    BREAKFAST("Breakfast"),
    LUNCH("Lunch"),
    DINNER("Dinner"),
    SNACKS("Snacks");

    private final String meal;
    Meals(String meal) {
        this.meal=meal;
    }


    public String getMeal() {
        return meal;
    }
}
