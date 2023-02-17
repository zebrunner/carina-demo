package koval.myfit.mobile.gui.common.plusButtonPages;

import koval.myfit.mobile.gui.MyAbstractPage;
import koval.myfit.mobile.gui.common.downMenuPages.JournalPageBase;
import koval.myfit.mobile.gui.common.modal.DatePickerModalBase;
import koval.myfit.mobile.gui.common.modal.TimePickerModalBase;
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

    public abstract String selectRandomActivity();

    public abstract JournalPageBase saveActivity();
}
