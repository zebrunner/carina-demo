package com.solvd.gui.amazon.pages;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductsPage  extends AbstractPage {
    @FindBy(xpath = "//div[@class='a-button-stack']/span/span/span/input")
    private ExtendedWebElement addToCart;
    @FindBy(xpath = "//*[@id='attach-close_sideSheet-link']")
    private ExtendedWebElement xBtn;

    public ProductsPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isPageOpened() {
        return addToCart.isElementPresent();
    }

    public CartPage openCartPage(){
        addToCart.click();
        return new CartPage(getDriver());
    }

    public void clickXBtn(){
        xBtn.click();
    }

}
