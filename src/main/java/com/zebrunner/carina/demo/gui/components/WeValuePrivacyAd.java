/*******************************************************************************
 * Copyright 2020-2023 Zebrunner Inc (https://www.zebrunner.com).
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
 *******************************************************************************/
package com.zebrunner.carina.demo.gui.components;

import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractUIObject;

public class WeValuePrivacyAd extends AbstractUIObject {

	@FindBy(xpath = "//button[contains(@onclick, 'setAndSaveAllConsent')]")
	private ExtendedWebElement okBtn;

	public WeValuePrivacyAd(WebDriver driver, SearchContext searchContext) {
		super(driver, searchContext);
	}

	public WeValuePrivacyAd(WebDriver driver) {
		super(driver);
	}

	public void closeAdIfPresent() {
		okBtn.clickIfPresent();
	}

}
