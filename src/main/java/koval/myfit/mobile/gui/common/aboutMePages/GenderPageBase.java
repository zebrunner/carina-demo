package koval.myfit.mobile.gui.common.aboutMePages;

import koval.myfit.mobile.gui.MyAbstractPage;
import koval.myfit.mobile.gui.common.downMenuPages.ProfilePageBase;
import koval.myfit.mobile.service.enums.Gender;
import org.openqa.selenium.WebDriver;


public abstract class GenderPageBase extends MyAbstractPage {

    public GenderPageBase(WebDriver driver) {
        super(driver);
    }

    public abstract GenderPageBase checkGenderByName(Gender gender);

    public abstract GenderPageBase checkGenderByName(String gender);
}
