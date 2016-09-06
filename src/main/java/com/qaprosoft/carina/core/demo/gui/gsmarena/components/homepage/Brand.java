package com.qaprosoft.carina.core.demo.gui.gsmarena.components.homepage;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractUIObject;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class Brand extends AbstractUIObject {

    @FindBy(xpath = "./a")
    private ExtendedWebElement brandName;

    public Brand(WebDriver driver, SearchContext context) {
        super(driver, context);
    }

    public String getBrandName() {
        return brandName.getText();
    }

    public void click() {
        click(brandName);
    }
}
