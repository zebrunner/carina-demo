package koval.mobile.myfitnesspal.gui.common.searchFood.tabsCreatePages.myRecipes;

import koval.mobile.myfitnesspal.gui.MyAbstractPage;
import koval.mobile.myfitnesspal.gui.common.downMenuPages.DiaryPageBase;
import koval.mobile.myfitnesspal.service.recipeFactory.Recipe;
import org.openqa.selenium.WebDriver;

import java.util.List;


public abstract class CreateRecipePageBase extends MyAbstractPage {

    public CreateRecipePageBase(WebDriver driver) {
        super(driver);
    }

    public abstract boolean isPageOpened();


    public abstract DiaryPageBase createRecipeByEnteringIngredientsPerLine(Recipe recipe);

    public abstract DiaryPageBase createRecipe(String recipeName, int servings, List<String> recipeIngredients);
}
