package com.qaprosoft.carina.demo.beatsbydre.component.desktop;

import com.qaprosoft.carina.demo.beatsbydre.component.common.AbstractFooter;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.decorator.annotations.Localized;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class Footer extends AbstractFooter {
    @Localized(focus = Localized.NameFocus.CLASS_DECLARE)
    @FindBy(xpath = ".//div[@class='copyright']/p")
    private ExtendedWebElement copyright;

    @FindBy(xpath = ".//div[@class='linksList parbase section']")
    private List<FooterItem> footerItemList;

    @Localized(focus = Localized.NameFocus.CLASS_DECLARE)
    @FindBy(id = "footerBeatsArmy")
    private ExtendedWebElement mediaTitle;

    @Localized(focus = Localized.NameFocus.CLASS_DECLARE, localeName = "desktopLocationTitle")
    @FindBy(className = "footerDirectoryTitle")
    private ExtendedWebElement locationTitle;

    @Localized(focus = Localized.NameFocus.CLASS_DECLARE)
    @FindBy(xpath = ".//span[contains(@class,'country')]")
    private ExtendedWebElement locationCountry;

    @Localized(focus = Localized.NameFocus.CLASS_DECLARE)
    @FindBy(className = "change-location")
    private ExtendedWebElement changeLocationButton;

    @Localized(focus = Localized.NameFocus.CLASS_DECLARE)
    @FindBy(xpath = ".//h2[not(@*)]")
    private ExtendedWebElement emailTitle;

    @Localized(focus = Localized.NameFocus.CLASS_DECLARE)
    @FindBy(xpath = ".//li[@class='newsletter-cta']")
    private ExtendedWebElement signUpButton;

    public Footer(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public void interactWithLocalizedElements() {
        copyright.scrollTo();
        copyright.hover();
        mediaTitle.hover();
        locationTitle.hover();
        locationCountry.hover();
        changeLocationButton.hover();
        emailTitle.hover();
        signUpButton.hover();
        footerItemList.forEach(FooterItem::hoverElements);
    }

    public List<FooterItem> getFooterItems() {
        return footerItemList;
    }
}
