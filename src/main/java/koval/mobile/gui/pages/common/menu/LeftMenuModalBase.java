package koval.mobile.gui.pages.common.menu;

import com.qaprosoft.carina.core.gui.AbstractPage;
import koval.mobile.gui.pages.service.enums.Menu;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;

public abstract class LeftMenuModalBase extends AbstractPage {

    public LeftMenuModalBase(WebDriver driver) {
        super(driver);
    }

    public LeftMenuModalBase(WebDriver driver, SearchContext searchContext) {
        super(driver);
    }

//    public abstract LeftMenuModalBase openMenu();

    public abstract boolean isElementPresent(Menu menu);


    public abstract LeftMenuModalBase openMenu();

    public abstract AbstractPage openPage(Menu menu);
}
