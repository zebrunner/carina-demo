package koval.mobile.gui.pages.ios;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.utils.exception.NotImplementedException;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.utils.factory.DeviceType.Type;
import koval.mobile.gui.pages.common.UIElementsPageBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

@DeviceType(pageType = Type.ANDROID_PHONE, parentClass = UIElementsPageBase.class)
public class UIElementsPage extends UIElementsPageBase {
    public UIElementsPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isPageOpened() {
        throw new NotImplementedException();
    }

    @Override
    public boolean isImageViewPresent() {
        throw new NotImplementedException();
    }
}
