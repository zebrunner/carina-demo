package koval.myfit.mobile.gui.pages.common.menuPages;

import com.qaprosoft.carina.core.gui.AbstractPage;
import koval.myfit.mobile.gui.pages.common.loginPages.WelcomePageBase;
import koval.myfit.mobile.gui.pages.service.enums.DownMenuElement;
import org.openqa.selenium.WebDriver;


public abstract class HomePageBase extends AbstractPage {

    public HomePageBase(WebDriver driver) {
        super(driver);
    }

    public abstract boolean isPageOpened();

    public abstract WelcomePageBase clickSignOutBtn();

    public abstract AbstractPage open(DownMenuElement downMenuElement);
}
