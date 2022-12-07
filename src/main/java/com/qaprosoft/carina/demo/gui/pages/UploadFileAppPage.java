package com.qaprosoft.carina.demo.gui.pages;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class UploadFileAppPage extends AbstractPage {
    @FindBy(id = "file-upload")
    private ExtendedWebElement upload;

    @FindBy(id = "file-submit")
    private ExtendedWebElement submit;

    public UploadFileAppPage(WebDriver driver) {
        super(driver);
        this.pageURL = "https://the-internet.herokuapp.com/upload";
    }

    public void sendFile(String filePath) {
        this.upload.attachFile(filePath);
    }

    public void submit() {
        this.submit.click();
    }


}
