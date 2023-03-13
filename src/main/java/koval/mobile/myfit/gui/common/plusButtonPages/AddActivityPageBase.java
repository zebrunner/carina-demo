package koval.mobile.myfit.gui.common.plusButtonPages;

import koval.mobile.myfit.gui.common.downMenuPages.JournalPageBase;
import koval.mobile.myfit.gui.common.modal.DatePickerModalBase;
import koval.mobile.myfit.gui.common.modal.TimePickerModalBase;
import koval.mobile.myfit.gui.MyAbstractPage;
import org.openqa.selenium.WebDriver;

import java.util.Calendar;


public abstract class AddActivityPageBase extends MyAbstractPage {

    public AddActivityPageBase(WebDriver driver) {
        super(driver);
    }

    public abstract TimePickerModalBase setTime(Calendar calendar);

    public abstract AddActivityPageBase setDuration(Calendar calendar);

    public abstract DatePickerModalBase setDate(Calendar calendar);

    public abstract String selectActivity(String activity);

    public abstract JournalPageBase saveActivity();
}
