package koval.myfit.mobile.gui.common.downMenuPages;

import com.qaprosoft.carina.core.gui.AbstractPage;
import koval.myfit.mobile.gui.MyAbstractPage;
import koval.myfit.mobile.service.enums.BrowseMenuElement;
import org.openqa.selenium.WebDriver;


public abstract class BrowsePageBase extends MyAbstractPage {

    public BrowsePageBase(WebDriver driver) {
        super(driver);
    }


    public abstract AbstractPage openCategoryByName(BrowseMenuElement browseMenuElement);
}
