package koval.mobile.myfitnesspal.service.enums;


import com.qaprosoft.carina.core.gui.AbstractPage;
import com.zebrunner.carina.utils.resources.L10N;
import koval.mobile.myfitnesspal.gui.common.actions.addExercise.NewCardioExercisePageBase;
import koval.mobile.myfitnesspal.gui.common.actions.addExercise.NewStrengthExercisePageBase;
import koval.mobile.myfitnesspal.gui.common.actions.addFood.tabsCreatePages.myFoods.CreateFoodPageBase;
import koval.mobile.myfitnesspal.gui.common.actions.addFood.tabsCreatePages.myMeals.CreateMealPageBase;
import koval.mobile.myfitnesspal.gui.common.actions.addFood.tabsCreatePages.myRecipes.CreateRecipePageBase;

public enum Items {

    MEALS("meals", CreateMealPageBase.class),

    RECIPES("recipes", CreateRecipePageBase.class),

    FOOD("food",  CreateFoodPageBase.class),

    CARDIO("cardio", NewCardioExercisePageBase.class),

    STRENGTH("strength", NewStrengthExercisePageBase.class),;


    public final String itemName;

    private final Class<? extends AbstractPage> className;


    Items(String itemName, Class<? extends AbstractPage> className) {
        this.itemName = itemName;
        this.className=className;
    }


    public String getItemName() {
        return L10N.getText(itemName);
    }


    public Class<? extends AbstractPage> getClassName() {
        return className;
    }
}
