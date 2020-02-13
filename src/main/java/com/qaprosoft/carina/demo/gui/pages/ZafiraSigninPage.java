package com.qaprosoft.carina.demo.gui.pages;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class ZafiraSigninPage extends AbstractPage {

    public ZafiraSigninPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "username")
    private ExtendedWebElement usernamePlaceholder;

    @FindBy(id = "password")
    private ExtendedWebElement passwordPlaceholder;

    @FindBy(xpath = "//button[contains(@class,'md-button') and text()='Login']")
    private ExtendedWebElement loginBtn;

    public void inputUsername(String username) {
        usernamePlaceholder.type(username);
    }

    public void inputPassword(String password) {
        passwordPlaceholder.type(password);
    }

    public ZafiraDashboardsPage clickLoginBtn() {
        loginBtn.click();
        return new ZafiraDashboardsPage(driver);
    }

    public boolean isOpened() {
        return isPageOpened() && loginBtn.isElementPresent();
    }

}
