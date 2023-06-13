package koval.mobile.myfitnesspal.gui.common.downMenuPages.plansPage;

import com.qaprosoft.carina.core.gui.AbstractPage;
import koval.mobile.myfitnesspal.gui.MyAbstractPageBase;
import koval.mobile.myfitnesspal.gui.common.downMenuPages.DiaryPageBase;
import koval.mobile.myfitnesspal.gui.common.downMenuPages.plansPage.workout.LogWorkoutPageBase;
import koval.mobile.myfitnesspal.service.enums.DownMenuElement;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;


public abstract class PlansTaskManagerPageBase extends MyAbstractPageBase {

    public PlansTaskManagerPageBase(WebDriver driver) {
        super(driver);
    }


    public abstract boolean isPageOpened(int timeout);

    public abstract String getCurrentPlanTitle();

    public abstract AbstractPage openPageFromDownMenuByName(DownMenuElement downMenuElement);

    public abstract boolean isSurveyTitleAtTheBottom();

    public abstract boolean isLoggedWorkoutConfirmMsgPresent();

    public abstract LogWorkoutPageBase clickLogWorkoutButton();

    public abstract DiaryPageBase clickViewButton();

    public abstract PlansHubPageBase clickOnPlusSign();

    public abstract PlansHubPageBase endPlan();

    public abstract PlansTaskManagerPageBase closeWelcomeMessageIfPresent(int timeout);

    public abstract PlansTaskManagerPageBase swipeToSurveyTitle(int timeout);

    public abstract boolean isSectionSurveyPresent(int timeout);

    public abstract Point getLocationElement();
}
