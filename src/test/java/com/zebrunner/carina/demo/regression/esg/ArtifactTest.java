package com.zebrunner.carina.demo.regression.esg;

import com.zebrunner.carina.core.IAbstractTest;
import com.zebrunner.carina.demo.gui.pages.common.HomePageBase;
import com.zebrunner.carina.demo.utils.ArtifactUtils;
import com.zebrunner.carina.utils.R;
import com.zebrunner.carina.utils.report.ReportContext;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.support.ui.FluentWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.lang.invoke.MethodHandles;
import java.time.Duration;
import java.util.List;

public class ArtifactTest implements IAbstractTest {
    private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

    @Test
    public void artifactTest() {
        HomePageBase homePage = initPage(getDriver(), HomePageBase.class);
        homePage.open();
        Assert.assertTrue(homePage.isPageOpened(), "Home page is not opened");

        LOGGER.info("Checking the presence of artifacts (video.log, task.log)...");
        List<String> artifacts = List.of("video.log", "task.log");
        SoftAssert softAssert = new SoftAssert();
        for (String artifact : artifacts) {
            boolean isPresent = ArtifactUtils.isArtifactPresent(
                    new FluentWait<>(getDriver())
                            .pollingEvery(Duration.ofSeconds(1))
                            .withTimeout(Duration.ofSeconds(30)),
                    artifact);
            softAssert.assertTrue(isPresent, artifact + " not found.");
            if (isPresent) {
                LOGGER.info("Artifact '{}' is present.", artifact);
                boolean isNotEmpty = FileUtils.sizeOf(ReportContext.getArtifact(getDriver(), artifact)) > 0;
                if (isNotEmpty) {
                    LOGGER.info("Artifact '{}' is not empty.", artifact);
                }
                softAssert.assertTrue(isNotEmpty, String.format("Artifact '%s' is empty.", artifact));
            }
        }
        softAssert.assertAll();
    }

    @Test
    public void mitmDumpArtifactTest() {
        R.CONFIG.put("proxy_type", "Zebrunner", true);
        HomePageBase homePage = initPage(getDriver(), HomePageBase.class);
        homePage.open();
        Assert.assertTrue(homePage.isPageOpened(), "Home page is not opened");

        LOGGER.info("Checking the presence of the dump.mitm artifact...");
        Assert.assertTrue(ArtifactUtils.isArtifactPresent(new FluentWait<>(getDriver())
                                .pollingEvery(Duration.ofSeconds(1))
                                .withTimeout(Duration.ofSeconds(30)),
                        "dump.mitm"),
                "Artifact 'dump.mitm' was not found.");
        LOGGER.info("Artifact 'dump.mitm' is present.");
        Assert.assertTrue(FileUtils.sizeOf(ReportContext.getArtifact(getDriver(), "dump.mitm")) > 0,
                "Artifact 'dump.mitm' is empty.");
        LOGGER.info("Artifact 'dump.mitm' is not empty.");
    }

    @Test
    public void mitmHarArtifactTest() {
        R.CONFIG.put("proxy_type", "Zebrunner", true);
        HomePageBase homePage = initPage(getDriver(), HomePageBase.class);
        homePage.open();
        Assert.assertTrue(homePage.isPageOpened(), "Home page is not opened");

        LOGGER.info("Checking the presence of the dump.har artifact...");
        Assert.assertTrue(ArtifactUtils.isArtifactPresent(new FluentWait<>(getDriver())
                                .pollingEvery(Duration.ofSeconds(1))
                                .withTimeout(Duration.ofSeconds(30)),
                        "dump.har"),
                "Artifact 'dump.har' was not found.");
        LOGGER.info("Artifact 'dump.har' is present.");
        Assert.assertTrue(FileUtils.sizeOf(ReportContext.getArtifact(getDriver(), "dump.har")) > 0,
                "Artifact 'dump.har' is empty.");
        LOGGER.info("Artifact 'dump.har' is not empty.");
    }
}
