package com.qaprosoft.carina.demo;

import com.qaprosoft.carina.core.foundation.IAbstractTest;
import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.demo.ui.constants.NavigationUrl;
import com.qaprosoft.carina.demo.ui.pages.HomePage;
import com.zebrunner.carina.core.registrar.ownership.MethodOwner;
import com.zebrunner.carina.core.registrar.tag.Priority;
import com.zebrunner.carina.core.registrar.tag.TestPriority;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CarinaWebTest implements IAbstractTest {

    @Test
    @MethodOwner(owner = "ygalitsyna")
    @TestPriority(Priority.P1)
    public void testOpenPage() {
        HomePage homePage = new HomePage(getDriver());
        homePage.open();
        Assert.assertTrue(homePage.isPageOpened(), "Home page is not opened");
    }

    @Test(dependsOnMethods = "testOpenPage")
    @MethodOwner(owner = "ygalitsyna")
    @TestPriority(Priority.P3)
    public void testCarinaTextInHeader() {
        HomePage homePage = new HomePage(getDriver());
        homePage.open();
        Assert.assertTrue(homePage.isCarinaTextInHeaderPresent(),
                "Header doesn't contain this word: ");
    }

    @Test
    @MethodOwner(owner = "ygalitsyna")
    @TestPriority(Priority.P3)
    public void testLogoInHeader() {
        HomePage homePage = new HomePage(getDriver());
        homePage.open();
        Assert.assertTrue(homePage.isZebrunnerLogoPresent(),
                "Zebrunner image isn't in the header");
        Assert.assertTrue(homePage.findExtendedWebElement(By.xpath("//header//img[@alt='logo']/.."))
                .getAttribute("href").equalsIgnoreCase(NavigationUrl.OVERVIEW.getUrl()),
                "Clicking on the Zebrunner image redirects to Overview page.");
    }

    @Test
    @MethodOwner(owner = "ygalitsyna")
    @TestPriority(Priority.P3)
    public void testSearchInHeader() {
        HomePage homePage = new HomePage(getDriver());
        homePage.open();
        Assert.assertTrue(homePage.isSearchItemPresent());
        Assert.assertTrue(homePage.isSearchLogoPresentOnPage(), "Search logo component isn't present on header");
        Assert.assertTrue(homePage.isSearchInputPresentOnPage(), "Search input component isn't present on header");
        Assert.assertTrue(homePage.getSearchInputPlaceholderOnPage().equalsIgnoreCase("Search"),
                "Search placeholder isn't present on header");
    }

    @Test
    @MethodOwner(owner = "ygalitsyna")
    @TestPriority(Priority.P3)
    public void testGithubLinkInHeader() {
        HomePage homePage = new HomePage(getDriver());
        homePage.open();
        Assert.assertTrue(homePage.isGithubLinkPresent(),
                "The header doesn't contain a link to go to the repository by link");
        Assert.assertTrue(homePage.getGithubLinkHrefAttribute().equalsIgnoreCase("https://github.com/zebrunner/carina/"),
                "Link doesn't redirect to Zebrunner github project");
    }

    @Test
    @MethodOwner(owner = "ygalitsyna")
    @TestPriority(Priority.P3)
    public void testHeaderAtTheBottomOfPage() {
        HomePage homePage = new HomePage(getDriver());
        homePage.open();
        Actions action = new Actions(homePage.getDriver());
        action.sendKeys(Keys.PAGE_DOWN).build().perform();
        Assert.assertTrue(homePage.isHeaderVisible(),
                "Header isn't visible when scrolling down the page");
        Assert.assertTrue(homePage.getCssValueHeaderPosition().equalsIgnoreCase("sticky"),
                "Header isn't attached to the top of a page");
        Assert.assertTrue(homePage.getCssValueHeaderTop().equalsIgnoreCase("0px"),
                "Header isn't attached to the top of a page");
    }

    @Test
    @MethodOwner(owner = "ygalitsyna")
    @TestPriority(Priority.P3)
    public void testNavigationElementVisibility() {
        HomePage homePage = new HomePage(getDriver());
        homePage.open();
        Assert.assertTrue(homePage.isNavigationElementItemPresent(),
                "Navigation element isn't present on header");
        Assert.assertTrue(homePage.getAllElementsOfNavigationElementItem() > 0, "List of navigation links is empty");
        Assert.assertTrue(homePage.getOverviewLabelText().equalsIgnoreCase(homePage.getOverviewNavigationElementText()),
                "Link to current page isn't highlighted");
    }

    @Test
    @MethodOwner(owner = "ygalitsyna")
    @TestPriority(Priority.P3)
    public void testNavigationHiddenComponent() {
        HomePage homePage = new HomePage(getDriver());
        homePage.open();
        Assert.assertFalse(homePage.isWebSectionPresentOnPage(),
                "The element is present on the page");
        Assert.assertTrue(homePage.isAutomationSectionPresentOnPage(),
                "The element isn't present on the page");
        homePage.expandAutomationSectionOnPage();
        Assert.assertTrue(homePage.isWebSectionPresentOnPage(), "The element isn't present on the page");
    }

    @Test
    @MethodOwner(owner = "ygalitsyna")
    @TestPriority(Priority.P3)
    public void testNavigationWorksProperly() {
        HomePage homePage = new HomePage(getDriver());
        homePage.open();
        for (ExtendedWebElement el : homePage.getNavigationList()) {
            Assert.assertTrue(homePage.isAttributeHrefCorrect(homePage.getAttributeHrefFromNavigationList(el)),
                        "The element contains an invalid page link");
        }
    }
}
