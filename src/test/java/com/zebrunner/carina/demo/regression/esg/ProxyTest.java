package com.zebrunner.carina.demo.regression.esg;

import com.zebrunner.agent.core.registrar.Artifact;
import com.zebrunner.carina.demo.gui.pages.desktop.WebFormPage;
import com.zebrunner.carina.utils.R;
import com.zebrunner.carina.utils.report.SessionContext;
import com.zebrunner.carina.webdriver.Screenshot;
import com.zebrunner.carina.webdriver.ScreenshotType;
import com.zebrunner.carina.webdriver.proxy.ZebrunnerProxyBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;
import java.lang.invoke.MethodHandles;
import java.nio.file.Files;
import java.nio.file.Path;

public class ProxyTest extends EsgTestBase {
    private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

    @Test(description = "ESG Proxy: modify page response")
    public void dynamicModeWithResponseFilterTest() throws IOException {
        R.CONFIG.put("proxy_type", "Zebrunner", true);
        LOGGER.info("Creating command for Zebrunner proxy.");
        ZebrunnerProxyBuilder.getInstance()
                .addBodyModify("Web form", "MODIFIED WEB FORM")
                .build(true);

        getDriver();
        WebFormPage webForm = openWebForm();
        LOGGER.info("Checking is title text modified from 'Web form' to 'MODIFIED WEB FORM'.");
        Assert.assertEquals(webForm.getHeading().getText(), "MODIFIED WEB FORM",
                "'Web form' title text should be modified in response.");
        webForm.typeText("ESG proxy test");
        Assert.assertEquals(webForm.getText(), "ESG proxy test", "Text input value");

        String pageSourceFileName = "ModifiedPageSource.txt";
        LOGGER.info("Title text modified in response to '{}'. Review changes in attached '{}' artifact.",
                "MODIFIED WEB FORM", pageSourceFileName);
        Screenshot.capture(getDriver(), ScreenshotType.EXPLICIT_VISIBLE);
        Screenshot.capture(webForm.getHeading().getElement(), ScreenshotType.EXPLICIT_VISIBLE,
                "The modified representation of the 'Web form' title on the page");

        Path file = SessionContext.getArtifactsFolder().resolve(pageSourceFileName);
        Files.writeString(file, getDriver().getPageSource());
        Artifact.attachToTest(pageSourceFileName, file);
    }
}
