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

import com.zebrunner.agent.core.annotation.TestLabel;
import com.zebrunner.carina.core.IAbstractTest;
import com.zebrunner.carina.core.registrar.ownership.MethodOwner;
import com.zebrunner.carina.core.registrar.tag.Priority;
import com.zebrunner.carina.core.registrar.tag.TestPriority;
import com.zebrunner.carina.demo.gui.components.ModelItem;
import com.zebrunner.carina.demo.gui.components.NewsItem;
import com.zebrunner.carina.demo.gui.components.compare.ModelSpecs;
import com.zebrunner.carina.demo.gui.pages.common.AllBrandsPageBase;
import com.zebrunner.carina.demo.gui.pages.common.BrandModelsPageBase;
import com.zebrunner.carina.demo.gui.pages.common.CompareModelsPageBase;
import com.zebrunner.carina.demo.gui.pages.common.HomePageBase;
import com.zebrunner.carina.demo.gui.pages.common.NewsPageBase;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.List;

/**
 * This sample shows how create Web test.
 *
 * @author qpsdemo
 */
public class WebSampleTest implements IAbstractTest {

    @Test
    @MethodOwner(owner = "qpsdemo")
    @TestPriority(Priority.P3)
    @TestLabel(name = "feature", value = { "web", "regression" })
    public void testModelSpecs() {
        // Open GSM Arena home page and verify page is opened
        HomePageBase homePage = initPage(getDriver(), HomePageBase.class);
        homePage.open();
        Assert.assertTrue(homePage.isPageOpened(), "Home page is not opened");
    }

    @Test
    @MethodOwner(owner = "qpsdemo")
    @TestPriority(Priority.P3)
    @TestLabel(name = "feature", value = { "web", "regression" })
    public void testModelSpecs01() {
        // Open GSM Arena home page and verify page is opened
        HomePageBase homePage = initPage(getDriver(), HomePageBase.class);
        homePage.open();
        Assert.assertTrue(homePage.isPageOpened(), "Home page is not opened");
    }

    @Test
    @MethodOwner(owner = "qpsdemo")
    @TestPriority(Priority.P3)
    @TestLabel(name = "feature", value = { "web", "regression" })
    public void testModelSpecs02() {
        // Open GSM Arena home page and verify page is opened
        HomePageBase homePage = initPage(getDriver(), HomePageBase.class);
        homePage.open();
        Assert.assertTrue(homePage.isPageOpened(), "Home page is not opened");
    }

    @Test
    @MethodOwner(owner = "qpsdemo")
    @TestPriority(Priority.P3)
    @TestLabel(name = "feature", value = { "web", "regression" })
    public void testModelSpecs03() {
        // Open GSM Arena home page and verify page is opened
        HomePageBase homePage = initPage(getDriver(), HomePageBase.class);
        homePage.open();
        Assert.assertTrue(homePage.isPageOpened(), "Home page is not opened");
    }

    @Test
    @MethodOwner(owner = "qpsdemo")
    @TestPriority(Priority.P3)
    @TestLabel(name = "feature", value = { "web", "regression" })
    public void testModelSpecs04() {
        // Open GSM Arena home page and verify page is opened
        HomePageBase homePage = initPage(getDriver(), HomePageBase.class);
        homePage.open();
        Assert.assertTrue(homePage.isPageOpened(), "Home page is not opened");
    }

    @Test
    @MethodOwner(owner = "qpsdemo")
    @TestPriority(Priority.P3)
    @TestLabel(name = "feature", value = { "web", "regression" })
    public void testModelSpecs05() {
        // Open GSM Arena home page and verify page is opened
        HomePageBase homePage = initPage(getDriver(), HomePageBase.class);
        homePage.open();
        Assert.assertTrue(homePage.isPageOpened(), "Home page is not opened");
    }

