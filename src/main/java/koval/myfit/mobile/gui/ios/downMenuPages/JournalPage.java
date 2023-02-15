package koval.myfit.mobile.gui.ios.downMenuPages;


import com.qaprosoft.carina.core.gui.AbstractPage;
import com.zebrunner.carina.utils.factory.DeviceType;
import koval.myfit.mobile.gui.common.ActivityPageBase;
import koval.myfit.mobile.gui.common.downMenuPages.JournalPageBase;
import koval.myfit.mobile.service.enums.DownMenuElement;
import org.joda.time.DateTime;
import org.openqa.selenium.WebDriver;

import java.util.Calendar;
import java.util.Date;


@DeviceType(pageType = DeviceType.Type.IOS_PHONE, parentClass = JournalPageBase.class)
public class JournalPage extends JournalPageBase {
    public JournalPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public AbstractPage openPageFromDownMenuByName(DownMenuElement downMenuElement) {
        return null;
    }

    @Override
    public String getActivityName() {
        return null;
    }

    @Override
    public int getActivityIndex(String activityTitle) {
        return 0;
    }

    @Override
    public Calendar getDuration(int activityIndex) {


        return null;
    }

    @Override
    public Calendar getStartTime(int activityIndex) {
        return null;
    }

    @Override
    public boolean isActivityPresent(String activityTitle) {
        return false;
    }

    @Override
    public ActivityPageBase openActivityByIndex(int activityIndex) {
        return null;
    }

    @Override
    public ActivityPageBase openActivity() {
        return null;
    }

    @Override
    public int getActivityListSize() {
        return 0;
    }


}
