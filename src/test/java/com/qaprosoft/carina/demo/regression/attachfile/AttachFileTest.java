package com.qaprosoft.carina.demo.regression.attachfile;

import com.qaprosoft.carina.core.foundation.IAbstractTest;
import com.qaprosoft.carina.demo.gui.pages.AttachFilePage;
import com.zebrunner.carina.core.registrar.ownership.MethodOwner;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.net.URL;
import java.nio.file.Path;

public class AttachFileTest implements IAbstractTest {

    @Test
    @MethodOwner(owner = "qpsdemo")
    public void testAttachFile() {
        AttachFilePage attachFilePage = new AttachFilePage(getDriver());
        attachFilePage.open();
        Assert.assertTrue(attachFilePage.isPageOpened(), "Attach file page has not been opened.");
        URL resourceURL = ClassLoader.getSystemClassLoader().getResource("files/icon.png");
        Assert.assertNotNull(resourceURL, "Resource should exists.");
        attachFilePage.uploadFile(Path.of(resourceURL.getPath()));
        attachFilePage.submit();
        Assert.assertTrue(attachFilePage.isFileUploaded(), "File has not been uploaded.");
    }
}
