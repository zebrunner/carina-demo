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
import org.openqa.selenium.WebDriver;
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
}
