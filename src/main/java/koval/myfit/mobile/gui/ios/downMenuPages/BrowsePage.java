package koval.myfit.mobile.gui.ios.downMenuPages;


import com.zebrunner.carina.utils.factory.DeviceType;
import koval.myfit.mobile.gui.common.downMenuPages.BrowsePageBase;
import org.openqa.selenium.WebDriver;


@DeviceType(pageType = DeviceType.Type.IOS_PHONE, parentClass = BrowsePageBase.class)
public class BrowsePage extends BrowsePageBase {

    public BrowsePage(WebDriver driver) {
        super(driver);
    }

}
