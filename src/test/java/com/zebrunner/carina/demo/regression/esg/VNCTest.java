package com.zebrunner.carina.demo.regression.esg;

import com.zebrunner.carina.demo.gui.pages.desktop.WebFormPage;
import com.zebrunner.carina.demo.websocket.WebsocketClientEndpoint;
import com.zebrunner.carina.utils.R;
import com.zebrunner.carina.webdriver.Screenshot;
import com.zebrunner.carina.webdriver.ScreenshotType;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.lang.invoke.MethodHandles;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.charset.StandardCharsets;
import java.time.Duration;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

import static com.zebrunner.carina.demo.websocket.EndpointUtils.getWebSocketUrl;
import static com.zebrunner.carina.demo.websocket.EndpointUtils.isMessagePresent;

public class VNCTest extends EsgTestBase {
    private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

    @Test(description = "ESG VNC: connect and verify protocol banner")
    public void vncTest() throws URISyntaxException, IOException {
        R.CONFIG.put("capabilities.zebrunner:enableVNC", "true", true);
        WebFormPage webForm = openWebForm();
        webForm.typeText("ESG VNC test");
        webForm.selectDropdown("One");
        Screenshot.capture(getDriver(), ScreenshotType.EXPLICIT_VISIBLE, "Web form opened before the VNC connection");

        LOGGER.info("Trying to create connection with the VNC endpoint...");
        List<Object> messages = new CopyOnWriteArrayList<>();
        try (WebsocketClientEndpoint clientEndPoint = new WebsocketClientEndpoint(
                new URI(getWebSocketUrl(getDriver(), "ws/vnc/")), messages::add)) {
            FluentWait<WebDriver> wait = new FluentWait<>(getDriver())
                    .pollingEvery(Duration.ofSeconds(1))
                    .withTimeout(Duration.ofSeconds(20));

            Assert.assertTrue(isMessagePresent(wait, messages), "There are no messages from the VNC endpoint.");
            ByteArrayOutputStream banner = new ByteArrayOutputStream();
            wait.until(dr -> {
                banner.reset();
                messages.forEach(message -> banner.writeBytes((byte[]) message));
                return banner.size() >= 12;
            });
            Assert.assertTrue(banner.toString(StandardCharsets.US_ASCII).startsWith("RFB "), "Invalid VNC protocol banner");
            LOGGER.info("Received the VNC protocol banner.");
        }
    }

}