    @Test
    @MethodOwner(owner = "qpsdemo")
    @TestPriority(Priority.P3)
    @TestLabel(name = "feature", value = { "web", "regression" })
    public void testModelSpecs06() {
        // Open GSM Arena home page and verify page is opened
        HomePageBase homePage = initPage(getDriver(), HomePageBase.class);
        homePage.open();
        Assert.assertTrue(homePage.isPageOpened(), "Home page is not opened");
    }

    @Test
    @MethodOwner(owner = "qpsdemo")
    @TestPriority(Priority.P3)
    @TestLabel(name = "feature", value = { "web", "regression" })
    public void testModelSpecs07() {
        // Open GSM Arena home page and verify page is opened
        HomePageBase homePage = initPage(getDriver(), HomePageBase.class);
        homePage.open();
        Assert.assertTrue(homePage.isPageOpened(), "Home page is not opened");
    }

    @Test
    @MethodOwner(owner = "qpsdemo")
    @TestPriority(Priority.P3)
    @TestLabel(name = "feature", value = { "web", "regression" })
    public void testModelSpecs08() {
        // Open GSM Arena home page and verify page is opened
        HomePageBase homePage = initPage(getDriver(), HomePageBase.class);
        homePage.open();
        Assert.assertTrue(homePage.isPageOpened(), "Home page is not opened");
    }

    @Test
    @MethodOwner(owner = "qpsdemo")
    @TestPriority(Priority.P3)
    @TestLabel(name = "feature", value = { "web", "regression" })
    public void testModelSpecs09() {
        // Open GSM Arena home page and verify page is opened
        HomePageBase homePage = initPage(getDriver(), HomePageBase.class);
        homePage.open();
        Assert.assertTrue(homePage.isPageOpened(), "Home page is not opened");
    }

    @Test
    @MethodOwner(owner = "qpsdemo")
    @TestPriority(Priority.P3)
    @TestLabel(name = "feature", value = { "web", "regression" })
    public void testModelSpecs010() {
        // Open GSM Arena home page and verify page is opened
        HomePageBase homePage = initPage(getDriver(), HomePageBase.class);
        homePage.open();
        Assert.assertTrue(homePage.isPageOpened(), "Home page is not opened");
    }

    @Test
    @MethodOwner(owner = "qpsdemo")
    @TestPriority(Priority.P3)
    @TestLabel(name = "feature", value = { "web", "regression" })
    public void testModelSpecs011() {
        // Open GSM Arena home page and verify page is opened
        HomePageBase homePage = initPage(getDriver(), HomePageBase.class);
        homePage.open();
        Assert.assertTrue(homePage.isPageOpened(), "Home page is not opened");
    }

    @Test
    @MethodOwner(owner = "qpsdemo")
    @TestPriority(Priority.P3)
    @TestLabel(name = "feature", value = { "web", "regression" })
    public void testModelSpecs1() {
        // Open GSM Arena home page and verify page is opened
        HomePageBase homePage = initPage(getDriver(), HomePageBase.class);
        homePage.open();
        Assert.assertTrue(homePage.isPageOpened(), "Home page is not opened");
    }

    @Test
    @MethodOwner(owner = "qpsdemo")
    @TestPriority(Priority.P3)
    @TestLabel(name = "feature", value = { "web", "regression" })
    public void testModelSpecs2() {
        // Open GSM Arena home page and verify page is opened
        HomePageBase homePage = initPage(getDriver(), HomePageBase.class);
        homePage.open();
        Assert.assertTrue(homePage.isPageOpened(), "Home page is not opened");
    }

    @Test
    @MethodOwner(owner = "qpsdemo")
    @TestPriority(Priority.P3)
    @TestLabel(name = "feature", value = { "web", "regression" })
    public void testModelSpecs3() {
        // Open GSM Arena home page and verify page is opened
        HomePageBase homePage = initPage(getDriver(), HomePageBase.class);
        homePage.open();
        Assert.assertTrue(homePage.isPageOpened(), "Home page is not opened");
    }

