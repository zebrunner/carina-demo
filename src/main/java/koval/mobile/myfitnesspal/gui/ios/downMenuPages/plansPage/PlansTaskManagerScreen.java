package koval.mobile.myfitnesspal.gui.ios.downMenuPages.plansPage;

import com.zebrunner.carina.utils.exception.NotImplementedException;
import com.zebrunner.carina.utils.factory.DeviceType;
import koval.mobile.myfitnesspal.gui.common.downMenuPages.plansPage.PlansHubScreenBase;
import koval.mobile.myfitnesspal.gui.common.downMenuPages.plansPage.PlansPageBase;
import koval.mobile.myfitnesspal.gui.common.downMenuPages.plansPage.PlansTaskManagerScreenBase;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;



@DeviceType(pageType = DeviceType.Type.IOS_PHONE, parentClass = PlansTaskManagerScreenBase.class)
public class PlansTaskManagerScreen extends PlansTaskManagerScreenBase {

    public PlansTaskManagerScreen(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isPageOpened(int timeout) {
        return false;
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
    public PlansHubScreenBase clickOnPlusSign() {
        throw new NotImplementedException();
    }


    @Override
    public PlansPageBase closeWelcomeMessageIfPresent(int timeout) {
        throw new NotImplementedException();
    }

    @Override
    public PlansPageBase swipeToSurveyTitle(int timeout) {
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
