package com.qaprosoft.carina.demo.cucumber.steps;


import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.Assert;

import com.qaprosoft.carina.core.foundation.cucumber.CucumberRunner;
import com.qaprosoft.carina.core.foundation.utils.image.ImageProcessing;
import com.qaprosoft.carina.demo.gui.components.NewsItem;
import com.qaprosoft.carina.demo.gui.pages.HomePage;
import com.qaprosoft.carina.demo.gui.pages.NewsPage;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class GSMArenaNewsSteps extends CucumberRunner {
    
    HomePage homePage = null;
    NewsPage newsPage = null;

    @Given("^I am on main page")
    public boolean iAmOnMainPage() {
        homePage = new HomePage(getDriver());
        homePage.open();
        return homePage.isPageOpened();
    }
    
    @When("^I open 'News' page$")
    public void iOpenNewsPage()  {
        newsPage = homePage.getFooterMenu().openNewsPage();
        Assert.assertTrue(newsPage.isPageOpened(), "News page is not opened!");
    }

    @Then("^page 'News' should be open$")
    public void pageSettingsShouldBeOpen() {
        Assert.assertTrue(newsPage.isPageOpened(), "News page is not opened!");
    }
    
    @And("^page 'News' should contains all items$")
    public void pageSettingsShouldContainsAllItems() {
        final String searchQ = "iphone";
        List<NewsItem> news = newsPage.searchNews(searchQ);
        Assert.assertFalse(CollectionUtils.isEmpty(news), "News not found!");
        for(NewsItem n : news) {
            System.out.println(n.readTitle());
            Assert.assertTrue(StringUtils.containsIgnoreCase(n.readTitle(), searchQ), "Invalid search results!");
        }
    }

    @After
    public void takeScreenshotOfFailure(Scenario scenario) {
        LOGGER.info("In  @After takeScreenshotOfFailure");
        if (scenario.isFailed()) {
            LOGGER.error("Cucumber Scenario FAILED! Creating screenshot.");
            byte[] screenshot=((TakesScreenshot) getDriver()).getScreenshotAs(OutputType.BYTES);

            screenshot = ImageProcessing.imageResize(screenshot);
            scenario.embed(screenshot, "image/png"); //stick it in the report
        }

    }

}
