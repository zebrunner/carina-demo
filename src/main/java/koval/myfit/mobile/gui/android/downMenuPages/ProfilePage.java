package koval.myfit.mobile.gui.android.downMenuPages;

import com.zebrunner.carina.utils.factory.DeviceType;
import koval.myfit.mobile.gui.common.downMenuPages.ProfilePageBase;
import org.openqa.selenium.WebDriver;


@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = ProfilePageBase.class)
public class ProfilePage extends ProfilePageBase {

    public ProfilePage(WebDriver driver) {
        super(driver);
    }
}
