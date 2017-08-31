package com.qaprosoft.carina.demo;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.qaprosoft.carina.core.demo.gui.stackoverflow.LoginPage;
import com.qaprosoft.carina.core.foundation.AbstractTest;

public class AISampleTest extends AbstractTest
{
	@Test
	public void testGoogleLoginWithAI()
	{
		LoginPage homePage = new LoginPage(getDriver());
		homePage.open();
		homePage.signInViaGoogle();
		Assert.assertTrue(getDriver().getCurrentUrl().startsWith("https://accounts.google.com/signin"),
				"Google login not opened");
	}
}