package com.qaprosoft.carina.demo.utils;

import java.lang.invoke.MethodHandles;
import java.util.Set;

import com.zebrunner.carina.utils.Configuration;
import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.ContextAware;
import org.openqa.selenium.NotFoundException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.decorators.Decorated;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.zebrunner.carina.webdriver.DriverHelper;
import com.zebrunner.carina.webdriver.IDriverPool;

import io.appium.java_client.remote.SupportsContextSwitching;

public class MobileContextUtils implements IDriverPool {

    private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());
    private static final int RETRY_COUNT = 2;

    /**
     * Returns a pure driver without listeners
     */
    public WebDriver getPureDriver(WebDriver driver) {
        if (driver instanceof Decorated<?>) {
            driver = (WebDriver) ((Decorated<?>) driver).getOriginal();
        }
        return driver;
    }

    public void switchMobileContext(View context, WebDriver driver){
        switchMobileContext(context, null, driver);
    }

    public void switchMobileContext(View context, View exclude, WebDriver driver) {
        String desiredContext = StringUtils.EMPTY;
        DriverHelper help = new DriverHelper();
        int retryNum = 0;
        while (desiredContext.isEmpty() && retryNum < RETRY_COUNT) {
            Set<String> contextHandles = help.performIgnoreException(((ContextAware) driver)::getContextHandles);
            desiredContext = searchForContext(context, exclude, contextHandles);
            if (desiredContext.isEmpty()){
                help.pause(Configuration.getLong(Configuration.Parameter.EXPLICIT_TIMEOUT)/2);
            }
            retryNum++;
        }

        if (desiredContext.isEmpty()) {
            throw new NotFoundException("Desired context is not present");
        }

        LOGGER.info("Switching to context : " + desiredContext);
        ((SupportsContextSwitching) driver).context(desiredContext);
    }

    private static String searchForContext(View context, View exclude, Set<String> contextHandles){
        String desiredContext = StringUtils.EMPTY;
        LOGGER.info("Existing contexts: ");
        for (String cont : contextHandles) {
            if (cont.contains(context.getView())) {
                if (exclude != null && cont.contains(exclude.getView())){
                    continue;
                }
                desiredContext = cont;
            }
            LOGGER.info(cont);
        }
        return desiredContext;
    }

    public enum View {
        NATIVE("NATIVE_APP"),
        WEB_CARINA("WEBVIEW_com.solvd.carinademoapplication"),

        WEB_BROWSER("WEBVIEW_");

        String viewName;

        View(String viewName) {
            this.viewName = viewName;
        }

        public String getView() {
            return this.viewName;
        }
    }

}
