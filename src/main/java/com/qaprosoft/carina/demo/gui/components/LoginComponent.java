package com.qaprosoft.carina.demo.gui.components;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractUIObject;
import com.qaprosoft.carina.demo.gui.pages.HomePage;
import com.qaprosoft.carina.demo.gui.pages.LoginPage;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class LoginComponent extends AbstractUIObject {

    @FindBy(xpath = "//form[@action='login.php3']/p")
    ExtendedWebElement loginTitle;

    @FindBy(xpath = "//form[@action='login.php3']/input[@type='email']")
    ExtendedWebElement emailTextField;

    @FindBy(xpath = "//form[@action='login.php3']/input[@type='password']")
    ExtendedWebElement passwordTextField;

    @FindBy(xpath = "//form[@action='login.php3']/input[@type='submit']")
    ExtendedWebElement submitButton;

    @FindBy(xpath = "//a[@href='forgot.php3']")
    ExtendedWebElement forgotPasswordLink;

    public LoginComponent(WebDriver driver) {
        super(driver);
    }

    public LoginComponent(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public boolean isLoginTitlePresent(){
        return loginTitle.isElementPresent();
    }

    public boolean isEmailTextFieldPresent(){
        return emailTextField.isElementPresent();
    }

    public boolean isPasswordTestFieldPresent(){
        return passwordTextField.isElementPresent();
    }

    public boolean isSubmitButtonPresent(){
        return submitButton.isElementPresent();
    }

    public boolean isForgotPasswordLinkPresent(){
        return forgotPasswordLink.isElementPresent();
    }

    public LoginComponent typeEmail(String email){
        emailTextField.type(email);
        return this;
    }

    public LoginComponent typePassword(String password){
        passwordTextField.type(password);
        return this;
    }

    public LoginPage clickSubmitButton(){
        submitButton.click();
        return new LoginPage(driver);
    }

    public ExtendedWebElement hoverSubmitButton(){
        submitButton.hover();
        return submitButton;
    }

    public String readColorOfTextOfSubmitButton(){
        return submitButton.getElement().getCssValue("color");
    }

    public String readColorOfSubmitButton(){
        return submitButton.getElement().getCssValue("background-color");
    }

    public String readEmailAttribute(String attribute){
        return emailTextField.getAttribute(attribute);
    }

    public String readPasswordAttribute(String attribute){
        return passwordTextField.getAttribute(attribute);
    }
}
