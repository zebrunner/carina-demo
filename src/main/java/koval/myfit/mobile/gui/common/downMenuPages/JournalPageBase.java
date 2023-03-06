package koval.myfit.mobile.gui.common.downMenuPages;

import com.qaprosoft.carina.core.gui.AbstractPage;
import koval.myfit.mobile.gui.MyAbstractPage;
import koval.myfit.mobile.gui.common.ActivityPageBase;
import koval.myfit.mobile.gui.common.modal.PlusButtonModalBase;
import koval.myfit.mobile.service.enums.DownMenuElement;
import koval.myfit.mobile.service.enums.PlusButtonMenuElement;
import org.openqa.selenium.WebDriver;

import java.io.IOException;
import java.text.ParseException;
import java.util.Calendar;


public abstract class JournalPageBase extends MyAbstractPage {

    public JournalPageBase(WebDriver driver) {
        super(driver);
    }

    public abstract int getAccountImageColor() throws IOException;

    public abstract AbstractPage openPageFromDownMenuByName(DownMenuElement downMenuElement);


    public abstract String getActivityName();

    public abstract Calendar getStartTime() throws ParseException;

    public abstract Calendar getDuration() throws ParseException;

    public abstract boolean isActivityPresent(String activityTitle);

    public abstract ActivityPageBase openActivityByIndex(int activityIndex);

    public abstract ActivityPageBase openActivity();

    public abstract int getActivityListSize();

    public abstract PlusButtonModalBase openPlusButtonMenu();

    public abstract AbstractPage openPageFromPlusButtonMenuByName(PlusButtonMenuElement plusButtonMenuElement);

    public abstract JournalPageBase clearActivityList();
}
