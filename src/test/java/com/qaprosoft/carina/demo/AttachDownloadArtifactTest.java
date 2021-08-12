package com.qaprosoft.carina.demo;

import com.qaprosoft.carina.core.foundation.AbstractTest;
import com.qaprosoft.carina.core.foundation.IAbstractTest;
import com.qaprosoft.carina.core.foundation.report.ReportContext;
import com.qaprosoft.carina.core.foundation.webdriver.Screenshot;
import com.qaprosoft.carina.demo.gui.pages.TestCenterMainPage;
import com.qaprosoft.carina.demo.gui.pages.TestDownloadPage;
import org.testng.Assert;
import org.testng.annotations.Test;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class AttachDownloadArtifactTest extends AbstractTest {

    @Test
    public void uploadPicTest() {
        TestCenterMainPage centerMainPage = new TestCenterMainPage(getDriver());
        centerMainPage.openURL("http://www.csm-testcenter.org/test?do=show&subdo=common&test=file_upload");
        String picPath = "src/test/resources/artifact/zebrunner_intro.png";
        Assert.assertTrue(centerMainPage.attachByHttpPost(picPath));
    }

    @Test
    public void downloadTest() {
        TestDownloadPage downloadPage = new TestDownloadPage(getDriver());
        downloadPage.openURL("http://xcal1.vodafone.co.uk/");
        String fileName = "5MB.zip";
        downloadPage.download5mbFile();
        pause(10);
        File art = ReportContext.downloadArtifact(getDriver(), fileName, 10, false);
        Assert.assertEquals(art.getName(), fileName);
    }
}
