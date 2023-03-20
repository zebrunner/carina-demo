package com.qaprosoft.carina.demo.reglog;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends AbstractPage {

    @FindBy(id = "user_email")
    private ExtendedWebElement userEmailInput;

    @FindBy(id = "user_password")
    private ExtendedWebElement userPasswordInput;

    @FindBy(xpath = "//input[@value='Login']")
    private ExtendedWebElement loginButton;

    @FindBy(xpath = "//div[contains(text(),'Invalid email or password.')]")
    private ExtendedWebElement errorMessage;

    public LoginPage(WebDriver driver) {
        super(driver);
        setPageAbsoluteURL("https://unsplash.com/login");
    }

    public ExtendedWebElement getUserEmailInput() {
        return userEmailInput;
    }

    public ExtendedWebElement getUserPasswordInput() {
        return userPasswordInput;
    }

    public ExtendedWebElement getLoginButton() {
        return loginButton;
    }

    public boolean isErrorMessagePresent() {
        return errorMessage.isElementPresent();
    }

    public String getErrorMessageText() {
        return errorMessage.getText();
    }
}
