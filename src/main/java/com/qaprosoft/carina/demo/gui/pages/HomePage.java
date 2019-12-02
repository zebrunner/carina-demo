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
package com.qaprosoft.carina.demo.gui.pages;

import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import com.qaprosoft.carina.demo.gui.components.FooterMenu;
import com.qaprosoft.carina.demo.gui.components.WeValuePrivacyAd;

public class HomePage extends AbstractPage {
	Logger LOGGER = Logger.getLogger(HomePage.class);

	@FindBy(id = "footmenu")
	private FooterMenu footerMenu;

	@FindBy(xpath = "//div[contains(@class, 'brandmenu-v2')]//a")
	private List<ExtendedWebElement> brandLinks;

	public HomePage(WebDriver driver) {
		super(driver);
	}

	public FooterMenu getFooterMenu() {
		return footerMenu;
	}

	public BrandModelsPage selectBrand(String brand) {
		LOGGER.info("selecting '" + brand + "' brand...");
		for (ExtendedWebElement brandLink : brandLinks) {
			String currentBrand = brandLink.getText();
			LOGGER.info("currentBrand: " + currentBrand);
			if (brand.equalsIgnoreCase(currentBrand)) {
				brandLink.click();
				return new BrandModelsPage(driver);
			}
		}
		throw new RuntimeException("Unable to open brand: " + brand);
	}

	public WeValuePrivacyAd getWeValuePrivacyAd() {
		return new WeValuePrivacyAd(driver);
	}

	@FindBy(xpath = "//button[@aria-label='Toggle Navigation']")
	private ExtendedWebElement burgerMenuBtn;

	@FindBy(id = "logo")
	private ExtendedWebElement gsmLogoBtn;

	@FindBy(id = "topsearch-text")
	private ExtendedWebElement searchLabelBtn;

	@FindBy(xpath = "//*[@class='tip-icon']")
	private ExtendedWebElement tipUsIcon;

	@FindBy(xpath = "//*[@class='fb-icon']")
	private ExtendedWebElement fbIcon;

	@FindBy(xpath = "//*[@class='tw-icon']")
	private ExtendedWebElement twitterIcon;

	@FindBy(xpath = "//*[@class='ig-icon']")
	private ExtendedWebElement instIcon;

	@FindBy(xpath = "//*[@class='yt-icon']")
	private ExtendedWebElement youTubeIcon;

	@FindBy(xpath = "//*[@class='rss-icon']")
	private ExtendedWebElement rssIcon;

	@FindBy(xpath = "//*[@class='login-icon']")
	private ExtendedWebElement loginIcon;

	@FindBy(xpath = "//*[contains(@class,'signup-icon')]")
	private ExtendedWebElement signUpIcon;

	@FindBy(id = "login-popup2")
	private ExtendedWebElement loginWind;

	@FindBy(xpath = "//*[@id='login-popup2']/form/p")
	private ExtendedWebElement loginLogo;

	@FindBy(id = "email")
	private ExtendedWebElement emailField;

	@FindBy(id = "upass")
	private ExtendedWebElement passwordField;

	@FindBy(xpath = "//*[@id='nick-submit' and @value='Log in']")
	private ExtendedWebElement loginBtn;

	@FindBy(xpath = "//*[@id='login-popup2']/a")
	private ExtendedWebElement iForgotPasswordLink;

	@FindBy(id = "login-active")
	private ExtendedWebElement userMenuIcon;

	@FindBy(xpath = "//*[@class ='head-icon icon-signout']")
	private ExtendedWebElement logOutBtn;

	@FindBy(xpath = "//*[@class ='normal-text res-error' and .//text()='Login failed.' and .//text()='Reason: Wrong password.']")
	private ExtendedWebElement wrongPasswordMessage;

	@FindBy(xpath = "//*[@class='pad-single pad-finder']")
	private ExtendedWebElement phoneFinderBtn;

	public boolean isBurgerMenuPresent() {
		return burgerMenuBtn.isPresent();
	}

	public boolean isLogoPresent() {
		return gsmLogoBtn.isPresent();
	}

	public boolean isSearchLabelPresent() {
		return searchLabelBtn.isPresent();
	}

	public boolean isTipIconPresent() {
		return tipUsIcon.isPresent();
	}

	public boolean isFbIconPresent() {
		return fbIcon.isPresent();
	}

	public boolean isTwitterIconPresent() {
		return twitterIcon.isPresent();
	}

	public boolean isInstagramIconPresent() {
		return instIcon.isPresent();
	}

	public boolean isYouTubeIconPresent() {
		return youTubeIcon.isPresent();
	}

	public boolean isRssIconPresent() {
		return rssIcon.isPresent();
	}

	public boolean isLoginIconPresent() {
		return loginIcon.isPresent();
	}

	public boolean isSignUpIconPresent() {
		return signUpIcon.isPresent();
	}

	public void clickLoginIcon() {
		loginIcon.click();
	}

	public boolean isLoginWindowPresent() {
		return loginWind.isPresent();
	}

	public boolean isLoginLogoPresent() {
		return loginLogo.isPresent();
	}

	public boolean isEmailFieldPresent() {
		return emailField.isPresent();
	}

	public boolean isPasswordFieldPresent() {
		return passwordField.isPresent();
	}

	public boolean isLoginBtnPresent() {
		return loginBtn.isPresent();
	}

	public boolean isIForgotPasswordLinkPresent() {
		return iForgotPasswordLink.isPresent();
	}

	public void inputLogin(String login) {
		emailField.type(login);
	}

	public void inputPassword(String pass) {
		passwordField.type(pass);
	}

	public void clickLoginBtn() {
		loginBtn.click();
	}

	public boolean isUserMenuPresent() {
		return userMenuIcon.isPresent();
	}

	public void clickLogOutBtn() {
		logOutBtn.click();
	}

	public boolean isOpened() {
		LOGGER.info("Page is opened : " + isPageOpened());
		return isPageOpened() && gsmLogoBtn.isElementPresent();
	}

	public boolean isWrongPasswordMessagePresent() {
		return wrongPasswordMessage.isPresent();
	}

	public boolean checkNewUrl() {
		return getDriver().getCurrentUrl().contains("login.php3");

	}

	public PhoneFinderPage clickPhoneFinderMenu() {
		phoneFinderBtn.click();
		return new PhoneFinderPage(driver);
	}

//Methods for find tooltips	
	public String getTooltipEmailMessage() {
		JavascriptExecutor js = (JavascriptExecutor) driver;

		WebElement field = driver.findElement(By.id("email"));
//		return (Boolean) js.executeScript("return arguments[0].checkValidity();", field);
		return (String) js.executeScript("return arguments[0].validationMessage;", field);

	}
	
	public String getTooltipPasswordMessage() {
		JavascriptExecutor js = (JavascriptExecutor) driver;

		WebElement field = driver.findElement(By.id("upass"));
//		return (Boolean) js.executeScript("return arguments[0].checkValidity();", field);
		return (String) js.executeScript("return arguments[0].validationMessage;", field);

	}

}
