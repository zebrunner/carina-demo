package koval.myfit.mobile.gui.common.menu;

import com.qaprosoft.carina.core.gui.AbstractPage;
import koval.myfit.mobile.gui.MyAbstractPage;
import koval.myfit.mobile.service.enums.DownMenuElement;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;

public abstract class DownMenuModalBase extends MyAbstractPage {

    public DownMenuModalBase(WebDriver driver) {
        super(driver);
    }

    public DownMenuModalBase(WebDriver driver, SearchContext searchContext) {
        super(driver);
    }

    public abstract AbstractPage openPageByName(DownMenuElement downMenuElement);
}
