package koval.myfit.mobile.gui.ios.downMenuPages;


import com.zebrunner.carina.utils.factory.DeviceType;
import koval.myfit.mobile.gui.common.downMenuPages.JournalPageBase;
import org.openqa.selenium.WebDriver;


@DeviceType(pageType = DeviceType.Type.IOS_PHONE, parentClass = JournalPageBase.class)
public class JournalPage extends JournalPageBase {
    public JournalPage(WebDriver driver) {
        super(driver);
    }

}
