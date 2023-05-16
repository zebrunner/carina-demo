package koval.mobile.myfitnesspal.gui;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.foundation.webdriver.decorator.annotations.CaseInsensitiveXPath;
import com.qaprosoft.carina.core.gui.AbstractPage;
import koval.mobile.myfitnesspal.gui.common.downMenuPages.dashboardPage.DashboardPageBase;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;



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


    public MyAbstractPageBase(WebDriver driver) {
        super(driver);
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

        initPage(getDriver(), DashboardPageBase.class);
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

}
