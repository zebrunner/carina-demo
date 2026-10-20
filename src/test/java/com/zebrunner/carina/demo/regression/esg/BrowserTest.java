package com.zebrunner.carina.demo.regression.esg;

import com.zebrunner.carina.demo.gui.pages.desktop.WebFormPage;
import com.zebrunner.carina.demo.gui.pages.desktop.WebFormSubmittedPage;
import com.zebrunner.carina.utils.R;
import com.zebrunner.carina.webdriver.Screenshot;
import com.zebrunner.carina.webdriver.ScreenshotType;

import org.openqa.selenium.Capabilities;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.HasCapabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.lang.invoke.MethodHandles;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Path;
import java.time.Duration;

public class BrowserTest extends EsgTestBase {
    private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

    @Test(description = "ESG Browser: resize, upload, submit, and switch tabs")
    public void browserResolutionAndFormTest() throws URISyntaxException {
        R.CONFIG.put("capabilities.zebrunner:screenResolution", "1920x1080x24", true);
        WebDriver driver = getDriver();
        Capabilities capabilities = ((HasCapabilities) driver).getCapabilities();
        LOGGER.info("Browser: {} {}", capabilities.getBrowserName(), capabilities.getBrowserVersion());

        SoftAssert softAssert = new SoftAssert();
        resizeWindow(driver, softAssert, 1024, 768);
        WebFormPage webForm = openWebForm();
        Assert.assertEquals(webForm.getHeading().getText(), "Web form", "Unexpected page title");

        LOGGER.info("Filling text fields at 1024x768...");
        webForm.typeText("ESG browser test");
        webForm.typePassword("Secret123");
        webForm.typeTextarea("Text typed at 1024x768.");
        webForm.selectDropdown("Two");
        softAssert.assertEquals(webForm.getText(), "ESG browser test", "Text input value");
        softAssert.assertEquals(webForm.getPassword(), "Secret123", "Password value");
        softAssert.assertEquals(webForm.getTextarea(), "Text typed at 1024x768.", "Textarea value");
        softAssert.assertEquals(webForm.getSelectedDropdown(), "Two", "Dropdown value");
        softAssert.assertFalse(webForm.isDisabledInputEnabled(), "Disabled input should be disabled");
        softAssert.assertEquals(webForm.getReadonlyValue(), "Readonly input", "Readonly input value");
        Screenshot.capture(driver, ScreenshotType.EXPLICIT_VISIBLE, "Text fields filled at 1024x768");

        resizeWindow(driver, softAssert, 1280, 720);
        LOGGER.info("Changing checkboxes, radio buttons, datalist and range at 1280x720...");
        webForm.setFirstCheckbox(false);
        webForm.setSecondCheckbox(true);
        webForm.selectSecondRadio();
        webForm.typeDatalist("Seattle");
        webForm.setRange(8);
        softAssert.assertFalse(webForm.isFirstCheckboxChecked(), "First checkbox should be unchecked");
        softAssert.assertTrue(webForm.isSecondCheckboxChecked(), "Second checkbox should be checked");
        softAssert.assertTrue(webForm.isSecondRadioSelected(), "Second radio should be selected");
        softAssert.assertEquals(webForm.getDatalist(), "Seattle", "Datalist value");
        softAssert.assertEquals(webForm.getRange(), "8", "Range value");
        Screenshot.capture(driver, ScreenshotType.EXPLICIT_VISIBLE, "Controls changed at 1280x720");

        verifySecondTab(driver, webForm);

        driver.manage().window().fullscreen();
        assertWindowSize(driver, softAssert, 1920, 1080);
        LOGGER.info("Filling the whole form at 1920x1080...");
        webForm.typeText("ESG full form");
        webForm.typePassword("FullForm456");
        webForm.typeTextarea("All fields filled after the second resize.");
        webForm.selectDropdown("Three");
        webForm.typeDatalist("Chicago");
        URL icon = BrowserTest.class.getResource("/files/icon.png");
        Assert.assertNotNull(icon, "Resource files/icon.png should exist");
        webForm.attachFile(Path.of(icon.toURI()));
        webForm.setFirstCheckbox(true);
        webForm.setSecondCheckbox(true);
        webForm.selectFirstRadio();
        webForm.setColor("#ff5733");
        webForm.typeDate("10/15/2026");
        webForm.setRange(3);
        softAssert.assertEquals(webForm.getText(), "ESG full form", "Text input value");
        softAssert.assertEquals(webForm.getPassword(), "FullForm456", "Password value");
        softAssert.assertEquals(webForm.getTextarea(), "All fields filled after the second resize.", "Textarea value");
        softAssert.assertEquals(webForm.getSelectedDropdown(), "Three", "Dropdown value");
        softAssert.assertEquals(webForm.getDatalist(), "Chicago", "Datalist value");
        softAssert.assertTrue(webForm.getAttachedFileName().endsWith("icon.png"), "Attached file name");
        softAssert.assertEquals(webForm.getColor(), "#ff5733", "Color value");
        softAssert.assertEquals(webForm.getDate(), "10/15/2026", "Date value");
        softAssert.assertEquals(webForm.getRange(), "3", "Range value");
        softAssert.assertTrue(webForm.isFirstCheckboxChecked(), "First checkbox should be checked");
        softAssert.assertTrue(webForm.isSecondCheckboxChecked(), "Second checkbox should be checked");
        softAssert.assertTrue(webForm.isFirstRadioSelected(), "First radio should be selected");
        softAssert.assertFalse(webForm.isSecondRadioSelected(), "Second radio should be unselected");
        Screenshot.capture(driver, ScreenshotType.EXPLICIT_VISIBLE, "Whole form filled at 1920x1080");

        LOGGER.info("Submitting the form...");
        WebFormSubmittedPage submittedPage = webForm.submit();
        Assert.assertTrue(submittedPage.isPageOpened(), "Submitted page is not opened");
        String query = submittedPage.getSubmittedQuery();
        softAssert.assertEquals(submittedPage.getMessage(), "Received!", "Submit result message");
        softAssert.assertTrue(query.contains("my-text=ESG+full+form"), "Submitted text value");
        softAssert.assertTrue(query.contains("my-select=3"), "Submitted dropdown value");
        softAssert.assertTrue(query.contains("my-datalist=Chicago"), "Submitted datalist value");
        softAssert.assertTrue(query.contains("my-file=icon.png"), "Submitted file name");
        softAssert.assertTrue(query.contains("my-colors=%23ff5733"), "Submitted color value");
        softAssert.assertTrue(query.contains("my-range=3"), "Submitted range value");
        softAssert.assertTrue(query.contains("my-date=10%2F15%2F2026"), "Submitted date value");
        Screenshot.capture(driver, ScreenshotType.EXPLICIT_VISIBLE, "Form submitted");
        softAssert.assertAll();
    }

