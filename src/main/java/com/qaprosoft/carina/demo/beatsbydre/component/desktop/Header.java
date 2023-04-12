package com.qaprosoft.carina.demo.beatsbydre.component.desktop;

import java.util.List;

import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.qaprosoft.carina.demo.beatsbydre.component.common.AbstractHeader;
import com.zebrunner.carina.utils.Configuration;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.decorator.annotations.Localized;

public class Header extends AbstractHeader {
    @Localized(focus = Localized.NameFocus.CLASS_DECLARE)
    @FindBy(xpath = ".//div[@class='header-container']//li[@role='presentation']/a")
    private List<ExtendedWebElement> headerTitles;

    @Localized(focus = Localized.NameFocus.CLASS_DECLARE)
    @FindBy(className = "show-desktop")
    private ExtendedWebElement promoText;

    public Header(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    @Override
    public void interactWithLocalizedElements() {
        waitUntil(ExpectedConditions.visibilityOf(promoText.getElement()),
                Configuration.getLong(Configuration.Parameter.EXPLICIT_TIMEOUT));
        promoText.hover();
        headerTitles.forEach(ExtendedWebElement::hover);
    }
}
