/*
 * Copyright 2013-2017 QAPROSOFT (http://qaprosoft.com/).
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
package com.qaprosoft.carina.demo;

import com.qaprosoft.carina.core.foundation.AbstractTest;
import com.qaprosoft.carina.core.foundation.dataprovider.annotations.XlsDataSourceParameters;
import com.qaprosoft.carina.core.foundation.utils.ownership.MethodOwner;
import com.qaprosoft.carina.core.foundation.webdriver.Screenshot;
import com.qaprosoft.carina.demo.gui.components.FooterMenu;
import com.qaprosoft.carina.demo.gui.components.compare.ModelSpecs;
import com.qaprosoft.carina.demo.gui.components.compare.ModelSpecs.SpecType;
import com.qaprosoft.carina.demo.gui.pages.BrandModelsPage;
import com.qaprosoft.carina.demo.gui.pages.CompareModelsPage;
import com.qaprosoft.carina.demo.gui.pages.HomePage;
import com.qaprosoft.carina.demo.gui.pages.ModelInfoPage;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.util.List;

/**
 * This sample shows how create Web test.
 * 
 * @author qpsdemo
 */
public class WebSampleTest extends AbstractTest {
    @Test(dataProvider = "SingleDataProvider", description = "JIRA#AUTO-0008")
    @MethodOwner(owner = "qpsdemo")
    @XlsDataSourceParameters(path = "xls/demo.xlsx", sheet = "GSMArena", dsUid = "TUID", dsArgs = "brand, model, display, camera, ram, battery")
    public void testModelSpecs2Drivers(String brand, String model, String display, String camera, String ram, String battery) {
        // Open GSM Arena home page and verify page is opened
        HomePage homePage = new HomePage(getDriver());
        homePage.open();
        HomePage homePage2 = new HomePage(getDriver("2"));
        homePage2.open();
        Assert.assertTrue(homePage.isPageOpened(), "Home page is not opened");
        Assert.assertTrue(homePage2.isPageOpened(), "Home page is not opened");
        homePage2.selectBrand(brand);
        Screenshot.capture(getDriver("2"), "2nd driver");
        // Select phone brand
        BrandModelsPage productsPage = homePage.selectBrand(brand);
        Screenshot.capture(getDriver(), "1st driver");
        // Select phone model
        ModelInfoPage productInfoPage = productsPage.selectModel(model);
        // Verify phone specifications
        Assert.assertEquals(productInfoPage.readDisplay(), display, "Invalid display info!");
        Assert.assertEquals(productInfoPage.readCamera(), camera, "Invalid camera info!");
        Assert.assertEquals(productInfoPage.readRam(), ram, "Invalid ram info!");
        Assert.assertEquals(productInfoPage.readBattery(), battery, "Invalid battery info!");
    }

    @Test(description = "JIRA#AUTO-0009")
    @MethodOwner(owner = "qpsdemo")
    @Parameters
    public void testCompareModels() {
        // Open GSM Arena home page and verify page is opened
        HomePage homePage = new HomePage(getDriver());
        homePage.open();
        Assert.assertTrue(homePage.isPageOpened(), "Home page is not opened");
        // Open model compare page
        FooterMenu footerMenu = homePage.getFooterMenu();
        Assert.assertTrue(footerMenu.isUIObjectPresent(2), "Footer menu wasn't found!");
        CompareModelsPage comparePage = footerMenu.openComparePage();
        // Compare 3 models
        List<ModelSpecs> specs = comparePage.compareModels("Samsung Galaxy J3", "Samsung Galaxy J5", "Samsung Galaxy J7 Pro");
        // Verify model announced dates
        Assert.assertEquals(specs.get(0).readSpec(SpecType.ANNOUNCED), "2015, November");
        Assert.assertEquals(specs.get(1).readSpec(SpecType.ANNOUNCED), "2016, September");
        Assert.assertEquals(specs.get(2).readSpec(SpecType.ANNOUNCED), "2017, June");
    }
}
