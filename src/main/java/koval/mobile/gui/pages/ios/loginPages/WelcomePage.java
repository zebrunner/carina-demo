package koval.mobile.gui.pages.ios.loginPages;

import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.utils.factory.DeviceType.Type;
import koval.mobile.gui.pages.common.loginPages.LoginPageBase;
import koval.mobile.gui.pages.common.loginPages.WelcomePageBase;
import com.zebrunner.carina.utils.exception.NotImplementedException;
import org.openqa.selenium.WebDriver;

@DeviceType(pageType = Type.IOS_PHONE, parentClass = WelcomePageBase.class)
public class WelcomePage extends WelcomePageBase {

    public WelcomePage(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isPageOpened() {
        throw new NotImplementedException();
    }

    @Override
    public LoginPageBase clickNextBtn() {
        throw new NotImplementedException();
    }

}
