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

    @FindBy(xpath = "//a[text()='Join Unsplash']")
    private ExtendedWebElement signUpButton;

    public LoginPage(WebDriver driver) {
        super(driver);
        setPageAbsoluteURL("https://unsplash.com/login");
    }

    public HomePage login(String email, String password){
        userEmailInput.type(email);
        userPasswordInput.type(password);
        loginButton.click();
        return new HomePage(getDriver());
    }

    public RegistrationPage goToRegistrationPage() {
        signUpButton.click();
        return new RegistrationPage(getDriver());
    }


    public boolean isErrorMessagePresent() {
        return errorMessage.isElementPresent();
    }

    public String getErrorMessageText() {
        return errorMessage.getText();
    }
}
