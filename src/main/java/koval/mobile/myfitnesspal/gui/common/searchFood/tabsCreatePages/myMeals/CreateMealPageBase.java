package koval.mobile.myfitnesspal.gui.common.searchFood.tabsCreatePages.myMeals;

import koval.mobile.myfitnesspal.gui.MyAbstractPage;
import koval.mobile.myfitnesspal.gui.common.searchFood.SearchFoodPageBase;
import org.openqa.selenium.WebDriver;


public abstract class CreateMealPageBase extends MyAbstractPage {

    public CreateMealPageBase(WebDriver driver) {
        super(driver);
    }

    public abstract boolean isPageOpened(String mealText);

    public abstract SearchFoodPageBase createMeal(String mealName);

}
