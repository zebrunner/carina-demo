package com.qaprosoft.carina.demo.beatsbydre.component.desktop;

import com.qaprosoft.carina.demo.beatsbydre.component.common.AbstractHeader;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.decorator.annotations.Localized;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class Header extends AbstractHeader {
    @FindBy(xpath = ".//button[@aria-label='Search Beats']")
    private ExtendedWebElement searchButton;

    @FindBy(xpath = ".//a[@aria-label='Beats Logo']")
    private ExtendedWebElement logoImg;

    @Localized
    @FindBy(xpath = ".//a[text()='{L10N:Header.headerItems0} ']")
    private ExtendedWebElement discoverButton;

    @Localized
    @FindBy(xpath = ".//a[text()='{L10N:Header.headerItems1} ]")
    private ExtendedWebElement shopButton;

    @Localized
    @FindBy(xpath = ".//a[text()='{L10N:Header.headerItems2} ']")
    private ExtendedWebElement supportButton;

    public Header(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

}
