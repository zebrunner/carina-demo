package com.zebrunner.carina.demo.regression.esg;

import com.github.kklisura.cdt.services.ChromeDevToolsService;
import com.zebrunner.carina.demo.gui.pages.desktop.WebFormPage;
import com.zebrunner.carina.utils.report.SessionContext;
import com.zebrunner.carina.webdriver.Screenshot;
import com.zebrunner.carina.webdriver.ScreenshotType;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.ByteArrayInputStream;
import java.lang.invoke.MethodHandles;
import java.util.Base64;

public class DevToolsTest extends EsgTestBase {
    private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

    @Test(description = "ESG DevTools: read browser JavaScript version")
    public void browserDevToolsTest() {
        WebFormPage webForm = openWebForm();
        webForm.typeText("ESG devtools test");
        Screenshot.capture(getDriver(), ScreenshotType.EXPLICIT_VISIBLE, "Web form opened and text typed");

        LOGGER.info("Trying to get Chrome DevTools...");
        ChromeDevToolsService browserDevTools = webForm.browserChromeDevTools();
        LOGGER.info("Got Chrome DevTools. Trying to get browser js version...");
        try {
            String jsVersion = browserDevTools.getBrowser()
                    .getVersion()
                    .getJsVersion();
            LOGGER.info("Got browser js version: {}", jsVersion);
            Assert.assertFalse(jsVersion == null || jsVersion.isBlank(), "Browser js version is empty");
        } finally {
            browserDevTools.close();
            browserDevTools.waitUntilClosed();
        }
    }

    @Test(description = "ESG DevTools: capture screenshot and read page text")
    public void pageDevToolsTest() {
        WebFormPage webForm = openWebForm();
        webForm.typeText("ESG devtools test");
        Screenshot.capture(getDriver(), ScreenshotType.EXPLICIT_VISIBLE, "Web form opened and text typed");

        LOGGER.info("Trying to get Chrome DevTools...");
        ChromeDevToolsService pageDevTools = webForm.pageChromeDevTools();
        LOGGER.info("Got Chrome DevTools. Trying to get screenshot...");

        try {
            String screenshot = pageDevTools.getPage().captureScreenshot();
            Assert.assertFalse(screenshot == null || screenshot.isBlank(), "DevTools screenshot is empty");
            LOGGER.info("Got DevTools screenshot ({} base64 characters). Reading the text input value...", screenshot.length());
            SessionContext.saveArtifact("devtools.png", new ByteArrayInputStream(Base64.getDecoder().decode(screenshot)));
            Object textValue = webForm.getTextThroughDevTools(pageDevTools);
            Assert.assertEquals(textValue, "ESG devtools test", "Text input value read through DevTools");
            LOGGER.info("Read text input value through DevTools: '{}'", textValue);
        } finally {
            pageDevTools.close();
            pageDevTools.waitUntilClosed();
        }
    }

}
