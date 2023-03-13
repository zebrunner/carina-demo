package koval.mobile.myfit.gui.common.loginPages;

import koval.mobile.myfit.gui.MyAbstractPage;
import org.openqa.selenium.WebDriver;


public abstract class WelcomePageBase extends MyAbstractPage {

    public WelcomePageBase(WebDriver driver) {
        super(driver);
    }

    public abstract boolean isPageOpened();

    public abstract AboutMePageBase clickLoginBtn();

}
