package com.qaprosoft.carina.demo.gui.pages;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class TestCenterMainPage extends AbstractPage {
    @FindBy(xpath = "//h1[text()='File upload via POST (HTTP)']/following-sibling::form//input[@name='file_upload']")
    private ExtendedWebElement httpFileAttach;

    @FindBy(xpath = "//h1[text()='File upload via POST (HTTP)']/following-sibling::form//input[@id='button']")
    private ExtendedWebElement httpSendButton;

    @FindBy(xpath = "//h1[text()='File Upload Finished']")
    private ExtendedWebElement fileUploadFinishedTitle;

    @FindBy(xpath = "//h1[text()='File upload via POST (HTTPS)']/following-sibling::form//input[@name='file_upload']")
    private ExtendedWebElement httpsFileAttach;

    @FindBy(xpath = "//h1[text()='File upload via POST (HTTPS)']/following-sibling::form//input[@id='button']")
    private ExtendedWebElement httpsSendButton;

    public TestCenterMainPage(WebDriver driver) {
        super(driver);
    }

    public boolean attachByHttpPost(String filepath) {
        httpFileAttach.attachFile(filepath);
        httpSendButton.click();
        return fileUploadFinishedTitle.isVisible(3);
    }

    public boolean attachByHttpsPost(String filepath) {
        httpsFileAttach.attachFile(filepath);
        httpsSendButton.click();
        return fileUploadFinishedTitle.isVisible(3);
    }
}
