package koval.mobile.myfitnesspal.gui;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import koval.mobile.myfitnesspal.gui.common.downMenuPages.DashboardPageBase;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


import java.lang.invoke.MethodHandles;


public abstract class MyAbstractPageBase extends AbstractPage implements IMyInterface {

    @FindBy(xpath = "//*[@content-desc='%s']")
    private ExtendedWebElement itemByContent;

    @FindBy(xpath = "//*[@resource-id='buttonExistingUserTutorial']/child::*[@class='android.widget.Button']")
    private ExtendedWebElement exitTutorialButton;


    private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

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

    public void pressKey(int keyCodeValue) {
        getDevice(getDriver()).pressKey(keyCodeValue);
    }

    public void closeTimestampsPopUpIfPresent() {
        itemByContent.format(NO_THANKS_ANSWER.toUpperCase()).clickIfPresent(TIMEOUT_FIVE);
    }

    public DashboardPageBase closeUserTutorialBoxIfPresent() {

        int attemp = 3;
        while (exitTutorialButton.isElementPresent(TIMEOUT_TEN) && attemp > 0) {
            exitTutorialButton.click(TIMEOUT_TEN);

            LOGGER.info("[ DASHBOARD PAGE ] Attempt left: {} for clicking on exit tutorial button", attemp);
            attemp--;
        }

        return initPage(getDriver(), DashboardPageBase.class);
    }

    public void closeAdvertisingPopUpIfPresent() {
        itemByContent.format(INTERSTITIAL_CLOSE_BUTTON).clickIfPresent(TIMEOUT_FIVE);
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
