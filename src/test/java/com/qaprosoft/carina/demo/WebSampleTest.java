/*
 * Copyright 2013-2018 QAPROSOFT (http://qaprosoft.com/).
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

import java.util.List;

import com.qaprosoft.carina.core.foundation.utils.tag.Priority;
import com.qaprosoft.carina.core.foundation.utils.tag.TestPriority;
import com.qaprosoft.carina.core.foundation.utils.tag.TestTag;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.qaprosoft.carina.core.foundation.AbstractTest;
import com.qaprosoft.carina.core.foundation.dataprovider.annotations.XlsDataSourceParameters;
import com.qaprosoft.carina.core.foundation.utils.R;
import com.qaprosoft.carina.core.foundation.utils.ownership.MethodOwner;
import com.qaprosoft.carina.demo.gui.components.FooterMenu;
import com.qaprosoft.carina.demo.gui.components.NewsItem;
import com.qaprosoft.carina.demo.gui.components.compare.ModelSpecs;
import com.qaprosoft.carina.demo.gui.components.compare.ModelSpecs.SpecType;
import com.qaprosoft.carina.demo.gui.pages.BrandModelsPage;
import com.qaprosoft.carina.demo.gui.pages.CompareModelsPage;
import com.qaprosoft.carina.demo.gui.pages.HomePage;
import com.qaprosoft.carina.demo.gui.pages.ModelInfoPage;
import com.qaprosoft.carina.demo.gui.pages.NewsPage;

/**
 * This sample shows how create Web test.
 * 
 * @author qpsdemo
 */
public class WebSampleTest extends AbstractTest {
	@Test(dataProvider = "SingleDataProvider", description = "JIRA#AUTO-0008")
	@MethodOwner(owner = "qpsdemo")
	@TestPriority(Priority.P3)
	@TestTag(name = "area test", value = "data provider")
	@TestTag(name = "specialization", value = "xlsx")
	@XlsDataSourceParameters(path = "xls/demo.xlsx", sheet = "GSMArena", dsUid = "TUID", dsArgs = "brand, model, display, camera, ram, battery")
	public void testModelSpecs(String brand, String model, String display, String camera, String ram, String battery) {
		// Open GSM Arena home page and verify page is opened
		HomePage homePage = new HomePage(getDriver());
		homePage.open();
		Assert.assertTrue(homePage.isPageOpened(), "Home page is not opened");

		// Closing advertising if it's displayed
		homePage.getWeValuePrivacyAd().closeAdIfPresent();

		// Select phone brand
		homePage = new HomePage(getDriver());
		BrandModelsPage productsPage = homePage.selectBrand(brand);
		// Select phone model
		ModelInfoPage productInfoPage = productsPage.selectModel(model);
		// Verify phone specifications
		Assert.assertEquals(productInfoPage.readDisplay(), display, "Invalid display info!");
		Assert.assertEquals(productInfoPage.readCamera(), camera, "Invalid camera info!");
		Assert.assertEquals(productInfoPage.readRam(), ram, "Invalid ram info!");
		Assert.assertEquals(productInfoPage.readBattery(), battery, "Invalid battery info!");
	}

	@Test(description = "JIRA#AUTO-0009")
	@MethodOwner(owner = "qpsdemo")
	@TestPriority(Priority.P1)
	@TestTag(name = "area test", value = "web")
	public void testCompareModels() {
		// Open GSM Arena home page and verify page is opened
		HomePage homePage = new HomePage(getDriver());
		homePage.open();
		Assert.assertTrue(homePage.isPageOpened(), "Home page is not opened");
		// Open model compare page
		FooterMenu footerMenu = homePage.getFooterMenu();
		Assert.assertTrue(footerMenu.isUIObjectPresent(2), "Footer menu wasn't found!");
		CompareModelsPage comparePage = footerMenu.openComparePage();
		// Compare 3 models
		List<ModelSpecs> specs = comparePage.compareModels("Samsung Galaxy J3", "Samsung Galaxy J5",
				"Samsung Galaxy J7 Pro");
		// Verify model announced dates
		Assert.assertEquals(specs.get(0).readSpec(SpecType.ANNOUNCED), "2015, November");
		Assert.assertEquals(specs.get(1).readSpec(SpecType.ANNOUNCED), "2015, June");
		Assert.assertEquals(specs.get(2).readSpec(SpecType.ANNOUNCED), "2017, June");
	}

	@Test(description = "JIRA#AUTO-0010")
	@MethodOwner(owner = "qpsdemo")
	public void testNewsSearch() {
		HomePage homePage = new HomePage(getDriver());
		homePage.open();
		Assert.assertTrue(homePage.isPageOpened(), "Home page is not opened!");

		NewsPage newsPage = homePage.getFooterMenu().openNewsPage();
		Assert.assertTrue(newsPage.isPageOpened(), "News page is not opened!");

		final String searchQ = "iphone";
		List<NewsItem> news = newsPage.searchNews(searchQ);
		Assert.assertFalse(CollectionUtils.isEmpty(news), "News not found!");
		for (NewsItem n : news) {
			System.out.println(n.readTitle());
			Assert.assertTrue(StringUtils.containsIgnoreCase(n.readTitle(), searchQ), "Invalid search results!");
		}
	}

