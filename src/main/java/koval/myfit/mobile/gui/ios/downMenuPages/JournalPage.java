package koval.myfit.mobile.gui.ios.downMenuPages;


import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import com.zebrunner.carina.utils.exception.NotImplementedException;
import com.zebrunner.carina.utils.factory.DeviceType;
import koval.myfit.mobile.gui.common.ActivityPageBase;
import koval.myfit.mobile.gui.common.downMenuPages.JournalPageBase;
import koval.myfit.mobile.service.enums.DownMenuElement;
import koval.myfit.mobile.service.enums.PlusButtonMenuElement;
import org.openqa.selenium.WebDriver;

import java.util.Calendar;



@DeviceType(pageType = DeviceType.Type.IOS_PHONE, parentClass = JournalPageBase.class)
public class JournalPage extends JournalPageBase {
    public JournalPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public AbstractPage openPageFromDownMenuByName(DownMenuElement downMenuElement) {
        throw new NotImplementedException();
    }

    @Override
    public String getActivityName() {
        throw new NotImplementedException();
    }

    @Override
    public int getActivityIndex(String activityTitle) {
        throw new NotImplementedException();
    }

    @Override
    public Calendar getDuration(int activityIndex) {
        throw new NotImplementedException();
    }

    @Override
    public Calendar getStartTime(int activityIndex) {
        throw new NotImplementedException();
    }

    @Override
    public boolean isActivityPresent(String activityTitle) {
        throw new NotImplementedException();
    }

    @Override
    public ActivityPageBase openActivityByIndex(int activityIndex) {
        throw new NotImplementedException();
    }

    @Override
    public ActivityPageBase openActivity() {
        throw new NotImplementedException();
    }

    @Override
    public int getActivityListSize() {
        throw new NotImplementedException();
    }

    @Override
    public ExtendedWebElement openPlusButtonMenu() {
        throw new NotImplementedException();
    }

    @Override
    public AbstractPage openPageFromPlusButtonMenuByName(PlusButtonMenuElement plusButtonMenuElement) {
        throw new NotImplementedException();
    }

    @Override
    public JournalPageBase clearActivityList() {
        throw new NotImplementedException();
    }


}
