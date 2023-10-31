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
package com.zebrunner.carina.demo;

import java.util.List;

import com.zebrunner.carina.demo.gui.components.ModelItem;
import com.zebrunner.carina.demo.gui.components.NewsItem;
import com.zebrunner.carina.demo.gui.components.compare.ModelSpecs;
import com.zebrunner.carina.webdriver.config.WebDriverConfiguration;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.testng.Assert;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.zebrunner.carina.demo.gui.pages.common.AllBrandsPageBase;
import com.zebrunner.carina.demo.gui.pages.common.BrandModelsPageBase;
import com.zebrunner.carina.demo.gui.pages.common.CompareModelsPageBase;
import com.zebrunner.carina.demo.gui.pages.common.HomePageBase;
import com.zebrunner.carina.demo.gui.pages.common.ModelInfoPageBase;
import com.zebrunner.carina.demo.gui.pages.common.NewsPageBase;
import com.zebrunner.carina.core.IAbstractTest;
import com.zebrunner.agent.core.annotation.TestLabel;
import com.zebrunner.carina.core.registrar.ownership.MethodOwner;
import com.zebrunner.carina.core.registrar.tag.Priority;
import com.zebrunner.carina.core.registrar.tag.TestPriority;

/**
 * This sample shows how create Web test.
 *
 * @author qpsdemo
 */
public class WebSampleTest implements IAbstractTest {


    @BeforeSuite
    public void beforeSuite() {
        WebDriverConfiguration.addIgnoredNewSessionErrorMessages("timed out waiting for a node to become available", "TimeoutException");
    }

    @Test(invocationCount = 200, threadPoolSize = 100)
    @MethodOwner(owner = "qpsdemo")
    @TestPriority(Priority.P3)
    @TestLabel(name = "feature", value = { "web", "regression" })
    public void testModelSpecs() {
        // Open GSM Arena home page and verify page is opened
        HomePageBase homePage = initPage(getDriver(), HomePageBase.class);
        homePage.open();
        Assert.assertTrue(homePage.isPageOpened(), "Home page is not opened");

        // Select phone brand
        BrandModelsPageBase productsPage = homePage.selectBrand("Samsung");
        // Select phone model
        ModelInfoPageBase productInfoPage = productsPage.selectModel("Galaxy A04");
        // Verify phone specifications
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(productInfoPage.readDisplay(), "6.5\"", "Invalid display info!");
        softAssert.assertEquals(productInfoPage.readCamera(), "50MP", "Invalid camera info!");
        softAssert.assertEquals(productInfoPage.readRam(), "3-8GB RAM", "Invalid ram info!");
        softAssert.assertEquals(productInfoPage.readBattery(), "5000mAh", "Invalid battery info!");
        softAssert.assertAll();
    }

}
