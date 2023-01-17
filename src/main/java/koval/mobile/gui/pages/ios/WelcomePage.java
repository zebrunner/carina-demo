package koval.mobile.gui.pages.ios;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.utils.factory.DeviceType.Type;
import koval.mobile.gui.pages.common.LoginPageBase;
import koval.mobile.gui.pages.common.WelcomePageBase;
import org.apache.commons.lang3.NotImplementedException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

@DeviceType(pageType = Type.IOS_PHONE, parentClass = WelcomePageBase.class)
public class WelcomePage extends WelcomePageBase {

    @FindBy(id = "carina_logo")
    private ExtendedWebElement title;

    @FindBy(id = "next_button")
    private ExtendedWebElement nextBtn;

    public WelcomePage(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isPageOpened() {
        throw new NotImplementedException("");
    }

    @Override
    public LoginPageBase clickNextBtn() {
        throw new NotImplementedException("");
    }

}
