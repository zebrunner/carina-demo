package com.qaprosoft.carina.demo.gui.pages;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class AttachFilePage extends AbstractPage {

    @FindBy(id = "file-upload")
    private ExtendedWebElement fileUploadingArea;

    @FindBy(id = "file-submit")
    private ExtendedWebElement submitButton;

    @FindBy(id = "content")
    private ExtendedWebElement content;

    public AttachFilePage(WebDriver driver) {
        super(driver);
        setUiLoadedMarker(fileUploadingArea);
        setPageAbsoluteURL("https://the-internet.herokuapp.com/upload");
    }

    public void uploadFile(String filePath) {
        this.fileUploadingArea.attachFile(filePath);
    }

    public void submit() {
        this.submitButton.click();
    }

    public boolean isFileUploaded() {
        return this.content.isElementWithTextPresent("File Uploaded!");
    }
}
