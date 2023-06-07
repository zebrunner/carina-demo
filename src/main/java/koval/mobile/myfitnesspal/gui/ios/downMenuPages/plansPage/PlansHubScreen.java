package koval.mobile.myfitnesspal.gui.ios.downMenuPages.plansPage;


import com.zebrunner.carina.utils.exception.NotImplementedException;
import com.zebrunner.carina.utils.factory.DeviceType;
import koval.mobile.myfitnesspal.gui.common.downMenuPages.plansPage.PlansDetailsPageBase;
import koval.mobile.myfitnesspal.gui.common.downMenuPages.plansPage.PlansHubScreenBase;
import koval.mobile.myfitnesspal.gui.common.webPages.PlansGoogleDocWebPageBase;
import koval.mobile.myfitnesspal.service.enums.Filters;
import koval.mobile.myfitnesspal.service.enums.PlansCategory;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;



@DeviceType(pageType = DeviceType.Type.IOS_PHONE, parentClass = PlansHubScreenBase.class)
public class PlansHubScreen extends PlansHubScreenBase {

    public PlansHubScreen(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isPageOpened(int timeout) {
        return false;
    }

    @Override
    public PlansDetailsPageBase clickOnAvailablePlan(Filters filters) {
        throw new NotImplementedException();
    }

    @Override
    public boolean isCurrentActivePlanDisplayed(String currentPlanTitle) {
        throw new NotImplementedException();
    }


    public int getActivePlanBlockHeight() {
        throw new NotImplementedException();
    }


    public int getActivePlanBlockByY() {
        throw new NotImplementedException();
    }


    @Override
    public boolean isActivePlanDisplayOnlyJoinedPlan() {
        throw new NotImplementedException();
    }


    public int getPlanCategoryByY(PlansCategory plansCategory) {
        throw new NotImplementedException();
    }


    @Override
    public PlansGoogleDocWebPageBase clickTakeSurvey() {
        throw new NotImplementedException();
    }

    @Override
    public PlansHubScreenBase swipeToSurveyTitle(int timeout) {
        throw new NotImplementedException();
    }

    @Override
    public boolean isSectionSurveyPresent(int timeout) {
        throw new NotImplementedException();
    }

    @Override
    public boolean isSurveyTitleAtTheBottom() {
        throw new NotImplementedException();
    }


    public Point getLocationElement() {
        throw new NotImplementedException();
    }

}
