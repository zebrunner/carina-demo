package koval.mobile.gui.pages.android;

import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.utils.factory.DeviceType.Type;
import koval.mobile.gui.pages.common.InstallationGuidWebPageBase;
import org.openqa.selenium.WebDriver;

@DeviceType(pageType = Type.ANDROID_PHONE, parentClass = InstallationGuidWebPageBase.class)
public class InstallationGuidWebPage extends InstallationGuidWebPageBase {

    public InstallationGuidWebPage(WebDriver driver) {
        super(driver);
        setPageAbsoluteURL("https://zebrunner.github.io/carina/");
    }


}
