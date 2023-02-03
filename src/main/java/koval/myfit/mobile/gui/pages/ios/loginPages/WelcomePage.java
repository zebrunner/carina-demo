package koval.myfit.mobile.gui.pages.ios.loginPages;


import com.zebrunner.carina.utils.exception.NotImplementedException;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.utils.mobile.IMobileUtils;
import koval.carinademo.mobile.gui.pages.service.interfaces.IConstantUtils;
import koval.myfit.mobile.gui.pages.common.loginPages.AboutMePageBase;
import koval.myfit.mobile.gui.pages.common.loginPages.WelcomePageBase;
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
    public AboutMePageBase clickLoginBtn() {
        throw new NotImplementedException();
    }

}
