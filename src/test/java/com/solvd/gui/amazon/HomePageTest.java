package com.solvd.gui.amazon;

import com.qaprosoft.carina.core.foundation.AbstractTest;
import com.solvd.gui.amazon.components.filters.PriceEnum;
import com.solvd.gui.amazon.pages.*;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HomePageTest extends AbstractTest {
    @Test
    public void amazonTest() {
        HomePage homePage = new HomePage(getDriver());
        homePage.open();
        Assert.assertTrue(homePage.isPageOpened(),"Amazon Home Page is not opened.");

        TodayDealsPage todayDealsPage = homePage.openBooksListPage();
        Assert.assertTrue(todayDealsPage.isPageOpened(),"Today's deals Page is not opened.");

        ProductsPage productsPage = todayDealsPage.openProductPage();
        Assert.assertTrue(productsPage.isPageOpened(),"Products Page is not opened.");
        CartPage cartPage = productsPage.openCartPage();
        homePage.clickCartPage();
        Assert.assertTrue(cartPage.isPageOpened(),"Cart Page is not opened.");
        cartPage.clickDeleteFromCartBtn();
        cartPage.pause(5);

    }

    @Test
    public void amazonLaptopTest() {
        HomePage homePage = new HomePage(getDriver());
        homePage.open();
        Assert.assertTrue(homePage.isPageOpened(),"Amazon Home Page is not opened.");

        SearchedResultPage searchedResultPage = homePage.openSearchedResultPage("Laptop");
        Assert.assertTrue(searchedResultPage.isPageOpened(),"Search Page is not opened.");
        searchedResultPage.choosePriceFilters(PriceEnum.TO600);
        searchedResultPage.getAllProducts();

        ProductsPage productsPage = searchedResultPage.clickProduct();
        Assert.assertTrue(productsPage.isPageOpened(),"Products Page is not opened.");

        CartPage cartPage = productsPage.openCartPage();
        cartPage.pause(5);
        productsPage.clickXBtn();
        homePage.clickCartPage();
        Assert.assertTrue(cartPage.isPageOpened(),"Cart Page is not opened.");

    }
}