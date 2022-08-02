package com.qaprosoft.carina.demo.mytest;

import com.qaprosoft.carina.core.foundation.IAbstractTest;
import com.qaprosoft.carina.demo.mymobile.gui.pages.android.HomePage;
import com.qaprosoft.carina.demo.mymobile.gui.pages.common.HomePageBase;
import com.qaprosoft.carina.demo.mymobile.gui.pages.common.RegisterPageBase;
import com.zebrunner.agent.core.annotation.TestLabel;
import org.testng.Assert;
import org.testng.annotations.Test;

public class MobileTest implements IAbstractTest {

    @Test
    public void testHomePageAndRegisterPage(){

        HomePageBase homePage = initPage(getDriver(), HomePageBase.class);
        //Assert.assertTrue(homePage.isPageOpened(), "Home page is not opened");
        Assert.assertTrue(homePage.isCarinaLogoPresent(), "Carina logo is not present");
        Assert.assertTrue(homePage.isNextBtnPresent(), "Next button is not present");

        RegisterPageBase registerPage = homePage.clickNextBtn();

        //Verify elements is present
        Assert.assertTrue(registerPage.isBackBtnPresent(), "Back button is not present");
        Assert.assertTrue(registerPage.isNameInputPresent(), "Name input is not present");
        Assert.assertTrue(registerPage.isPasswordInputPresent(), "Password input is not present");
        Assert.assertTrue(registerPage.isMaleRadioPresent(), "Male radio is not present");
        Assert.assertTrue(registerPage.isFemaleRadioPresent(), "Female radio is not present");
        Assert.assertTrue(registerPage.isCheckboxPresent(), "Checkbox is not present");
        Assert.assertTrue(registerPage.isSignUpBtnPresent(), "Sign up button is not present");
        Assert.assertEquals(registerPage.readCarinaLogo(), "CARINA", "Carina logo has wrong text");

        //Verify radio buttons
        Assert.assertFalse(registerPage.isMaleRadioChecked(), "Male radio button should be turned off");
        Assert.assertFalse(registerPage.isFemaleRadioChecked(), "Female radio button should be turned off");
        registerPage.clickMaleRadio();
        Assert.assertTrue(registerPage.isMaleRadioChecked(), "Male radio button should be turned on");
        Assert.assertFalse(registerPage.isFemaleRadioChecked(), "Female radio button should be turned off");
        registerPage.clickFemaleRadio();
        Assert.assertFalse(registerPage.isMaleRadioChecked(), "Male radio button should be turned off");
        Assert.assertTrue(registerPage.isFemaleRadioChecked(), "Female radio button should be turned on");

        //Verify checkbox
        Assert.assertFalse(registerPage.isCheckboxChecked());
        registerPage.clickCheckbox();
        Assert.assertTrue(registerPage.isCheckboxChecked());
        registerPage.clickCheckbox();
        Assert.assertFalse(registerPage.isCheckboxChecked());
    }

}
