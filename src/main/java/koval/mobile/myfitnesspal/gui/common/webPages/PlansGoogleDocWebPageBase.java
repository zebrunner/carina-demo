package koval.mobile.myfitnesspal.gui.common.webPages;

import koval.mobile.myfitnesspal.gui.MyAbstractPageBase;
import org.openqa.selenium.WebDriver;


public abstract class PlansGoogleDocWebPageBase extends MyAbstractPageBase {

    public PlansGoogleDocWebPageBase(WebDriver driver) {
        super(driver);
    }

    public abstract boolean isPageOpened(int timeout, String url);

    public abstract PlansGoogleDocWebPageBase closeChromeStopsWorkingPopUpIfPresent();
}
