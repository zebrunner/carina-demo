package com.zebrunner.carina.demo.utils;

import com.zebrunner.carina.demo.websocket.EndpointUtils;
import com.zebrunner.carina.utils.report.SessionContext;

import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.FluentWait;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URI;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.Duration;
import java.util.List;
import java.util.Optional;

public final class ArtifactUtils {

    private ArtifactUtils() {
        // hide
    }

    public static boolean isArtifactPresent(FluentWait<WebDriver> wait, String name) {
        boolean isFound = false;
        try {
            isFound = wait.until(dr -> {
                List<String> list = SessionContext.listArtifacts(dr);
                if (list.contains(name)) {
                    return true;
                }
                return null;
            });
        } catch (TimeoutException e) {
            // do nothing
        }
        return isFound;
    }

    public static Optional<Path> downloadArtifact(WebDriver driver, String remotePath, long minimumSize) {
        String url = EndpointUtils.getHttpUrl(driver, "download") + "/" + remotePath;
        return downloadArtifact(url, Path.of(remotePath).getFileName().toString(), minimumSize, Duration.ofSeconds(30));
    }

    public static Optional<Path> downloadArtifact(String url, String fileName, long minimumSize, Duration timeout) {
        try {
            return Optional.of(new FluentWait<>(url)
                    .pollingEvery(Duration.ofSeconds(1))
                    .withTimeout(timeout)
                    .until(endpoint -> {
                        HttpURLConnection connection = null;
                        try {
                            connection = EndpointUtils.openConnection(endpoint);
                            int status = connection.getResponseCode();
                            if (status == HttpURLConnection.HTTP_MOVED_TEMP || status == HttpURLConnection.HTTP_MOVED_PERM) {
                                URI location = URI.create(endpoint).resolve(connection.getHeaderField("Location"));
                                connection.disconnect();
                                connection = (HttpURLConnection) location.toURL().openConnection();
                                connection.setConnectTimeout(5000);
                                connection.setReadTimeout(10000);
                                connection.setInstanceFollowRedirects(false);
                            }
                            if (connection.getResponseCode() != HttpURLConnection.HTTP_OK) {
                                return null;
                            }
                            long contentLength = connection.getContentLengthLong();
                            if (contentLength >= 0 && contentLength < minimumSize) {
                                return null;
                            }
                            try (InputStream input = connection.getInputStream()) {
                                Path file = SessionContext.saveArtifact(fileName, input);
                                return Files.size(file) >= minimumSize ? file : null;
                            }
                        } catch (IOException e) {
                            return null;
                        } finally {
                            if (connection != null) {
                                connection.disconnect();
                            }
                        }
                    }));
        } catch (TimeoutException e) {
            return Optional.empty();
        }
    }
}
