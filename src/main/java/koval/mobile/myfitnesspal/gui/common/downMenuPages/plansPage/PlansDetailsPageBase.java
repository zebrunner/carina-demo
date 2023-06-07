package koval.mobile.myfitnesspal.gui.common.downMenuPages.plansPage;

import koval.mobile.myfitnesspal.gui.MyAbstractPageBase;
import org.openqa.selenium.WebDriver;


public abstract class PlansDetailsPageBase extends MyAbstractPageBase {

    public PlansDetailsPageBase(WebDriver driver) {
        super(driver);
    }


    public abstract boolean isPageOpened(int timeout);

    public abstract PlansDetailsPageBase clickOnStartPlan();

    public abstract PlansTaskManagerScreenBase clickOnContinueAlertMessageIfPresent();

    public abstract boolean isAlertMessageAboutEndingPlanOpen();
}
