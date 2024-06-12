package com.qaprosoft.carina.demo.beatsbydre.component.ios;

import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import com.qaprosoft.carina.demo.beatsbydre.component.common.AbstractCustomCard;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.decorator.annotations.Localized;

public class CustomCard extends AbstractCustomCard {
    @Localized(focus = Localized.NameFocus.FULL_PATH)
    @FindBy(tagName = "h2")
    private ExtendedWebElement featureTitle;

    @Localized(focus = Localized.NameFocus.FULL_PATH)
    @FindBy(xpath = ".//div[@class='card__content-top']//div//p")
    private ExtendedWebElement featureDescription;

    public CustomCard(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public void interactWithElements() {
        featureDescription.getText();
        featureTitle.getText();
    }
}
