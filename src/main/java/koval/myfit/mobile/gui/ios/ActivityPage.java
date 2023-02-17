package koval.myfit.mobile.gui.ios;


import com.zebrunner.carina.utils.exception.NotImplementedException;
import com.zebrunner.carina.utils.factory.DeviceType;
import koval.myfit.mobile.gui.common.ActivityPageBase;
import koval.myfit.mobile.gui.common.downMenuPages.JournalPageBase;
import org.openqa.selenium.WebDriver;



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
    public String getDateTime() {
        throw new NotImplementedException();
    }
}
