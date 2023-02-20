package koval.myfit.mobile.gui.common;

import koval.myfit.mobile.gui.MyAbstractPage;
import koval.myfit.mobile.gui.common.downMenuPages.JournalPageBase;
import org.openqa.selenium.WebDriver;

import java.text.ParseException;
import java.util.Calendar;
import java.util.Date;


public abstract class ActivityPageBase extends MyAbstractPage {

    public ActivityPageBase(WebDriver driver) {
        super(driver);
    }


    public abstract boolean isPageOpened(String activityName);

    public abstract JournalPageBase deleteActivity();


    public abstract Calendar getStartDateTime() throws ParseException;

    public abstract Calendar getEndTime() throws ParseException;
}
