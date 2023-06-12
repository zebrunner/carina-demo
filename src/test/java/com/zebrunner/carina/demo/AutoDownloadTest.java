package com.zebrunner.carina.demo;

import com.zebrunner.carina.core.IAbstractTest;
import com.zebrunner.carina.utils.R;
import com.zebrunner.carina.utils.report.SessionContext;
import com.zebrunner.carina.webdriver.DriverHelper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.lang.invoke.MethodHandles;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.Duration;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public class AutoDownloadTest implements IAbstractTest {

    private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());
    
    @BeforeSuite()
    public void BeforeAutoDownload() {
        R.CONFIG.put("auto_download", "true");
        R.CONFIG.put("auto_screenshot", "false");
    }

    @Test()
    public void getArtifactTest() {
        String url = "https://www.free-css.com/assets/files/free-css-templates/download/page292/grandcoffee.zip";

        LOGGER.info("Artifact's folder: {}", SessionContext.getArtifactsFolder());

        DriverHelper driverHelper = new DriverHelper(getDriver());
        driverHelper.openURL(url);

        Optional<Path> file = SessionContext.getArtifact(getDriver(), "grandcoffee.zip", Duration.ofSeconds(30));
        Assert.assertTrue(file.isPresent() && Files.exists(file.get()), "grandcoffee.zip is not available among downloaded artifacts");
    }
    
    @Test(expectedExceptions = AssertionError.class, expectedExceptionsMessageRegExp = "Unable to find artifact:.*")
    public void getInvalidArtifactTest() {
        String url = "https://www.free-css.com/assets/files/free-css-templates/download/page280/klassy-cafe.zip";

        LOGGER.info("Artifact's folder: {}", SessionContext.getArtifactsFolder());

        DriverHelper driverHelper = new DriverHelper(getDriver());
        driverHelper.openURL(url);

        SessionContext.getArtifact(getDriver(), UUID.randomUUID().toString());
    }
   
    
    @Test()
    public void getArtifactsTest() {
        String url1 = "https://www.free-css.com/assets/files/free-css-templates/download/page279/tropiko.zip";
        String url2 = "https://www.free-css.com/assets/files/free-css-templates/download/page280/solar.zip";

        R.CONFIG.put("auto_download", "true");

        LOGGER.info("Artifact's folder: {}", SessionContext.getArtifactsFolder());

        DriverHelper driverHelper = new DriverHelper(getDriver());
        driverHelper.openURL(url1);
        driverHelper.openURL(url2);


        SoftAssert softAssert = new SoftAssert();

        softAssert.assertTrue(SessionContext.getArtifact(getDriver(), "tropiko.zip", Duration.ofSeconds(30)).isPresent(), "tropiko.zip not found");
        softAssert.assertTrue(SessionContext.getArtifact(getDriver(), "solar.zip", Duration.ofSeconds(30)).isPresent(), "solar.zip not found");

        softAssert.assertAll();

        List<Path> files = SessionContext.getArtifacts(getDriver(), ".+");
        Assert.assertEquals(files.size(), 2);

        files = SessionContext.getArtifacts(getDriver(), "solar.z.+");
        Assert.assertEquals(files.size(), 1);

        files = SessionContext.getArtifacts(getDriver(), "UUID.randomUUID().toString()");
        Assert.assertEquals(files.size(), 0);

    }

}
