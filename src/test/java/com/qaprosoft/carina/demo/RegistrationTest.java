package com.qaprosoft.carina.demo;

import com.qaprosoft.carina.core.foundation.IAbstractTest;
import com.qaprosoft.carina.demo.reglog.HomePage;
import com.qaprosoft.carina.demo.reglog.RegistrationPage;
import com.zebrunner.carina.core.registrar.ownership.MethodOwner;
import com.zebrunner.carina.core.registrar.tag.Priority;
import com.zebrunner.carina.core.registrar.tag.TestPriority;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class RegistrationTest implements IAbstractTest {

    @Test(dataProvider = "registration")
    @MethodOwner(owner = "ygalitsyna")
    @TestPriority(Priority.P1)
    public void testRegistration(String firstName, String lastName, String email, String userName, String password)  {
        HomePage homePage = new HomePage(getDriver());
        homePage.open();
        RegistrationPage registrationPage = homePage.goToRegistrationPage();
        registrationPage.getUserFirstNameInput().type(firstName);
        registrationPage.getUserLastNameInput().type(lastName);
        registrationPage.getUserEmailInput().type(email);
        registrationPage.getUserNameInput().type(userName);
        registrationPage.getUserPasswordInput().type(password);
        registrationPage.getJoinButton().click();
    }

    @DataProvider(name = "registration")
    public Object [][] getData(){
        return new Object[][]{
                {"Adam", "Smith", "sui1jt83f4m3@gmail.com", "adamsmithhh", "p@sswordAdama"}
        };
    }
}
