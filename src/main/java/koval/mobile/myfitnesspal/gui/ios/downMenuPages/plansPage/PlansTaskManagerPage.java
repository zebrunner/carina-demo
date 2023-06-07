package koval.mobile.myfitnesspal.gui.ios.downMenuPages.plansPage;

import com.zebrunner.carina.utils.exception.NotImplementedException;
import com.zebrunner.carina.utils.factory.DeviceType;
import koval.mobile.myfitnesspal.gui.common.downMenuPages.plansPage.PlansHubPageBase;
import koval.mobile.myfitnesspal.gui.common.downMenuPages.plansPage.PlansTaskManagerPageBase;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;



@DeviceType(pageType = DeviceType.Type.IOS_PHONE, parentClass = PlansTaskManagerPageBase.class)
public class PlansTaskManagerPage extends PlansTaskManagerPageBase {

    public PlansTaskManagerPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isPageOpened(int timeout) {
        throw new NotImplementedException();
    }

    @Override
    public String getCurrentPlanTitle() {
        throw new NotImplementedException();
    }

    @Override
    public boolean isSurveyTitleAtTheBottom() {
        throw new NotImplementedException();
    }

    @Override
    public PlansHubPageBase clickOnPlusSign() {
        throw new NotImplementedException();
    }

    @Override
    public PlansHubPageBase endPlan() {
        throw new NotImplementedException();
    }


    @Override
    public PlansTaskManagerPageBase closeWelcomeMessageIfPresent(int timeout) {
        throw new NotImplementedException();
    }

    @Override
    public PlansTaskManagerPageBase swipeToSurveyTitle(int timeout) {
        throw new NotImplementedException();
    }

    @Override
    public boolean isSectionSurveyPresent(int timeout) {
        throw new NotImplementedException();
    }

    @Override
    public Point getLocationElement() {
        throw new NotImplementedException();
    }

}
