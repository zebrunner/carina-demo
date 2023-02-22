package koval.myfit.mobile.gui.common.browsePages;

import koval.myfit.mobile.gui.MyAbstractPage;
import org.openqa.selenium.WebDriver;


public abstract class VitalsPageBase extends MyAbstractPage {

    public VitalsPageBase(WebDriver driver) {
        super(driver);
    }

    public abstract int getTopNumberBloodPressure();

    public abstract int getBottomNumberBloodPressure();
}
