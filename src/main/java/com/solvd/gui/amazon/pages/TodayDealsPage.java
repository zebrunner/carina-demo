package com.solvd.gui.amazon.pages;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class TodayDealsPage extends AbstractPage {
    @FindBy(xpath = "//*[@id=\"nav-subnav\"]/a[1]/span")
    private ExtendedWebElement todayDeals;

    @FindBy(xpath = "//*[@id=\"grid-main-container\"]/div[2]/span[3]/ul/li[7]/label/input")
    private ExtendedWebElement booksButton;

    @FindBy(xpath = "//div[@class='Grid-module__gridDisplayGrid_2X7cDTY7pjoTwwvSRQbt9Y']/div[3]/div/div/a")
    private ExtendedWebElement book;

    public TodayDealsPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isPageOpened() {
        return todayDeals.isElementPresent();
    }

    public ProductsPage openProductPage(){
        booksButton.click();
        book.click();
        return new ProductsPage(getDriver());
    }

}
