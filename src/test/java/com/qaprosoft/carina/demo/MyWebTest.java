package com.qaprosoft.carina.demo;

import com.qaprosoft.carina.core.foundation.IAbstractTest;
import com.qaprosoft.carina.demo.gui.components.Header;
import com.qaprosoft.carina.demo.gui.components.LoginForm;
import com.qaprosoft.carina.demo.gui.pages.HomePage;
import com.qaprosoft.carina.demo.gui.pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class MyWebTest implements IAbstractTest {
    private final String loginGsmArena = "mixanod681@aregods.com";
    private final String wrongEmailGsmArena = "hggfhgfhgfh@aregods.com";
    private final String passwordGsmArena = "mixanod681";

    @Test
    public void verifyHeaderComponents() {
        SoftAssert softAssert = new SoftAssert();
        HomePage homePage = new HomePage(getDriver());
        homePage.open();
        Assert.assertTrue(homePage.isPageOpened(), "Home page isn't open");
        Assert.assertTrue(homePage.isHeaderPresent(), "Header isn't present");

        Header header = homePage.getHeader();
        softAssert.assertTrue(header.isBurgerMenuPresent(), "Burger menu isn't present");
        softAssert.assertTrue(header.isLogoPresent(), "Logo isn't present");
        softAssert.assertTrue(header.isSearchFieldPresent(), "Search field isn't present");
        softAssert.assertTrue(header.isTipIconPresent(), "Tip icon isn't present");
        softAssert.assertTrue(header.isYouTubeIconPresent(), "YouTube icon isn't present");
        softAssert.assertTrue(header.isInstagramIconPresent(), "Instagram icon isn't present");
        softAssert.assertTrue(header.isRssIconPresent(), "Rss icon isn't present");
        softAssert.assertTrue(header.isEvIconPresent(), "EV icon isn't present");
        softAssert.assertTrue(header.isMerchIconPresent(), "Merch icon isn't present");
        softAssert.assertTrue(header.isLoginIconPresent(), "Login icon isn't present");
        softAssert.assertTrue(header.isSignUpIconPresent(), "SignUp icon isn't present");

        softAssert.assertAll();
    }

    @Test
    public void verifySuccessLogin() {
        SoftAssert softAssert = new SoftAssert();
        HomePage homePage = new HomePage(getDriver());
        homePage.open();
        Assert.assertTrue(homePage.isPageOpened(), "Home page isn't open");
        Assert.assertTrue(homePage.isHeaderPresent(), "Header isn't present");
        Header header = homePage.getHeader();
        softAssert.assertTrue(header.isLoginIconPresent(), "Login icon isn't present");
        LoginForm loginForm = homePage.getHeader().openLoginForm();
        Assert.assertTrue(loginForm.isEmailInputPresent(), "Email field isn't present");
        loginForm.loginMethod(loginGsmArena,passwordGsmArena);
        loginForm.loginButtonClick();
        Assert.assertTrue(homePage.getHeader().isLogOutIconPresent(), "Operation login are not successful");
        softAssert.assertAll();
    }

    @Test
    public void verifyLoginWithWrongEmail(){
        SoftAssert softAssert = new SoftAssert();
        HomePage homePage = new HomePage(getDriver());
        homePage.open();
        Assert.assertTrue(homePage.isPageOpened(), "Home page isn't open");
        Assert.assertTrue(homePage.isHeaderPresent(), "Header isn't present");
        Header header = homePage.getHeader();
        softAssert.assertTrue(header.isLoginIconPresent(), "Login icon isn't present");
        LoginForm loginForm = homePage.getHeader().openLoginForm();
        Assert.assertTrue(loginForm.isEmailInputPresent(), "Email field isn't present");
        loginForm.loginMethod(wrongEmailGsmArena,passwordGsmArena);
        LoginPage loginPage=loginForm.clickLoginButton();
        Assert.assertTrue(loginPage.isLoginFailedTextPresent(),"Incorrect password or another problem");
        softAssert.assertAll();
    }
}
