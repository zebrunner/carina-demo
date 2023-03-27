package koval.mobile.myfitnesspal.gui.android.loginPages;


import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.utils.factory.DeviceType;
import koval.mobile.myfitnesspal.gui.android.modal.TopToolbarModal;
import koval.mobile.myfitnesspal.gui.common.downMenuPages.DashboardPageBase;
import koval.mobile.myfitnesspal.gui.common.loginPages.LogInPageBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;


@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = LogInPageBase.class)
public class LogInPage extends LogInPageBase {

    @FindBy(id = "com.myfitnesspal.android:id/toolbar")
    private TopToolbarModal topToolbarModal;

    @FindBy(xpath = "//*[@text='%s']")
    private ExtendedWebElement itemByText;

    @FindBy(xpath = "//android.widget.Button[@text='Log In']")
    private ExtendedWebElement loginButton;

    @FindBy(xpath = "//*[@resource-id='buttonExistingUserTutorial']/child::*[@class='android.widget.Button']")
    private ExtendedWebElement exitTutorialButton;


    public LogInPage(WebDriver driver) {
        super(driver);
    }


    @Override
    public boolean isPageOpened() {
        return topToolbarModal.isPageOpened(LOGIN);
    }

    @Override
    public LogInPageBase typeMail(String password) {
        itemByText.format(EMAIL_ADDRESS).type(password, TIMEOUT_FIVE);
        return initPage(getDriver(), LogInPageBase.class);
    }


    @Override
    public LogInPageBase typePassword(String password) {
        itemByText.format(PASSWORD).type(password, TIMEOUT_FIVE);
        return initPage(getDriver(), LogInPageBase.class);
    }

    @Override
    public LogInPageBase clickLoginButton() {

        loginButton.click();
        return initPage(getDriver(), LogInPageBase.class);
    }


    @Override
    public DashboardPageBase closeNoSubscriptionsPopUpIfPresent() {

        waitUntil(ExpectedConditions.visibilityOfElementLocated(itemByText.format(CANCEL).getBy()), TIMEOUT_TWENTY);

        itemByText.format(CANCEL).click();

        return initPage(getDriver(), DashboardPageBase.class);
    }


    @Override
    public DashboardPageBase closeUserTutorialBoxIfPresent() {

        while (exitTutorialButton.isElementPresent(TIMEOUT_TEN)) {
            exitTutorialButton.clickIfPresent(TIMEOUT_TEN);
        }

        return initPage(getDriver(), DashboardPageBase.class);
    }


}