    @Test
    @MethodOwner(owner = "qpsdemo")
    @TestPriority(Priority.P3)
    @TestLabel(name = "feature", value = { "web", "regression" })
    public void testModelSpecs4() {
        // Open GSM Arena home page and verify page is opened
        HomePageBase homePage = initPage(getDriver(), HomePageBase.class);
        homePage.open();
        Assert.assertTrue(homePage.isPageOpened(), "Home page is not opened");
    }

    @Test
    @MethodOwner(owner = "qpsdemo")
    @TestPriority(Priority.P3)
    @TestLabel(name = "feature", value = { "web", "regression" })
    public void testModelSpecs5() {
        // Open GSM Arena home page and verify page is opened
        HomePageBase homePage = initPage(getDriver(), HomePageBase.class);
        homePage.open();
        Assert.assertTrue(homePage.isPageOpened(), "Home page is not opened");
    }

    @Test
    @MethodOwner(owner = "qpsdemo")
    @TestPriority(Priority.P3)
    @TestLabel(name = "feature", value = { "web", "regression" })
    public void testModelSpecs6() {
        // Open GSM Arena home page and verify page is opened
        HomePageBase homePage = initPage(getDriver(), HomePageBase.class);
        homePage.open();
        Assert.assertTrue(homePage.isPageOpened(), "Home page is not opened");
    }

    @Test
    @MethodOwner(owner = "qpsdemo")
    @TestPriority(Priority.P3)
    @TestLabel(name = "feature", value = { "web", "regression" })
    public void testModelSpecs7() {
        // Open GSM Arena home page and verify page is opened
        HomePageBase homePage = initPage(getDriver(), HomePageBase.class);
        homePage.open();
        Assert.assertTrue(homePage.isPageOpened(), "Home page is not opened");
    }

    @Test
    @MethodOwner(owner = "qpsdemo")
    @TestPriority(Priority.P3)
    @TestLabel(name = "feature", value = { "web", "regression" })
    public void testModelSpecs8() {
        // Open GSM Arena home page and verify page is opened
        HomePageBase homePage = initPage(getDriver(), HomePageBase.class);
        homePage.open();
        Assert.assertTrue(homePage.isPageOpened(), "Home page is not opened");
    }

    @Test
    @MethodOwner(owner = "qpsdemo")
    @TestPriority(Priority.P3)
    @TestLabel(name = "feature", value = { "web", "regression" })
    public void testModelSpecs9() {
        // Open GSM Arena home page and verify page is opened
        HomePageBase homePage = initPage(getDriver(), HomePageBase.class);
        homePage.open();
        Assert.assertTrue(homePage.isPageOpened(), "Home page is not opened");
    }

    @Test
    @MethodOwner(owner = "qpsdemo")
    @TestPriority(Priority.P3)
    @TestLabel(name = "feature", value = { "web", "regression" })
    public void testModelSpecs10() {
        // Open GSM Arena home page and verify page is opened
        HomePageBase homePage = initPage(getDriver(), HomePageBase.class);
        homePage.open();
        Assert.assertTrue(homePage.isPageOpened(), "Home page is not opened");
    }

    @Test
    @MethodOwner(owner = "qpsdemo")
    @TestPriority(Priority.P3)
    @TestLabel(name = "feature", value = { "web", "regression" })
    public void testModelSpecs11() {
        // Open GSM Arena home page and verify page is opened
        HomePageBase homePage = initPage(getDriver(), HomePageBase.class);
        homePage.open();
        Assert.assertTrue(homePage.isPageOpened(), "Home page is not opened");
    }

    @Test
    @MethodOwner(owner = "qpsdemo")
    @TestPriority(Priority.P3)
    @TestLabel(name = "feature", value = { "web", "regression" })
    public void testModelSpecs12() {
        // Open GSM Arena home page and verify page is opened
        HomePageBase homePage = initPage(getDriver(), HomePageBase.class);
        homePage.open();
        Assert.assertTrue(homePage.isPageOpened(), "Home page is not opened");
    }

