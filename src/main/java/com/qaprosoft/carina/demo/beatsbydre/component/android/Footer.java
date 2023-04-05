package com.qaprosoft.carina.demo.beatsbydre.component.android;

import com.zebrunner.carina.utils.mobile.IMobileUtils;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import com.qaprosoft.carina.demo.beatsbydre.component.common.AbstractFooter;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.decorator.annotations.Localized;
import com.zebrunner.carina.webdriver.locator.Context;

public class Footer extends AbstractFooter implements IMobileUtils {
    @Localized
    @FindBy(xpath = ".//div[@class='copyright']/p")
    private ExtendedWebElement copyright;

    @FindBy(xpath = ".//div[@class='mobile-select-country']")
    private ExtendedWebElement countryRow;

    @Localized
    @FindBy(tagName = "p")
    @Context(dependsOn = "countryRow")
    private ExtendedWebElement mobileLocation;

    @Localized
    @FindBy(tagName = "a")
    @Context(dependsOn = "countryRow")
    private ExtendedWebElement currentCountry;

    public Footer(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    @Override
    public void interactWithLocalizedElements() {
        swipe(copyright);
        copyright.hover();
        mobileLocation.hover();
        currentCountry.hover();
    }

}
