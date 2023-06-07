package koval.mobile.myfitnesspal.service.enums;

public enum PlansCategory {
    AVAILABLE_PLANS("Available Plans"),

    ACTIVE_PLANS("Active Plans");


    public final String categories;

    PlansCategory(String categories) {
        this.categories = categories;
    }


    public String getPlanCategory() {
        return categories;
    }

}
