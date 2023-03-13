package koval.mobile.carinademo.gui.android.loginPages;

import koval.mobile.carinademo.gui.common.loginPages.LoginPageBase;
import koval.mobile.carinademo.gui.common.loginPages.WelcomePageBase;
import koval.mobile.carinademo.service.interfaces.IConstantUtils;
import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;

import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.utils.factory.DeviceType.Type;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

@DeviceType(pageType = Type.ANDROID_PHONE, parentClass = WelcomePageBase.class)
public class WelcomePage extends WelcomePageBase {

    @FindBy(id = "com.solvd.carinademoapplication:id/carina_logo")
    private ExtendedWebElement title;

    @FindBy(id = "com.solvd.carinademoapplication:id/next_button")
    private ExtendedWebElement nextBtn;

    public WelcomePage(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isPageOpened() {
        return title.isElementPresent(IConstantUtils.TIMEOUT_FIVE);
    }

    @Override
    public LoginPageBase clickNextBtn() {
        nextBtn.click();
        return initPage(getDriver(), LoginPageBase.class);
    }

}
