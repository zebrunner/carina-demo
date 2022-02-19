package com.qaprosoft.carina.demo.myweb;

import com.itextpdf.text.log.LoggerFactory;
import com.qaprosoft.carina.core.foundation.IAbstractTest;
import com.qaprosoft.carina.demo.gui.mypages.HomePageDemo;
import com.qaprosoft.carina.demo.gui.mypages.InventoryPageDemo;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;


public class MyWebTest implements IAbstractTest {
    HomePageDemo homePageDemo = new HomePageDemo(getDriver());
    private String correctUsername = "standard_user";
    private String correctPassword = "secret_sauce";
    private String incorrectUsername = "needhelp";
    private String incorrectPasword = "needhelp";

    @Test
    public void testHomeTitle() {
        homePageDemo.open();
        Assert.assertTrue(homePageDemo.isTitlePresent(), "Home page title isn`t present");
    }

    @Test
    public void testSuccessLogin() {
        homePageDemo.open();
        Assert.assertTrue(homePageDemo.isPageOpened(), "Home page is not opened");
        homePageDemo.typeUsername(correctUsername);
        homePageDemo.typePassword(correctPassword);
        InventoryPageDemo inventoryPageDemo = homePageDemo.clickLoginBtn();
        Assert.assertTrue(inventoryPageDemo.isPageOpened(), "Inventory page is not opened");
        Assert.assertTrue(inventoryPageDemo.isMenuButtonPresent(), "Menu button is not present");
    }

    @Test
    public void testFailLogin() {
        final String expectedErrorMessage = "Epic sadface: Username and password do not match any user in this service";
        homePageDemo.open();
        Assert.assertTrue(homePageDemo.isPageOpened(), "Home page is not opened");
        homePageDemo.typeUsername(incorrectUsername);
        homePageDemo.typePassword(incorrectPasword);
        homePageDemo.clickLoginBtn();
        Assert.assertTrue(homePageDemo.isPageOpened(), "Home page is not opened");
        Assert.assertTrue(homePageDemo.isErrorButtonPresent(), "There is no error button");
        Assert.assertTrue(homePageDemo.isErrorIconPresent(), "There is no error icon");
        String actualErrorMessage = homePageDemo.getErrorMessage();
        Assert.assertEquals(actualErrorMessage, expectedErrorMessage, "Incorrect credentials");
    }

    @Test
    public void testElementsOnHomePage() {
        homePageDemo.open();
        SoftAssert softAssert = new SoftAssert();
        Assert.assertTrue(homePageDemo.isPageOpened(), "Home page is not opened");
        softAssert.assertTrue(homePageDemo.isUsernameFieldPresent(), "Username field is null");
        softAssert.assertTrue(homePageDemo.isPasswordFieldPresent(), "Password field is null");
        softAssert.assertTrue(homePageDemo.isLoginButtonPresent(), "Login button is null");
        softAssert.assertAll();
    }

    @Test
    public void testProductItemCard() {
        homePageDemo.open();
        SoftAssert softAssert = new SoftAssert();
        Assert.assertTrue(homePageDemo.isPageOpened(), "Home page is not opened");
        homePageDemo.typeUsername(correctUsername);
        homePageDemo.typePassword(correctPassword);
        InventoryPageDemo inventoryPageDemo = homePageDemo.clickLoginBtn();
        Assert.assertTrue(inventoryPageDemo.isPageOpened(), "Inventory page is not opened");
        softAssert.assertTrue(inventoryPageDemo.isProductImagePresent(), "There is no product image");
        softAssert.assertEquals(inventoryPageDemo.getProductName(), "Sauce Labs Backpack", "Incorrect product name");
        softAssert.assertTrue(inventoryPageDemo.isProductDescriptionPresent(), "There is no product description");
        softAssert.assertEquals(inventoryPageDemo.getProductPrice(), "$29.99", "Incorrect product price");
        softAssert.assertTrue(inventoryPageDemo.isAddToCartPresent(), "There is no Add to cart");
        softAssert.assertAll();
    }

    @Test
    public void testDropDownFilterMenu() {
        String nameAZ = "Name (A to Z)";
        String nameZA = "Name (Z to A)";
        String priceLH = "Price (low to high)";
        String priceHL = "Price (high to low)";
        homePageDemo.open();
        homePageDemo.typeUsername(correctUsername);
        homePageDemo.typePassword(correctPassword);
        InventoryPageDemo inventoryPageDemo = homePageDemo.clickLoginBtn();
        Assert.assertTrue(inventoryPageDemo.isPageOpened(), "Inventory page is not opened");
        Assert.assertTrue(inventoryPageDemo.isOptionDropdownByNamePresent(nameAZ), "There is no Name (A to Z)");
        Assert.assertTrue(inventoryPageDemo.isOptionDropdownByNameZAPresent(nameZA), "There is no Name (Z to A)");
        Assert.assertTrue(inventoryPageDemo.isOptionDropdownByPriceLHPresent(priceLH), "There is no NPrice (low to high)");
        Assert.assertTrue(inventoryPageDemo.isOptionDropdownByPriceHLPresent(priceHL), "There is no Price (high to low)");
    }

    @Test
    public void testDropFilterMenu() {
        final String expectedDefaultDropdownMenu = "NAME (A TO Z)";
        homePageDemo.open();
        homePageDemo.typeUsername(correctUsername);
        homePageDemo.typePassword(correctPassword);
        InventoryPageDemo inventoryPageDemo = homePageDemo.clickLoginBtn();
        Assert.assertTrue(inventoryPageDemo.isPageOpened(), "Inventory page is not opened");
        String actualDefaultDropdownMenu = inventoryPageDemo.getActiveOptionDropdownMenu();
        Assert.assertEquals(actualDefaultDropdownMenu,expectedDefaultDropdownMenu, "Incorrect default filter dropdown menu");
        inventoryPageDemo.clickPriceHL();
        Assert.assertEquals(inventoryPageDemo.getActiveOptionDropdownMenu().toLowerCase(), "Price (high to low)".toLowerCase(),
                "There are different elements of menu");
    }
}