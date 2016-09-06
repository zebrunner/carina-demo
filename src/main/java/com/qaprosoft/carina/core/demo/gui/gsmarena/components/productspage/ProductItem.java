package com.qaprosoft.carina.core.demo.gui.gsmarena.components.productspage;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractUIObject;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class ProductItem extends AbstractUIObject {

    @FindBy(xpath = ".//strong/span")
    private ExtendedWebElement productName;

    @FindBy(xpath = ".//a")
    private ExtendedWebElement productLnk;

    public ProductItem(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public String getProductItemName() {
        return productName.getText();
    }

    public void click() {
        productLnk.click();
    }
}
