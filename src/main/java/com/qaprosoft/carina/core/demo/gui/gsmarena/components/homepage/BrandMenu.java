package com.qaprosoft.carina.core.demo.gui.gsmarena.components.homepage;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractUIObject;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class BrandMenu extends AbstractUIObject {

    @FindBy(xpath = ".//a[contains(@class, 'pad-single')]")
    private ExtendedWebElement phoneFinderBtn;

    @FindBy(xpath = ".//li")
    private List<Brand> brandList;

    @FindBy(xpath = ".//a[contains(@class, 'allbrands')]")
    private ExtendedWebElement allBrandsBtn;

    @FindBy(xpath = ".//a[contains(@class, 'rumormill')]")
    private ExtendedWebElement rumorMillBtn;

    public BrandMenu(WebDriver driver, SearchContext context) {
        super(driver, context);
    }

    public void clickBrandByName(String brandName) {
        Brand brand = getBrandByName(brandName);
        brand.click();
    }

    private Brand getBrandByName(String brandName) {
        for(Brand brand: brandList) {
            if(brand.getBrandName().toLowerCase().contains(brandName.toLowerCase())) {
                return brand;
            }
        }
        throw new RuntimeException("Brand with name '" + brandName + "' is not found");
    }
}
