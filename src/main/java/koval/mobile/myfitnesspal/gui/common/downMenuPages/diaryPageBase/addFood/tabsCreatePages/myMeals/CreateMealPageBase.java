package koval.mobile.myfitnesspal.gui.common.downMenuPages.diaryPageBase.addFood.tabsCreatePages.myMeals;

import koval.mobile.myfitnesspal.gui.MyAbstractPageBase;
import koval.mobile.myfitnesspal.gui.common.downMenuPages.diaryPageBase.addFood.SearchFoodPageBase;
import org.openqa.selenium.WebDriver;


public abstract class CreateMealPageBase extends MyAbstractPageBase {

    public CreateMealPageBase(WebDriver driver) {
        super(driver);
    }

    public abstract boolean isPageOpened();

    public abstract SearchFoodPageBase createMeal(String mealName);

    public abstract SearchFoodPageBase clickSaveButton();
}
