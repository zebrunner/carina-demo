package com.qaprosoft.carina.demo;

import com.qaprosoft.carina.core.foundation.IAbstractTest;
import com.qaprosoft.carina.demo.gui.components.compare.ModelSpecs;
import com.qaprosoft.carina.demo.mobile.gui.web.pages.common.*;
import com.zebrunner.carina.core.registrar.ownership.MethodOwner;
import org.apache.commons.lang3.StringUtils;;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.List;

public class WebMobileSampleTest implements IAbstractTest {
    @Test
    @MethodOwner(owner = "qpsdemo")
    public void testModelSpecs() {
        HomePageBase homePage = initPage(getDriver(), HomePageBase.class);
        homePage.open();
        homePage.assertPageOpened();

        BrandModelsPageBase productsPage = homePage.selectBrand("Samsung");
        productsPage.closeAd();
        ModelInfoPageBase productInfoPage = productsPage.selectModel("Galaxy A14 5g");
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(productInfoPage.readDisplay(), "6.5\"", "Invalid display info!");
        softAssert.assertEquals(productInfoPage.readCamera(), "50", "Invalid camera info!");
        softAssert.assertEquals(productInfoPage.readRam(), "4-8", "Invalid ram info!");
        softAssert.assertEquals(productInfoPage.readBattery(), "5000", "Invalid battery info!");
        softAssert.assertAll();
    }

    @Test()
    @MethodOwner(owner = "qpsdemo")
    public void testCompareModels() {
        HomePageBase homePage = initPage(getDriver(), HomePageBase.class);
        homePage.open();
        homePage.assertPageOpened();

        CompareModelsPageBase compareModelsPage = homePage.openComparePage();

        List<ModelSpecs> specs = compareModelsPage.compareModels("Samsung Galaxy J3 (2016)", "Samsung Galaxy J5");

        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(specs.get(0).readSpec(ModelSpecs.SpecType.ANNOUNCED), "2016, March 31. Released 2016, May 06");
        softAssert.assertEquals(specs.get(0).readSpec(ModelSpecs.SpecType.TECHNOLOGY), "GSM / HSPA / LTE");
        softAssert.assertEquals(specs.get(1).readSpec(ModelSpecs.SpecType.ANNOUNCED), "2015, June 19. Released 2015, July 28");
        softAssert.assertEquals(specs.get(1).readSpec(ModelSpecs.SpecType.TECHNOLOGY), "GSM / HSPA / LTE");
        softAssert.assertAll();
    }

    @Test()
    @MethodOwner(owner = "qpsdemo")
    public void testNewsSearch() {
        HomePageBase homePage = initPage(getDriver(), HomePageBase.class);
        homePage.open();
        homePage.assertPageOpened();

        NewsPageBase newsPage = homePage.openNewsPage();
        newsPage.assertPageOpened();

        final String searchQ = "iphone";
        List<String> news = newsPage.searchNews(searchQ);
        SoftAssert softAssert = new SoftAssert();
        for (int i = 0; i < news.size(); i++) {
            softAssert.assertTrue(StringUtils.containsIgnoreCase(news.get(i), searchQ),
                    "Invalid search results for " + news.get(i));
        }
        softAssert.assertAll();
    }
}
