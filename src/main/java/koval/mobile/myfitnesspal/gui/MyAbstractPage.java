package koval.mobile.myfitnesspal.gui;


import com.zebrunner.carina.utils.factory.DeviceType;
import org.openqa.selenium.WebDriver;



@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = MyAbstractPageBase.class)
public class MyAbstractPage extends MyAbstractPageBase {

    public MyAbstractPage(WebDriver driver) {
        super(driver);
    }
}