package koval.mobile.gui.pages.ios;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.utils.factory.DeviceType.Type;
import koval.mobile.gui.pages.common.CarinaDescriptionPageBase;
import org.apache.commons.lang3.NotImplementedException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

@DeviceType(pageType = Type.IOS_PHONE, parentClass = CarinaDescriptionPageBase.class)
public class CarinaDescriptionPage extends CarinaDescriptionPageBase {
    @FindBy(id = "content_frame")
    private ExtendedWebElement webViewContent;

    public CarinaDescriptionPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isPageOpened() {
        throw new NotImplementedException("");
    }

}