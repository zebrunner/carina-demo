package com.qaprosoft.carina.demo.gui.pages;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends AbstractPage {

    @FindBy(xpath = "//div[contains(@class, 'normal-text')]/h3")
    private ExtendedWebElement loginResultTitle;

    public LoginPage(WebDriver driver) {
        super(driver);
        setPageURL("/login.php3");
    }

    public boolean isLoginResultTitlePresent(){
        return loginResultTitle.isElementPresent();
    }

    public String readLoginResultTitle(){
        return loginResultTitle.getText();
    }
}
