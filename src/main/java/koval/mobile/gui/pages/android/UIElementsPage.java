package koval.mobile.gui.pages.android;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.utils.factory.DeviceType.Type;
import koval.mobile.gui.pages.common.UIElementsPageBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

@DeviceType(pageType = Type.ANDROID_PHONE, parentClass = UIElementsPageBase.class)
public class UIElementsPage extends UIElementsPageBase {

    @FindBy(className = "android.widget.TextView")
    private ExtendedWebElement title;

    @FindBy(id = "imageView")
    private ExtendedWebElement imageView;

    public UIElementsPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isPageOpened() {
        return title.isElementPresent();
    }

    @Override
    public boolean isImageViewPresent() {
        return imageView.isElementPresent();
    }
}
