package com.qaprosoft.carina.demo.beatsbydre.component.ios;

import java.util.List;

import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import com.qaprosoft.carina.demo.beatsbydre.component.common.AbstractHeader;
import com.zebrunner.carina.utils.mobile.IMobileUtils;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.decorator.annotations.Localized;

public class Header extends AbstractHeader implements IMobileUtils {

    @FindBy(xpath = ".//button[@aria-controls='secondary-nav-sm']")
    private ExtendedWebElement navMenuButton;

    @Localized
    @FindBy(xpath = ".//nav[@id='secondary-nav-sm']//li[@role='presentation']/a[not(@target='_blank')]")
    private List<ExtendedWebElement> mobileHeaderTitles;

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
        promoText.getText();
        navMenuButton.click();
        expandAllNavButton.click();
        for (ExtendedWebElement title: mobileHeaderTitles) {
            swipe(title);
            title.getText();
        }
        navMenuButton.click();
    }

}
