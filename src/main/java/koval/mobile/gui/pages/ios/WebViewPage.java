package koval.mobile.gui.pages.ios;

import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.utils.factory.DeviceType.Type;
import koval.mobile.gui.pages.common.WebViewPageBase;
import org.openqa.selenium.WebDriver;

@DeviceType(pageType = Type.ANDROID_PHONE, parentClass = WebViewPageBase.class)
public class WebViewPage extends WebViewPageBase {
    public WebViewPage(WebDriver driver) {
        super(driver);
    }

}
