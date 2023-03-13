package koval.mobile.myfit.gui.android.profilePages;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.utils.factory.DeviceType;
import koval.mobile.myfit.gui.common.profilePages.SettingsPageBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;


@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = SettingsPageBase.class)
public class SettingsPage extends SettingsPageBase {

    @FindBy(xpath = "//*[@content-desc='Navigate up']//following-sibling::*[@class ='android.widget.TextView']")
    private ExtendedWebElement title;

    public SettingsPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isPageOpened() {
        return isPageOpened(title, "Settings");
    }
}
