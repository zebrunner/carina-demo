package koval.mobile.myfitnesspal.gui.common.downMenuPages.diaryPageBase.addFood.tabsCreatePages.myRecipes;

import koval.mobile.myfitnesspal.gui.MyAbstractPageBase;
import koval.mobile.myfitnesspal.gui.common.downMenuPages.diaryPageBase.DiaryPageBase;
import koval.mobile.myfitnesspal.service.factories.recipeFactory.Recipe;
import org.openqa.selenium.WebDriver;

import java.util.List;


public abstract class CreateRecipePageBase extends MyAbstractPageBase {

    public CreateRecipePageBase(WebDriver driver) {
        super(driver);
    }

    public abstract boolean isPageOpened();


    public abstract DiaryPageBase createRecipeByEnteringIngredientsPerLine(Recipe recipe);

    public abstract DiaryPageBase createRecipe(String recipeName, int servings, List<String> recipeIngredients);
}
