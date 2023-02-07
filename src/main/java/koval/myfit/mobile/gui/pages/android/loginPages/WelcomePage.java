package koval.myfit.mobile.gui.pages.android.loginPages;


import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.utils.factory.DeviceType;
import koval.myfit.mobile.gui.pages.common.loginPages.AboutMePageBase;
import koval.myfit.mobile.gui.pages.common.loginPages.WelcomePageBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;


@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = WelcomePageBase.class)
public class WelcomePage extends WelcomePageBase {

    @FindBy(id = "com.google.android.apps.fitness:id/fit_app_icon")
    private ExtendedWebElement heartLogoImage;

    @FindBy(id = "com.google.android.apps.fitness:id/login_button")
    private ExtendedWebElement loginButton;

    public WelcomePage(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isPageOpened() {
        return heartLogoImage.isElementPresent(TIMEOUT_FIVE) && loginButton.isElementPresent(TIMEOUT_FIVE);
    }

    @Override
    public AboutMePageBase clickLoginBtn() {
        loginButton.click();
        return initPage(getDriver(), AboutMePageBase.class);
    }

}
