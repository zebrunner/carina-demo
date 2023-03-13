package koval.mobile.myfit.gui.common.aboutMePages;

import koval.mobile.myfit.gui.MyAbstractPage;
import org.openqa.selenium.WebDriver;


public abstract class GenderPageBase extends MyAbstractPage {

    public GenderPageBase(WebDriver driver) {
        super(driver);
    }

    public abstract GenderPageBase checkGenderByName(String gender);
}
