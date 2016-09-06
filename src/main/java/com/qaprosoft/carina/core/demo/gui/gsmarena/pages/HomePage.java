package com.qaprosoft.carina.core.demo.gui.gsmarena.pages;

import com.qaprosoft.carina.core.demo.gui.gsmarena.components.homepage.BrandMenu;
import com.qaprosoft.carina.core.demo.gui.gsmarena.components.homepage.FootMenu;
import com.qaprosoft.carina.core.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class HomePage extends AbstractPage {

    @FindBy(xpath = "//div[contains(@class, 'brandmenu')]")
    private BrandMenu brandMenu;

    @FindBy(id = "footmenu")
    private FootMenu footMenu;

    public HomePage(WebDriver driver) {
        super(driver);
        setPageAbsoluteURL("http://www.gsmarena.com");
    }

    public ProductsPage clickBrandByName(String brandName) {
        brandMenu.clickBrandByName(brandName);
        return new ProductsPage(driver);
    }

    public FootMenu getHomeMenu() {
        return footMenu;
    }
}