	@Test
	public void testHeaderBaseElements() {
		HomePage homePage = new HomePage(getDriver());
		homePage.open();
		Assert.assertTrue(homePage.isPageOpened(), "Home page is not opened");
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertTrue(homePage.isBurgerMenuPresent(), "Burger menu is not present");

		softAssert.assertTrue(homePage.isLogoPresent(), "Logo is not present");
		softAssert.assertTrue(homePage.isSearchLabelPresent(), "Search label is not present");
		softAssert.assertTrue(homePage.isTipIconPresent(), "Tip icon is not present");
		softAssert.assertTrue(homePage.isFbIconPresent(), "Facebook icon is not present");
		softAssert.assertTrue(homePage.isTwitterIconPresent(), "Twitter icon is not present");
		softAssert.assertTrue(homePage.isInstagramIconPresent(), "Instagram icon is not present");
		softAssert.assertTrue(homePage.isYouTubeIconPresent(), "Youtube icon is not present");
		softAssert.assertTrue(homePage.isRssIconPresent(), "Rss icon is not present");
		softAssert.assertTrue(homePage.isLoginIconPresent(), "Lojin icon is not present");
		softAssert.assertTrue(homePage.isSignUpIconPresent(), "SignUp icon is not present");
		softAssert.assertAll();

	}

//Scenario 0
	@Test
	public void testLoginWindow() {
		HomePage homePage = new HomePage(getDriver());
		homePage.open();
		Assert.assertTrue(homePage.isPageOpened(), "Home page is not opened");

		homePage.clickLoginBtn();
		Assert.assertTrue(homePage.isLoginWindowPresent(), "Login dialog window is not opened");
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertTrue(homePage.isLoginLogoPresent(), "Login Logo is not present");
		softAssert.assertTrue(homePage.isEmailFieldPresent(), "Email field is not present");
		softAssert.assertTrue(homePage.isPasswordFieldPresent(), "Password field is not present");
		softAssert.assertTrue(homePage.isLoginBtnPresent(), "Login button is not present");
		softAssert.assertTrue(homePage.isIForgotPasswordLinkPresent(), "Email field is not present");
		softAssert.assertAll();
	}

//Scenario 1
	@Test
	public void testAuthorizaton() {
		HomePage homePage = new HomePage(getDriver());
		homePage.open();
		Assert.assertTrue(homePage.isOpened(), "Home page is not opened");
		homePage.clickLoginIcon();
		Assert.assertTrue(homePage.isLoginWindowPresent(), "Login dialog window is not opened");
		homePage.inputLogin(R.TESTDATA.get("email"));
		homePage.inputPassword(R.TESTDATA.get("password"));
		homePage.clickLoginBtn();
		Assert.assertTrue(homePage.isUserMenuPresent(), "User menu is not present");

		homePage.clickLogOutBtn();
	}

//Scenario 2
	@Test
	public void testFailedEmailAuthorization() {
		HomePage homePage = new HomePage(getDriver());
		homePage.open();
		Assert.assertTrue(homePage.isOpened(), "Home page is not opened");
		homePage.clickLoginIcon();
		Assert.assertTrue(homePage.isLoginWindowPresent(), "Login dialog window is not opened");
		homePage.inputLogin("s9rowamail.ru");
		homePage.inputPassword(R.TESTDATA.get("password"));
		homePage.clickLoginBtn();
		homePage.getTooltipEmailMessage();
		Assert.assertEquals(homePage.getTooltipEmailMessage(),
				"Please include an '@' in the email address. 's9rowamail.ru' is missing an '@'.",
				"Error email message is not equal");
	}

//Scenario 3	
	@Test
	public void testInvalidPasswordAuthorization() {
		HomePage homePage = new HomePage(getDriver());
		homePage.open();
		Assert.assertTrue(homePage.isOpened(), "Home page is not opened");
		homePage.clickLoginIcon();
		Assert.assertTrue(homePage.isLoginWindowPresent(), "Login dialog window is not opened");
		homePage.inputLogin(R.TESTDATA.get("email"));
		homePage.inputPassword("12");
		homePage.clickLoginBtn();
		homePage.getTooltipPasswordMessage();
		Assert.assertEquals(homePage.getTooltipPasswordMessage(), "Please match the requested format.",
				"Error password message is not equal");
	}

//Scenario 4
	@Test
	public void testWrongPasswordAuthorization() {
		HomePage homePage = new HomePage(getDriver());
		homePage.open();
		Assert.assertTrue(homePage.isOpened(), "Home page is not opened");
		homePage.clickLoginIcon();
		Assert.assertTrue(homePage.isLoginWindowPresent(), "Login dialog window is not opened");
		homePage.inputLogin(R.TESTDATA.get("email"));
		homePage.inputPassword("1234567");
		homePage.clickLoginBtn();
		Assert.assertTrue(homePage.checkNewUrl(), "Page is not opened");
		LOGGER.info("Page is checked");
		Assert.assertTrue(homePage.isWrongPasswordMessagePresent(), "Error message is not present");

	}
}
