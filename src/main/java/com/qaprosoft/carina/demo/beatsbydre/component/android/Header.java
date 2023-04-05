package com.qaprosoft.carina.demo.beatsbydre.component.android;

import java.util.List;

import com.zebrunner.carina.utils.Configuration;
import com.zebrunner.carina.utils.mobile.IMobileUtils;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import com.qaprosoft.carina.demo.beatsbydre.component.common.AbstractHeader;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.decorator.annotations.Localized;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class Header extends AbstractHeader implements IMobileUtils {

    @FindBy(xpath = ".//button[@aria-controls='secondary-nav-sm']")
    private ExtendedWebElement navMenuButton;

    @Localized
    @FindBy(xpath = ".//nav[@id='secondary-nav-sm']//li[@role='presentation']/a[not(@target='_blank')]")
    private List<ExtendedWebElement> headerTitles;

    @FindBy(xpath = ".//nav[@id='secondary-nav-sm']//a[@class='has-subNavItems']")
    private ExtendedWebElement expandAllNavButton;

    @Localized
    @FindBy(className = "show-mobile")
    private ExtendedWebElement promoText;

    public Header(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    @Override
    public void interactWithLocalizedElements() {
        promoText.hover();
        navMenuButton.click();
        expandAllNavButton.click();
        for (ExtendedWebElement title: headerTitles) {
            swipe(title);
            title.hover();
        }
        navMenuButton.click();
    }

}
