package com.zebrunner.carina.demo.regression.esg;

import com.zebrunner.carina.core.IAbstractTest;
import com.zebrunner.carina.demo.gui.pages.desktop.WebFormPage;
import org.testng.Assert;

public abstract class EsgTestBase implements IAbstractTest {
    private static final long RECORDING_DURATION_SECONDS = 5;

    protected WebFormPage openWebForm() {
        WebFormPage webForm = new WebFormPage(getDriver());
        webForm.open();
        Assert.assertTrue(webForm.isPageOpened(), "Web form page is not opened");
        pause(RECORDING_DURATION_SECONDS);
        return webForm;
    }
}
