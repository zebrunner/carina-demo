package com.qaprosoft.carina.demo.beatsbydre.component.desktop;

import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import com.qaprosoft.carina.demo.beatsbydre.component.common.AbstractLargeCard;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.decorator.annotations.Localized;

public class LargeCard extends AbstractLargeCard {
    @Localized(focus = Localized.NameFocus.FULL_PATH)
    @FindBy(tagName = "h2")
    private ExtendedWebElement popularCardTitle;

    @Localized(focus = Localized.NameFocus.FULL_PATH)
    @FindBy(className = "pc-originalprice")
    private ExtendedWebElement popularCardPrice;
    public LargeCard(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public void interactWithElements() {
        popularCardTitle.hover();
        popularCardPrice.hover();
    }
}
