package com.qaprosoft.carina.demo.gui.components;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.invoke.MethodHandles;

public class LoginService extends AbstractPage {

    private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

    @FindBy(xpath = "//*[@class='head-icon icon-login']")
    private ExtendedWebElement loginButton;

    @FindBy(xpath = "//*[@id='email']")
    private ExtendedWebElement emailField;

    @FindBy(xpath = "//*[@id='upass']")
    private ExtendedWebElement passField;

    @FindBy(xpath = "//*[@class='button']")
    private ExtendedWebElement loginFormButton;

    @FindBy(xpath = "//*[@class='head-icon icon-user-plus']")
    private ExtendedWebElement signUpButton;

    @FindBy(xpath = "//*[@class='head-icon icon-signout']")
    private ExtendedWebElement logoutButton;

    public LoginService(WebDriver driver) {
        super(driver);
    }

    public void login(String email, String pass) {
            loginButton.click();
            emailField.click();
            emailField.type(email);
            passField.click();
            passField.type(pass);
            loginFormButton.click();
    }
    public void logout(){
        logoutButton.click();
    }

    public boolean isLoginButtonPresented() {
        return loginButton.isPresent();
    }

    public boolean isSignUpButtonPresented() {
        return signUpButton.isPresent();
    }

    public boolean isLogoutButtonPresented() {
        return logoutButton.isPresent();
    }

}
