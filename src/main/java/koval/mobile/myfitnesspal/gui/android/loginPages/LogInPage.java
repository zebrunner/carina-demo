package koval.mobile.myfitnesspal.gui.android.loginPages;


import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.utils.factory.DeviceType;
import koval.mobile.myfitnesspal.gui.android.modal.TopToolbarModal;
import koval.mobile.myfitnesspal.gui.common.downMenuPages.DashboardPageBase;
import koval.mobile.myfitnesspal.gui.common.loginPages.LogInPageBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.invoke.MethodHandles;


@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = LogInPageBase.class)
public class LogInPage extends LogInPageBase {

    @FindBy(id = "com.myfitnesspal.android:id/toolbar")
    private TopToolbarModal topToolbarModal;

    @FindBy(xpath = "//*[@text='%s']")
    private ExtendedWebElement itemByText;

    @FindBy(xpath = "//android.widget.Button[@text='{L10N:logIn}']")
    private ExtendedWebElement loginButton;

    @FindBy(xpath = "//*[@resource-id='buttonExistingUserTutorial']/child::*[@class='android.widget.Button']")
    private ExtendedWebElement exitTutorialButton;

    private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());


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

        int attemp = 3;
        while (itemByText.format(CANCEL).isElementPresent(TIMEOUT_TEN) && attemp > 0) {
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
