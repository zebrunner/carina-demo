package com.qaprosoft.carina.demo.gui.pages;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class TestDownloadPage extends AbstractPage {
    @FindBy(xpath = "//img[contains(@src,'5MB')]")
    private ExtendedWebElement download5mbButton;

    public TestDownloadPage(WebDriver driver) {
        super(driver);
    }

    public void download5mbFile() {
        download5mbButton.click();
    }
}
