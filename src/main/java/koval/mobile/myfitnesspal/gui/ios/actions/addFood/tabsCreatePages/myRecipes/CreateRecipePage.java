package koval.mobile.myfitnesspal.gui.ios.actions.addFood.tabsCreatePages.myRecipes;


import com.zebrunner.carina.utils.exception.NotImplementedException;
import com.zebrunner.carina.utils.factory.DeviceType;
import koval.mobile.myfitnesspal.gui.common.downMenuPages.DiaryPageBase;
import koval.mobile.myfitnesspal.gui.common.actions.addFood.tabsCreatePages.myRecipes.CreateRecipePageBase;
import koval.mobile.myfitnesspal.service.factories.recipeFactory.Recipe;
import org.openqa.selenium.WebDriver;

import java.util.List;


@DeviceType(pageType = DeviceType.Type.IOS_PHONE, parentClass = CreateRecipePageBase.class)
public class CreateRecipePage extends CreateRecipePageBase {

    public CreateRecipePage(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isPageOpened() {
        throw new NotImplementedException();
    }

    @Override
    public DiaryPageBase createRecipeByEnteringIngredientsPerLine(Recipe recipe) {
        throw new NotImplementedException();
    }

    @Override
    public DiaryPageBase createRecipe(String recipeName, int servings, List<String> recipeIngredients) {
        throw new NotImplementedException();
    }
}
