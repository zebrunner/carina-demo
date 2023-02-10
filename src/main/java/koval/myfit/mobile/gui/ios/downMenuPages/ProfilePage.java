package koval.myfit.mobile.gui.ios.downMenuPages;

import com.zebrunner.carina.utils.factory.DeviceType;
import koval.myfit.mobile.gui.common.downMenuPages.ProfilePageBase;
import org.openqa.selenium.WebDriver;

@DeviceType(pageType = DeviceType.Type.IOS_PHONE, parentClass = ProfilePageBase.class)
public class ProfilePage extends ProfilePageBase {
    public ProfilePage(WebDriver driver) {
        super(driver);
    }
}
