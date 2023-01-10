package com.solvd.gui.amazon.pages;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import com.qaprosoft.carina.demo.gui.components.FooterMenu;
import com.zebrunner.carina.utils.Configuration;
import com.zebrunner.carina.utils.R;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.invoke.MethodHandles;
import java.util.List;

public class HomePage extends AbstractPage {
    private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

    @FindBy(xpath = "//*[@id=\"nav-main\"]/div[1]/div/div/div[3]/span[1]/span/input")
    private ExtendedWebElement changeLanguageBtn;
    @FindBy(xpath = "//div[@id='nav-xshop-container']/div/a[1]")
    private ExtendedWebElement todayDealsBtn;
    @FindBy(xpath = "//input[@aria-label='Search']")
    private ExtendedWebElement searchInput;
    @FindBy(xpath = "//input[@type='submit']")
    private ExtendedWebElement searchButton;
    @FindBy(xpath = "//*[@id='nav-cart']")
    private ExtendedWebElement cart;

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public TodayDealsPage openBooksListPage(){
        changeLanguageBtn.click();
        todayDealsBtn.click();
        return new TodayDealsPage(getDriver());
    }

    public SearchedResultPage openSearchedResultPage(String input){
        searchInput.type(input);
        searchButton.click();
        return  new SearchedResultPage(getDriver());
    }

     public void clickCartPage(){
         cart.click();
     }

}
