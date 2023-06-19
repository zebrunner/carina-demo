package koval.mobile.myfitnesspal.gui;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.foundation.webdriver.decorator.annotations.CaseInsensitiveXPath;
import com.qaprosoft.carina.core.gui.AbstractPage;
import com.zebrunner.carina.utils.R;
import koval.mobile.myfitnesspal.gui.common.downMenuPages.dashboardPage.DashboardPageBase;
import koval.mobile.myfitnesspal.gui.common.loginPages.LogInPageBase;
import koval.mobile.myfitnesspal.gui.common.loginPages.WelcomePageBase;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.Locale;
import java.util.ResourceBundle;


public abstract class MyAbstractPageBase extends AbstractPage implements IMyInterface {

    @FindBy(xpath = "//*[@resource-id='buttonExistingUserTutorial']/child::*[@class='android.widget.Button']")
    private ExtendedWebElement exitTutorialButton;

    @FindBy(xpath = "//android.view.View/android.view.View[1]/android.view.View/android.view.View[2]/android.view.View/android.widget.Button |" +
            "//android.widget.ImageButton[@content-desc='Interstitial close button']")
    private ExtendedWebElement advertisingCloseButton;


    @FindBy(xpath = "//*[@content-desc='%s']")
    public ExtendedWebElement itemByContent;


    @FindBy(xpath = "//*[@text='%s']")
    public ExtendedWebElement itemByText;

    @CaseInsensitiveXPath
    @FindBy(xpath = "//*[contains(@text,'%s')]")
    public ExtendedWebElement itemByContainsText;


    @FindBy(xpath ="//*[@resource-id='android:id/content']/child::*//*[@resource-id='com.myfitnesspal.android:id/subtitle' and contains(@text, '%s')]")
    public ExtendedWebElement popUpCompletePlanTasks;

    public MyAbstractPageBase(WebDriver driver) {
        super(driver);
    }


    public boolean isPopUpCompletePlanTasksPresent() {
        return popUpCompletePlanTasks.format(COMPLETE_PLAN).isElementPresent(TIMEOUT_FIVE);
    }


    public boolean isPageOpened(ExtendedWebElement title, String textTitle, int timeout) {
        return title.isElementPresent(timeout) && title.getText().equals(textTitle);
    }

    public boolean isPageOpened(ExtendedWebElement title, String textTitle) {
        return isPageOpened(title, textTitle, TIMEOUT_FIFTEEN);
    }

    public void hideKeyboard() {
        pressKey(BACK);
    }

    public WelcomePageBase notificationSendPopUpIfPresent(String answer) {

        itemByText.format(answer).clickIfPresent(TIMEOUT_TEN);

        return initPage(getDriver(), WelcomePageBase.class);
    }

    public boolean isNotificationSendPopUpPresent(String answer) {
        return itemByText.format(answer).isElementPresent(TIMEOUT_TEN);
    }


    public void closeTimestampsPopUpIfPresent() {
        itemByContent.format(NO_THANKS_ANSWER.toUpperCase()).clickIfPresent(TIMEOUT_FIVE);
    }


    public void closeUserTutorialBoxIfPresent() {

        int attemp = 3;
        while (exitTutorialButton.isElementPresent(TIMEOUT_TEN) && attemp > 0) {
            exitTutorialButton.click(TIMEOUT_TEN);

            LOGGER.info("[ DASHBOARD PAGE ] Attempt left: {} for clicking on exit tutorial button", attemp);
            attemp--;
        }

    }

    public void closeCompleteTasksMessageBoxIfPresent() {
        itemByText.format(LATER).clickIfPresent(TIMEOUT_TEN);
    }


    public void closeAdvertisingPopUpIfPresent() {
        waitUntil(ExpectedConditions.visibilityOfElementLocated(advertisingCloseButton.getBy()), TIMEOUT_FIFTEEN);

        itemByText.format(CLOSE).clickIfPresent();
        int attemp = 3;
        while (advertisingCloseButton.format(CANCEL).isElementPresent(TIMEOUT_TEN) && attemp > 0) {
            advertisingCloseButton.format(CANCEL).click(TIMEOUT_TEN);

            LOGGER.info("[ DASHBOARD PAGE ] Attempt left: {} for clicking on exit Advertising PopUp button", attemp);
            attemp--;
        }

    }

    public int getCenterX(ExtendedWebElement extendedWebElement) {

        int leftX = extendedWebElement.getLocation().getX();
        int rightX = extendedWebElement.getSize().getWidth();

        return (leftX + (leftX + rightX)) / 2;
    }

    public int getCenterY(ExtendedWebElement extendedWebElement) {

        int upperY = extendedWebElement.getLocation().getY();
        int lowerY = extendedWebElement.getSize().getHeight();

        return (upperY + (upperY + lowerY)) / 2;
    }


    public static String getText(String key) {
        Locale currentLocale = getCurrentLocale();
        ResourceBundle bundle = ResourceBundle.getBundle("locale", currentLocale);
        return bundle.getString(key);
    }

    public static Locale getCurrentLocale() {
        String[] currentLocaleString = R.CONFIG.getProperties().getProperty("locale").split("_");
        return new Locale(currentLocaleString[0], currentLocaleString[1]);
    }


    public DashboardPageBase closeNoSubscriptionsPopUpIfPresent() {

        waitUntil(ExpectedConditions.visibilityOfElementLocated(itemByText.format(CANCEL).getBy()), TIMEOUT_FIFTY);

        int attemp = 3;
        while (itemByText.format(CANCEL).isElementPresent() && attemp > 0) {
            itemByText.format(CANCEL).click(TIMEOUT_TEN);

            LOGGER.info("[ DASHBOARD PAGE ] Attempt left: {} for clicking on exit No Subscriptions PopUp button", attemp);
            attemp--;
        }

        return initPage(getDriver(), DashboardPageBase.class);
    }



    public boolean closeNotRespondingPopUpIfPresent() {

        ExtendedWebElement closeAppButton = itemByText.format(CLOSE_APP);
        boolean isNotRespondingPopUpPresent = closeAppButton.isElementPresent(TIMEOUT_FIFTEEN);

        closeAppButton.clickIfPresent(TIMEOUT_TEN);


        return isNotRespondingPopUpPresent;
    }


    public LogInPageBase closeLoginFailedPopUpIfPresent() {
        itemByText.format(CLOSE).clickIfPresent();
        return initPage(getDriver(), LogInPageBase.class);
    }


}
