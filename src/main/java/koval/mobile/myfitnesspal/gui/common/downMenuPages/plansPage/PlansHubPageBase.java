package koval.mobile.myfitnesspal.gui.common.downMenuPages.plansPage;

import com.qaprosoft.carina.core.gui.AbstractPage;
import koval.mobile.myfitnesspal.gui.MyAbstractPageBase;
import koval.mobile.myfitnesspal.gui.common.webPages.PlansGoogleDocWebPageBase;
import koval.mobile.myfitnesspal.service.enums.DownMenuElement;
import koval.mobile.myfitnesspal.service.enums.Filters;
import koval.mobile.myfitnesspal.service.enums.PlansCategory;
import org.openqa.selenium.WebDriver;


public abstract class PlansHubPageBase extends MyAbstractPageBase {

    public PlansHubPageBase(WebDriver driver) {
        super(driver);
    }


    public abstract boolean isPageOpened(int timeout);


    public abstract AbstractPage openPageFromDownMenuByName(DownMenuElement downMenuElement);

    public abstract PlansDetailsPageBase clickOnAvailablePlan(Filters filters);

    public abstract boolean isCurrentActivePlanDisplayed(String currentPlanTitle);


    public abstract int getActivePlanBlockHeight();

    public abstract int getActivePlanBlockByY();

    public abstract boolean isActivePlanDisplayOnlyJoinedPlan();


    public abstract int getPlanCategoryByY(PlansCategory plansCategory);

    public abstract PlansGoogleDocWebPageBase clickTakeSurvey();

    public abstract PlansTaskManagerPageBase clickBackButton();

    public abstract PlansHubPageBase swipeToSurveyTitle(int timeout);

    public abstract boolean isSectionSurveyPresent(int timeout);

    public abstract boolean isSurveyTitleAtTheBottom();
}
