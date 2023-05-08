package koval.mobile.myfitnesspal.service.enums;

import com.qaprosoft.carina.core.gui.AbstractPage;
import com.zebrunner.carina.utils.resources.L10N;
import koval.mobile.myfitnesspal.gui.common.actions.addFood.tabsCreatePages.myFoods.CreateFoodPageBase;
import koval.mobile.myfitnesspal.gui.common.actions.addFood.tabsCreatePages.myMeals.CopyMealPageBase;
import koval.mobile.myfitnesspal.gui.common.actions.addFood.tabsCreatePages.myMeals.CreateMealPageBase;
import koval.mobile.myfitnesspal.gui.common.actions.addFood.tabsCreatePages.myRecipes.CreateRecipePageBase;

public enum ActionsFromTabsSearchFood {
    CREATE_A_MEAL("create_a_meal", CreateMealPageBase.class),
    COPY_A_MEAL("copy_a_meal", CopyMealPageBase.class),
    CREATE_A_RECIPE("create_a_recipe", CreateRecipePageBase.class),
    CREATE_A_FOOD("create_a_food", CreateFoodPageBase.class);


    public final String pageName;
    private final Class<? extends AbstractPage> className;

    ActionsFromTabsSearchFood(String pageName, Class<? extends AbstractPage> className) {
        this.pageName = pageName;
        this.className = className;
    }

    public String getPageName() {
        return L10N.getText(pageName);
    }

    public Class<? extends AbstractPage> getClassName() {
        return className;
    }
}
