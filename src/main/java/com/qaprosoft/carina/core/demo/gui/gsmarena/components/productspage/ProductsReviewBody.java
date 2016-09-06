package com.qaprosoft.carina.core.demo.gui.gsmarena.components.productspage;

import com.qaprosoft.carina.core.gui.AbstractUIObject;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class ProductsReviewBody extends AbstractUIObject {

    @FindBy(xpath = ".//li")
    private List<ProductItem> productItemList;

    public ProductsReviewBody(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public void clickProductItemByName(String productItemName) {
        ProductItem productItem = getProductItemByName(productItemName);
        productItem.click();
    }

    private ProductItem getProductItemByName(String productItemName) {
        for(ProductItem productItem: productItemList) {
            if(productItem.getProductItemName().toLowerCase().equals(productItemName.toLowerCase())) {
                return productItem;
            }
        }
        throw new RuntimeException("Product with name '" + productItemName + "' is not found");
    }
}
