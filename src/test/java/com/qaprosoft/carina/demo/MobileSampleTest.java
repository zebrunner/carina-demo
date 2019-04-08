package com.qaprosoft.carina.demo;

import java.io.File;

import com.qaprosoft.carina.core.foundation.utils.mobile.MobileUtils;
import com.qaprosoft.carina.demo.mobile.gui.pages.common.*;
import org.apache.commons.lang3.RandomStringUtils;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.qaprosoft.carina.core.foundation.AbstractTest;
import com.qaprosoft.carina.core.foundation.utils.Configuration;
import com.qaprosoft.carina.core.foundation.utils.R;
import com.qaprosoft.carina.core.foundation.utils.factory.DeviceType.Type;
import com.qaprosoft.carina.core.foundation.utils.ownership.MethodOwner;

public class MobileSampleTest extends AbstractTest {

	@Test(description = "JIRA#DEMO-0011")
	@MethodOwner(owner = "qpsdemo")
	public void testLoginUser() {
		setApplicationPath();
		String username = "Test user";
		String password = RandomStringUtils.randomAlphabetic(10);
		WelcomePageBase welcomePage = initPage(getDriver(), WelcomePageBase.class);
		Assert.assertTrue(welcomePage.isPageOpened(), "Welcome page isn't opened");
		LoginPageBase loginPage = welcomePage.clickNextBtn();
		Assert.assertFalse(loginPage.isLoginBtnActive(), "Login button is active");
		loginPage.typeName(username);
		loginPage.typePassword(password);
		loginPage.selectMaleSex();
		loginPage.checkPrivacyPolicyCheckbox();
		CarinaDescriptionPageBase carinaDescriptionPage = loginPage.clickLoginBtn();
		Assert.assertTrue(carinaDescriptionPage.isPageOpened(), "Carina description page isn't opened");
	}

	@Test(description = "JIRA#DEMO-0011")
	@MethodOwner(owner = "qpsdemo")
	public void testWebView() {
		setApplicationPath();
		WelcomePageBase welcomePage = initPage(getDriver(), WelcomePageBase.class);
		LoginPageBase loginPage = welcomePage.clickNextBtn();
		CarinaDescriptionPageBase carinaDescriptionPage = loginPage.login();
		WebViewPageBase webViewPageBase = carinaDescriptionPage.navigateToWebViewPage();
		ContactUsPageBase contactUsPage = webViewPageBase.goToContactUsPage();
		contactUsPage.typeName("John Doe");
		contactUsPage.typeEmail("some@email.com");
		contactUsPage.typeQuestion("your framework is awesome");
		MobileUtils.hideKeyboard();
		contactUsPage.submit();
		Assert.assertTrue(contactUsPage.isSuccessMessagePresent(),"message was not sent!");
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
