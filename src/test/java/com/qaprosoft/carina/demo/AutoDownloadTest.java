package com.qaprosoft.carina.demo;

import com.qaprosoft.carina.core.foundation.IAbstractTest;
import com.qaprosoft.carina.core.foundation.report.ReportContext;
import com.qaprosoft.carina.core.foundation.utils.R;
import com.qaprosoft.carina.core.foundation.webdriver.DriverHelper;
import com.qaprosoft.carina.demo.utils.AutoDownloadUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.File;
import java.lang.invoke.MethodHandles;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class AutoDownloadTest implements IAbstractTest {

    private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

    private static final String[] URLS = new String[] {
            "https://www.free-css.com/assets/files/free-css-templates/download/page280/klassy-cafe.zip",
            "https://www.free-css.com/assets/files/free-css-templates/download/page279/tropiko.zip",
            "https://www.free-css.com/assets/files/free-css-templates/download/page280/solar.zip"
    };

    @DataProvider(name = "validArtifacts", parallel = false)
    public Object[][] artifactURLs() {
        return new Object[][] { { URLS[0], "NULL", "NULL" },
                { URLS[1], "/tmp/111", "NULL" },
                { URLS[2], "NULL", "/tmp/111" } };
    }

    @Test(dataProvider = "validArtifacts")
    public void downloadArtifactTest(String artifactURL, String autoDownloadFolder, String customArtifactsFolder)
            throws URISyntaxException {
        R.CONFIG.put("auto_download", "true");
        R.CONFIG.put("auto_download_folder", autoDownloadFolder, true);
        R.CONFIG.put("custom_artifacts_folder", customArtifactsFolder, true);

        LOGGER.info("Auto download folder: {}", ReportContext.getAutoDownloadFolder().getAbsolutePath());
        LOGGER.info("Artifact's folder: {}", ReportContext.getArtifactsFolder().getAbsolutePath());

        String fileName = AutoDownloadUtils.getFileNameFromURL(artifactURL);

        ReportContext.deleteAllArtifacts();
        AutoDownloadUtils.deleteFileFromAutoDownloadFolder(fileName);

        LOGGER.info("TEST STARTED WITH PARAMETERS: artifact url: '{}', auto download folder '{}', custom artifact folder '{}'",
                artifactURL, autoDownloadFolder, customArtifactsFolder);

        Assert.assertFalse(AutoDownloadUtils.isArtifactPresent(fileName),
                "Artifact with name " + fileName + " shouldn't be in artifact's folder because it had to be removed!");
        DriverHelper driverHelper = new DriverHelper(getDriver());
        driverHelper.openURL(artifactURL);

        boolean isAssertionErrorAppears = false;
        try {
            ReportContext.downloadArtifact(getDriver(), fileName + UUID.randomUUID(), 5, false);
        } catch (AssertionError assertionError) {
            isAssertionErrorAppears = true;
        } finally {
            Assert.assertTrue(isAssertionErrorAppears,
                    "Assertion error should appear when try to input  artifact filename that doesn't exists");
        }

        File validArtifactFile = ReportContext.downloadArtifact(getDriver(), fileName, 5, false);
        Assert.assertTrue(validArtifactFile.exists(),
                "Artifact with name" + fileName + "is not exists by file link returned by downloadArtifact function");
        Assert.assertTrue(AutoDownloadUtils.isArtifactPresent(fileName),
                "Artifact with name " + fileName + " should present in artifacts folder - searched by name");
    }

    @Test(dataProvider = "validArtifacts")
    public void downloadArtifactsTest(String artifactURL, String autoDownloadFolder, String customArtifactsFolder) throws URISyntaxException {
        R.CONFIG.put("auto_download", "true");
        R.CONFIG.put("auto_download_folder", autoDownloadFolder, true);
        R.CONFIG.put("custom_artifacts_folder", customArtifactsFolder, true);

        LOGGER.info("Auto download folder: {}", ReportContext.getAutoDownloadFolder().getAbsolutePath());
        LOGGER.info("Artifact's folder: {}", ReportContext.getArtifactsFolder().getAbsolutePath());
        
        List<String> fileNames = new ArrayList<>();
        for (String url : URLS) {
            fileNames.add(AutoDownloadUtils.getFileNameFromURL(url));
        }

        ReportContext.deleteAllArtifacts();
        AutoDownloadUtils.deleteFilesFromAutoDownloadFolder(fileNames);

        LOGGER.info("TEST STARTED WITH PARAMETERS: auto download folder: '{}', custom artifact folder: '{}', urls: '{}'",
                autoDownloadFolder, customArtifactsFolder, URLS);

        for (String fileName : fileNames) {
            Assert.assertFalse(AutoDownloadUtils.isArtifactPresent(fileName),
                    "Artifact with name " + fileName + " shouldn't be in artifacts folder because it had to be removed");
        }

        DriverHelper driverHelper = new DriverHelper(getDriver());
        for (String url : URLS) {
            driverHelper.openURL(url);
        }

        List<File> emptyArtifactsList = ReportContext.downloadArtifacts(getDriver(), "", false);
        Assert.assertTrue(emptyArtifactsList.isEmpty(), "Files in auto download folder shouldn't be found by empty regex");

        List<File> validArtifactFiles = ReportContext.downloadArtifacts(getDriver(), AutoDownloadUtils.getRegexForOnly(fileNames), false);
        Assert.assertEquals(validArtifactFiles.size(), fileNames.size(),
                "Amount of artifacts that was found by regex should be equal with amount of downloaded artifacts");

        for (File file : validArtifactFiles) {
            Assert.assertTrue(file.exists(),
                    "Artifact with name " + file.getName() + " should exists in artifacts folder");
        }

    }
}
