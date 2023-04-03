package koval.mobile.myfitnesspal.service.enums;

import com.qaprosoft.carina.core.gui.AbstractPage;
import koval.mobile.myfitnesspal.gui.common.searchFood.tabsCreatePages.myFoods.CreateFoodPageBase;
import koval.mobile.myfitnesspal.gui.common.searchFood.tabsCreatePages.myMeals.CopyMealPageBase;
import koval.mobile.myfitnesspal.gui.common.searchFood.tabsCreatePages.myMeals.CreateMealPageBase;
import koval.mobile.myfitnesspal.gui.common.searchFood.tabsCreatePages.myRecipes.CreateRecipePageBase;

public enum ActionsFromTabsSearchFood {
    CREATE_A_MEAL("Create a Meal", CreateMealPageBase.class),
    COPY_A_MEAL("Copy Previous Meal", CopyMealPageBase.class),
    CREATE_A_RECIPE("Create a Recipe", CreateRecipePageBase.class),
    CREATE_A_FOOD("Create a Food", CreateFoodPageBase.class);


    public final String pageName;
    private final Class<? extends AbstractPage> className;

    ActionsFromTabsSearchFood(String pageName, Class<? extends AbstractPage> className) {
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
