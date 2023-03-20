package com.qaprosoft.carina.demo;

import com.qaprosoft.carina.core.foundation.IAbstractTest;
import com.qaprosoft.carina.demo.reglog.HomePage;
import com.qaprosoft.carina.demo.reglog.LoginPage;
import com.zebrunner.carina.core.registrar.ownership.MethodOwner;
import com.zebrunner.carina.core.registrar.tag.Priority;
import com.zebrunner.carina.core.registrar.tag.TestPriority;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class LoginTest implements IAbstractTest {

    @Test(dataProvider = "login")
    @MethodOwner(owner = "ygalitsyna")
    @TestPriority(Priority.P1)
    public void testSuccessfulLogin(String email, String password) {
        HomePage homePage = new HomePage(getDriver());
        homePage.open();
        LoginPage loginPage = homePage.goToLoginPage();
        loginPage.getUserEmailInput().type(email);
        loginPage.getUserPasswordInput().type(password);
        loginPage.getLoginButton().click();
        Assert.assertTrue(homePage.isPersonalMenuButtonPresent(), "Logging failed");
    }

    @Test(dataProvider = "unsuccessful_login")
    @MethodOwner(owner = "ygalitsyna")
    @TestPriority(Priority.P1)
    public void testUnsuccessfulLogin(String email, String password) {
        HomePage homePage = new HomePage(getDriver());
        homePage.open();
        LoginPage loginPage = homePage.goToLoginPage();
        loginPage.getUserEmailInput().type(email);
        loginPage.getUserPasswordInput().type(password);
        loginPage.getLoginButton().click();
        Assert.assertTrue(loginPage.isErrorMessagePresent(), "No error message appeared. User logged in with wrong email or password");
        Assert.assertTrue(loginPage.getErrorMessageText().equalsIgnoreCase("Invalid email or password."), "Invalid error message");
    }

    @DataProvider(name = "login")
    public Object[][] getData() {
        return new Object[][]{
                {"vaminab359@loongwin.com", "p@ssword1111"}
        };
    }

    @DataProvider(name = "unsuccessful_login")
    public Object[][] getWrongData() {
        return new Object[][]{
                {"vaminab359@loongwin.com", "p@ssword111"}
        };
    }
}
