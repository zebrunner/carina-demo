package koval.mobile.gui.pages.android.leftMenuPages;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.utils.factory.DeviceType.Type;
import koval.mobile.gui.pages.android.menu.LeftMenuModal;
import koval.mobile.gui.pages.common.leftMenuPages.WebViewPageBase;
import koval.mobile.gui.pages.common.menu.LeftMenuModalBase;
import koval.mobile.gui.pages.service.enums.LeftMenu;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.invoke.MethodHandles;

import static koval.mobile.gui.pages.service.interfaces.IConstantUtils.TIMEOUT_FIVE;

@DeviceType(pageType = Type.ANDROID_PHONE, parentClass = WebViewPageBase.class)
public class WebViewPage extends WebViewPageBase {

    private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

    @FindBy(className = "android.widget.TextView")
    private ExtendedWebElement title;

    @FindBy(id = "com.solvd.carinademoapplication:id/content_frame")
    private ExtendedWebElement webViewContent;

    public WebViewPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isElementPresent() {
        return webViewContent.isElementPresent(TIMEOUT_FIVE);
    }

    @Override
    public boolean isPageOpened() {
        return title.getText().equals(LeftMenu.WEB_VIEW.getPageName());
    }

}
