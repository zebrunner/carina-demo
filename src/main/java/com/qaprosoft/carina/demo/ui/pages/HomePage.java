package com.qaprosoft.carina.demo.ui.pages;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import com.qaprosoft.carina.demo.ui.components.NavigationElementItem;
import com.qaprosoft.carina.demo.ui.components.SearchItem;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.invoke.MethodHandles;
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

    public ExtendedWebElement getCarinaTextInHeader() {
        return carinaTextInHeader;
    }

    public ExtendedWebElement getZebrunnerLogo() {
        return zebrunnerLogo;
    }

    public ExtendedWebElement getOverviewLabel() {
        return overviewLabel;
    }

    public SearchItem getSearchItem() {
        return searchItem;
    }

    public ExtendedWebElement getGithubLink() {
        return githubLink;
    }

    public ExtendedWebElement getHeader() {
        return header;
    }

    public NavigationElementItem getNavigationElementItem() {
        return navigationElementItem;
    }

    public List<ExtendedWebElement> getNavigationList() {
        return navigationList;
    }

}
