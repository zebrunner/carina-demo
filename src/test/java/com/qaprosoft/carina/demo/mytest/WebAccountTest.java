package com.qaprosoft.carina.demo.mytest;

import java.lang.invoke.MethodHandles;

import org.apache.commons.lang3.RandomStringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qaprosoft.carina.demo.gui.components.LoginComponent;
import com.qaprosoft.carina.demo.gui.components.TopNavbarComponent;
import com.qaprosoft.carina.core.foundation.IAbstractTest;
import com.qaprosoft.carina.core.foundation.utils.ownership.MethodOwner;
import com.qaprosoft.carina.core.foundation.utils.tag.Priority;
import com.qaprosoft.carina.core.foundation.utils.tag.TestPriority;
import com.qaprosoft.carina.demo.gui.pages.HomePage;
import com.qaprosoft.carina.demo.gui.pages.RegisterPage;
import com.qaprosoft.carina.demo.gui.pages.AccountPage;
import com.qaprosoft.carina.demo.gui.pages.LoginPage;
import com.zebrunner.agent.core.annotation.TestLabel;

public class WebAccountTest implements IAbstractTest {

    @DataProvider(name = "login-data")
    public Object[][] dataProvMethod(){
        int n = 4; // number of email-password scenarios
        Object[][] data = new Object[n][2];

        for (int i = 0; i < n; i++) {
            data[i][0] = RandomStringUtils.random(10, "abcdefghijklmnopqrstuvwxyz1234567890") + "@gmail.com";
            data[i][1] = RandomStringUtils.random(10, "abcdefghijklmnopqrstuvwxyz1234567890_-.");
        }
        return data;
    }

    @Test
    @MethodOwner(owner = "nickpopyk")
    @TestPriority(Priority.P3)
    @TestLabel(name = "feature", value = {"web", "regression"})
    public void testRegistrationSuccessful(){
        // Open GSM Arena home page and verify page is opened
        HomePage homePage = new HomePage(getDriver());
        homePage.open();
        Assert.assertTrue(homePage.isPageOpened(), "Home page is not opened");

        // Open register page and verify page is opened
        RegisterPage registerPage = homePage.getTopNavbarComponent().openRegisterPage();
        Assert.assertTrue(registerPage.isPageOpened(), "Register page is not opened");

        // Verify if form elements are present
        Assert.assertTrue(registerPage.isUsernameTextFieldPresent(), "Username textfield is not present");
        Assert.assertTrue(registerPage.isEmailTextFieldPresent(), "Email textfield is not present");
        Assert.assertTrue(registerPage.isPasswordTextFieldPresent(), "Password textfield is not present");
        Assert.assertTrue(registerPage.isAgreementCheckBoxPresent(), "Agreement checkbox textfield is not present");
        Assert.assertTrue(registerPage.isAgeConfirmationCheckBoxPresent(), "Age confirmation checkbox is not present");

        registerPage.fillForm("tecbxzlsfrb", "tefbxfopssdf@gmail.com", "1234567890");
        Assert.assertFalse(registerPage.isSubmitButtonDisabled(), "Submit button is disabled");
        registerPage.clickSubmitButton();

        //Check if success title (registration is successful)
        Assert.assertTrue(registerPage.isSuccessTitlePresent(), "Success title is not present");
        Assert.assertEquals(registerPage.getSuccessTitleString(), "Your account was created.", "Success title has wrong text");
    }

