package koval.myfit.mobile.gui.pages.common.menu;

import com.qaprosoft.carina.core.gui.AbstractPage;
import koval.myfit.mobile.gui.pages.service.enums.DownMenuElement;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;

public abstract class DownMenuModalBase extends AbstractPage {

    public DownMenuModalBase(WebDriver driver) {
        super(driver);
    }

    public DownMenuModalBase(WebDriver driver, SearchContext searchContext) {
        super(driver);
    }

    public abstract AbstractPage openPageByName(DownMenuElement downMenuElement);
}
