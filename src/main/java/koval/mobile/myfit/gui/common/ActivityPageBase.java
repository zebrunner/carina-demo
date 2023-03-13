package koval.mobile.myfit.gui.common;

import koval.mobile.myfit.gui.MyAbstractPage;
import koval.mobile.myfit.gui.common.downMenuPages.JournalPageBase;
import org.openqa.selenium.WebDriver;

import java.text.ParseException;
import java.util.Calendar;


public abstract class ActivityPageBase extends MyAbstractPage {

    public ActivityPageBase(WebDriver driver) {
        super(driver);
    }


    public abstract boolean isPageOpened(String activityName);

    public abstract JournalPageBase deleteActivity();


    public abstract Calendar getStartDateTime() throws ParseException;

    public abstract Calendar getEndTime() throws ParseException;
}
