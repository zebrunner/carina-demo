package koval.mobile.myfitnesspal.gui.common.downMenuPages.plansPage;

import koval.mobile.myfitnesspal.gui.MyAbstractPageBase;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;


public abstract class PlansTaskManagerScreenBase extends MyAbstractPageBase {

    public PlansTaskManagerScreenBase(WebDriver driver) {
        super(driver);
    }


    public abstract boolean isPageOpened(int timeout);

    public abstract String getCurrentPlanTitle();

    public abstract boolean isSurveyTitleAtTheBottom();

    public abstract PlansHubScreenBase clickOnPlusSign();

    public abstract PlansPageBase closeWelcomeMessageIfPresent(int timeout);

    public abstract PlansPageBase swipeToSurveyTitle(int timeout);

    public abstract boolean isSectionSurveyPresent(int timeout);

    public abstract Point getLocationElement();
}
