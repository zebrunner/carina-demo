package koval.mobile.myfit.gui.common.browsePages;

import koval.mobile.myfit.gui.MyAbstractPage;
import org.openqa.selenium.WebDriver;


public abstract class VitalsPageBase extends MyAbstractPage {

    public VitalsPageBase(WebDriver driver) {
        super(driver);
    }

    public abstract int getTopNumberBloodPressure();

    public abstract int getBottomNumberBloodPressure();
}
