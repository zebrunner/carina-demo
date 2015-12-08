/*
 * Copyright 2013 QAPROSOFT (http://qaprosoft.com/).
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.qaprosoft.carina.core.demo;

import java.util.List;
import java.util.regex.Pattern;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.qaprosoft.carina.core.foundation.UITest;
import com.qaprosoft.carina.core.foundation.crypto.CryptoTool;
import com.qaprosoft.carina.core.foundation.utils.SpecialKeywords;
import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.demo.gui.GmailHomePage;
import com.qaprosoft.carina.core.demo.gui.GmailLoginPage;
import com.qaprosoft.carina.core.demo.gui.GoogleMapsPage;

public class WebUITest extends UITest
{
	@Test
	@Parameters({"email", "password"})
	public void testGmailLoginWithEncryptedData(String email, String password) throws Exception
	{
		GmailLoginPage gmailLoginPage = new GmailLoginPage(driver);
		gmailLoginPage.open();
		GmailHomePage gmailHomePage = gmailLoginPage.login(email, password);
		String decryptedEmail = (new CryptoTool()).decryptByPattern(email, Pattern.compile(SpecialKeywords.CRYPT));
		Assert.assertEquals(gmailHomePage.getUser(), decryptedEmail);
	}
	
	@Test
	@Parameters({"from", "to"})
	public void testGoogleMaps(String from, String to) throws Exception
	{
		GoogleMapsPage googleMapsPage = new GoogleMapsPage(driver);
		googleMapsPage.open();
//		click(googleMapsPage.closeTipButton);
		googleMapsPage.search(to);
		googleMapsPage.click(googleMapsPage.getDirectionsLink);
//		Assert.assertEquals(googleMapsPage.pointBTextField.getAttribute(HTML.VALUE), to);
		List<ExtendedWebElement> routes = googleMapsPage.getDirections(from, to);
		Assert.assertTrue(routes.size() > 0, "No routes found!");
	}
}