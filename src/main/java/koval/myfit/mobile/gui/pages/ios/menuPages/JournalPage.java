package koval.myfit.mobile.gui.pages.ios.menuPages;


import com.zebrunner.carina.utils.factory.DeviceType;
import koval.myfit.mobile.gui.pages.common.menuPages.JournalPageBase;
import org.openqa.selenium.WebDriver;


@DeviceType(pageType = DeviceType.Type.IOS_PHONE, parentClass = JournalPageBase.class)
public class JournalPage extends JournalPageBase {
    public JournalPage(WebDriver driver) {
        super(driver);
    }

}
