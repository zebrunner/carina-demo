package com.qaprosoft.carina.demo.ui.pages;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import com.qaprosoft.carina.demo.ui.components.NavigationElementItem;
import com.qaprosoft.carina.demo.ui.components.NavigationUrl;
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

    String searchPlaceholder = "";

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
        boolean isSearchItemPresent = false;
        boolean isSearchLogoPresent = false;
        boolean isSearchInputPresent = false;
        isSearchItemPresent = searchItem.isUIObjectPresent();
        if (isSearchItemPresent) {
            isSearchLogoPresent = searchItem.isSearchLogoPresent();
            if (isSearchLogoPresent) {
                isSearchInputPresent = searchItem.isSearchInputPresent();
                if (isSearchInputPresent) {
                    searchPlaceholder = searchItem.getSearchInputPlaceholder();
                } else {
                    LOGGER.error("Search input component isn't present on header");
                }
            } else {
                LOGGER.error("Search logo component isn't present on header");
            }
        } else {
            LOGGER.error("Search component isn't present on header");
        }
        return isSearchItemPresent && isSearchLogoPresent && isSearchInputPresent;
    }

    public String getSearchPlaceholder() {
        return searchPlaceholder;
    }

    public boolean isGithubLinkPresent() {
        return githubLink.isElementPresent();
    }

    public String getGithubLinkHrefAttribute() {
        String githubLinkHrefAttribute = githubLink.getAttribute("href");
        return githubLinkHrefAttribute;
    }

    public boolean isHeaderVisible() {
        return header.isVisible();
    }

    public String getCssValueHeaderPosition() {
        String cssValuePosition = header.getElement().getCssValue("position");
        return cssValuePosition;
    }

    public String getCssValueHeaderTop() {
        String cssValueTop = header.getElement().getCssValue("top");
        return cssValueTop;
    }

    public boolean isNavigationElementItemPresent() {
        return navigationElementItem.isUIObjectPresent();
    }

    public int getAllElementsOfNavigationElementItem() {
        List<ExtendedWebElement> elements = navigationElementItem
                .findExtendedWebElements(By.xpath("//li[contains(@class,'md-nav__item')]"));
        System.out.println(elements.size());
        return elements.size();
    }

    public String getOverviewLabelText() {
        String overviewLabelText = overviewLabel.getText();
        return overviewLabelText;
    }

    public String getOverviewNavigationElementText() {
        String overviewNavigationElementText = navigationElementItem
                .findExtendedWebElement(By.xpath("//li[@class='md-nav__item md-nav__item--active']"))
                .getAttribute("innerText");
        return overviewNavigationElementText;
    }

    public boolean isWebPresentOnPage() {
        return navigationElementItem.isWebPresent();
    }

    public boolean isAutomationPresentOnPage() {
        return navigationElementItem.isAutomationPresent();
    }

    public void clickOnAutomationOnPage() {
        navigationElementItem.clickOnAutomation();
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
        boolean result = listOfNameAndHref.get(1).equalsIgnoreCase(NavigationUrl.valueOf(listOfNameAndHref.get(0)).getUrl());
        return result;
    }
}
