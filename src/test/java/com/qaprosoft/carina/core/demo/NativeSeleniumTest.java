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

import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class NativeSeleniumTest
{
	private Logger LOG = Logger.getLogger(NativeSeleniumTest.class);
	
	private WebDriver driver;
	
	@BeforeTest
	public void init()
	{
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}
	
	@AfterTest
	public void finilize()
	{
		driver.quit();
	}
	
	@Test
	@Parameters({"email", "password"})
	public void testGoogleLogin(String email, String password) throws Exception
	{
		driver.get("https://mail.google.com/");
		LOG.info("URL 'https://mail.google.com/' is opened");
		((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE).createNewFile();
		
		driver.findElement(By.id("Email")).sendKeys(email);
		LOG.info(email + " keys are sent to emailTextField");
		driver.findElement(By.id("Passwd")).sendKeys(password);
		LOG.info(email + " keys are sent to emailTextField");
		driver.findElement(By.id("signIn")).click();
		LOG.info("signInButton is clicked");
		
		driver.get("https://mail.google.com/mail/u/0/#inbox");
		LOG.info("URL 'https://mail.google.com/mail/u/0/#inbox' is opened");
		((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE).createNewFile();
		
		Assert.assertEquals(driver.findElement(By.id("gbgs4dn")).getText(), email);
	}
}