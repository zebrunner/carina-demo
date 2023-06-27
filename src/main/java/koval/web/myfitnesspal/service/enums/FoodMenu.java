package koval.web.myfitnesspal.service.enums;

import com.qaprosoft.carina.core.gui.AbstractPage;
import koval.web.myfitnesspal.pages.menuPages.foodMenu.*;
import koval.web.myfitnesspal.pages.menuPages.foodMenu.foodDiaryPages.FoodDiaryPage;

public enum FoodMenu {

    FOOD_DIARY("Food Diary", FoodDiaryPage.class),

    DATABASE("Database", DatabasePage.class),

    MY_FOODS("My Foods", MyFoodsPage.class),

    MY_MEALS("My Meals", MyMealsPage.class),

    RECIPES("Recipes", RecipesPage.class),

    SETTINGS("Settings", SettingsPage.class);


    private final String pageName;
    private final Class<? extends AbstractPage> className;
    FoodMenu(String pageName, Class<? extends AbstractPage> className) {
        this.pageName = pageName;
        this.className = className;
    }

    public String getPageName() {
        return pageName;
    }

    public Class<? extends AbstractPage> getClassName() {
        return className;
    }
}