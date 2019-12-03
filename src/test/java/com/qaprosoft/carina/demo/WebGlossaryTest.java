package com.qaprosoft.carina.demo;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.qaprosoft.carina.core.foundation.AbstractTest;
import com.qaprosoft.carina.demo.gui.pages.GlossaryPage;
import com.qaprosoft.carina.demo.gui.pages.HomePage;

public class WebGlossaryTest extends AbstractTest {
//Scenario 0
	@Test
	public void testGlossaryItemsAlphabetically() {
		SoftAssert softAssert = new SoftAssert();
		HomePage homePage = new HomePage(getDriver());
		homePage.open();
		Assert.assertTrue(homePage.isOpened(), "Home page is not opened");
		homePage.clickBurgerMenuBtn();
		GlossaryPage glossaryPage = homePage.clickGlossaryBtn();
		Assert.assertTrue(glossaryPage.isOpened(), "Glossary page is not opened");
		String alphabet = "ABCDEFGHIGKLMNOPQRTSUVWX";
		for (int i = 0; i < alphabet.length(); ++i) {
			String symb = String.valueOf(alphabet.charAt(i));
			softAssert.assertTrue(glossaryPage.isGlossarySectionSortedAlphabetically(symb),
					String.format("Glossary items %s is not alphabetically", symb));

			Assert.assertTrue(glossaryPage.isStartLetterSectionEqualsTo(symb), "Capital letter is not compare");
		}
		softAssert.assertAll();
	}

}
