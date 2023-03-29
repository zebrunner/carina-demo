package koval.mobile.myfitnesspal.gui.common.searchFood.tabsCreatePages.myMeals;

import koval.mobile.myfitnesspal.gui.MyAbstractPage;
import koval.mobile.myfitnesspal.gui.common.downMenuPages.DiaryPageBase;
import org.openqa.selenium.WebDriver;


public abstract class CopyMealPageBase extends MyAbstractPage {

    public CopyMealPageBase(WebDriver driver) {
        super(driver);
    }

    public abstract boolean isPageOpened();

    public abstract DiaryPageBase copyMeal();
}
