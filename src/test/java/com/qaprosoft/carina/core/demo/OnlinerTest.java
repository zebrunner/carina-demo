/*
 * Copyright 2016 QAPROSOFT (http://qaprosoft.com/).
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


import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.qaprosoft.carina.core.demo.gui.onliner.HomePage;
import com.qaprosoft.carina.core.demo.gui.onliner.LoginPage;
import com.qaprosoft.carina.core.foundation.UITest;

public class OnlinerTest extends UITest
{
	@Test
	@Parameters({"email", "password", "username"})
	public void testOnlinerLogin(String email, String password, String username)
	{
		HomePage homePage = new HomePage(getDriver());
		homePage.open();
		
		LoginPage loginPage = homePage.openLoginPage();
		homePage = loginPage.login(email, password);
		
		Assert.assertTrue(homePage.isUserLoggedIn(username));
	}
}