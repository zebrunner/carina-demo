package com.qaprosoft.carina.demo;

import com.qaprosoft.carina.core.foundation.IAbstractTest;
import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.demo.ui.components.Url;
import com.qaprosoft.carina.demo.ui.pages.HomePage;
import com.zebrunner.carina.core.registrar.ownership.MethodOwner;
import com.zebrunner.carina.core.registrar.tag.Priority;
import com.zebrunner.carina.core.registrar.tag.TestPriority;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class CarinaWebTest implements IAbstractTest {

    @Test
    @MethodOwner(owner = "yana-glt")
    @TestPriority(Priority.P1)
    public void testOpenPage() {
        HomePage homePage = new HomePage(getDriver());
        homePage.open();
        Assert.assertTrue(homePage.isPageOpened(), "Home page is not opened");
    }

    @Test(dependsOnMethods = "testOpenPage")
    @MethodOwner(owner = "yana-glt")
    @TestPriority(Priority.P3)
    public void testCarinaTextInHeader() {
        HomePage homePage = new HomePage(getDriver());
        homePage.open();
        Assert.assertTrue(homePage.getCarinaTextInHeader().getText().equals("Carina"),
                "Header doesn't contain this word: ");
    }

    @Test
    @MethodOwner(owner = "yana-glt")
    @TestPriority(Priority.P3)
    public void testLogoInHeader() {
        HomePage homePage = new HomePage(getDriver());
        homePage.open();
        Assert.assertTrue(homePage.getZebrunnerLogo().isElementPresent(),
                "Zebrunner image isn't in the header");
        Assert.assertTrue(homePage.findExtendedWebElement(By.xpath("//header//img[@alt='logo']/.."))
                .getAttribute("href").equalsIgnoreCase(Url.OVERVIEW.getUrl()),
                "Clicking on the Zebrunner image redirects to Overview page.");
    }

    @Test
    @MethodOwner(owner = "yana-glt")
    @TestPriority(Priority.P3)
    public void testSearchInHeader() {
        HomePage homePage = new HomePage(getDriver());
        homePage.open();
        Assert.assertTrue(homePage.getSearchItem().isUIObjectPresent(),
                "Search component isn't present on header");
        Assert.assertTrue(homePage.getSearchItem().getSearchInput().isElementPresent(),
                "Search input component isn't present on header");
        String searchPlaceholder = homePage.getSearchItem().getSearchInput().getAttribute("ariaLabel");
        Assert.assertTrue(searchPlaceholder.equalsIgnoreCase("Search"),
                "Search placeholder  isn't present on header");
        Assert.assertTrue(homePage.getSearchItem().getSearchLogo().isElementPresent(),
                "Search logo component isn't present on header");
    }

    @Test
    @MethodOwner(owner = "yana-glt")
    @TestPriority(Priority.P3)
    public void testGithubLinkInHeader() {
        HomePage homePage = new HomePage(getDriver());
        homePage.open();
        Assert.assertTrue(homePage.getGithubLink().isElementPresent(),
                "The header doesn't contain a link to go to the repository by link");
        Assert.assertTrue(homePage.getGithubLink().getAttribute("href")
                        .equalsIgnoreCase("https://github.com/zebrunner/carina/"),
                "Link doesn't redirect to Zebrunner github project");
    }

    @Test
    @MethodOwner(owner = "yana-glt")
    @TestPriority(Priority.P3)
    public void testHeaderAtTheBottomOfPage() {
        HomePage homePage = new HomePage(getDriver());
        homePage.open();
        Actions at = new Actions(homePage.getDriver());
        at.sendKeys(Keys.PAGE_DOWN).build().perform();
        Assert.assertTrue(homePage.getHeader().isVisible(),
                "Header isn't visible when scrolling down the page");
        Assert.assertTrue(homePage.getHeader().getElement().getCssValue("position").equalsIgnoreCase("sticky"),
                "Header isn't attached to the top of a page");
        Assert.assertTrue(homePage.getHeader().getElement().getCssValue("top").equalsIgnoreCase("0px"),
                "Header isn't attached to the top of a page");
    }

    @Test
    @MethodOwner(owner = "yana-glt")
    @TestPriority(Priority.P3)
    public void testNavigationElementVisibility() {
        HomePage homePage = new HomePage(getDriver());
        homePage.open();
        Assert.assertTrue(homePage.getNavigationElementItem().isUIObjectPresent(),
                "Navigation element isn't present on header");
        List<ExtendedWebElement> list = homePage
                .getNavigationElementItem()
                .findExtendedWebElements(By.xpath("//li[contains(@class,'md-nav__item')]"));
        Assert.assertTrue(list.size() > 0, "List of navigation links is empty");
        String overviewTitle = homePage.getOverviewLabel().getText();
        String overviewNavigElement = homePage
                .getNavigationElementItem()
                .findExtendedWebElement(By.xpath("//li[@class='md-nav__item md-nav__item--active']"))
                .getAttribute("innerText");
        Assert.assertTrue(overviewTitle.equalsIgnoreCase(overviewNavigElement),
                "Link to current page isn't highlighted");
    }

    @Test
    @MethodOwner(owner = "yana-glt")
    @TestPriority(Priority.P3)
    public void testNavigationHiddenComponent() {
        HomePage homePage = new HomePage(getDriver());
        homePage.open();
        Assert.assertTrue(homePage.getNavigationElementItem().getWeb().isElementNotPresent(5),
                "The element is present on the page");
        Assert.assertTrue(homePage.getNavigationElementItem().getAutomation().isElementPresent(),
                "The element isn't present on the page");
        homePage.getNavigationElementItem().getAutomation().click();
        Assert.assertTrue(homePage.getNavigationElementItem().getWeb()
                .isElementPresent(), "The element isn't present on the page");
    }

    @Test
    @MethodOwner(owner = "yana-glt")
    @TestPriority(Priority.P3)
    public void testNavigationWorksProperly() {
        HomePage homePage = new HomePage(getDriver());
        homePage.open();
        List<ExtendedWebElement> list = homePage.getNavigationList();
        for (ExtendedWebElement el : list) {
            if (el.isElementPresent()) {
                String name = el.getText().toUpperCase().replace(' ', '_').trim();
                Assert.assertTrue(el.getAttribute("href").equalsIgnoreCase(Url.valueOf(name).getUrl()),
                        "The element contains an invalid page link");
            } else {
                String name = el.getAttribute("title").toUpperCase().replace(' ', '_').trim();
                if (name.equals("MOBILE")) {
                    String temp = el.getAttribute("href");
                    if (temp.contains("automation")) {
                        name = "MOBILE_IN_AUTOMATION";
                        Assert.assertTrue(el.getAttribute("href").equalsIgnoreCase(Url.valueOf(name).getUrl()),
                                "The element contains an invalid page link");
                    } else {
                        name = "MOBILE_IN_ADVANCED";
                        Assert.assertTrue(el.getAttribute("href").equalsIgnoreCase(Url.valueOf(name).getUrl()),
                                "The element contains an invalid page link");
                    }
                }
            }
        }
    }
}
