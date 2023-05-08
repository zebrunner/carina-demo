package koval.mobile.myfitnesspal.service.enums;


import com.zebrunner.carina.utils.resources.L10N;

public enum TabsFromSearchFoodPage {

    ALL("all"),
    MY_MEALS("my_meals"),
    MY_RECIPES("my_recipes"),
    MY_FOODS("my_foods");


    public final String tabName;

    TabsFromSearchFoodPage(String tabName) {
        this.tabName = tabName;
    }


    public String getTabName() {
        return L10N.getText(tabName);
    }

}
