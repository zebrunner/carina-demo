package koval.myfit.mobile.gui.pages.common.loginPages;

import com.qaprosoft.carina.core.gui.AbstractPage;
import org.openqa.selenium.WebDriver;


public abstract class WelcomePageBase extends AbstractPage {

    public WelcomePageBase(WebDriver driver) {
        super(driver);
    }
    public abstract boolean isPageOpened();

    public abstract AboutMePageBase clickLoginBtn();

}
