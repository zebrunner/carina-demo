package koval.mobile.myfitnesspal.gui.common.actions.addFood.tabsCreatePages.myMeals;

import koval.mobile.myfitnesspal.gui.MyAbstractPageBase;
import koval.mobile.myfitnesspal.gui.common.downMenuPages.DiaryPageBase;
import org.openqa.selenium.WebDriver;


public abstract class CopyMealPageBase extends MyAbstractPageBase {

    public CopyMealPageBase(WebDriver driver) {
        super(driver);
    }

    public abstract boolean isPageOpened();

    public abstract DiaryPageBase copyMeal();
}
