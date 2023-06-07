package koval.mobile.myfitnesspal.service.enums;

public enum Filters {
    FREE("Free"),

    WALKING("Walking"),

    NUTRITION("Nutrition");


    public final String filters;

    Filters(String filters) {
        this.filters = filters;
    }


    public String getFilters() {
        return filters;
    }

}
