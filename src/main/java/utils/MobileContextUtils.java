package utils;

import com.qaprosoft.carina.core.foundation.webdriver.DriverHelper;
import io.appium.java_client.AppiumDriver;
import org.apache.log4j.Logger;
import org.openqa.selenium.NotFoundException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;
import java.util.Set;

public class MobileContextUtils {

    private static final Logger LOGGER = Logger.getLogger(DriverHelper.class);

    private static AppiumDriver getDriverSafe(WebDriver driver) {
        if (driver instanceof EventFiringWebDriver) {
            driver = ((EventFiringWebDriver) driver).getWrappedDriver();
            if (driver instanceof AppiumDriver) {
                return (AppiumDriver) driver;
            }
        }
        if (driver instanceof Proxy) {
            InvocationHandler innerProxy = Proxy.getInvocationHandler(driver);
            Field locatorField = null;
            try {
                locatorField = innerProxy.getClass().getDeclaredField("arg$2");
            } catch (NoSuchFieldException e) {
                LOGGER.error(e.getMessage());
            }
            if (locatorField!=null) {
                locatorField.setAccessible(true);
                WebDriver appiumDriver = null;
                try {
                    appiumDriver = (WebDriver) locatorField.get(innerProxy);
                } catch (IllegalAccessException e) {
                    LOGGER.error(e.getMessage());
                }
                if (appiumDriver instanceof AppiumDriver) {
                    return (AppiumDriver) appiumDriver;
                }
            }
        }
        throw new ClassCastException("Appium Driver can not be casted from the actual driver.");
    }

    public void switchMobileContext(View context, WebDriver dvr) {
        AppiumDriver<?> driver = (AppiumDriver<?>) getDriverSafe(dvr);
        DriverHelper help = new DriverHelper();
        Set<String> contextHandles = help.performIgnoreException(driver::getContextHandles);
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
        driver.context(desiredContext);
    }

    public enum View {
        NATIVE("NATIVE_APP"),
        WEB("WEBVIEW_chrome");

        String viewName;

        View(String viewName) {
            this.viewName = viewName;
        }

        public String getView() {
            return this.viewName;
        }
    }
}