package koval.myfit.mobile.gui.common.downMenuPages;

import com.qaprosoft.carina.core.gui.AbstractPage;
import koval.myfit.mobile.gui.MyAbstractPage;
import koval.myfit.mobile.gui.common.ActivityPageBase;
import koval.myfit.mobile.service.enums.DownMenuElement;
import org.openqa.selenium.WebDriver;

import java.text.ParseException;
import java.util.Calendar;


public abstract class JournalPageBase extends MyAbstractPage {

    public JournalPageBase(WebDriver driver) {
        super(driver);
    }

    public abstract AbstractPage openPageFromDownMenuByName(DownMenuElement downMenuElement);


    public abstract String getActivityName();

    public abstract int getActivityIndex(String activityTitle);

    public abstract Calendar getDuration(int activityIndex) throws ParseException;

    public abstract Calendar getStartTime(int activityIndex) throws ParseException;


    public abstract boolean isActivityPresent(String activityTitle);

    public abstract ActivityPageBase openActivityByIndex(int activityIndex);

    public abstract ActivityPageBase openActivity();

    public abstract int getActivityListSize();
}
