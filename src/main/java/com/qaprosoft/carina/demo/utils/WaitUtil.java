package com.qaprosoft.carina.demo.utils;

import com.google.common.base.Function;
import com.jayway.restassured.response.Response;
import com.qaprosoft.carina.core.foundation.api.AbstractApiMethodV2;
import com.qaprosoft.carina.core.foundation.api.http.HttpResponseStatusType;
import com.qaprosoft.carina.core.foundation.performance.ACTION_NAME;
import com.qaprosoft.carina.core.foundation.performance.Timer;
import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractUIObject;
import org.apache.log4j.Logger;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.util.List;

import static com.qaprosoft.carina.core.foundation.utils.common.CommonUtils.pause;

public class WaitUtil {
    protected final static Logger LOGGER = Logger.getLogger(WaitUtil.class);
    private static final int WAIT_TIMEOUT_SEC = 45;
    private static final int WAIT_POLL_INTERVAL_MS = 1000;

    public static void waitForElementPresent(final WebDriver driver, final ExtendedWebElement element) {
        try {
            new WebDriverWait(driver, WAIT_TIMEOUT_SEC, WAIT_POLL_INTERVAL_MS).ignoring(StaleElementReferenceException.class)
                    .until(new Function<WebDriver, Boolean>() {
                        @Override
                        public Boolean apply(WebDriver input) {
                            return (element.getElement().isDisplayed() && element.getElement().isEnabled());
                        }
                    });
        } catch (TimeoutException e) {
            throw new RuntimeException(
                    String.format("Can't find Element '%s' on page after %d sec waiting", element.getName(), WAIT_TIMEOUT_SEC));
        }
    }

    public static void waitForElementsTextContains(final WebDriver browser, int timeoutSec, int pollIntervalMS, final ExtendedWebElement element, final String key, final boolean refreshPage) {
        try {
            new WebDriverWait(browser, timeoutSec, pollIntervalMS).ignoring(StaleElementReferenceException.class)
                    .until(new Function<WebDriver, Boolean>() {
                        @Override
                        public Boolean apply(WebDriver input) {
                            if (refreshPage)
                                browser.navigate().refresh();
                            return (element.getText().toLowerCase().contains(key.toLowerCase()));
                        }
                    });
        } catch (TimeoutException e) {
            throw new RuntimeException(String.format("Element's text '%s' doesn't contains key %s after %d sec waiting", element.getText(),
                    key, WAIT_TIMEOUT_SEC));
        }
    }

    public static void waitForElementsTextContains(final WebDriver browser, final ExtendedWebElement element, final String key, final boolean refreshPage) {
        waitForElementsTextContains(browser, WAIT_TIMEOUT_SEC, WAIT_POLL_INTERVAL_MS, element, key, refreshPage);
    }

    public static void waitForElementsListNotEmpty(final WebDriver driver, final List<? extends ExtendedWebElement> elements) {
        waitForElementsListNotEmpty(driver, elements, WAIT_TIMEOUT_SEC);
    }

    public static void waitForElementsListNotEmpty(final WebDriver driver, final List<? extends ExtendedWebElement> elements, int waitTimeoutSec) {
        try {
            new WebDriverWait(driver, waitTimeoutSec, WAIT_POLL_INTERVAL_MS).ignoring(WebDriverException.class)
                    .until(new Function<WebDriver, Boolean>() {
                        @Override
                        public Boolean apply(WebDriver input) {
                            return elements.size() > 0;
                        }
                    });
        } catch (TimeoutException e) {
            throw new RuntimeException(String.format("Elements list doesn't contain any visible elements"));
        }
    }

    public static void waitForUIObjectsListNotEmpty(final WebDriver driver, final List<? extends AbstractUIObject> uiObjects) {
        waitForUIObjectsListNotEmpty(driver, uiObjects, WAIT_TIMEOUT_SEC);
    }

    public static void waitForUIObjectsListNotEmpty(final WebDriver driver, final List<? extends AbstractUIObject> uiObjects, int waitTimeoutSec) {
        try {
            new WebDriverWait(driver, waitTimeoutSec, WAIT_POLL_INTERVAL_MS).ignoring(WebDriverException.class)
                    .until(new Function<WebDriver, Boolean>() {
                        @Override
                        public Boolean apply(WebDriver input) {
                            return uiObjects.size() > 0;
                        }
                    });
        } catch (TimeoutException e) {
            throw new RuntimeException(String.format("UI objects list doesn't contain any visible elements"));
        }
    }

    public static void waitForElementDisappear(ExtendedWebElement element) {
        int attempts = 7;
        int pauseDuration = 3;
        while (element.isElementPresent(1) && attempts-- > 0) {
            LOGGER.info(String.format("Waiting till '%s' element will disappear, attempts left: '%s'.", element.getName(), attempts));
            pause(pauseDuration);
        }
        Assert.assertFalse(element.isElementPresent(1), "Menu item " + element.getName() + " is unexpectedly present!");
    }

    public static Response waitExpectedApiResponse(AbstractApiMethodV2 apiMethod, HttpResponseStatusType httpResponseStatusType) {
        int WAIT_POLL_INTERVAL = 5;
        for (int i = WAIT_TIMEOUT_SEC / WAIT_POLL_INTERVAL; i >= 0; i--) {
            pause(WAIT_POLL_INTERVAL);
            Response response = apiMethod.callAPI();
            if (response.getStatusCode() == httpResponseStatusType.getCode()) {
                return response;
            }
        }
        throw new RuntimeException("Api method didn't get expected status code in response!");
    }

    public static void waitForPageLoaded(WebDriver driver) {
        try {
            new WebDriverWait(driver, WAIT_TIMEOUT_SEC, WAIT_POLL_INTERVAL_MS)
                    .until(new Function<WebDriver, Boolean>() {
                        @Override
                        public Boolean apply(WebDriver input) {
                            return String
                                    .valueOf(((JavascriptExecutor) driver).executeScript("return document.readyState;"))
                                    .equalsIgnoreCase("complete");
                        }
                    });
        } catch (TimeoutException e) {
            throw new RuntimeException(String.format("Page hasn't been loaded in %d seconds", WAIT_TIMEOUT_SEC));
        }
    }

    public static boolean waitUntil(WebDriver driver, ExpectedCondition<?> condition, long timeout) {
        boolean result;
        Timer.start(ACTION_NAME.WAIT);
        Wait<WebDriver> wait = new WebDriverWait(driver, timeout, WAIT_POLL_INTERVAL_MS).ignoring(WebDriverException.class)
                .ignoring(NoSuchSessionException.class);
        try {
            wait.until(condition);
            result = true;
            LOGGER.debug("waitUntil: finished true...");
        } catch (NoSuchElementException | TimeoutException e) {
            // don't write exception even in debug mode
            LOGGER.debug("waitUntil: NoSuchElementException | TimeoutException e..." + condition.toString());
            result = false;
        } catch (Exception e) {
            LOGGER.error("waitUntil: " + condition.toString(), e);
            result = false;
        }
        Timer.stop(ACTION_NAME.WAIT);
        return result;
    }
}
