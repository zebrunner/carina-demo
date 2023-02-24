package koval.myfit.mobile.gui.ios.downMenuPages;


import com.qaprosoft.carina.core.gui.AbstractPage;
import com.zebrunner.carina.utils.exception.NotImplementedException;
import com.zebrunner.carina.utils.factory.DeviceType;
import koval.myfit.mobile.gui.common.downMenuPages.BrowsePageBase;
import koval.myfit.mobile.service.enums.BrowseMenuElement;
import org.openqa.selenium.WebDriver;


@DeviceType(pageType = DeviceType.Type.IOS_PHONE, parentClass = BrowsePageBase.class)
public class BrowsePage extends BrowsePageBase {

    public BrowsePage(WebDriver driver) {
        super(driver);
    }

    @Override
    public AbstractPage openCategoryByName(BrowseMenuElement browseMenuElement) {
        throw new NotImplementedException();
    }

}
