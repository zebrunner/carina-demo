package koval.mobile.myfit.gui.ios;


import com.zebrunner.carina.utils.exception.NotImplementedException;
import com.zebrunner.carina.utils.factory.DeviceType;
import koval.mobile.myfit.gui.common.downMenuPages.JournalPageBase;
import koval.mobile.myfit.gui.common.ActivityPageBase;
import org.openqa.selenium.WebDriver;

import java.util.Calendar;


@DeviceType(pageType = DeviceType.Type.IOS_PHONE, parentClass = ActivityPageBase.class)
public class ActivityPage extends ActivityPageBase {


    public ActivityPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isPageOpened(String activityName) {
        throw new NotImplementedException();
    }

    @Override
    public JournalPageBase deleteActivity() {
        throw new NotImplementedException();
    }

    @Override
    public Calendar getStartDateTime()   {
        throw new NotImplementedException();
    }

    @Override
    public Calendar getEndTime()   {
        throw new NotImplementedException();
    }

}
