package koval.myfit.mobile.gui.pages.common.menuPages;

import com.qaprosoft.carina.core.gui.AbstractPage;
import koval.myfit.mobile.gui.pages.service.MyAbstractPage;
import org.openqa.selenium.WebDriver;


public abstract class BrowsePageBase extends MyAbstractPage {

    public BrowsePageBase(WebDriver driver) {
        super(driver);
    }

}
