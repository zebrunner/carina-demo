package com.qaprosoft.carina.demo.ui.pages;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import com.qaprosoft.carina.demo.ui.components.NavigationElementItem;
import com.qaprosoft.carina.demo.ui.constants.NavigationUrl;
import com.qaprosoft.carina.demo.ui.components.SearchItem;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class HomePage extends AbstractPage {

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

    @FindBy(xpath = "//header//div[@class='md-header-nav__source']//a")
    private ExtendedWebElement githubLink;

    @FindBy(xpath = "//li[contains(@class, 'md-nav__item') and .//a[contains(text(),%s)]]")
    private ExtendedWebElement  navElement;

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

    public boolean isCurrentPageLinkHighlighted() {
        return navElement.format("Overview").getAttribute("class").contains("md-nav__item--active");
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

    public boolean getAttributeHrefFromNavigationList(ExtendedWebElement element) {
        String name;
        String href;
        if (element.isElementPresent()) {
            name = element.getText().toUpperCase().replace(' ', '_').trim();
            href = element.getAttribute("href");
        } else {
            name = element.getAttribute("title").toUpperCase().replace(' ', '_').trim();
            if (name.equals("MOBILE")) {
                href = element.getAttribute("href");
                if (href.contains("automation")) {
                    name = "MOBILE_IN_AUTOMATION";
                } else {
                    name = "MOBILE_IN_ADVANCED";
                }
            } else {
                href = element.getAttribute("href");
            }
        }
        return isAttributeHrefCorrect(name, href);
    }

    public static boolean isAttributeHrefCorrect(String name, String href) {
        return href.equalsIgnoreCase(NavigationUrl.valueOf(name).getUrl());
    }
}
