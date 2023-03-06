package koval.myfit.mobile.gui.ios.downMenuPages;


import com.qaprosoft.carina.core.gui.AbstractPage;
import com.zebrunner.carina.utils.exception.NotImplementedException;
import com.zebrunner.carina.utils.factory.DeviceType;
import koval.myfit.mobile.gui.common.downMenuPages.BrowsePageBase;
import koval.myfit.mobile.service.enums.BrowseMenuElement;
import koval.myfit.mobile.service.enums.DownMenuElement;
import org.openqa.selenium.WebDriver;

import java.io.IOException;


@DeviceType(pageType = DeviceType.Type.IOS_PHONE, parentClass = BrowsePageBase.class)
public class BrowsePage extends BrowsePageBase {

    public BrowsePage(WebDriver driver) {
        super(driver);
    }

    @Override
    public AbstractPage openCategoryByName(BrowseMenuElement browseMenuElement) {
        throw new NotImplementedException();
    }

    @Override
    public AbstractPage openPageFromDownMenuByName(DownMenuElement downMenuElement) {
        throw new NotImplementedException();
    }

    @Override
    public int getAccountImageColor() throws IOException {
        throw new NotImplementedException();
    }

}
