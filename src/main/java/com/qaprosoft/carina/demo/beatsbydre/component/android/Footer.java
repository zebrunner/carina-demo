package com.qaprosoft.carina.demo.beatsbydre.component.android;

import java.util.List;

import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import com.qaprosoft.carina.demo.beatsbydre.component.common.AbstractFooter;
import com.qaprosoft.carina.demo.beatsbydre.component.desktop.FooterItem;
import com.zebrunner.carina.utils.mobile.IMobileUtils;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.decorator.annotations.Localized;
import com.zebrunner.carina.webdriver.locator.Context;

public class Footer extends AbstractFooter implements IMobileUtils {
    @Localized(focus = Localized.NameFocus.CLASS_DECLARE)
    @FindBy(xpath = ".//div[@class='copyright']/p")
    private ExtendedWebElement copyright;

    @FindBy(xpath = ".//div[@class='mobile-select-country']")
    private ExtendedWebElement countryRow;

    @Localized(focus = Localized.NameFocus.CLASS_DECLARE)
    @FindBy(tagName = "p")
    @Context(dependsOn = "countryRow")
    private ExtendedWebElement mobileLocation;

    @Localized(focus = Localized.NameFocus.CLASS_DECLARE)
    @FindBy(tagName = "a")
    @Context(dependsOn = "countryRow")
    private ExtendedWebElement locationCountry;

    @FindBy(xpath = ".//div[@class='mobile-newsletter']")
    private ExtendedWebElement emailRaw;

    @Localized(focus = Localized.NameFocus.CLASS_DECLARE)
    @Context(dependsOn = "emailRaw")
    @FindBy(tagName= "p")
    private ExtendedWebElement mobileEmailTitle;

    @Localized(focus = Localized.NameFocus.CLASS_DECLARE)
    @Context(dependsOn = "emailRaw")
    @FindBy(tagName = "a")
    private ExtendedWebElement signUpButton;

    public Footer(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    @Override
    public void interactWithLocalizedElements() {
        swipe(copyright);
        copyright.hover();
        mobileLocation.hover();
        locationCountry.hover();
        mobileEmailTitle.hover();
        signUpButton.hover();
    }

    public List<FooterItem> getFooterItems() {
        throw new RuntimeException("There is no footer items for android");
    }
}
