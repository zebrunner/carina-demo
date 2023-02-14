package koval.myfit.mobile.gui.common;

import koval.myfit.mobile.gui.MyAbstractPage;
import koval.myfit.mobile.gui.common.downMenuPages.JournalPageBase;
import org.openqa.selenium.WebDriver;


public abstract class ActivityPageBase extends MyAbstractPage {

    public ActivityPageBase(WebDriver driver) {
        super(driver);
    }


    public abstract boolean isPageOpened(String activityName);

    public abstract JournalPageBase deleteActivity();
}
