package koval.mobile.myfitnesspal.gui.common.phoneInterface;

import koval.mobile.myfitnesspal.gui.MyAbstractPage;
import org.openqa.selenium.WebDriver;


public abstract class PhoneWidgetPageBase extends MyAbstractPage {

    public PhoneWidgetPageBase(WebDriver driver) {
        super(driver);
    }

    public abstract boolean isPageOpened(int timeout);

    public abstract PhoneWidgetPageBase searchForApp(String appName);

    public abstract PhoneHomePageBase addWidgetToDesktop(String widgetName);
}
