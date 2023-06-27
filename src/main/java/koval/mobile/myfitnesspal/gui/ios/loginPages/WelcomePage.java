package koval.mobile.myfitnesspal.gui.ios.loginPages;


import com.qaprosoft.carina.core.gui.AbstractPage;
import com.zebrunner.carina.utils.exception.NotImplementedException;
import com.zebrunner.carina.utils.factory.DeviceType;
import koval.mobile.myfitnesspal.gui.common.loginPages.LogInPageBase;
import koval.mobile.myfitnesspal.gui.common.loginPages.SignUpPageBase;
import koval.mobile.myfitnesspal.gui.common.loginPages.WelcomePageBase;
import org.openqa.selenium.WebDriver;


@DeviceType(pageType = DeviceType.Type.IOS_PHONE, parentClass = WelcomePageBase.class)
public class WelcomePage extends WelcomePageBase {


    public WelcomePage(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isPageOpened() {
        throw new NotImplementedException();
    }

    @Override
    public WelcomePageBase notificationSendPopUpIfPresent(String answer) {
        throw new NotImplementedException();
    }

    @Override
    public SignUpPageBase signUp() {
        throw new NotImplementedException();
    }

    @Override
    public LogInPageBase logIn() {
        throw new NotImplementedException();
    }

    @Override
    public AbstractPage clickButton(String buttonText) {
        throw new NotImplementedException();
    }


}
