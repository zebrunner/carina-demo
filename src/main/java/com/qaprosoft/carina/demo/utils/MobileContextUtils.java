package com.qaprosoft.carina.demo.utils;

import com.qaprosoft.carina.core.foundation.webdriver.DriverHelper;
import com.qaprosoft.carina.core.foundation.webdriver.IDriverPool;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import org.openqa.selenium.NotFoundException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.invoke.MethodHandles;
import java.util.Set;


public class MobileContextUtils implements IDriverPool {

    private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

    private WebDriver getDriverSafe() {
        WebDriver driver = getDriver();
        if (driver instanceof EventFiringWebDriver) {
            driver = ((EventFiringWebDriver) driver).getWrappedDriver();
        }
        return driver;
    }

    public void switchMobileContext(View context) {
        AppiumDriver driver = (AppiumDriver) getDriverSafe();
        DriverHelper help = new DriverHelper();
        Set<String> contextHandles;
        if (driver instanceof AndroidDriver) {
            contextHandles = help.performIgnoreException(((AndroidDriver) driver)::getContextHandles);
        } else if (driver instanceof IOSDriver) {
            contextHandles = help.performIgnoreException(((IOSDriver) driver)::getContextHandles);
        } else {
            throw new RuntimeException("Unsupported type of driver");
        }
        String desiredContext = "";
        boolean isContextPresent = false;
        LOGGER.info("Existing contexts: ");
        for (String cont : contextHandles) {
            if (cont.contains(context.getView())) {
                desiredContext = cont;
                isContextPresent = true;
            }
            LOGGER.info(cont);
        }
        if (!isContextPresent) {
            throw new NotFoundException("Desired context is not present");
        }
        LOGGER.info("Switching to context : " + context.getView());

        if (driver instanceof AndroidDriver) {
            ((AndroidDriver) driver).context(desiredContext);
        } else if (driver instanceof IOSDriver) {
            ((IOSDriver) driver).context(desiredContext);
        } else {
            throw new RuntimeException("Unsupported type of driver");
        }
    }

    public enum View {
        NATIVE("NATIVE_APP"),
        WEB("WEBVIEW_");

        String viewName;

        View(String viewName) {
            this.viewName = viewName;
        }

        public String getView() {
            return this.viewName;
        }
    }
}