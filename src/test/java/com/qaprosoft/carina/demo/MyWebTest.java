package com.qaprosoft.carina.demo;

import com.qaprosoft.carina.core.foundation.IAbstractTest;
import com.qaprosoft.carina.core.foundation.utils.ownership.MethodOwner;
import com.qaprosoft.carina.demo.gui.components.HeaderItem;
import com.qaprosoft.carina.demo.gui.pages.HomePage;
import com.zebrunner.agent.core.annotation.TestLabel;
import org.testng.Assert;
import org.testng.annotations.Test;

public class MyWebTest implements IAbstractTest {

    private String email = "gordiy99@gmail.com";
    private String pass = "123456gsm";
    private final String USER_NOT_FOUND = "Reason: User record not found.";
    private final String WRONG_PASSWORD = "Reason: Wrong password.";

    @Test(description = "Header items are present")
    @MethodOwner(owner = "qpsdemo")
    @TestLabel(name = "header", value = "web")
    public void headerValidation() {
        HomePage homePage = new HomePage(getDriver());
        homePage.open();
        HeaderItem headerItem = new HeaderItem(getDriver());
        Assert.assertTrue(homePage.isPageOpened(), "Home page is not opened");
        Assert.assertTrue(headerItem.isMenuPresented(), "Menu isn't present.");
        Assert.assertTrue(headerItem.isSiteLogoPresented(), "Site logo isn't present.");
        Assert.assertTrue(headerItem.isSearchBarPresented(), "Search bar isn't present.");
        Assert.assertTrue(headerItem.isTipLogoPresented(), "Tip isn't present.");
        Assert.assertTrue(headerItem.isFbIconPresented(), "Facebook isn't presented.");
        Assert.assertTrue(headerItem.isTwIconPresented(), "Twitter isn't present.");
        Assert.assertTrue(headerItem.isInstIconPresented(), "Instagram isn't present.");
        Assert.assertTrue(headerItem.isYtIconPresented(), "YouTube isn't present.");
        Assert.assertTrue(headerItem.isRssIconPresented(), "RSS isn't present.");
        Assert.assertTrue(headerItem.isLoginButtonPresented(), "Login button isn't present.");
        Assert.assertTrue(headerItem.isSignUpButtonPresented(), "Sign Up button isn't present.");
    }

    @Test(description = "Login with currect creds")
    @MethodOwner(owner = "qpsdemo")
    @TestLabel(name = "login", value = "web")
    public void loginTest() {
        HomePage homePage = new HomePage(getDriver());
        homePage.open();
        HeaderItem headerItem = new HeaderItem(getDriver());
        Assert.assertTrue(homePage.isPageOpened(), "Home page isn't opened.");
        headerItem.login(email, pass);
        Assert.assertTrue(homePage.isUserLogged(), "User isn't logged in.");
    }

    @Test(description = "Login with wrong email")
    @MethodOwner(owner = "qpsdemo")
    @TestLabel(name = "login", value = "web")
    public void loginWrongEmail() {
        HomePage homePage = new HomePage(getDriver());
        homePage.open();
        HeaderItem headerItem = new HeaderItem(getDriver());
        Assert.assertTrue(homePage.isPageOpened(), "Home page isn't opened.");
        headerItem.login(email + "1", pass);
        Assert.assertEquals(homePage.getErrorMessage(), USER_NOT_FOUND, String.format("Found message: %s, expected: %s", homePage.getErrorMessage(), USER_NOT_FOUND));
        Assert.assertFalse(homePage.isUserLogged());
    }

    @Test(description = "Login with wrong password")
    @MethodOwner(owner = "qpsdemo")
    @TestLabel(name = "login", value = "web")
    public void loginWrongPass() {
        HomePage homePage = new HomePage(getDriver());
        homePage.open();
        HeaderItem headerItem = new HeaderItem(getDriver());
        Assert.assertTrue(homePage.isPageOpened(), "Home page isn't opened.");
        headerItem.login(email, pass + "1");
        Assert.assertEquals(homePage.getErrorMessage(), WRONG_PASSWORD,String.format("Found message: %s, expected: %s", homePage.getErrorMessage(), WRONG_PASSWORD));
        Assert.assertFalse(homePage.isUserLogged());
    }

}
