package com.qaprosoft.carina.demo.beatsbydre.component.ios;

import com.qaprosoft.carina.demo.beatsbydre.component.desktop.FooterItem;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import com.qaprosoft.carina.demo.beatsbydre.component.common.AbstractFooter;
import com.zebrunner.carina.utils.mobile.IMobileUtils;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.decorator.annotations.Localized;
import com.zebrunner.carina.webdriver.locator.Context;

import java.util.List;

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
    @FindBy(tagName = "span")
    private ExtendedWebElement emailTitle;

    @Localized(focus = Localized.NameFocus.CLASS_DECLARE)
    @Context(dependsOn = "emailRaw")
    @FindBy(tagName = "a")
    private ExtendedWebElement signUpButton;

    public Footer(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    @Override
    public void interactWithLocalizedElements() {
        copyright.scrollTo();
        copyright.getText();
        mobileLocation.getText();
        locationCountry.getText();
        emailTitle.getText();
        signUpButton.getText();
    }

    public List<FooterItem> getFooterItems() {
        throw new RuntimeException("There is no footer items for ios");
    }

}
