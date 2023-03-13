package koval.mobile.myfit.gui.common.modal;

import koval.mobile.myfit.gui.MyAbstractPage;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;

import java.util.Calendar;

public abstract class TimePickerModalBase extends MyAbstractPage {

    public TimePickerModalBase(WebDriver driver) {
        super(driver);
    }

    public TimePickerModalBase(WebDriver driver, SearchContext searchContext) {
        super(driver);
    }

    public abstract TimePickerModalBase setTime(Calendar calendar);
}
