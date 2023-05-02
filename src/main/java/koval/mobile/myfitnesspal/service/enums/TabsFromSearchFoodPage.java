package koval.mobile.myfitnesspal.service.enums;


import com.zebrunner.carina.utils.resources.L10N;

public enum TabsFromSearchFoodPage {

    ALL(L10N.getText("all")),
    MY_MEALS(L10N.getText("my_meals")),
    MY_RECIPES(L10N.getText("my_recipes")),
    MY_FOODS(L10N.getText("my_foods"));


    public final String tabName;

    TabsFromSearchFoodPage(String tabName) {
        this.tabName = tabName;
    }


    public String getTabName() {
        return tabName;
    }

}
