package koval.myfit.mobile.gui.pages.android.menuPages;


import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.utils.mobile.IMobileUtils;
import koval.myfit.mobile.gui.pages.common.menuPages.JournalPageBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;


@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = JournalPageBase.class)
public class JournalPage extends JournalPageBase implements IMobileUtils {

    public JournalPage(WebDriver driver) {
        super(driver);
    }

}
