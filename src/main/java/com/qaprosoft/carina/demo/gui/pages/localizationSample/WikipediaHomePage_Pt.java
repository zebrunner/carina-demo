package com.qaprosoft.carina.demo.gui.pages.localizationSample;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class WikipediaHomePage_Pt extends AbstractPage implements WikipediaHomePage {

    @FindBy(xpath = "//span[@class='hp-welkom-1']")
    private ExtendedWebElement welcomeText;

    public WikipediaHomePage_Pt(WebDriver driver) {
        super(driver);
    }

    @Override
    public String getWelcomeText() {
        return welcomeText.getText();
    }
}
