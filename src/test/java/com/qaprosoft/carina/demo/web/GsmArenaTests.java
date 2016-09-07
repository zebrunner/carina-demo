package com.qaprosoft.carina.demo.web;

import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.qaprosoft.carina.core.demo.gui.gsmarena.components.compare.ModelSpecs;
import com.qaprosoft.carina.core.demo.gui.gsmarena.pages.BrandModelsPage;
import com.qaprosoft.carina.core.demo.gui.gsmarena.pages.CompareModelsPage;
import com.qaprosoft.carina.core.demo.gui.gsmarena.pages.HomePage;
import com.qaprosoft.carina.core.demo.gui.gsmarena.pages.ModelInfoPage;
import com.qaprosoft.carina.core.foundation.UITest;
import com.qaprosoft.carina.core.foundation.dataprovider.annotations.XlsDataSourceParameters;
import com.qaprosoft.carina.core.foundation.utils.ownership.MethodOwner;

public class GsmArenaTests extends UITest
{
	@Test(dataProvider = "SingleDataProvider", description = "JIRA#AUTO-10001")
	@MethodOwner(owner = "brutskov")
	@XlsDataSourceParameters(path = "xls/demo.xlsx", sheet = "GSMArena", dsUid = "TUID", dsArgs = "brand, model, display, camera, ram, battery")
	public void testModelSpecs(String brand, String model, String display, String camera, String ram, String battery)
	{
		// Open GSM Arena home page and verify page is opened
		HomePage homePage = new HomePage(getDriver());
		homePage.open();
		Assert.assertTrue(homePage.isPageOpened(), "Home page is not opened");
		// Select phone brand
		BrandModelsPage productsPage = homePage.selectBrand(brand);
		// Select phone model
		ModelInfoPage productInfoPage = productsPage.selectModel(model);
		// Verify phone specifications
		Assert.assertEquals(productInfoPage.readDisplay(), display, "Invalid display info!");
		Assert.assertEquals(productInfoPage.readCamera(), camera, "Invalid camera info!");
		Assert.assertEquals(productInfoPage.readRam(), ram, "Invalid ram info!");
		Assert.assertEquals(productInfoPage.readBattery(), battery, "Invalid battery info!");
	}

	@Test(description = "JIRA#AUTO-10002")
	@Parameters
	public void testCompareModels()
	{
		// Open GSM Arena home page and verify page is opened
		HomePage homePage = new HomePage(getDriver());
		homePage.open();
		Assert.assertTrue(homePage.isPageOpened(), "Home page is not opened");
		// Open model compare page
		CompareModelsPage comparePage = homePage.getFooterMenu().openComparePage();
		List<ModelSpecs> specs = comparePage.compareModels("Samsung Galaxy J3", "Samsung Galaxy J5", "Samsung Galaxy J7");
		System.out.println();
	}
}
