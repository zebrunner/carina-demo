package koval.mobile.gui.pages.ios;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.utils.exception.NotImplementedException;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.utils.factory.DeviceType.Type;
import koval.mobile.gui.pages.common.ChartsPageBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

@DeviceType(pageType = Type.IOS_PHONE, parentClass = ChartsPageBase.class)
public class ChartsPage extends ChartsPageBase {

    public ChartsPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isPageOpened() {
        throw new NotImplementedException();
    }

    @Override
    public boolean isVennChartPresent() {
        throw new NotImplementedException();
    }
}
