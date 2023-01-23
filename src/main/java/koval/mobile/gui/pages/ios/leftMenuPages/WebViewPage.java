package koval.mobile.gui.pages.ios.leftMenuPages;

import com.qaprosoft.carina.core.gui.AbstractPage;
import com.zebrunner.carina.utils.exception.NotImplementedException;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.utils.factory.DeviceType.Type;
import koval.mobile.gui.pages.common.leftMenuPages.WebViewPageBase;
import koval.mobile.gui.pages.service.enums.LeftMenu;
import org.openqa.selenium.WebDriver;

@DeviceType(pageType = Type.IOS_PHONE, parentClass = WebViewPageBase.class)
public class WebViewPage extends WebViewPageBase {
    public WebViewPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isElementPresent() {
        throw new NotImplementedException();
    }

}
