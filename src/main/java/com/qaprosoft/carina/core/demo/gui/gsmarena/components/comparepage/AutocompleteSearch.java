package com.qaprosoft.carina.core.demo.gui.gsmarena.components.comparepage;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractUIObject;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class AutocompleteSearch extends AbstractUIObject {

    @FindBy(xpath = ".//a/span")
    private List<ExtendedWebElement> productList;

    public AutocompleteSearch(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public ExtendedWebElement getElement(Integer index) {
        return productList.get(index - 1);
    }
}
