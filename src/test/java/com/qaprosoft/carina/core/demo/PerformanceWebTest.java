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

import java.util.Map;
import java.util.concurrent.CountDownLatch;
import java.util.regex.Pattern;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.qaprosoft.carina.core.foundation.PerformanceTest;
import com.qaprosoft.carina.core.foundation.crypto.CryptoTool;
import com.qaprosoft.carina.core.foundation.performance.PerformanceTestResult.Status;
import com.qaprosoft.carina.core.foundation.utils.SpecialKeywords;
import com.qaprosoft.carina.core.demo.gui.GmailHomePage;
import com.qaprosoft.carina.core.demo.gui.GmailLoginPage;

public class PerformanceWebTest extends PerformanceTest
{
	public PerformanceWebTest(WebDriver driver, CountDownLatch latch, Map<String, String> testParams)
	{
		super(driver, latch, testParams);
	}

	@Override
	public void executeTask(Map<String, String> testParams) throws Exception
	{
		/*start*/performanceTestResult.startSubTest("OpenGmail");
		GmailLoginPage gmailLoginPage = new GmailLoginPage(driver);
		gmailLoginPage.open();
		/*stop*/performanceTestResult.finishSubTest("OpenGmail", Status.PASS, null);
		
		/*start*/performanceTestResult.startSubTest("LoginGmail");
		GmailHomePage gmailHomePage = gmailLoginPage.login(testParams.get("email"), testParams.get("password"));
		String decryptedEmail = (new CryptoTool()).decryptByPattern(testParams.get("email"), Pattern.compile(SpecialKeywords.CRYPT));
		Assert.assertEquals(gmailHomePage.getUser(), decryptedEmail);
		/*stop*/performanceTestResult.finishSubTest("LoginGmail", Status.PASS, null);
	}
}
