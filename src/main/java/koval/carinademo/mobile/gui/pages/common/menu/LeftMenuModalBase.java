package koval.carinademo.mobile.gui.pages.common.menu;

import koval.carinademo.mobile.gui.pages.service.enums.LeftMenu;
import com.qaprosoft.carina.core.gui.AbstractPage;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;

public abstract class LeftMenuModalBase extends AbstractPage {

    public LeftMenuModalBase(WebDriver driver) {
        super(driver);
    }

    public LeftMenuModalBase(WebDriver driver, SearchContext searchContext) {
        super(driver);
    }


    public abstract boolean isElementPresent(LeftMenu menu);

    public abstract LeftMenuModalBase openMenu();

    public abstract AbstractPage openPage(LeftMenu menu);

}
