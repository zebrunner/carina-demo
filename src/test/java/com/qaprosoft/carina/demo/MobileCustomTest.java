/*
 * Copyright 2013-2021 QAPROSOFT (http://qaprosoft.com/).
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.qaprosoft.carina.demo;

import com.qaprosoft.carina.core.foundation.IAbstractTest;
import com.qaprosoft.carina.core.foundation.utils.mobile.IMobileUtils;
import com.qaprosoft.carina.core.foundation.utils.ownership.MethodOwner;
import com.qaprosoft.carina.demo.mobile.gui.pages.common.*;
import com.qaprosoft.carina.demo.utils.MobileContextUtils;
import com.qaprosoft.carina.demo.utils.MobileContextUtils.View;
import com.zebrunner.agent.core.annotation.TestLabel;
import org.apache.commons.lang3.RandomStringUtils;
import org.testng.Assert;
import org.testng.annotations.Test;


public class MobileCustomTest implements IAbstractTest, IMobileUtils {

    @Test()
    @MethodOwner(owner = "qpsdemo")
    @TestLabel(name = "feature", value = {"mobile", "regression"})
    public void testLoginPage() {
        String username = "Test user";
        String password = RandomStringUtils.randomAlphabetic(10);
        WelcomePageBase welcomePage = initPage(getDriver(), WelcomePageBase.class);
        Assert.assertTrue(welcomePage.isPageOpened(), "Welcome page isn't opened");
        LoginPageBase loginPage = welcomePage.clickNextBtn();
        Assert.assertFalse(loginPage.isLoginBtnActive(), "Login button is active when it should be disabled");
        Assert.assertTrue(loginPage.getNameField().getText().equals("Name"));
        Assert.assertTrue(loginPage.getPasswordField().getText().equals("Password"));
        Assert.assertTrue(loginPage.getMaleButton().getText().equals("Male") && !loginPage.getMaleButton().isChecked());
        Assert.assertTrue(loginPage.getFemaleButton().getText().equals("Female") && !loginPage.getFemaleButton().isChecked());
        Assert.assertTrue(loginPage.getPrivacyCheckbox().getText().equals("I agree to the Privacy Policy") && !loginPage.getPrivacyCheckbox().isChecked());
        Assert.assertTrue(loginPage.getLoginButton().getText().equals("Sign Up"));

        loginPage.typeName(username);
        loginPage.typePassword(password);

        Assert.assertTrue(loginPage.getNameField().getText().length() > 0);
        Assert.assertTrue(loginPage.getPasswordField().getText().length() > 0);

        loginPage.selectMaleSex();
        loginPage.checkPrivacyPolicyCheckbox();
        CarinaDescriptionPageBase carinaDescriptionPage = loginPage.clickLoginBtn();
        Assert.assertTrue(carinaDescriptionPage.isPageOpened(), "Carina description page isn't opened");
    }
}