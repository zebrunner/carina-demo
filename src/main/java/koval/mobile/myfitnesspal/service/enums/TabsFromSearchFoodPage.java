package koval.mobile.myfitnesspal.service.enums;


public enum TabsFromSearchFoodPage {

    ALL("All"),
    MY_MEALS("My Meals"),
    MY_RECIPES("My Recipes"),
    MY_FOODS("My Foods");


    public final String tabName;

    TabsFromSearchFoodPage(String tabName) {
        this.tabName = tabName;
    }


    public String getTabName() {
        return tabName;
    }

}
