package koval.mobile.myfitnesspal.gui.common.searchFood.tabsCreatePages.myRecipes;

import koval.mobile.myfitnesspal.gui.MyAbstractPage;
import koval.mobile.myfitnesspal.gui.common.downMenuPages.DiaryPageBase;
import org.openqa.selenium.WebDriver;

import java.util.List;


public abstract class CreateRecipePageBase extends MyAbstractPage {

    public CreateRecipePageBase(WebDriver driver) {
        super(driver);
    }

    public abstract boolean isPageOpened();


    public abstract DiaryPageBase createRecipeByEnteringIngredientsPerLine(String recipeName, int servings, List<String> recipeIngredients);

    public abstract DiaryPageBase createRecipe(String recipeName, int servings, List<String> recipeIngredients);
}
