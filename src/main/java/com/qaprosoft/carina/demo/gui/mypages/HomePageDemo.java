package com.qaprosoft.carina.demo.gui.mypages;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;


public class HomePageDemo extends AbstractPage {

    @FindBy(className = "login_logo")
    private ExtendedWebElement title;

    @FindBy(id = "user-name")
    private ExtendedWebElement usernameField;

    @FindBy(id = "password")
    private ExtendedWebElement passwordField;

    @FindBy(id = "login-button")
    private ExtendedWebElement loginButton;

    @FindBy(xpath = "//*[@id='login_button_container']/div/form/div[3]/h3")
    private ExtendedWebElement errorMessage;

    @FindBy(className = "error-button")
    private ExtendedWebElement errorButton;

    @FindBy(className = "error_icon")
    private ExtendedWebElement errorIcon;

    public HomePageDemo(WebDriver driver) {
        super(driver);
    }

    public boolean isTitlePresent() {
        return title.isElementPresent(5);
    }

    public boolean isUsernameFieldPresent() {
        return usernameField.isElementPresent();
    }

    public boolean isPasswordFieldPresent() {
        return passwordField.isElementPresent();
    }

    public boolean isLoginButtonPresent() {
        return loginButton.isElementPresent();
    }

    public boolean isErrorButtonPresent() {
        return errorButton.isElementPresent();
    }

    public boolean isErrorIconPresent() {
        return errorIcon.isElementPresent();
    }

    public String getUsername() {
        return usernameField.getText();
    }

    public void typeUsername(String username) {
        usernameField.type(username);
    }

    public String getPassword() {
        return passwordField.getText();
    }

    public void typePassword(String password) {
        passwordField.type(password);
    }

    public String getLoginButton() {
        return loginButton.getText();
    }

    public InventoryPageDemo clickLoginBtn() {
        loginButton.click();
        return new InventoryPageDemo(getDriver());
    }

    public String getErrorMessage() {
        return errorMessage.getText();
    }
}