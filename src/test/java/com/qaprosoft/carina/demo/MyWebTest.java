package com.qaprosoft.carina.demo;

import com.qaprosoft.carina.core.foundation.IAbstractTest;
import com.qaprosoft.carina.core.foundation.utils.ownership.MethodOwner;
import com.qaprosoft.carina.demo.constants.IConstant;
import com.qaprosoft.carina.demo.gui.components.FooterMenu;
import com.qaprosoft.carina.demo.gui.components.HeaderItem;
import com.qaprosoft.carina.demo.gui.services.LoginService;
import com.qaprosoft.carina.demo.gui.pages.ArticlePage;
import com.qaprosoft.carina.demo.gui.pages.HomePage;
import com.qaprosoft.carina.demo.gui.pages.NewsPage;
import com.qaprosoft.carina.demo.gui.services.UserService;
import com.zebrunner.agent.core.annotation.TestLabel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.lang.invoke.MethodHandles;

public class MyWebTest implements IAbstractTest, IConstant {
    private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

    @Test(description = "Header items are present")
    @MethodOwner(owner = "qpsdemo")
    @TestLabel(name = "header", value = "web")
    public void headerValidation() {
        SoftAssert softAssert = new SoftAssert();
        HomePage homePage = new HomePage(getDriver());
        homePage.open();
        HeaderItem headerItem = new HeaderItem(getDriver());
        Assert.assertTrue(homePage.isPageOpened(), "Home page is not opened");
        softAssert.assertTrue(headerItem.isMenuPresented(), "Menu isn't present.");
        softAssert.assertTrue(headerItem.isSiteLogoPresented(), "Site logo isn't present.");
        softAssert.assertTrue(headerItem.isSearchBarPresented(), "Search bar isn't present.");
        softAssert.assertTrue(headerItem.isTipLogoPresented(), "Tip isn't present.");
        softAssert.assertTrue(headerItem.isFbIconPresented(), "Facebook isn't presented.");
        softAssert.assertTrue(headerItem.isTwIconPresented(), "Twitter isn't present.");
        softAssert.assertTrue(headerItem.isInstIconPresented(), "Instagram isn't present.");
        softAssert.assertTrue(headerItem.isYtIconPresented(), "YouTube isn't present.");
        softAssert.assertTrue(headerItem.isRssIconPresented(), "RSS isn't present.");
        softAssert.assertFalse(headerItem.isLoginButtonPresented(), "Login button isn't present.");
        softAssert.assertTrue(headerItem.isSignUpButtonPresented(), "Sign Up button isn't present.");
        softAssert.assertAll();
    }

    @Test(description = "Login with currect creds")
    @MethodOwner(owner = "qpsdemo")
    @TestLabel(name = "login", value = "web")
    public void loginTest() {
        HomePage homePage = new HomePage(getDriver());
        LoginService loginService = new LoginService();
        homePage.open();
        Assert.assertTrue(homePage.isPageOpened(), "Home page isn't opened.");
        loginService.login(UserService.getUser());
    }

    @Test(description = "Login with wrong email")
    @MethodOwner(owner = "qpsdemo")
    @TestLabel(name = "login", value = "web")
    public void loginWrongEmail() {
        HomePage homePage = new HomePage(getDriver());
        HeaderItem headerItem = new HeaderItem(getDriver());
        LoginService loginService = new LoginService();
        homePage.open();
        Assert.assertTrue(homePage.isPageOpened(), "Home page isn't opened.");
        Assert.assertTrue(headerItem.isLoginButtonPresented(), "Login button isn't present.");
        headerItem.login(EMAIL + 1, PASS);
        Assert.assertTrue(headerItem.isUserLogged(), "User isn't logged in.");
        Assert.assertEquals(homePage.getErrorMessage(), USER_NOT_FOUND, String.format("Found message: %s, expected: %s", homePage.getErrorMessage(), USER_NOT_FOUND));
        Assert.assertFalse(headerItem.isUserLogged(), "User is logged in.");
    }

    @Test(description = "Login with wrong password")
    @MethodOwner(owner = "qpsdemo")
    @TestLabel(name = "login", value = "web")
    public void loginWrongPass() {
        HomePage homePage = new HomePage(getDriver());
        LoginService loginService = new LoginService();
        HeaderItem headerItem = new HeaderItem(getDriver());
        homePage.open();
        Assert.assertTrue(homePage.isPageOpened(), "Home page isn't opened.");
        Assert.assertTrue(headerItem.isLoginButtonPresented(), "Login button isn't present.");
        headerItem.login(EMAIL, PASS + 1);
        Assert.assertTrue(headerItem.isUserLogged(), "User isn't logged in.");
        Assert.assertEquals(homePage.getErrorMessage(), WRONG_PASSWORD, String.format("Found message: %s, expected: %s", homePage.getErrorMessage(), WRONG_PASSWORD));
    }

    @Test(description = "First article check")
    @MethodOwner(owner = "qpsdemo")
    @TestLabel(name = "article", value = "web")
    public void articleVerifying() {
        HomePage homePage = new HomePage(getDriver());
        LoginService loginService = new LoginService();
        homePage.open();
        Assert.assertTrue(homePage.isPageOpened(), "Home page isn't opened.");
        loginService.login(UserService.getUser());
        FooterMenu footerMenu = homePage.getFooterMenu();
        NewsPage newsPage = footerMenu.openNewsPage();
        Assert.assertTrue(newsPage.isPageOpened(), "News page isn't opened.");
        String articleTitleFromSearch = newsPage.getFirstArticleTitle();
        ArticlePage articlePage = newsPage.openFirstArticle();
        Assert.assertEquals(articleTitleFromSearch, articlePage.articleTitle(), String.format("Expected title: '%s', actual - '%s'", articleTitleFromSearch, articlePage.articleTitle()));
        Assert.assertTrue(articlePage.isArticlePresented(), "Article isn't opened.");
        loginService.logout();
    }

    @Test(description = "Articles search check")
    @MethodOwner(owner = "qpsdemo")
    @TestLabel(name = "article", value = "web")
    public void articleSearching() {
        String search_text = "iPhone";
        SoftAssert softAssert = new SoftAssert();
        LoginService loginService = new LoginService();
        HomePage homePage = new HomePage(getDriver());
        homePage.open();
        Assert.assertTrue(homePage.isPageOpened(), "Home page isn't opened.");
        loginService.login(UserService.getUser());
        FooterMenu footerMenu = homePage.getFooterMenu();
        NewsPage newsPage = footerMenu.openNewsPage();
        Assert.assertTrue(newsPage.isPageOpened(), "News page isn't opened.");
        newsPage.searchNews(search_text);
        softAssert.assertEquals(newsPage.getResultSearchText(), String.format(SEARCH_RESULT, search_text), "Search result isn't correct.");
        LOGGER.info(newsPage.getTitle());
        LOGGER.info(String.format(SEARCH_RESULT, search_text));
        Assert.assertTrue(newsPage.areArticlesContain(search_text), String.format("Article aren't contain text: '%s'.", search_text));
        softAssert.assertAll();
    }

}
