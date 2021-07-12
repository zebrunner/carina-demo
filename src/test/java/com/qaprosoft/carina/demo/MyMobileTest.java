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

public class MyMobileTest implements IAbstractTest, IMobileUtils {
    @Test()
    @MethodOwner(owner = "qpsdemo")
    @TestLabel(name = "feature", value = {"mobile", "regression"})
    public void LoginTest(){
        String name = "Yaroslav";
        String pass = "pass123";

        WelcomePageBase welcomePageBase = initPage(getDriver(), WelcomePageBase.class);

        //1st step
        LoginPageBase loginPageBase = welcomePageBase.clickNextBtn();
        Assert.assertTrue(loginPageBase.isPageOpened(), "Login page is opened");

        //2nd step
        Assert.assertTrue(loginPageBase.namePresented(), "Name is presented on the login Page");
        Assert.assertTrue(loginPageBase.passPresented(), "Password is presented on the login Page");
        Assert.assertTrue(loginPageBase.genderPresented(), "Male radio is presented on the login Page");

        //3rd step
        loginPageBase.typeName(name);
        loginPageBase.typePassword(pass);

        Assert.assertTrue(loginPageBase.namePresented() && loginPageBase.passPresented(), "Name and pass fields are filled");

        //4th step
        loginPageBase.selectMaleSex();
        Assert.assertTrue(loginPageBase.isMaleSelected(), "Selected male radio");

        //5th step
        loginPageBase.checkPrivacyPolicyCheckbox();
        Assert.assertTrue(loginPageBase.isPrivacyChecked(), "Privacy button is checked");

        //6th step
        Assert.assertTrue(loginPageBase.isLoginBtnActive(), "Login button is clickable");
        CarinaDescriptionPageBase carinaPageBase = loginPageBase.clickLoginBtn();
        Assert.assertTrue(carinaPageBase.isPageOpened(), "Logged in");

    }

}