    @Test
    @MethodOwner(owner = "qpsdemo")
    @TestPriority(Priority.P1)
    @TestLabel(name = "feature", value = { "web", "acceptance" })
    public void testCompareModels() {
        // Open GSM Arena home page and verify page is opened
        HomePageBase homePage = initPage(getDriver(), HomePageBase.class);
        homePage.open();
        Assert.assertTrue(homePage.isPageOpened(), "Home page is not opened");
        // Open model compare page
        CompareModelsPageBase comparePage = homePage.openComparePage();
        // Compare 2 (for mobile testing) or 3 (for desktop testing) models
        List<ModelSpecs> specs = comparePage.compareModels("Samsung Galaxy J3", "Samsung Galaxy S23 Ultra", "Samsung Galaxy J7 Pro");
        // Verify model announced dates
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(specs.get(0).readSpec(ModelSpecs.SpecType.ANNOUNCED), "2016, March 31. Released 2016, May 06");
        softAssert.assertEquals(specs.get(0).readSpec(ModelSpecs.SpecType.TECHNOLOGY), "GSM / HSPA / LTE");
        softAssert.assertEquals(specs.get(1).readSpec(ModelSpecs.SpecType.ANNOUNCED), "2023, February 29");
        softAssert.assertEquals(specs.get(1).readSpec(ModelSpecs.SpecType.TECHNOLOGY), "GSM / CDMA / HSPA / EVDO / LTE / 5G");
        // for desktop could be compared 3 devices, when for mobile only 2
        if (specs.size() > 2) {
            softAssert.assertEquals(specs.get(2).readSpec(ModelSpecs.SpecType.ANNOUNCED), "2017, June");
            softAssert.assertEquals(specs.get(2).readSpec(ModelSpecs.SpecType.TECHNOLOGY), "GSM / HSPA / LTE");
        }

        softAssert.assertAll();
    }

    @Test
    @MethodOwner(owner = "qpsdemo")
    @TestLabel(name = "feature", value = { "web", "acceptance" })
    public void testNewsSearch() {
        HomePageBase homePage = initPage(getDriver(), HomePageBase.class);
        homePage.open();
        Assert.assertTrue(homePage.isPageOpened(), "Home page is not opened!");

        NewsPageBase newsPage = homePage.getFooterMenu().openNewsPage();
        Assert.assertTrue(newsPage.isPageOpened(), "News page is not opened!");

        final String searchQ = "iphone";
        List<NewsItem> news = newsPage.searchNews(searchQ);
        Assert.assertFalse(CollectionUtils.isEmpty(news), "News not found!");
        SoftAssert softAssert = new SoftAssert();
        for (NewsItem n : news) {
            System.out.println(n.readTitle());
            softAssert.assertTrue(StringUtils.containsIgnoreCase(n.readTitle(), searchQ),
                    "Invalid search results for " + n.readTitle());
        }
        softAssert.assertAll();
    }

    @Test()
    @MethodOwner(owner = "qpsdemo")
    @TestPriority(Priority.P3)
    @TestLabel(name = "feature", value = { "web", "regression" })
    public void testBrandGroup() {
        HomePageBase homePage = initPage(getDriver(), HomePageBase.class);
        homePage.open();
        Assert.assertTrue(homePage.isPageOpened(), "Home page is not opened!");

        AllBrandsPageBase allBrandsPage = homePage.openAllBrandsPage();
        Assert.assertTrue(allBrandsPage.isPageOpened(), "All mobile phone brands page is not opened!");

        final String brandName = "Lava";
        BrandModelsPageBase brandModelsPage = allBrandsPage.selectBrand(brandName);
        List<ModelItem> models = brandModelsPage.getModels();
        SoftAssert softAssert = new SoftAssert();
        for (ModelItem modelItem : models) {
            softAssert.assertFalse(modelItem.readModel().contains(brandName),
                    "Model " + modelItem.readModel() + " should not include brand " + brandName + " in title");
        }

        softAssert.assertAll();
    }

}
