package koval.myfit.mobile.gui.pages.ios.menuPages;


import com.qaprosoft.carina.core.gui.AbstractPage;
import com.zebrunner.carina.utils.exception.NotImplementedException;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.utils.mobile.IMobileUtils;
import koval.myfit.mobile.gui.pages.common.loginPages.WelcomePageBase;
import koval.myfit.mobile.gui.pages.common.menuPages.HomePageBase;
import koval.myfit.mobile.gui.pages.service.enums.DownMenuElement;
import org.openqa.selenium.WebDriver;


@DeviceType(pageType = DeviceType.Type.IOS_PHONE, parentClass = HomePageBase.class)
public class HomePage extends HomePageBase {

    public HomePage(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isPageOpened() {
        throw new NotImplementedException();
    }

    @Override
    public WelcomePageBase clickSignOutBtn() {
        throw new NotImplementedException();
    }

    @Override
    public AbstractPage open(DownMenuElement downMenuElement) {
        throw new NotImplementedException();
    }

}
