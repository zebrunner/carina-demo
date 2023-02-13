package koval.myfit.mobile.gui.common.plusButtonPages;

import koval.myfit.mobile.gui.MyAbstractPage;
import koval.myfit.mobile.gui.common.modal.TimePickerModalBase;
import org.openqa.selenium.WebDriver;

import java.util.Calendar;


public abstract class AddActivityPageBase extends MyAbstractPage {

    public AddActivityPageBase(WebDriver driver) {
        super(driver);
    }

    public abstract TimePickerModalBase setTime(Calendar calendar);

    public abstract AddActivityPageBase selectActivity(String activity);

    public abstract AddActivityPageBase selectRandomActivity();
}
