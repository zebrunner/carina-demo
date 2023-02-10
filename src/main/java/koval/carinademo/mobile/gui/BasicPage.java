package koval.carinademo.mobile.gui;

import com.zebrunner.carina.utils.factory.DeviceType;
import koval.carinademo.mobile.gui.common.BasicPageBase;
import org.openqa.selenium.WebDriver;



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
