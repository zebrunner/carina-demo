package koval.mobile.gui.pages.ios.leftMenuPages;

import com.qaprosoft.carina.core.gui.AbstractPage;
import com.zebrunner.carina.utils.exception.NotImplementedException;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.utils.factory.DeviceType.Type;
import koval.mobile.gui.pages.common.leftMenuPages.WebViewPageBase;
import koval.mobile.gui.pages.service.enums.Menu;
import org.openqa.selenium.WebDriver;

@DeviceType(pageType = Type.IOS_PHONE, parentClass = WebViewPageBase.class)
public class WebViewPage extends WebViewPageBase {
    public WebViewPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public AbstractPage openMenu() {
        throw new NotImplementedException();
    }

    @Override
    public AbstractPage openPage(Menu menu) {
        throw new NotImplementedException();
    }

    @Override
    public boolean isMenuElementPresent(Menu menu) {
        throw new NotImplementedException();
    }


    @Override
    public boolean isElementPresent() {
        throw new NotImplementedException();
    }

}
