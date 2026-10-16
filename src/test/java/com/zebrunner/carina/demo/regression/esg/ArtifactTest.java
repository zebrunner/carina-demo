package com.zebrunner.carina.demo.regression.esg;

import com.zebrunner.agent.core.registrar.Artifact;
import com.zebrunner.carina.demo.gui.pages.desktop.WebFormPage;
import com.zebrunner.carina.demo.utils.ArtifactUtils;
import com.zebrunner.carina.demo.websocket.EndpointUtils;
import com.zebrunner.carina.utils.R;
import com.zebrunner.carina.webdriver.Screenshot;
import com.zebrunner.carina.webdriver.ScreenshotType;
import com.zebrunner.carina.webdriver.helper.IProxyHelper;
import com.zebrunner.carina.webdriver.listener.DriverListener;
import com.zebrunner.carina.webdriver.proxy.ZebrunnerProxyBuilder;

import org.openqa.selenium.remote.RemoteWebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.io.IOException;
import java.lang.invoke.MethodHandles;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.Duration;
import java.util.List;
import java.util.Optional;

public class ArtifactTest extends EsgTestBase implements IProxyHelper {
    private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

    @Test(description = "ESG Artifacts: download logs and finalized video")
    public void artifactTest() throws IOException {
        R.CONFIG.put("capabilities.zebrunner:enableVideo", "true", true);
        openArtifactPage();

        String sessionId = DriverListener.castDriver(getDriver(), RemoteWebDriver.class).getSessionId().toString();
        SoftAssert softAssert = new SoftAssert();
        for (String artifact : List.of("task.log", sessionId + "/video.log")) {
            Optional<Path> downloaded = ArtifactUtils.downloadArtifact(getDriver(), artifact, 1);
            softAssert.assertTrue(downloaded.isPresent(), "Remote artifact is missing or empty: " + artifact);
            if (downloaded.isPresent()) {
                softAssert.assertTrue(Files.size(downloaded.get()) > 0, "Downloaded artifact is empty: " + artifact);
                LOGGER.info("Downloaded artifact '{}' ({} bytes)", artifact, Files.size(downloaded.get()));
            }
        }
        String videoUrl = EndpointUtils.getHttpUrl(getDriver(), "video");
        quitDriver();
        Optional<Path> video = ArtifactUtils.downloadArtifact(videoUrl, "video.mp4", 1024, Duration.ofSeconds(90));
        softAssert.assertTrue(video.isPresent(), "Finalized session video could not be downloaded or contains no recording data");
        if (video.isPresent()) {
            LOGGER.info("Downloaded finalized session video ({} bytes)", Files.size(video.get()));
        }
        softAssert.assertAll();
    }

    @Test(description = "ESG MITM: export and download traffic dump")
    public void mitmDumpArtifactTest() throws IOException {
        R.CONFIG.put("proxy_type", "Zebrunner", true);
        ZebrunnerProxyBuilder.getInstance().useExtendedProxy().build(true);
        openArtifactPage();

        Optional<Path> dump = getProxyDumpArtifact("mitm");
        Assert.assertTrue(dump.isPresent(), "Proxy dump could not be exported and downloaded");
        Assert.assertTrue(Files.size(dump.orElseThrow()) > 0, "Downloaded proxy dump is empty");
        Artifact.attachToTest("mitm.dump", dump.orElseThrow());
    }

    @Test(description = "ESG MITM: export and download HAR")
    public void mitmHarArtifactTest() throws IOException {
        R.CONFIG.put("proxy_type", "Zebrunner", true);
        ZebrunnerProxyBuilder.getInstance().useExtendedProxy().build(true);
        openArtifactPage();

        Optional<Path> har = getProxyHarArtifact("mitm");
        Assert.assertTrue(har.isPresent(), "Proxy HAR could not be exported and downloaded");
        Assert.assertTrue(Files.size(har.orElseThrow()) > 0, "Downloaded proxy HAR is empty");
        Artifact.attachToTest("mitm.har", har.orElseThrow());
    }

    private void openArtifactPage() {
        WebFormPage webForm = openWebForm();
        webForm.typeText("ESG artifact test");
        Assert.assertEquals(webForm.getText(), "ESG artifact test", "Text input value");
        Screenshot.capture(getDriver(), ScreenshotType.EXPLICIT_VISIBLE, "Web form opened and text typed");
    }
}
