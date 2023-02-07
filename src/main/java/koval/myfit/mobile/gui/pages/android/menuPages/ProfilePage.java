package koval.myfit.mobile.gui.pages.android.menuPages;

import com.zebrunner.carina.utils.factory.DeviceType;
import koval.myfit.mobile.gui.pages.common.menuPages.ProfilePageBase;
import org.openqa.selenium.WebDriver;


@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = ProfilePageBase.class)
public class ProfilePage extends ProfilePageBase {

    public ProfilePage(WebDriver driver) {
        super(driver);
    }
}
