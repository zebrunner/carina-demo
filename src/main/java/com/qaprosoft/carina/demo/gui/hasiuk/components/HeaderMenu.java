package com.qaprosoft.carina.demo.gui.hasiuk.components;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractUIObject;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class HeaderMenu extends AbstractUIObject {

    @FindBy(xpath = ".//a[1]")
    private ExtendedWebElement homeLink;

    @FindBy(xpath = ".//a[2]")
    private ExtendedWebElement newsLink;

    @FindBy(xpath = ".//a[3]")
    private ExtendedWebElement reviewsLink;

    @FindBy(xpath = ".//a[4]")
    private ExtendedWebElement videosLink;

    @FindBy(xpath = ".//a[5]")
    private ExtendedWebElement featuredLink;

    @FindBy(xpath = ".//a[6]")
    private ExtendedWebElement phoneFinderLink;

    @FindBy(xpath = ".//a[7]")
    private ExtendedWebElement dealsLink;

    @FindBy(xpath = ".//a[8]")
    private ExtendedWebElement merchLink;

    @FindBy(xpath = ".//a[9]")
    private ExtendedWebElement coverageLink;

    @FindBy(xpath = ".//a[10]")
    private ExtendedWebElement contactLink;

    public HeaderMenu(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public boolean isAllElementsPresent() {
        List<ExtendedWebElement> thisElement = List.of(homeLink, newsLink, reviewsLink, videosLink, featuredLink,
                phoneFinderLink, dealsLink, merchLink, coverageLink, contactLink);
        for (ExtendedWebElement element : thisElement) {
            if (!element.isPresent()) return false;
        }
        return true;
    }
}
