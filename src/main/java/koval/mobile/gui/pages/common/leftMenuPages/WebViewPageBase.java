package koval.mobile.gui.pages.common.leftMenuPages;

import com.qaprosoft.carina.core.gui.AbstractPage;
import koval.mobile.gui.pages.service.enums.Menu;
import org.openqa.selenium.WebDriver;

public abstract class WebViewPageBase extends AbstractPage {

    public WebViewPageBase(WebDriver driver) {
        super(driver);
    }


    public abstract AbstractPage openMenu();

    public abstract AbstractPage openPage(Menu menu);

    public abstract boolean isMenuElementPresent(Menu menu);

    public abstract boolean isElementPresent();
}
