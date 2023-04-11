package com.zebrunner.carina.demo.mobile.gui.pages.ios;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.decorator.annotations.ClassChain;
import com.zebrunner.carina.webdriver.gui.AbstractPage;

public class PreferencesPage extends AbstractPage {

    @FindBy(xpath = "**/XCUIElementTypeCell[`label == \"General\"`]")
    @ClassChain
    private ExtendedWebElement generalButton;
    
    public PreferencesPage(WebDriver driver) {
        super(driver);
    }

    public void clickGeneralBtn() {
        generalButton.click();
    }

}
