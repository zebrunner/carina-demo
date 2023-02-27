package com.qaprosoft.carina.demo.gui.pages;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.foundation.webdriver.decorator.PageOpeningStrategy;
import com.qaprosoft.carina.core.gui.AbstractPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class AllBrandsPage extends AbstractPage {
    @FindBy(xpath = "//h1[@class='article-info-name']")
    private ExtendedWebElement pageTitle;

    public AllBrandsPage(WebDriver driver) {
        super(driver);
        setPageOpeningStrategy(PageOpeningStrategy.BY_ELEMENT);
        setUiLoadedMarker(pageTitle);
    }

    public BrandModelsPage selectBrand(String brandName){
        brandName = brandName.toUpperCase();
        for (ExtendedWebElement brand: findExtendedWebElements(By.xpath("//div[@class='st-text']//td/a"))){
            if (brand.getText().contains(brandName)){
                brand.click();
                return new BrandModelsPage(driver);
            }
        }
        throw new RuntimeException("Unable to open brand page: " + brandName);
    }
}
