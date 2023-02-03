package koval.myfit.mobile.gui.pages.ios.menuPages;


import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.utils.mobile.IMobileUtils;
import koval.myfit.mobile.gui.pages.common.menuPages.BrowsePageBase;
import org.openqa.selenium.WebDriver;


@DeviceType(pageType = DeviceType.Type.IOS_PHONE, parentClass = BrowsePageBase.class)
public class BrowsePage extends BrowsePageBase implements IMobileUtils {

    public BrowsePage(WebDriver driver) {
        super(driver);
    }

}
