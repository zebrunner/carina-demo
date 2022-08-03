package com.qaprosoft.carina.demo.gui.components;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractUIObject;
import com.qaprosoft.carina.demo.gui.pages.LoginPage;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class LoginForm extends AbstractUIObject {
    @FindBy(xpath = "//span[@class='tooltip']//..//p[contains(text(),'Login')]")
    private ExtendedWebElement loginText;

    @FindBy(xpath = "//span[@class='tooltip']//..//input[@id='email']")
    private ExtendedWebElement emailInput;

    @FindBy(xpath = "//span[@class='tooltip']//..//input[@id='upass']")
    private ExtendedWebElement passwordInput;

    @FindBy(xpath = "//span[@class='tooltip']//..//input[@class='button']")
    private ExtendedWebElement loginButton;


    public LoginForm(WebDriver driver) {
        super(driver);
    }

    public boolean isLoginTextPresent() {
        return loginText.isPresent();
    }

    public boolean isEmailInputPresent() {
        return emailInput.isPresent();
    }

    public boolean isPasswordInputPresent() {
        return passwordInput.isPresent();
    }

    public boolean isLoginButtonPresent() {
        return loginButton.isPresent();
    }

    public void loginMethod(String email,String password){
        emailInput.click();
        emailInput.type(email);
        emailInput.format(email).click();

        passwordInput.click();
        passwordInput.type(password);
        passwordInput.format(password).click();
    }

    public void loginButtonClick() {
        loginButton.click();
    }

    public LoginPage clickLoginButton(){
        loginButton.click();
        return new LoginPage(driver);
    }

}
