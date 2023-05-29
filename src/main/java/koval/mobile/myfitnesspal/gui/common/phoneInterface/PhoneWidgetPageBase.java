package koval.mobile.myfitnesspal.gui.common.phoneInterface;

import koval.mobile.myfitnesspal.gui.MyAbstractPageBase;
import org.openqa.selenium.WebDriver;


public abstract class PhoneWidgetPageBase extends MyAbstractPageBase {

    public PhoneWidgetPageBase(WebDriver driver) {
        super(driver);
    }

    public abstract boolean isPageOpened(int timeout);


    public abstract PhoneHomePageBase closeFingertipsPopUpIfPresent();

    public abstract PhoneHomePageBase addWidgetToDesktop(String appName, String widgetName);
}
