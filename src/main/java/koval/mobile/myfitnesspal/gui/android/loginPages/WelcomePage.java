package koval.mobile.myfitnesspal.gui.android.loginPages;


import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.utils.factory.DeviceType;
import koval.mobile.myfitnesspal.gui.common.loginPages.LogInPageBase;
import koval.mobile.myfitnesspal.gui.common.loginPages.SignUpPageBase;
import koval.mobile.myfitnesspal.gui.common.loginPages.WelcomePageBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.invoke.MethodHandles;


@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = WelcomePageBase.class)
public class WelcomePage extends WelcomePageBase {

    @FindBy(xpath = "//*[@text='%s']")
    private ExtendedWebElement itemByText;

    public WelcomePage(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isPageOpened() {
        return itemByText.format(SIGNUP).isElementPresent(TIMEOUT_TEN) && itemByText.format(LOGIN).isElementPresent(TIMEOUT_TEN);
    }

    private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());


    @Override
    public WelcomePageBase notificationSendPopUpIfPresent(String answer) {

        itemByText.format(answer).clickIfPresent(TIMEOUT_FIVE);

        return initPage(getDriver(), WelcomePageBase.class);
    }

    @Override
    public SignUpPageBase signUp() {
        itemByText.format(SIGNUP).click();
        return initPage(getDriver(), SignUpPageBase.class);
    }

    @Override
    public LogInPageBase logIn() {
        itemByText.format(LOGIN).click();
        return initPage(getDriver(), LogInPageBase.class);
    }


}
