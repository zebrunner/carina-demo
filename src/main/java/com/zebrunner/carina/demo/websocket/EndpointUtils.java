package com.zebrunner.carina.demo.websocket;

import com.zebrunner.carina.utils.Configuration;
import com.zebrunner.carina.utils.report.ReportContext;
import com.zebrunner.carina.webdriver.listener.DriverListener;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.FluentWait;

import java.net.Authenticator;
import java.util.List;
import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class EndpointUtils {

    private EndpointUtils() {
        //hide
    }

    public static String getWebSocketSelenoidUrl(WebDriver driver, String endpoint) {
        return String.format("%s%s", Configuration.getSeleniumUrl()
                        .replace("wd/hub", endpoint)
                        .replaceFirst("http([s]?):", "wss:"),
                (DriverListener.castDriver(driver, RemoteWebDriver.class)).getSessionId().toString());
    }

    public static String getHttpSelenoidUrl(WebDriver driver, String endpoint) {
        return String.format("%s%s", Configuration.getSeleniumUrl()
                        .replace("wd/hub", endpoint),
                (DriverListener.castDriver(driver, RemoteWebDriver.class))
                        .getSessionId()
                        .toString());
    }

    public static boolean isMessagePresent(FluentWait<WebDriver> wait, List<Object> messages) {
        boolean isFound = false;
        try {
            isFound = wait.until(dr -> {
                if (!messages.isEmpty()) {
                    return true;
                }
                return null;
            });
        } catch (TimeoutException e) {
            // do nothing
        }
        return isFound;
    }

    public static Optional<Authenticator> getHttpAuthorization() {
        String username = getUsername();
        String password = getPassword();
        if (username.isEmpty() || password.isEmpty()) {
            return Optional.empty();
        }
        return Optional.of(new ReportContext.CustomAuthenticator(username, password));
    }

    private static String getUsername() {
        Matcher matcher = Pattern.compile(".*:\\/\\/(.*):(.*)@")
                .matcher(Configuration.getSeleniumUrl());
        if (matcher.find()) {
            return matcher.group(1);
        } else {
            return "";
        }
    }

    private static String getPassword() {
        Matcher matcher = Pattern.compile(".*:\\/\\/(.*):(.*)@")
                .matcher(Configuration.getSeleniumUrl());
        if (matcher.find()) {
            return matcher.group(2);
        } else {
            return "";
        }
    }
}
