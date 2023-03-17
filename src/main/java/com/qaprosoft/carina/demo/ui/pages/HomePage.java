package com.qaprosoft.carina.demo.ui.pages;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import com.qaprosoft.carina.demo.ui.components.NavigationElementItem;
import com.qaprosoft.carina.demo.ui.constants.NavigationUrl;
import com.qaprosoft.carina.demo.ui.components.SearchItem;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.invoke.MethodHandles;
import java.util.ArrayList;
import java.util.List;

public class HomePage extends AbstractPage {

    private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

    @FindBy(xpath = "//header")
    private ExtendedWebElement header;

    @FindBy(xpath = "//header//span[contains(text(),'Carina')]")
    private ExtendedWebElement carinaTextInHeader;

    @FindBy(xpath = "//header//img[@alt='logo']")
    private ExtendedWebElement zebrunnerLogo;

    @FindBy(xpath = "//header//div[@class='md-search']")
    private SearchItem searchItem;

    @FindBy(xpath = "//nav[@class='md-nav md-nav--primary']")
    private NavigationElementItem navigationElementItem;

    @FindBy(xpath = "//h1[@id='overview']")
    private ExtendedWebElement overviewLabel;

    @FindBy(xpath = "//header//div[@class='md-header-nav__source']//a")
    private ExtendedWebElement githubLink;

    @FindBy(xpath = "//li//a")
    private List<ExtendedWebElement> navigationList;

    public HomePage(WebDriver driver) {
        super(driver);
        setPageAbsoluteURL("http://zebrunner.github.io/carina/");
    }

    public List<ExtendedWebElement> getNavigationList() {
        return navigationList;
    }

    public boolean isCarinaTextInHeaderPresent() {
        return carinaTextInHeader.getText().equals("Carina");
    }

    public boolean isZebrunnerLogoPresent() {
        return zebrunnerLogo.isElementPresent();
    }

    public boolean isSearchItemPresent() {
        return searchItem.isUIObjectPresent();
    }

    public boolean isSearchLogoPresentOnPage() {
        return searchItem.isSearchLogoPresent();
    }

    public boolean isSearchInputPresentOnPage() {
        return searchItem.isSearchInputPresent();
    }

    public String getSearchInputPlaceholderOnPage() {
        return searchItem.getSearchInputPlaceholder();
    }

    public boolean isGithubLinkPresent() {
        return githubLink.isElementPresent();
    }

    public String getGithubLinkHrefAttribute() {
        return githubLink.getAttribute("href");
    }

    public boolean isHeaderVisible() {
        return header.isVisible();
    }

    public String getCssValueHeaderPosition() {
        return header.getElement().getCssValue("position");
    }

    public String getCssValueHeaderTop() {
        return header.getElement().getCssValue("top");
    }

    public boolean isNavigationElementItemPresent() {
        return navigationElementItem.isUIObjectPresent();
    }

    public int getAllElementsOfNavigationElementItem() {
        return (navigationElementItem.findExtendedWebElements(By.xpath("//li[contains(@class,'md-nav__item')]"))).size();
    }

    public String getOverviewLabelText() {
        return overviewLabel.getText();
    }

    public String getOverviewNavigationElementText() {
        return navigationElementItem.findExtendedWebElement(By.xpath("//li[@class='md-nav__item md-nav__item--active']"))
                .getAttribute("innerText");
    }

    public boolean isWebSectionPresentOnPage() {
        return navigationElementItem.isWebSectionPresent();
    }

    public boolean isAutomationSectionPresentOnPage() {
        return navigationElementItem.isAutomationSectionPresent();
    }

    public void expandAutomationSectionOnPage() {
        navigationElementItem.expandAutomationSection();
    }

    public List<String> getAttributeHrefFromNavigationList(ExtendedWebElement element) {
        List<String> listOfNameAndHref = new ArrayList<>();
        if (element.isElementPresent()) {
            String name = element.getText().toUpperCase().replace(' ', '_').trim();
            listOfNameAndHref.add(name);
            String href = element.getAttribute("href");
            listOfNameAndHref.add(href);
            return listOfNameAndHref;
        } else {
            String name = element.getAttribute("title").toUpperCase().replace(' ', '_').trim();
            if (name.equals("MOBILE")) {
                String href = element.getAttribute("href");
                if (href.contains("automation")) {
                    name = "MOBILE_IN_AUTOMATION";
                } else {
                    name = "MOBILE_IN_ADVANCED";
                }
                listOfNameAndHref.add(name);
                listOfNameAndHref.add(href);
            } else {
                String href = element.getAttribute("href");
                listOfNameAndHref.add(name);
                listOfNameAndHref.add(href);
            }
            return listOfNameAndHref;
        }
    }

    public boolean isAttributeHrefCorrect(List<String> listOfNameAndHref) {
        return listOfNameAndHref.get(1).equalsIgnoreCase(NavigationUrl.valueOf(listOfNameAndHref.get(0)).getUrl());
    }
}
