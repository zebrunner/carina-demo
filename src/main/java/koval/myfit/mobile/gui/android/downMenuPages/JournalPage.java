package koval.myfit.mobile.gui.android.downMenuPages;


import com.zebrunner.carina.utils.factory.DeviceType;
import koval.myfit.mobile.gui.common.downMenuPages.JournalPageBase;
import org.openqa.selenium.WebDriver;


@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = JournalPageBase.class)
public class JournalPage extends JournalPageBase {

    public JournalPage(WebDriver driver) {
        super(driver);
    }

}
