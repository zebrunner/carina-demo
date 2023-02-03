package koval.myfit.mobile.gui.pages.android.menuPages;


import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.utils.mobile.IMobileUtils;
import koval.myfit.mobile.gui.pages.common.menuPages.BrowsePageBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;


@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = BrowsePageBase.class)
public class BrowsePage extends BrowsePageBase {
    public BrowsePage(WebDriver driver) {
        super(driver);
    }

}
