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

import java.io.IOException;
import java.util.HashMap;

import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.qaprosoft.carina.core.foundation.UITest;
import com.qaprosoft.carina.core.demo.gui.mobile.MobileScreen;

public class MobileTest extends UITest
{
	@Test
	@Parameters({ "oper1", "oper2", "expSum" })
	public void testSumOperation(String oper1, String oper2, String expSum)
			throws IOException
	{
		MobileScreen mobileScreen = new MobileScreen(driver);
		String sum = mobileScreen.performSum(oper1, oper2);
		Assert.assertEquals(sum, expSum, "Invalid sum!");
	}

	@Test
	@Parameters({ "expAlert" })
	public void testBasicAlert(String expAlert) throws Exception
	{
		MobileScreen mobileScreen = new MobileScreen(driver);
		click(mobileScreen.showAlertButton);
		Alert alert = driver.switchTo().alert();
		Assert.assertEquals(alert.getText(), expAlert);
		alert.accept();
	}
	
	@SuppressWarnings("serial")
	@Test
	public void testGestures() throws Exception
	{
		MobileScreen mobileScreen = new MobileScreen(driver);
		click(mobileScreen.testGestureButton);
		((JavascriptExecutor) driver).executeScript("mobile: rotate", new HashMap<String, Double>() {{ put("x", (double)114); put("y", (double)198); put("radius", (double)3); put("touchCount", (double)2);  put("duration", 5.0);  put("rotation", 220.0); }});
		((JavascriptExecutor) driver).executeScript("mobile: pinchClose", new HashMap<String, Double>() {{ put("startX", (double)150); put("startY", (double)230); put("endX", (double)200); put("endY", (double)260);  put("duration", 2.0); }});
		((JavascriptExecutor) driver).executeScript("mobile: pinchOpen", new HashMap<String, Double>() {{ put("startX", (double)114); put("startY", (double)198); put("endX", (double)257); put("endY", (double)256);  put("duration", 2.0); }});

	}
}
