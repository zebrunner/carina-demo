package com.zebrunner.carina.demo.regression.esg;

import com.zebrunner.carina.demo.gui.pages.desktop.WebFormPage;
import com.zebrunner.carina.demo.websocket.EndpointUtils;
import com.zebrunner.carina.webdriver.Screenshot;
import com.zebrunner.carina.webdriver.ScreenshotType;

import org.openqa.selenium.support.ui.FluentWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.nio.charset.StandardCharsets;
import java.time.Duration;

public class ClipboardTest extends EsgTestBase {
    private static final String CLIPBOARD_TEXT = "Example text for the clipboard.";

    @Test(description = "ESG Clipboard: write and read remote clipboard")
    public void clipboardWriteTest() throws IOException {
        openWebForm();
        writeClipboard(CLIPBOARD_TEXT);
        Assert.assertEquals(readClipboard(), CLIPBOARD_TEXT, "Remote clipboard text after writing");
    }

    @Test(description = "ESG Clipboard: copy page text to remote clipboard")
    public void clipboardReadTest() throws IOException {
        WebFormPage webForm = openWebForm();
        writeClipboard("");
        webForm.typeText(CLIPBOARD_TEXT);
        webForm.copyText();
        new FluentWait<>(getDriver())
                .pollingEvery(Duration.ofMillis(200))
                .withTimeout(Duration.ofSeconds(10))
                .until(driver -> {
                    try {
                        return CLIPBOARD_TEXT.equals(readClipboard());
                    } catch (IOException e) {
                        return false;
                    }
                });
        Assert.assertEquals(readClipboard(), CLIPBOARD_TEXT, "Remote clipboard text");
    }

    @Test(description = "ESG Clipboard: paste remote clipboard into page")
    public void clipboardPasteToPageTest() throws IOException {
        WebFormPage webForm = openWebForm();
        writeClipboard(CLIPBOARD_TEXT);
        webForm.pasteIntoText();
        Assert.assertEquals(webForm.getText(), CLIPBOARD_TEXT, "Text pasted from the remote clipboard");
        Screenshot.capture(getDriver(), ScreenshotType.EXPLICIT_VISIBLE, "Clipboard pasted into the text input");
    }

    private void writeClipboard(String text) throws IOException {
        HttpURLConnection connection = EndpointUtils.openConnection(EndpointUtils.getHttpUrl(getDriver(), "clipboard"));
        try {
            connection.setRequestMethod("POST");
            connection.setDoOutput(true);
            try (OutputStream output = connection.getOutputStream()) {
                output.write(text.getBytes(StandardCharsets.UTF_8));
            }
            Assert.assertEquals(connection.getResponseCode(), HttpURLConnection.HTTP_OK, "Clipboard write response");
        } finally {
            connection.disconnect();
        }
    }

    private String readClipboard() throws IOException {
        HttpURLConnection connection = EndpointUtils.openConnection(EndpointUtils.getHttpUrl(getDriver(), "clipboard"));
        try {
            Assert.assertEquals(connection.getResponseCode(), HttpURLConnection.HTTP_OK, "Clipboard read response");
            try (InputStream input = connection.getInputStream()) {
                return new String(input.readAllBytes(), StandardCharsets.UTF_8).stripTrailing();
            }
        } finally {
            connection.disconnect();
        }
    }
}
