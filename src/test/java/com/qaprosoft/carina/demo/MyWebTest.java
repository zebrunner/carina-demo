package com.qaprosoft.carina.demo;

import com.qaprosoft.carina.core.foundation.IAbstractTest;
import com.qaprosoft.carina.core.foundation.utils.ownership.MethodOwner;
import com.qaprosoft.carina.demo.gui.components.FooterMenu;
import com.qaprosoft.carina.demo.gui.components.HeaderItem;
import com.qaprosoft.carina.demo.gui.components.LoginService;
import com.qaprosoft.carina.demo.gui.pages.ArticlePage;
import com.qaprosoft.carina.demo.gui.pages.HomePage;
import com.qaprosoft.carina.demo.gui.pages.NewsPage;
import com.zebrunner.agent.core.annotation.TestLabel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.lang.invoke.MethodHandles;

public class MyWebTest implements IAbstractTest {
    private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

    private String email = "gordiy99@gmail.com";
    private String pass = "123456gsm";
    private final String USER_NOT_FOUND = "Reason: User record not found.";
    private final String WRONG_PASSWORD = "Reason: Wrong password.";
    private final String SEARCH_RESULT = "Results for \"%s\"";

    @Test(description = "Header items are present")
    @MethodOwner(owner = "qpsdemo")
    @TestLabel(name = "header", value = "web")
    public void headerValidation() {
        SoftAssert softAssert = new SoftAssert();
        HomePage homePage = new HomePage(getDriver());
        LoginService loginService = new LoginService(getDriver());
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
        softAssert.assertFalse(loginService.isLoginButtonPresented(), "Login button isn't present.");
        softAssert.assertTrue(loginService.isSignUpButtonPresented(), "Sign Up button isn't present.");
        softAssert.assertAll();
    }

    @Test(description = "Login with currect creds")
    @MethodOwner(owner = "qpsdemo")
    @TestLabel(name = "login", value = "web")
    public void loginTest() {
        HomePage homePage = new HomePage(getDriver());
        LoginService loginService = new LoginService(getDriver());
        homePage.open();
        Assert.assertTrue(homePage.isPageOpened(), "Home page isn't opened.");
        loginService.login(email, pass);
        Assert.assertTrue(homePage.isUserLogged(), "User isn't logged in.");
    }

    @Test(description = "Login with wrong email")
    @MethodOwner(owner = "qpsdemo")
    @TestLabel(name = "login", value = "web")
    public void loginWrongEmail() {
        HomePage homePage = new HomePage(getDriver());
        LoginService loginService = new LoginService(getDriver());
        homePage.open();
        Assert.assertTrue(homePage.isPageOpened(), "Home page isn't opened.");
        loginService.login(email + "1", pass);
        Assert.assertEquals(homePage.getErrorMessage(), USER_NOT_FOUND, String.format("Found message: %s, expected: %s", homePage.getErrorMessage(), USER_NOT_FOUND));
        Assert.assertFalse(homePage.isUserLogged(), "User is logged in.");
    }

    @Test(description = "Login with wrong password")
    @MethodOwner(owner = "qpsdemo")
    @TestLabel(name = "login", value = "web")
    public void loginWrongPass() {
        HomePage homePage = new HomePage(getDriver());
        LoginService loginService = new LoginService(getDriver());
        homePage.open();
        Assert.assertTrue(homePage.isPageOpened(), "Home page isn't opened.");
        loginService.login(email, pass + "1");
        Assert.assertEquals(homePage.getErrorMessage(), WRONG_PASSWORD, String.format("Found message: %s, expected: %s", homePage.getErrorMessage(), WRONG_PASSWORD));
        Assert.assertFalse(homePage.isUserLogged(), "User is logged in.");
    }

    @Test(description = "First article check")
    @MethodOwner(owner = "qpsdemo")
    @TestLabel(name = "article", value = "web")
    public void articleVerifying() {
        HomePage homePage = new HomePage(getDriver());
        LoginService loginService = new LoginService(getDriver());
        homePage.open();
        Assert.assertTrue(homePage.isPageOpened(), "Home page isn't opened.");
        Assert.assertEquals(loginService.isLoginButtonPresented(), "Login button isn't present.");
        loginService.login(email, pass);
        Assert.assertTrue(homePage.isUserLogged(), "User isn't logged in.");
        FooterMenu footerMenu = homePage.getFooterMenu();
        NewsPage newsPage = footerMenu.openNewsPage();
        Assert.assertTrue(newsPage.isPageOpened(), "News page isn't opened.");
        String articleTitleFromSearch = newsPage.firstArticleTitle();
        ArticlePage articlePage = newsPage.openFirstArticle();
        Assert.assertEquals(articleTitleFromSearch, articlePage.articleTitle(), String.format("Expected title: '%s', actual - '%s'", articleTitleFromSearch, articlePage.articleTitle()));
        Assert.assertTrue(articlePage.isArticlePresented(), "Article isn't opened.");
        Assert.assertEquals(loginService.isLogoutButtonPresented(), "Logout button isn't presented.");
        loginService.logout();
        Assert.assertEquals(loginService.isSignUpButtonPresented(), "Can't logout.");
    }

    @Test(description = "Articles search check")
    @MethodOwner(owner = "qpsdemo")
    @TestLabel(name = "article", value = "web")
    public void articleSearching() {
        String search_text = "iPhone";
        SoftAssert softAssert = new SoftAssert();
        LoginService loginService = new LoginService(getDriver());
        HomePage homePage = new HomePage(getDriver());
        homePage.open();
        Assert.assertTrue(homePage.isPageOpened(), "Home page isn't opened.");
        loginService.login(email, pass);
        Assert.assertTrue(homePage.isUserLogged(), "User isn't logged in.");
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
