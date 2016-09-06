package com.qaprosoft.carina.core.demo.gui.gsmarena.pages;

import com.qaprosoft.carina.core.demo.gui.gsmarena.components.productspage.ProductsReviewBody;
import com.qaprosoft.carina.core.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class ProductsPage extends AbstractPage {

    @FindBy(id = "review-body")
    private ProductsReviewBody productsReviewBody;

    public ProductsPage(WebDriver driver) {
        super(driver);
    }

    public ProductInfoPage clickProductByName(String productName) {
        productsReviewBody.clickProductItemByName(productName);
        return new ProductInfoPage(driver);
    }
}
