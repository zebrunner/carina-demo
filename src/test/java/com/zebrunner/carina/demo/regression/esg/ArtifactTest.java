package com.zebrunner.carina.demo.regression.esg;

import com.zebrunner.carina.core.IAbstractTest;
import com.zebrunner.carina.demo.gui.pages.common.HomePageBase;
import com.zebrunner.carina.utils.R;
import com.zebrunner.carina.utils.report.SessionContext;
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

public class ArtifactTest implements IAbstractTest {
    private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

    @Test
    public void artifactTest() throws IOException {
        HomePageBase homePage = initPage(getDriver(), HomePageBase.class);
        homePage.open();
        Assert.assertTrue(homePage.isPageOpened(), "Home page is not opened");

        LOGGER.info("Checking the presence of artifacts (video.log, task.log)...");
        List<String> artifacts = List.of("video.log", "task.log");
        SoftAssert softAssert = new SoftAssert();
        for (String artifact : artifacts) {
            Optional<Path> path = SessionContext.getArtifact(getDriver(), artifact, Duration.ofSeconds(30));
            softAssert.assertTrue(path.isPresent(), artifact + " not found.");
            if (path.isPresent()) {
                LOGGER.info("Artifact '{}' is present.", artifact);
                boolean isNotEmpty = Files.size(SessionContext.getArtifact(getDriver(), artifact).get()) > 0;
                if (isNotEmpty) {
                    LOGGER.info("Artifact '{}' is not empty.", artifact);
                }
                softAssert.assertTrue(isNotEmpty, String.format("Artifact '%s' is empty.", artifact));
            }
        }
        softAssert.assertAll();
    }

    @Test
    public void mitmDumpArtifactTest() throws IOException {
        R.CONFIG.put("proxy_type", "Zebrunner", true);
        HomePageBase homePage = initPage(getDriver(), HomePageBase.class);
        homePage.open();
        Assert.assertTrue(homePage.isPageOpened(), "Home page is not opened");

        LOGGER.info("Checking the presence of the mitm.dump artifact...");
        Assert.assertTrue(SessionContext.getArtifact(getDriver(), "mitm.dump", Duration.ofSeconds(30)).isPresent(),
                "Artifact 'mitm.dump' was not found.");
        LOGGER.info("Artifact 'mitm.dump' is present.");
        Assert.assertTrue(Files.size(SessionContext.getArtifact(getDriver(), "mitm.dump").get()) > 0,
                "Artifact 'mitm.dump' is empty.");
        LOGGER.info("Artifact 'mitm.dump' is not empty.");
    }
}
