package koval.mobile.myfitnesspal.gui.ios.phoneInterface;


import com.zebrunner.carina.utils.exception.NotImplementedException;
import com.zebrunner.carina.utils.factory.DeviceType;
import koval.mobile.myfitnesspal.gui.common.phoneInterface.PhoneHomePageBase;
import koval.mobile.myfitnesspal.gui.common.phoneInterface.PhoneWidgetPageBase;
import org.openqa.selenium.WebDriver;


@DeviceType(pageType = DeviceType.Type.IOS_PHONE, parentClass = PhoneWidgetPageBase.class)
public class PhoneWidgetPage extends PhoneWidgetPageBase {

    public PhoneWidgetPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isPageOpened(int timeout) {
        throw new NotImplementedException();
    }

    @Override
    public PhoneHomePageBase addWidgetToDesktop(String appName, String widgetName) {
        throw new NotImplementedException();
    }
}
