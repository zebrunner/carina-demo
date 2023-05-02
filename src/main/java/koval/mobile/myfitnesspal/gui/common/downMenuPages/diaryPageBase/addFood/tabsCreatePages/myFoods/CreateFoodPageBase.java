package koval.mobile.myfitnesspal.gui.common.downMenuPages.diaryPageBase.addFood.tabsCreatePages.myFoods;

import koval.mobile.myfitnesspal.gui.MyAbstractPageBase;
import koval.mobile.myfitnesspal.gui.common.downMenuPages.diaryPageBase.DiaryPageBase;
import koval.mobile.myfitnesspal.service.factories.foodFactory.Food;
import org.openqa.selenium.WebDriver;


public abstract class CreateFoodPageBase extends MyAbstractPageBase {

    public CreateFoodPageBase(WebDriver driver) {
        super(driver);
    }

    public abstract DiaryPageBase createFood(Food food);
}
