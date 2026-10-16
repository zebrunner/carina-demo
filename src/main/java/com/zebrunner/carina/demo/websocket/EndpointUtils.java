package com.zebrunner.carina.demo.websocket;

import com.zebrunner.carina.utils.config.Configuration;
import com.zebrunner.carina.utils.config.StandardConfigurationOption;
import com.zebrunner.carina.utils.report.ReportContext;
import com.zebrunner.carina.webdriver.config.WebDriverConfiguration;
import com.zebrunner.carina.webdriver.listener.DriverListener;

import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.FluentWait;

import java.io.IOException;
import java.net.Authenticator;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.charset.StandardCharsets;
import java.util.Base64;
import java.util.List;
import java.util.Optional;

public final class EndpointUtils {

    private EndpointUtils() {
        //hide
    }

    public static String getWebSocketUrl(WebDriver driver, String endpoint) {
        URI httpUrl = URI.create(getHttpUrl(driver, endpoint));
        try {
            return new URI("https".equalsIgnoreCase(httpUrl.getScheme()) ? "wss" : "ws",
                    null, httpUrl.getHost(), httpUrl.getPort(), httpUrl.getPath(), null, null).toString();
        } catch (URISyntaxException e) {
            throw new IllegalArgumentException("Cannot create the grid WebSocket URL", e);
        }
    }

    public static String getHttpUrl(WebDriver driver, String endpoint) {
        URI seleniumUrl = getSeleniumUrl();
        String basePath = seleniumUrl.getPath().replaceFirst("/wd/hub/?$", "").replaceFirst("/+$", "");
        String path = basePath + "/" + endpoint.replaceAll("^/+|/+$", "") + "/"
                + DriverListener.castDriver(driver, RemoteWebDriver.class).getSessionId();
        try {
            return new URI(seleniumUrl.getScheme(), null, seleniumUrl.getHost(), seleniumUrl.getPort(), path, null, null).toString();
        } catch (URISyntaxException e) {
            throw new IllegalArgumentException("Cannot create the grid HTTP URL", e);
        }
    }

    public static HttpURLConnection openConnection(String url) throws IOException {
        HttpURLConnection connection = (HttpURLConnection) URI.create(url).toURL().openConnection();
        connection.setConnectTimeout(5000);
        connection.setReadTimeout(10000);
        connection.setInstanceFollowRedirects(false);
        getHttpAuthorization().ifPresent(connection::setAuthenticator);
        String userInfo = getSeleniumUrl().getUserInfo();
        if (userInfo != null) {
            connection.setRequestProperty("Authorization", "Basic "
                    + Base64.getEncoder().encodeToString(userInfo.getBytes(StandardCharsets.UTF_8)));
        }
        return connection;
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
        String userInfo = getSeleniumUrl().getUserInfo();
        if (userInfo == null || !userInfo.contains(":")) {
            return Optional.empty();
        }
        String[] credentials = userInfo.split(":", 2);
        return Optional.of(new ReportContext.CustomAuthenticator(credentials[0], credentials[1]));
    }

    private static URI getSeleniumUrl() {
        return URI.create(Configuration.getRequired(WebDriverConfiguration.Parameter.SELENIUM_URL,
                StandardConfigurationOption.DECRYPT));
    }
}
