package koval.mobile.myfitnesspal.gui.common.actions.addFood.tabsCreatePages.myMeals;

import koval.mobile.myfitnesspal.gui.MyAbstractPageBase;
import koval.mobile.myfitnesspal.gui.common.actions.addFood.SearchFoodPageBase;
import org.openqa.selenium.WebDriver;


public abstract class CreateMealPageBase extends MyAbstractPageBase {

    public CreateMealPageBase(WebDriver driver) {
        super(driver);
    }

    public abstract boolean isPageOpened();

    public abstract SearchFoodPageBase createMeal(String mealName);

    public abstract SearchFoodPageBase clickSaveButton();
}
