package koval.mobile.myfitnesspal.gui.common.downMenuPages.plansPage;

import koval.mobile.myfitnesspal.gui.MyAbstractPageBase;
import koval.mobile.myfitnesspal.gui.android.downMenuPages.plansPage.PlansDetailsPage;
import org.openqa.selenium.WebDriver;


public abstract class PlansDetailsPageBase extends MyAbstractPageBase {

    public PlansDetailsPageBase(WebDriver driver) {
        super(driver);
    }


    public abstract boolean isPageOpened(int timeout);

    public abstract PlansDetailsPageBase clickOnStartPlan();

    public abstract PlansPageBase clickOnContinueAlertMessage();

    public abstract boolean isAlertMessageAboutEndingPlanOpen();
}
