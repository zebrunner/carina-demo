package com.qaprosoft.carina.demo;


import com.qaprosoft.carina.core.foundation.IAbstractTest;
import com.qaprosoft.carina.core.foundation.utils.mobile.IMobileUtils;
import com.qaprosoft.carina.core.foundation.utils.ownership.MethodOwner;
import com.qaprosoft.carina.demo.mobile.gui.pages.common.CarinaDescriptionPageBase;
import com.qaprosoft.carina.demo.mobile.gui.pages.common.LoginPageBase;
import com.qaprosoft.carina.demo.mobile.gui.pages.common.WelcomePageBase;
import com.zebrunner.agent.core.annotation.TestLabel;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class MyMobileTest implements IAbstractTest, IMobileUtils {
    @Test(description = "My mobile test for login")
    @MethodOwner(owner = "qpsdemo")
    @TestLabel(name = "feature", value = {"mobile", "regression"})
    public void LoginTest() throws Exception {
        String name = "Yaroslav";
        String pass = "pass123";

        WelcomePageBase welcomePageBase = initPage(getDriver(), WelcomePageBase.class);

        SoftAssert softAssert= new SoftAssert();
        //1st step
        LoginPageBase loginPageBase = welcomePageBase.clickNextBtn();
        softAssert.assertTrue(loginPageBase.isPageOpened(), "Login Form isn't open.");

        //2nd step
        softAssert.assertTrue(loginPageBase.isNamePresented(), "Name field isn't present on the Login Form.");
        softAssert.assertTrue(loginPageBase.isPassPresented(), "Password field isn't present on the Login Form.");
        softAssert.assertTrue(loginPageBase.isGenderPresented(), "Male radio isn't present on the Login Form.");
        softAssert.assertFalse(loginPageBase.isPrivacyChecked(), "Privacy is checked by default.");
        softAssert.assertFalse(loginPageBase.isLoginBtnActive(),"Login button is active with empty fields.");

        //3rd step
        loginPageBase.typeName(name);
        loginPageBase.typePassword(pass);
        softAssert.assertTrue(loginPageBase.isNameEntered(name), "Name field isn't filled.");
        softAssert.assertTrue(loginPageBase.isPassEntered(pass),"Pass field isn't filled.");
        //4th step
        loginPageBase.selectMaleSex();
        softAssert.assertTrue(loginPageBase.isMaleSelected(), "Male radio not selected.");

        //5th step
        loginPageBase.checkPrivacyPolicyCheckbox();
        softAssert.assertTrue(loginPageBase.isPrivacyChecked(), "Privacy button isn't checked.");

        //6th step
        softAssert.assertTrue(loginPageBase.isLoginBtnActive(), "Login button isn't clickable.");
        CarinaDescriptionPageBase carinaPageBase = loginPageBase.clickLoginBtn();
        softAssert.assertTrue(carinaPageBase.isPageOpened(), "Can't log in.");

        softAssert.assertAll();

    }

}
