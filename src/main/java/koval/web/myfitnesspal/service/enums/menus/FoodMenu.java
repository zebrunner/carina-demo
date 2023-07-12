package koval.web.myfitnesspal.service.enums.menus;

import com.qaprosoft.carina.core.gui.AbstractPage;
import koval.web.myfitnesspal.pages.menuPages.mainMenu.foodMenu.DatabasePage;
import koval.web.myfitnesspal.pages.menuPages.mainMenu.foodMenu.MyMealsPage;
import koval.web.myfitnesspal.pages.menuPages.mainMenu.foodMenu.RecipesPage;
import koval.web.myfitnesspal.pages.menuPages.mainMenu.foodMenu.foodDiaryPages.FoodDiaryPage;
import koval.web.myfitnesspal.pages.menuPages.mainMenu.foodMenu.myFoods.MyFoodsPage;
import koval.web.myfitnesspal.pages.menuPages.mainMenu.myhomeMenu.SettingsPage;

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

    public Class<? extends AbstractPage> getClassName(){
        return className;
    }
}