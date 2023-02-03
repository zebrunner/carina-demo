package com.qaprosoft.carina.demo.regression.attachfile;

import com.qaprosoft.carina.core.foundation.IAbstractTest;
import com.qaprosoft.carina.core.foundation.webdriver.DriverHelper;
import com.qaprosoft.carina.demo.gui.pages.AttachFilePage;
import com.zebrunner.carina.core.registrar.ownership.MethodOwner;
import com.zebrunner.carina.utils.R;
import com.zebrunner.carina.utils.report.ReportContext;
import org.apache.commons.io.FilenameUtils;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.testng.Assert;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class AttachFileTest implements IAbstractTest {

    @BeforeSuite
    public void beforeSuite() {
        R.CONFIG.put("auto_download", "true");
        R.CONFIG.put("auto_screenshot", "false");
    }

    @Test(description = "download file and attach it to the page")
    @MethodOwner(owner = "qpsdemo")
    public void testAttachFile() {
        String url = "https://www.free-css.com/assets/files/free-css-templates/download/page280/klassy-cafe.zip";
        DriverHelper driverHelper = new DriverHelper(getDriver());
        driverHelper.openURL(url);

        FluentWait<WebDriver> wait = new FluentWait<>(getDriver())
                .pollingEvery(Duration.ofSeconds(1))
                .withTimeout(Duration.ofSeconds(30));
        Assert.assertTrue(isArtifactPresent(wait, "klassy-cafe.zip"), "klassy-cafe.zip is not available among downloaded artifacts");

        AttachFilePage attachFilePage = new AttachFilePage(getDriver());
        attachFilePage.open();
        Assert.assertTrue(attachFilePage.isPageOpened(), "Attach file page has not been opened.");
        attachFilePage.uploadFile(FilenameUtils.separatorsToUnix(ReportContext.getArtifact(getDriver(), "klassy-cafe.zip").getPath()));
        attachFilePage.submit();
        Assert.assertTrue(attachFilePage.isFileUploaded(), "File has not been uploaded.");
    }

    private static boolean isArtifactPresent(FluentWait<WebDriver> wait, String name) {
        boolean isFound = false;
        try {
            isFound = wait.until(dr -> {
                List<String> list = ReportContext.listArtifacts(dr);
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
}
