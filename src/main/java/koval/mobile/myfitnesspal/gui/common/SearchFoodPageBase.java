package koval.mobile.myfitnesspal.gui.common;

import koval.mobile.myfitnesspal.gui.MyAbstractPage;
import koval.mobile.myfitnesspal.gui.common.downMenuPages.DiaryPageBase;
import koval.mobile.myfitnesspal.service.enums.Meals;
import org.openqa.selenium.WebDriver;


public abstract class SearchFoodPageBase extends MyAbstractPage {

    public SearchFoodPageBase(WebDriver driver) {
        super(driver);
    }

    public abstract boolean isPageOpened(String mealText);


    public abstract SearchFoodPageBase changeMealByName(Meals meals);

    public abstract SearchFoodPageBase addFoodToMealByName(String food);

    public abstract DiaryPageBase clickBackButton();
}
