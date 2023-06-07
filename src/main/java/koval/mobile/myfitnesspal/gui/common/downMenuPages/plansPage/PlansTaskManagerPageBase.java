package koval.mobile.myfitnesspal.gui.common.downMenuPages.plansPage;

import koval.mobile.myfitnesspal.gui.MyAbstractPageBase;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;


public abstract class PlansTaskManagerPageBase extends MyAbstractPageBase {

    public PlansTaskManagerPageBase(WebDriver driver) {
        super(driver);
    }


    public abstract boolean isPageOpened(int timeout);

    public abstract String getCurrentPlanTitle();

    public abstract boolean isSurveyTitleAtTheBottom();

    public abstract PlansHubPageBase clickOnPlusSign();

    public abstract PlansHubPageBase endPlan();

    public abstract PlansTaskManagerPageBase closeWelcomeMessageIfPresent(int timeout);

    public abstract PlansTaskManagerPageBase swipeToSurveyTitle(int timeout);

    public abstract boolean isSectionSurveyPresent(int timeout);

    public abstract Point getLocationElement();
}
