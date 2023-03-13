package koval.mobile.myfit.gui.common.downMenuPages;

import com.qaprosoft.carina.core.gui.AbstractPage;
import koval.mobile.myfit.gui.MyAbstractPage;
import koval.mobile.myfit.service.enums.BrowseMenuElement;
import koval.mobile.myfit.service.enums.DownMenuElement;
import org.openqa.selenium.WebDriver;

import java.io.IOException;


public abstract class BrowsePageBase extends MyAbstractPage {

    public BrowsePageBase(WebDriver driver) {
        super(driver);
    }


    public abstract AbstractPage openCategoryByName(BrowseMenuElement browseMenuElement);


    public abstract AbstractPage openPageFromDownMenuByName(DownMenuElement downMenuElement);

    public abstract int getAccountImageColor() throws IOException;
}