    @Test(dataProvider = "login-data")
    @MethodOwner(owner = "nickpopyk")
    @TestPriority(Priority.P3)
    @TestLabel(name = "feature", value = {"web", "regression"})
    public void testLoginUnsuccessful(String email, String password) throws InterruptedException {
        // Open GSM Arena home page and verify page is opened
        HomePage homePage = new HomePage(getDriver());
        homePage.open();
        Assert.assertTrue(homePage.isPageOpened(), "Home page is not opened");

        // Open login pop up window and verify window is opened
        LoginComponent loginPopup =  homePage.getTopNavbarComponent().openLoginPopUp();
        Assert.assertTrue(loginPopup.isUIObjectPresent(), "Login pop up is not opened");

        // Verify login pop up elements is present
        Assert.assertTrue(loginPopup.isLoginTitlePresent(), "Login title is not present");
        Assert.assertTrue(loginPopup.isEmailTextFieldPresent(), "Email test field is not present");
        Assert.assertTrue(loginPopup.isPasswordTestFieldPresent(), "Password text field is not present");
        Assert.assertTrue(loginPopup.isSubmitButtonPresent(), "Submit button is not present");
        Assert.assertTrue(loginPopup.isForgotPasswordLinkPresent(), "Forgot password link is not present");

        // Hover submit button and wait for animation to finish
        loginPopup.hoverSubmitButton();
        pause(1);

        //Check for colors of submit button when its hovered
        Assert.assertEquals(
                loginPopup.readColorOfTextOfSubmitButton(),
                "rgba(255, 255, 255, 1)",
                "Color of text in submit button is wrong"
        );  //white
        Assert.assertEquals(
                loginPopup.readColorOfSubmitButton(),
                "rgba(213, 0, 0, 1)",
                "Color of submit button is wrong"
        );  //red

        //Check for validation attributes
        Assert.assertEquals(loginPopup.readEmailAttribute("type"), "email", "'type' attribute of email input is not 'email'");
        Assert.assertEquals(loginPopup.readEmailAttribute("required"), "true", "Email input doesn't have 'required' attribute");
        Assert.assertEquals(loginPopup.readPasswordAttribute("type"), "password", "'type' attribute of password input is not 'password'");
        Assert.assertEquals(loginPopup.readPasswordAttribute("required"), "true", "Password input doesn't have 'required' attribute");
        Assert.assertEquals(loginPopup.readPasswordAttribute("pattern"), "\\S{6,}", "Password pattern is wrong");

        loginPopup.typeEmail(email);
        loginPopup.typePassword(password);

        LoginPage loginPage = loginPopup.clickSubmitButton();
        Assert.assertTrue(loginPage.isPageOpened(), "Login page is not opened");
        Assert.assertTrue(loginPage.isLoginResultTitlePresent(), "Login result title is not present");
        Assert.assertEquals(loginPage.readLoginResultTitle(), "Login failed.", "Login result title has wrong text");
    }

    @Test
    @MethodOwner(owner = "nickpopyk")
    @TestPriority(Priority.P3)
    @TestLabel(name = "feature", value = {"web", "regression"})
    public void testLoginSuccessful(){
        // Open GSM Arena home page and verify page is opened
        HomePage homePage = new HomePage(getDriver());
        homePage.open();
        Assert.assertTrue(homePage.isPageOpened(), "Home page is not opened");

        // Open login pop up window and verify window is opened
        TopNavbarComponent topNavbar = homePage.getTopNavbarComponent();
        LoginComponent loginPopup = topNavbar.openLoginPopUp();
        Assert.assertTrue(loginPopup.isUIObjectPresent(), "Login pop up is not opened");

        // Verify login pop up elements is present
        Assert.assertTrue(loginPopup.isLoginTitlePresent(), "Login title is not present");
        Assert.assertTrue(loginPopup.isEmailTextFieldPresent(), "Email test field is not present");
        Assert.assertTrue(loginPopup.isPasswordTestFieldPresent(), "Password text field is not present");
        Assert.assertTrue(loginPopup.isSubmitButtonPresent(), "Submit button is not present");
        Assert.assertTrue(loginPopup.isForgotPasswordLinkPresent(), "Forgot password link is not present");

        // Log in into the existing account
        String email = "thistestn123@gmail.com";
        String password = "1234567890";
        String username = "testuser990";
        loginPopup.typeEmail(email);
        loginPopup.typePassword(password);
        loginPopup.clickSubmitButton();

        //Check if login successful
        Assert.assertTrue(homePage.isPageOpened(), "Home page is not opened");
        Assert.assertTrue(topNavbar.isAccountButtonPresent(), "Account button is not present");
        Assert.assertTrue(topNavbar.isLogoutButtonPresent(), "Logout button is not present");
        topNavbar.hoverAccountButton();
        Assert.assertEquals(topNavbar.readAccountTitle(), username.toUpperCase(), "Account title is not as expected");
        topNavbar.hoverLogoutButton();
        Assert.assertEquals(topNavbar.readLogoutTitle(), "LOG OUT", "Logout title is not as expected");

        AccountPage accountPage = topNavbar.openAccountPage();
        Assert.assertTrue(accountPage.isAccountTitlePresent(), "Account title is not present");
        Assert.assertEquals(accountPage.readAccountTitle(), username + " - user account", "Account title is not as expected");
    }
}
