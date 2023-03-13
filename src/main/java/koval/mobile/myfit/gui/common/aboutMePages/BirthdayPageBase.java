package koval.mobile.myfit.gui.common.aboutMePages;

import koval.mobile.myfit.gui.MyAbstractPage;
import org.openqa.selenium.WebDriver;

import java.util.Calendar;


public abstract class BirthdayPageBase extends MyAbstractPage {

    public BirthdayPageBase(WebDriver driver) {
        super(driver);
    }

    public abstract BirthdayPageBase setDate(Calendar calendar);

    public abstract BirthdayPageBase saveChanges();

    public abstract BirthdayPageBase returnBack();
}
