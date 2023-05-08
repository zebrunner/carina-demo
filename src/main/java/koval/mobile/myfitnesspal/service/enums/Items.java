package koval.mobile.myfitnesspal.service.enums;


import com.qaprosoft.carina.core.gui.AbstractPage;
import com.zebrunner.carina.utils.resources.L10N;
import koval.mobile.myfitnesspal.gui.common.actions.addExercise.NewCardioExercisePageBase;
import koval.mobile.myfitnesspal.gui.common.actions.addExercise.NewStrengthExercisePageBase;
import koval.mobile.myfitnesspal.gui.common.actions.addFood.tabsCreatePages.myFoods.CreateFoodPageBase;
import koval.mobile.myfitnesspal.gui.common.actions.addFood.tabsCreatePages.myMeals.CreateMealPageBase;
import koval.mobile.myfitnesspal.gui.common.actions.addFood.tabsCreatePages.myRecipes.CreateRecipePageBase;

public enum Items {

    MEALS(L10N.getText("meals"), CreateMealPageBase.class),

    RECIPES(L10N.getText("recipes"), CreateRecipePageBase.class),

    FOODS(L10N.getText("foods"),  CreateFoodPageBase.class),

    CARDIO(L10N.getText("cardio"), NewCardioExercisePageBase.class),

    STRENGTH(L10N.getText("strength"), NewStrengthExercisePageBase.class),;


    public final String itemName;

    private final Class<? extends AbstractPage> className;


    Items(String itemName, Class<? extends AbstractPage> className) {
        this.itemName = itemName;
        this.className=className;
    }


    public String getItemName() {
        return itemName;
    }

    public String getItemNameSmall() {
        return itemName.toLowerCase();
    }

    public Class<? extends AbstractPage> getClassName() {
        return className;
    }
}
