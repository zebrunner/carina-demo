package com.qaprosoft.carina.demo.gui.mypages;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class InventoryPageDemo extends AbstractPage {

    @FindBy(className = "bm-burger-button")
    private ExtendedWebElement menuButton;

    @FindBy(id = "item_4_img_link")
    private ExtendedWebElement productImage;

    @FindBy(className = "inventory_item_name")
    private ExtendedWebElement productName;

    @FindBy(className = "inventory_item_desc")
    private ExtendedWebElement productDescription;

    @FindBy(className = "inventory_item_price")
    private ExtendedWebElement productPrice;

    @FindBy(id = "add-to-cart-test.allthethings()-t-shirt-(red)")
    private ExtendedWebElement addToCart;

    @FindBy(className = "product_sort_container")
    private ExtendedWebElement sortItem;

    @FindBy(xpath = "//*[@id=\"header_container\"]/div[2]/div[2]/span/select/option[1]")
    private ExtendedWebElement optionDropdownByName;

    @FindBy(xpath = "//*[@id=\"header_container\"]/div[2]/div[2]/span/select/option[2]")
    private ExtendedWebElement optionDropdownByNameZA;

    @FindBy(xpath = "//*[@id=\"header_container\"]/div[2]/div[2]/span/select/option[3]")
    private ExtendedWebElement optionDropdownByPriceLH;

    @FindBy(xpath = "//*[@id=\"header_container\"]/div[2]/div[2]/span/select/option[4]")
    private ExtendedWebElement optionDropdownByPriceHL;

    @FindBy(xpath = "//*[@id=\"header_container\"]/div[2]/div[2]/span/span")
    private ExtendedWebElement activeOptionDropdownMenu;

    public InventoryPageDemo(WebDriver driver) {
        super(driver);
        setPageURL("/inventory.html");
    }

    public boolean isOptionDropdownByNamePresent(String optionMenu) {
        return optionDropdownByName.format(optionMenu).isElementPresent();
    }

    public boolean isOptionDropdownByNameZAPresent(String optionMenu) {
        return optionDropdownByNameZA.format(optionMenu).isElementPresent();
    }

    public boolean isOptionDropdownByPriceLHPresent(String optionMenu) {
        return optionDropdownByPriceLH.format(optionMenu).isElementPresent();
    }

    public boolean isOptionDropdownByPriceHLPresent(String optionMenu) {
        return optionDropdownByPriceHL.format(optionMenu).isElementPresent();
    }

    public void clickPriceHL() {
        optionDropdownByPriceHL.click();
    }

    public boolean isMenuButtonPresent() {
        return menuButton.isElementPresent();
    }

    public boolean isProductImagePresent() {
        return productImage.isElementPresent();
    }

    public String getProductName() {
        return productName.getText();
    }

    public boolean isProductDescriptionPresent() {
        return productDescription.isElementPresent();
    }

    public String getProductPrice() {
        return productPrice.getText();
    }

    public boolean isAddToCartPresent() {
        return addToCart.isElementPresent();
    }

    public boolean isSortItemPresent() {
        return sortItem.isElementPresent();
    }

    public String getActiveOptionDropdownMenu() {
        return activeOptionDropdownMenu.getText();
    }
}