package com.zebrunner.carina.demo.regression.esg;

import com.zebrunner.carina.demo.gui.pages.desktop.WebFormPage;
import com.zebrunner.carina.webdriver.Screenshot;
import com.zebrunner.carina.webdriver.ScreenshotType;
import org.apache.commons.lang3.RandomStringUtils;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LocalStorageTest extends EsgTestBase {

    @Test(description = "ESG Local Storage: write and read a value")
    public void addItemToTheLocalStorageWithJS() {
        WebFormPage webForm = openWebForm();
        String name = RandomStringUtils.randomAlphabetic(5);
        String value = RandomStringUtils.randomAlphabetic(10);
        try {
            webForm.setLocalStorageValue(name, value);
            Assert.assertEquals(webForm.getValueFromLocalStorage(name).orElse(""), value, "Local storage value");
            webForm.typeText(name + "=" + value);
            Assert.assertEquals(webForm.getText(), name + "=" + value, "Local storage value typed into the form");
            Screenshot.capture(getDriver(), ScreenshotType.EXPLICIT_VISIBLE, "Local storage value verified");
        } finally {
            webForm.removeFromLocalStorage(name);
        }
    }

    @Test(description = "ESG Local Storage: retain values after reload")
    public void localStoragePersistsAfterReloadTest() {
        WebFormPage webForm = openWebForm();
        String name = RandomStringUtils.randomAlphabetic(5);
        String value = RandomStringUtils.randomAlphabetic(10);
        try {
            webForm.setLocalStorageValue(name, value);
            webForm.reload();
            Assert.assertTrue(webForm.isPageOpened(), "Web form page is not opened after reload");
            Assert.assertEquals(webForm.getValueFromLocalStorage(name).orElse(""), value, "Local storage value after reload");
            webForm.removeFromLocalStorage(name);
            Assert.assertTrue(webForm.getValueFromLocalStorage(name).isEmpty(), "Local storage value should be removed");
            Screenshot.capture(getDriver(), ScreenshotType.EXPLICIT_VISIBLE, "Local storage persisted after reload and was removed");
        } finally {
            webForm.removeFromLocalStorage(name);
        }
    }

}
