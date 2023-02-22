package koval.myfit.mobile.gui.common.aboutMePages;

import koval.myfit.mobile.gui.MyAbstractPage;
import org.openqa.selenium.WebDriver;


public abstract class BirthdayPageBase extends MyAbstractPage {

    public BirthdayPageBase(WebDriver driver) {
        super(driver);
    }

    public abstract BirthdayPageBase setDate();

    public abstract BirthdayPageBase saveChanges();

    public abstract BirthdayPageBase returnBack();
}
