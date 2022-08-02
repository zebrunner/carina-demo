package com.qaprosoft.carina.demo.gui.pages;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class AccountPage extends AbstractPage {

    @FindBy(xpath = "//h1[@class='article-info-name']")
    private ExtendedWebElement accountTitle;

    public AccountPage(WebDriver driver) {
        super(driver);
        setPageURL("/account.php3");
    }

    public boolean isAccountTitlePresent(){
        return accountTitle.isElementPresent();
    }

    public String readAccountTitle(){
        return accountTitle.getText();
    }
}
