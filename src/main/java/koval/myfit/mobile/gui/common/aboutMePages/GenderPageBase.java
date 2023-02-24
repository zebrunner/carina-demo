package koval.myfit.mobile.gui.common.aboutMePages;

import koval.myfit.mobile.gui.MyAbstractPage;
import org.openqa.selenium.WebDriver;


public abstract class GenderPageBase extends MyAbstractPage {

    public GenderPageBase(WebDriver driver) {
        super(driver);
    }

    public abstract GenderPageBase checkGenderByName(String gender);
}
