package koval.myfit.mobile.gui.pages.ios.menuPages;

import com.zebrunner.carina.utils.factory.DeviceType;
import koval.myfit.mobile.gui.pages.common.menuPages.ProfilePageBase;
import org.openqa.selenium.WebDriver;

@DeviceType(pageType = DeviceType.Type.IOS_PHONE, parentClass = ProfilePageBase.class)
public class ProfilePage extends ProfilePageBase {
    public ProfilePage(WebDriver driver) {
        super(driver);
    }
}
