package koval.mobile.gui.pages.common.leftMenuPages;

import com.qaprosoft.carina.core.gui.AbstractPage;
import koval.mobile.gui.pages.service.enums.LeftMenu;
import org.openqa.selenium.WebDriver;

public abstract class WebViewPageBase extends AbstractPage {

    public WebViewPageBase(WebDriver driver) {
        super(driver);
    }

    public abstract boolean isElementPresent();
}
