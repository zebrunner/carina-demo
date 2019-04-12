package com.qaprosoft.carina.demo;

import com.qaprosoft.carina.core.foundation.AbstractTest;
import com.qaprosoft.carina.core.foundation.utils.Configuration;
import com.qaprosoft.carina.core.foundation.utils.R;
import com.qaprosoft.carina.core.foundation.utils.factory.DeviceType.Type;
import com.qaprosoft.carina.core.foundation.utils.mobile.MobileUtils;
import com.qaprosoft.carina.core.foundation.utils.ownership.MethodOwner;
import com.qaprosoft.carina.core.foundation.webdriver.MobileContextHelper;
import com.qaprosoft.carina.demo.mobile.gui.pages.common.*;
import org.apache.commons.lang3.RandomStringUtils;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.File;

public class MobileSampleTest extends AbstractTest {

    @DataProvider(name = "contactMessage", parallel = false)
    public Object[][] contactMessage() {
        return new Object[][]
            { { "Jose", "I like your framework" }, { "Saul", "I would like to know more" }, { "Bhupesh", "It is awesome" } };

    }

    @Test(description = "JIRA#DEMO-0011")
    @MethodOwner(owner = "qpsdemo")
    public void testLoginUser() {
        setApplicationPath();
        String username = "Test user";
        String password = RandomStringUtils.randomAlphabetic(10);
        WelcomePageBase welcomePage = initPage(getDriver(), WelcomePageBase.class);
        Assert.assertTrue(welcomePage.isPageOpened(), "Welcome page isn't opened");
        LoginPageBase loginPage = welcomePage.clickNextBtn();
        Assert.assertFalse(loginPage.isLoginBtnActive(), "Login button is active when it should be disabled");
        loginPage.typeName(username);
        loginPage.typePassword(password);
        loginPage.selectMaleSex();
        loginPage.checkPrivacyPolicyCheckbox();
        CarinaDescriptionPageBase carinaDescriptionPage = loginPage.clickLoginBtn();
        Assert.assertTrue(carinaDescriptionPage.isPageOpened(), "Carina description page isn't opened");
    }

    @Test(dataProvider = "contactMessage",description = "JIRA#DEMO-0011")
    @MethodOwner(owner = "qpsdemo")
    public void testWebView(String name, String message) {
        setApplicationPath();
        WelcomePageBase welcomePage = initPage(getDriver(), WelcomePageBase.class);
        LoginPageBase loginPage = welcomePage.clickNextBtn();
        loginPage.login();
        WebViewPageBase webViewPageBase = initPage(getDriver(), WebViewPageBase.class);
        MobileContextHelper contextHelper = new MobileContextHelper();
        contextHelper.changeToWebViewContext(getDriver());
        ContactUsPageBase contactUsPage = webViewPageBase.goToContactUsPage();
        contactUsPage.typeName(name);
        contactUsPage.typeEmail("some@email.com");
        contactUsPage.typeQuestion(message);
        MobileUtils.hideKeyboard();
        contactUsPage.submit();
        Assert.assertTrue(contactUsPage.isSuccessMessagePresent()|| contactUsPage.isRecaptchaPresent(),
            "message was not sent or captcha was not displayed");
    }

    @Test(description = "JIRA#DEMO-0011")
    @MethodOwner(owner = "qpsdemo")
    public void testUIElements() {
        setApplicationPath();
        WelcomePageBase welcomePage = initPage(getDriver(), WelcomePageBase.class);
        LoginPageBase loginPage = welcomePage.clickNextBtn();
        CarinaDescriptionPageBase carinaDescriptionPage = loginPage.login();
        UIElementsPageBase uiElements = carinaDescriptionPage.navigateToUIElementsPage();
        uiElements.typeText("some Text");
        uiElements.typeDate("22/10/2018");
        uiElements.typeEmail("some@email.com");
        uiElements.swipeToFemaleRadioButton();
        uiElements.checkCopy();
        uiElements.clickOnFemaleRadioButton();
        uiElements.clickOnOtherRadioButton();

    }

    private void setApplicationPath() {
        String pathToApp;
        String iosPath = "src/main/resources/carinademoexample.zip";
        String androidPath = "src/main/resources/carinademoexample.apk";
        if (Type.ANDROID_PHONE.getFamily().equalsIgnoreCase(R.CONFIG.get("capabilities.platformName")))
            pathToApp = androidPath;
        else
            pathToApp = iosPath;
        File file = new File(pathToApp);
        Configuration.setMobileApp(file.getAbsolutePath());
    }

}
