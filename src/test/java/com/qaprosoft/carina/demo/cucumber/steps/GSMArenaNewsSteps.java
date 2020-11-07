package com.qaprosoft.carina.demo.cucumber.steps;


import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.testng.Assert;

import com.qaprosoft.carina.core.foundation.webdriver.IDriverPool;
import com.qaprosoft.carina.demo.gui.components.NewsItem;
import com.qaprosoft.carina.demo.gui.pages.HomePage;
import com.qaprosoft.carina.demo.gui.pages.NewsPage;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class GSMArenaNewsSteps implements IDriverPool {
    
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

	@When("I open news #{int}")
	public void iOpenParticularNews(int index) {
		newsPage.openNewsByIndex(index);
	}

}
