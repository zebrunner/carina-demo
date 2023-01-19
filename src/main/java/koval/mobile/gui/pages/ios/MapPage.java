package koval.mobile.gui.pages.ios;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.utils.exception.NotImplementedException;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.utils.factory.DeviceType.Type;
import koval.mobile.gui.pages.common.MapPageBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

@DeviceType(pageType = Type.ANDROID_PHONE, parentClass = MapPageBase.class)
public class MapPage extends MapPageBase {

    public MapPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isPageOpened() {
        throw new NotImplementedException();
    }

    @Override
    public boolean isMapImagePresent() {
        throw new NotImplementedException();
    }
}
