package koval.mobile.myfit.gui.common.modal;

import koval.mobile.myfit.gui.MyAbstractPage;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;

import java.util.Calendar;


public abstract class DatePickerModalBase extends MyAbstractPage {

    public DatePickerModalBase(WebDriver driver) {
        super(driver);
    }

    public DatePickerModalBase(WebDriver driver, SearchContext searchContext) {
        super(driver);
    }

    public abstract DatePickerModalBase setDate(Calendar calendar);
}
