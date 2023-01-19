package koval.mobile.gui.pages.android;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.utils.factory.DeviceType.Type;
import koval.mobile.gui.pages.common.CarinaDescriptionPageBase;
import koval.mobile.gui.pages.common.WebViewPageBase;
import koval.mobile.gui.pages.service.enums.Tab;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

@DeviceType(pageType = Type.ANDROID_PHONE, parentClass = WebViewPageBase.class)
public class WebViewPage extends WebViewPageBase {
    public WebViewPage(WebDriver driver) {
        super(driver);
    }

}
