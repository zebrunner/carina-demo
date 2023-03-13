package koval.mobile.myfit.gui.common.modal;

import com.qaprosoft.carina.core.gui.AbstractPage;
import koval.mobile.myfit.gui.MyAbstractPage;
import koval.mobile.myfit.service.enums.DownMenuElement;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;

import java.io.IOException;

public abstract class DownMenuModalBase extends MyAbstractPage {

    public DownMenuModalBase(WebDriver driver) {
        super(driver);
    }

    public DownMenuModalBase(WebDriver driver, SearchContext searchContext) {
        super(driver);
    }

    public abstract AbstractPage openPageByName(DownMenuElement downMenuElement);


    public abstract String getIconColor(DownMenuElement downMenuElement) throws IOException;

    public abstract String getLabelColor(DownMenuElement downMenuElement) throws IOException;
}
