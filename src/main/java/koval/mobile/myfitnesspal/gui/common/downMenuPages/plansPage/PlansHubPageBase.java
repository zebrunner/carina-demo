package koval.mobile.myfitnesspal.gui.common.downMenuPages.plansPage;

import koval.mobile.myfitnesspal.gui.MyAbstractPageBase;
import koval.mobile.myfitnesspal.service.enums.Filters;
import org.openqa.selenium.WebDriver;


public abstract class PlansHubPageBase extends MyAbstractPageBase {

    public PlansHubPageBase(WebDriver driver) {
        super(driver);
    }


    public abstract boolean isPageOpened(int timeout);


    public abstract PlansDetailsPageBase clickOnAvailablePlan(Filters filters);
}
