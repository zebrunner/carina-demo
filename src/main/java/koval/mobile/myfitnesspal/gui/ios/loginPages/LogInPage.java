package koval.mobile.myfitnesspal.gui.ios.loginPages;


import com.zebrunner.carina.utils.exception.NotImplementedException;
import com.zebrunner.carina.utils.factory.DeviceType;
import koval.mobile.myfitnesspal.gui.common.downMenuPages.dashboardPage.DashboardPageBase;
import koval.mobile.myfitnesspal.gui.common.loginPages.LogInPageBase;
import org.openqa.selenium.WebDriver;


@DeviceType(pageType = DeviceType.Type.IOS_PHONE, parentClass = LogInPageBase.class)
public class LogInPage extends LogInPageBase {


    public LogInPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isPageOpened() {
        throw new NotImplementedException();
    }

    @Override
    public LogInPageBase typeMail(String password) {
        throw new NotImplementedException();
    }

    @Override
    public LogInPageBase typePassword(String password) {
        throw new NotImplementedException();
    }

    @Override
    public LogInPageBase clickLoginButton() {
        throw new NotImplementedException();
    }

    @Override
    public DashboardPageBase closeNoSubscriptionsPopUpIfPresent() {
        throw new NotImplementedException();
    }

    @Override
    public void closeUserTutorialBoxIfPresent() {
        throw new NotImplementedException();
    }


}
