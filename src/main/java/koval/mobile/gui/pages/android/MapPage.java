package koval.mobile.gui.pages.android;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.utils.factory.DeviceType.Type;
import koval.mobile.gui.pages.common.MapPageBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

@DeviceType(pageType = Type.ANDROID_PHONE, parentClass = MapPageBase.class)
public class MapPage extends MapPageBase {

    @FindBy(className = "android.widget.TextView")
    private ExtendedWebElement title;

    @FindBy(xpath = "//android.widget.RelativeLayout[@index='2']")
    private ExtendedWebElement mapImage;

    public MapPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isPageOpened() {
        return title.isElementPresent();
    }

    @Override
    public boolean isMapImagePresent() {
        return mapImage.isElementPresent();
    }
}