    private void resizeWindow(WebDriver driver, SoftAssert softAssert, int width, int height) {
        LOGGER.info("Changing window size to {}x{}...", width, height);
        driver.manage().window().setSize(new Dimension(width, height));
        assertWindowSize(driver, softAssert, width, height);
    }

    private void assertWindowSize(WebDriver driver, SoftAssert softAssert, int width, int height) {
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .withMessage(() -> "Expected window size " + width + "x" + height + ", actual " + driver.manage().window().getSize())
                .until(dr -> dr.manage().window().getSize().equals(new Dimension(width, height)));
        Dimension size = driver.manage().window().getSize();
        LOGGER.info("Window size is now {}x{}", size.getWidth(), size.getHeight());
        softAssert.assertEquals(size.getWidth(), width, "Window width after resize");
        softAssert.assertEquals(size.getHeight(), height, "Window height after resize");
        Screenshot.capture(driver, ScreenshotType.EXPLICIT_VISIBLE, String.format("Window resized to %dx%d", width, height));
    }

    private void verifySecondTab(WebDriver driver, WebFormPage firstTabPage) {
        String firstTab = driver.getWindowHandle();
        int tabCount = driver.getWindowHandles().size();
        driver.switchTo().newWindow(WindowType.TAB);
        try {
            Assert.assertNotEquals(driver.getWindowHandle(), firstTab, "Second tab should have a different handle");
            Assert.assertEquals(driver.getWindowHandles().size(), tabCount + 1, "Second tab should be open");
            WebFormPage secondTabPage = new WebFormPage(driver);
            secondTabPage.open();
            Assert.assertTrue(secondTabPage.isPageOpened(), "Web form is not opened in the second tab");
            Assert.assertEquals(secondTabPage.getText(), "", "Second tab should have an independent form");
            secondTabPage.typeText("ESG second tab");
            secondTabPage.selectDropdown("One");
            WebFormSubmittedPage submittedPage = secondTabPage.submit();
            Assert.assertTrue(submittedPage.isPageOpened(), "Second tab form was not submitted");
            Assert.assertEquals(submittedPage.getMessage(), "Received!", "Second tab submit result");
            Assert.assertTrue(submittedPage.getSubmittedQuery().contains("my-text=ESG+second+tab"), "Second tab submitted text");
            Screenshot.capture(driver, ScreenshotType.EXPLICIT_VISIBLE, "Second tab form submitted");
        } finally {
            driver.close();
            driver.switchTo().window(firstTab);
        }
        Assert.assertEquals(driver.getWindowHandles().size(), tabCount, "Second tab should be closed");
        Assert.assertTrue(firstTabPage.isPageOpened(), "First tab should still show the web form");
        Assert.assertEquals(firstTabPage.getText(), "ESG browser test", "First tab text should be preserved");
        Assert.assertEquals(firstTabPage.getDatalist(), "Seattle", "First tab datalist should be preserved");
        Assert.assertEquals(firstTabPage.getRange(), "8", "First tab range should be preserved");
    }
}
