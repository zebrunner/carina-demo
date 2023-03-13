package koval.mobile.myfitnesspal.gui.android.loginPages;


import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.utils.factory.DeviceType;
import koval.mobile.myfitnesspal.gui.common.loginPages.LogInPageBase;
import koval.mobile.myfitnesspal.gui.common.loginPages.SignUpPageBase;
import koval.mobile.myfitnesspal.gui.common.loginPages.WelcomePageBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;


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


    @Override
    public WelcomePageBase notificationSendPopUp(String answer) {

        if(itemByText.format(answer).isElementPresent(TIMEOUT_FIVE))
        {
            itemByText.format(answer).click();
        }

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
