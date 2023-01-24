package koval.mobile.gui.pages.service;

import com.zebrunner.carina.utils.factory.DeviceType;
import koval.mobile.gui.pages.common.BasicPageBase;
import org.openqa.selenium.WebDriver;

import static com.zebrunner.agent.core.webdriver.RemoteWebDriverFactory.getDriver;


@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = BasicPageBase.class)
public class BasicPage extends BasicPageBase {


    public BasicPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public void getBack() {
        getDriver().navigate().back();
    }
}
