package com.qaprosoft.carina.demo;

import com.qaprosoft.carina.core.foundation.IAbstractTest;
import com.qaprosoft.carina.demo.reglog.HomePage;
import com.qaprosoft.carina.demo.reglog.LoginPage;
import com.qaprosoft.carina.demo.reglog.RegistrationPage;
import com.zebrunner.carina.core.registrar.ownership.MethodOwner;
import com.zebrunner.carina.core.registrar.tag.Priority;
import com.zebrunner.carina.core.registrar.tag.TestPriority;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class RegistrationTest implements IAbstractTest {

    @Test(dataProvider = "registration")
    @MethodOwner(owner = "ygalitsyna")
    @TestPriority(Priority.P1)
    public void testRegistration(String firstName, String lastName, String email, String userName, String password)  {
        HomePage homePage = new HomePage(getDriver());
        homePage.open();
        LoginPage loginPage = homePage.goToLoginPage();
        RegistrationPage registrationPage = loginPage.goToRegistrationPage();
        HomePage homePageAfterRegistration = registrationPage.signUp(firstName, lastName, email, userName, password);
        Assert.assertTrue(homePageAfterRegistration.isPersonalMenuButtonPresent(), "Registration failed");
    }

    @Test(dataProvider = "registration")
    @MethodOwner(owner = "ygalitsyna")
    @TestPriority(Priority.P1)
    public void testUnsuccessfulRegistration(String firstName, String lastName, String email, String userName, String password)  {
        HomePage homePage = new HomePage(getDriver());
        homePage.open();
        LoginPage loginPage = homePage.goToLoginPage();
        RegistrationPage registrationPage = loginPage.goToRegistrationPage();
        registrationPage.signUp(firstName, lastName, email, userName, password);
        Assert.assertTrue(registrationPage.isErrorMessagePresent(),
                "No error message appeared. The user has registered with the data that was already used during registration.");
        Assert.assertTrue(registrationPage.getErrorMessageText().equalsIgnoreCase("3 errors prohibited this user from being saved:"),
                "Invalid error message");
    }

    @DataProvider(name = "registration")
    public Object [][] getData(){
        return new Object[][]{
                {"Ad", "Smile", "sui1jt83fdm@gmail.com", "adamsmile", "p@sswordAdama"}
        };
    }
}
