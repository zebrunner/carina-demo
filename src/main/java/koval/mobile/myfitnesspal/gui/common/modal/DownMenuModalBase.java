package koval.mobile.myfitnesspal.gui.common.modal;

import com.qaprosoft.carina.core.gui.AbstractPage;
import koval.mobile.myfitnesspal.gui.MyAbstractPage;
import koval.mobile.myfitnesspal.service.enums.DownMenuElement;
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
