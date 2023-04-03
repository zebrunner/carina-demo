package com.qaprosoft.carina.demo.ralphlauren.gui.component;

import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractUIObject;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class Region extends AbstractUIObject {

    @FindBy(tagName = "h4")
    private ExtendedWebElement regionName;

    @FindBy(className = "countries-title")
    private ExtendedWebElement title;

    @FindBy(xpath = ".//li[contains(@class,'country tree-item')]")
    private List<Country> countryList;

    public Region(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public String getRegionName() {
        return regionName.getText().trim();
    }

    public List<Country> openCountries(){
        regionName.click();
        return countryList;
    }

    public ExtendedWebElement getCountryTitle() {
        return title;
    }

    public List<Country> getCountryList() {
        return countryList;
    }
}
