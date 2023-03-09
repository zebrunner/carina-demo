package com.qaprosoft.carina.demo.ui.components;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractUIObject;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class SearchItem extends AbstractUIObject{
    @FindBy(xpath="//header//label[@class='md-search__icon md-icon']")
    private ExtendedWebElement searchLogo;
    @FindBy(xpath="//header//input[@class='md-search__input']")
    private ExtendedWebElement searchInput;

    public SearchItem(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public ExtendedWebElement getSearchLogo() {
        return searchLogo;
    }

    public ExtendedWebElement getSearchInput() {
        return searchInput;
    }

}
