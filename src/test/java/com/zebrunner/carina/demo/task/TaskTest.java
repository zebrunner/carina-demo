package com.zebrunner.carina.demo.task;
import com.zebrunner.agent.core.annotation.TestLabel;
import com.zebrunner.carina.core.IAbstractTest;
import com.zebrunner.carina.core.registrar.ownership.MethodOwner;
import com.zebrunner.carina.demo.gui.pages.common.HomePageBase;
import com.zebrunner.carina.demo.gui.pages.common.MerchPage;
import com.zebrunner.carina.demo.gui.pages.common.PaymentInformationComponent;
import com.zebrunner.carina.demo.gui.pages.common.TopMenu;
import com.zebrunner.carina.utils.R;
import jdk.jfr.Description;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;


public class TaskTest implements IAbstractTest {

    private static final String PRODUCT_ID = "CAMERA ISLANDS TEE";
    private static final String PRODUCT_COLOR = "NAVY";
    private static final String PRODUCT_SIZE = "M";
    private static final int ONE_QTY_TO_ADD = 2;


    @Test
    @MethodOwner(owner = "avoz")
    @Description("Login Test:\n" +
            "Open the login page.\n" +
            "Enter valid username and password.\n" +
            "Click on the login button.\n" +
            "Verify that the user is successfully logged in.")
    @TestLabel(name = "feature", value = {"web", "regression"})
    public void testAccountLogin() {
        HomePageBase homePage = initPage(getDriver(), HomePageBase.class);
        homePage.open();
        Assert.assertTrue(homePage.isPageOpened(), "Home page is not opened");
        TopMenu topMenu = new TopMenu(getDriver());
        topMenu.clickLoginIcon();
        topMenu.setEmail(R.TESTDATA.get("email"));
        topMenu.setPass(R.TESTDATA.get("pass"));
        topMenu.clickLoginButton();
        SoftAssert softAssert = new SoftAssert();
        //I can't pick up an element for acert to work
        softAssert.assertEquals(topMenu.getLoginName(), "Alena", "Unsuccessful login!");
        softAssert.assertAll();
    }

    @Test
    @MethodOwner(owner = "avoz")
    @Description("Login to the application.\n" +
            "Enter a search keyword in the search bar.\n" +
            "Click on the search button.\n" +
            "Verify that the search results page is displayed.\n" +
            "Validate that the search results contain the expected items.")
    @TestLabel(name = "feature", value = {"web", "regression"})
    public void testSearchTest() {
        testAccountLogin();
        HomePageBase homePage = initPage(getDriver(), HomePageBase.class);
        homePage.open();
        TopMenu topMenu = new TopMenu(getDriver());
        topMenu.typeTextToSearchBar("Motorola Edge 30 Neo");
        topMenu.clickMerchButton();
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(topMenu.getSearchRowResult(), "Search results for \"Motorola Edge 30 Neo\"", "Unsuccessful search!");
        softAssert.assertEquals(topMenu.getSearchPageResult(), "Specs\nMotorola\nEdge 30 Neo", "Unsuccessful search!");
        softAssert.assertAll();

    }

    @Test
    @MethodOwner(owner = "avoz")
    @Description("Login to the application.\n" +
            "Navigate to a product page.\n" +
            "Click on the “Add to Cart” button.\n" +
            "Verify that the item is added to the cart.\n" +
            "Validate the cart quantity and total price.")
    @TestLabel(name = "feature", value = {"web", "regression"})
    public void testAddToCartTest() {
        HomePageBase homePage = initPage(getDriver(), HomePageBase.class);
        homePage.open();
        Assert.assertTrue(homePage.isPageOpened(), "Home page is not opened");
        //testAccountLogin();
        TopMenu topMenu = new TopMenu(getDriver());
        topMenu.clickMerchButton();
        MerchPage merchPage = new MerchPage(getDriver());
        merchPage.switchWindow();
        merchPage.searchProduct(PRODUCT_ID, PRODUCT_COLOR, PRODUCT_SIZE, ONE_QTY_TO_ADD);
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(merchPage.itemAddToChartVerify(), "ADDED TO CART", "Unsuccessful add to chart!");
        merchPage.clickCheckoutBtn();
        PaymentInformationComponent paymentInformationComponent = new PaymentInformationComponent(getDriver());
        paymentInformationComponent.setShippingData();
        softAssert.assertEquals(merchPage.checkChartQuantity(), "1", "Unsuccessful quantity!");
        softAssert.assertEquals(merchPage.checkTotalPrise(), "USD\n$22", "Unsuccessful prise!");
        softAssert.assertAll();

    }

    @Test
    @MethodOwner(owner = "avoz")
    @Description("Login to the application.\n" +
            "Add items to the cart.\n" +
            "Navigate to the cart page.\n" +
            "Click on the “Checkout” button.\n" +
            "Enter shipping and payment details.\n" +
            "Place the order.\n" +
            "Verify that the order confirmation page is displayed.")
    @TestLabel(name = "feature", value = {"web", "regression"})
    public void testCheckoutTest() {
        HomePageBase homePage = initPage(getDriver(), HomePageBase.class);
        homePage.open();
        Assert.assertTrue(homePage.isPageOpened(), "Home page is not opened");

    }

    @Test
    @MethodOwner(owner = "avoz")
    @Description("Open the login page.\n" +
            "Click on the “Forgot Password” link.\n" +
            "Enter the registered email address.\n" +
            "Click on the “Reset Password” button.\n" +
            "Verify that a password reset confirmation message is displayed.")
    @TestLabel(name = "feature", value = {"web", "regression"})
    public void testForgotPassword() {
        HomePageBase homePage = initPage(getDriver(), HomePageBase.class);
        homePage.open();
        Assert.assertTrue(homePage.isPageOpened(), "Home page is not opened");

    }

    @Test
    @MethodOwner(owner = "avoz")
    @Description("Login to the application.\n" +
            "Navigate to a product listing page.\n" +
            "Select a sorting option from the dropdown.\n" +
            "Verify that the products are sorted correctly according to the selected option.")
    @TestLabel(name = "feature", value = {"web", "regression"})
    public void testSortProducts() {
        HomePageBase homePage = initPage(getDriver(), HomePageBase.class);
        homePage.open();
        Assert.assertTrue(homePage.isPageOpened(), "Home page is not opened");

    }

    @Test
    @MethodOwner(owner = "avoz")
    @Description("Login to the application.\n" +
            "Navigate to a product page.\n" +
            "Click on the “Add to Wishlist” button.\n" +
            "Verify that the item is added to the wishlist.\n" +
            "Validate the wishlist count and the added item.")
    @TestLabel(name = "feature", value = {"web", "regression"})
    public void testAddToWishlist() {
        HomePageBase homePage = initPage(getDriver(), HomePageBase.class);
        homePage.open();
        Assert.assertTrue(homePage.isPageOpened(), "Home page is not opened");

    }

}
