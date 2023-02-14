package koval.myfit.mobile.gui.common.downMenuPages;

import com.qaprosoft.carina.core.gui.AbstractPage;
import koval.myfit.mobile.gui.MyAbstractPage;
import koval.myfit.mobile.gui.common.ActivityPageBase;
import koval.myfit.mobile.service.enums.DownMenuElement;
import org.openqa.selenium.WebDriver;


public abstract class JournalPageBase extends MyAbstractPage {

    public JournalPageBase(WebDriver driver) {
        super(driver);
    }

    public abstract AbstractPage openPageFromDownMenuByName(DownMenuElement downMenuElement);


    public abstract String getActivityName();

    public abstract boolean isActivityPresent(String activityTitle);

    public abstract ActivityPageBase openActivity();

    public abstract int getActivityListSize();
}
