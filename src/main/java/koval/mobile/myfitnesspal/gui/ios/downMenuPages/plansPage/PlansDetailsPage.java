package koval.mobile.myfitnesspal.gui.ios.downMenuPages.plansPage;


import com.zebrunner.carina.utils.exception.NotImplementedException;
import com.zebrunner.carina.utils.factory.DeviceType;
import koval.mobile.myfitnesspal.gui.common.downMenuPages.plansPage.PlansDetailsPageBase;
import koval.mobile.myfitnesspal.gui.common.downMenuPages.plansPage.PlansTaskManagerPageBase;
import org.openqa.selenium.WebDriver;



@DeviceType(pageType = DeviceType.Type.IOS_PHONE, parentClass = PlansDetailsPageBase.class)
public class PlansDetailsPage extends PlansDetailsPageBase {

    public PlansDetailsPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isPageOpened(int timeout) {
        throw new NotImplementedException();
    }


    @Override
    public PlansDetailsPageBase clickOnStartPlan() {
        throw new NotImplementedException();
    }

    @Override
    public PlansTaskManagerPageBase clickOnContinueAlertMessageIfPresent() {
        throw new NotImplementedException();
    }

    @Override
    public boolean isAlertMessageAboutEndingPlanOpen() {
        throw new NotImplementedException();
    }

}
