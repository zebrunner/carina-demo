package koval.mobile.myfitnesspal.gui.android.loginPages;


import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.utils.factory.DeviceType;
import koval.mobile.myfitnesspal.gui.android.modal.TopToolbarModal;
import koval.mobile.myfitnesspal.gui.common.downMenuPages.dashboardPage.DashboardPageBase;
import koval.mobile.myfitnesspal.gui.common.loginPages.LogInPageBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;


@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = LogInPageBase.class)
public class LogInPage extends LogInPageBase {

    @FindBy(id = "com.myfitnesspal.android:id/toolbar")
    private TopToolbarModal topToolbarModal;

    @FindBy(xpath = "//android.widget.Button[@text='{L10N:logIn}']")
    private ExtendedWebElement loginButton;

    @FindBy(xpath = "//*[@resource-id='buttonExistingUserTutorial']/child::*[@class='android.widget.Button']")
    private ExtendedWebElement exitTutorialButton;

    @FindBy(id = "com.myfitnesspal.android:id/password_edit")
    private ExtendedWebElement passwordField;

    @FindBy(id = "com.myfitnesspal.android:id/email_address_edit")
    private ExtendedWebElement mailField;

    public LogInPage(WebDriver driver) {
        super(driver);
    }


    @Override
    public boolean isPageOpened() {
        return topToolbarModal.isPageOpened(LOGIN);
    }

    @Override
    public LogInPageBase typeMail(String password) {
        mailField.type(password, TIMEOUT_FIVE);
        return initPage(getDriver(), LogInPageBase.class);
    }


    @Override
    public LogInPageBase closeLoginFailedPopUpIfPresent() {
        itemByText.format("Close").clickIfPresent(TIMEOUT_TEN);
        return initPage(getDriver(), LogInPageBase.class);
    }

    @Override
    public LogInPageBase typePassword(String password) {
        passwordField.type(password, TIMEOUT_FIVE);
        return initPage(getDriver(), LogInPageBase.class);
    }


    @Override
    public LogInPageBase clickLoginButton() {
        loginButton.click(TIMEOUT_TEN);
        return initPage(getDriver(), LogInPageBase.class);

    }


    @Override
    public DashboardPageBase closeNoSubscriptionsPopUpIfPresent() {

        waitUntil(ExpectedConditions.visibilityOfElementLocated(itemByText.format(CANCEL).getBy()), TIMEOUT_TWENTY);

        int attemp = 3;
        while (itemByText.format(CANCEL).isElementPresent(TIMEOUT_FIFTEEN) && attemp > 0) {
            itemByText.format(CANCEL).click(TIMEOUT_TEN);

            LOGGER.info("[ DASHBOARD PAGE ] Attempt left: {} for clicking on exit No Subscriptions PopUp button", attemp);
            attemp--;
        }

        return initPage(getDriver(), DashboardPageBase.class);
    }


    @Override
    public void closeUserTutorialBoxIfPresent() {

        int attemp = 3;
        while (exitTutorialButton.isElementPresent(TIMEOUT_TEN) && attemp > 0) {
            exitTutorialButton.click(TIMEOUT_TEN);

            LOGGER.info("[ DASHBOARD PAGE ] Attempt left: {} for clicking on exit tutorial button", attemp);
            attemp--;
        }

        initPage(getDriver(), DashboardPageBase.class);
    }


}
