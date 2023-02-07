package koval.myfit.mobile.gui.pages.android.menuPages;


import com.zebrunner.carina.utils.factory.DeviceType;
import koval.myfit.mobile.gui.pages.common.menuPages.BrowsePageBase;
import org.openqa.selenium.WebDriver;



@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = BrowsePageBase.class)
public class BrowsePage extends BrowsePageBase {

    public BrowsePage(WebDriver driver) {
        super(driver);
    }

}
