package koval.mobile.myfitnesspal.gui.common.searchFood.tabsCreatePages.myFoods;

import koval.mobile.myfitnesspal.gui.MyAbstractPage;
import koval.mobile.myfitnesspal.gui.common.downMenuPages.DiaryPageBase;
import koval.mobile.myfitnesspal.service.foodFactory.Food;
import org.openqa.selenium.WebDriver;


public abstract class CreateFoodPageBase extends MyAbstractPage {

    public CreateFoodPageBase(WebDriver driver) {
        super(driver);
    }

    public abstract boolean isPageOpened();

    public abstract DiaryPageBase createFood(Food food);
}
