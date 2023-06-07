package koval.mobile.myfitnesspal.gui.ios.downMenuPages.plansPage;


import com.qaprosoft.carina.core.gui.AbstractPage;
import com.zebrunner.carina.utils.exception.NotImplementedException;
import com.zebrunner.carina.utils.factory.DeviceType;
import koval.mobile.myfitnesspal.gui.common.downMenuPages.plansPage.PlansDetailsPageBase;
import koval.mobile.myfitnesspal.gui.common.downMenuPages.plansPage.PlansHubPageBase;
import koval.mobile.myfitnesspal.gui.common.downMenuPages.plansPage.PlansTaskManagerPageBase;
import koval.mobile.myfitnesspal.gui.common.webPages.PlansGoogleDocWebPageBase;
import koval.mobile.myfitnesspal.service.enums.DownMenuElement;
import koval.mobile.myfitnesspal.service.enums.Filters;
import koval.mobile.myfitnesspal.service.enums.PlansCategory;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;



@DeviceType(pageType = DeviceType.Type.IOS_PHONE, parentClass = PlansHubPageBase.class)
public class PlansHubPage extends PlansHubPageBase {

    public PlansHubPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isPageOpened(int timeout) {
        throw new NotImplementedException();
    }

    @Override
    public AbstractPage openPageFromDownMenuByName(DownMenuElement downMenuElement) {
        throw new NotImplementedException();
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
    public PlansTaskManagerPageBase clickBackButton() {
        throw new NotImplementedException();
    }

    @Override
    public PlansHubPageBase swipeToSurveyTitle(int timeout) {
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

}
