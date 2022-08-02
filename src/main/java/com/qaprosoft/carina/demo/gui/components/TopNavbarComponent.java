package com.qaprosoft.carina.demo.gui.components;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractUIObject;
import com.qaprosoft.carina.demo.gui.pages.AccountPage;
import com.qaprosoft.carina.demo.gui.pages.RegisterPage;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class TopNavbarComponent extends AbstractUIObject {

    @FindBy(xpath = "//div/a[@class='login-icon']")
    private ExtendedWebElement logInButton;

    @FindBy(xpath = "//a[@href=\"register.php3\"]")
    private ExtendedWebElement signUpButton;

    @FindBy(xpath = "//a[contains(@href, 'account')]")
    private ExtendedWebElement accountButton;

    @FindBy(xpath = "//a[contains(@href, 'logout')]")
    private ExtendedWebElement logoutButton;

    @FindBy(xpath = "//a[contains(@href, 'account')]/span[@class='icon-count']")
    private ExtendedWebElement accountTitle;

    @FindBy(xpath = "//a[contains(@href, 'logout')]/span[@class='icon-count']")
    private ExtendedWebElement logoutTitle;

    @FindBy(xpath = "//span[@id='login-popup2']")
    private LoginComponent loginPopUp;

    public TopNavbarComponent(WebDriver driver) {
        super(driver);
    }

    public TopNavbarComponent(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public LoginComponent getLoginPopup(){
        return loginPopUp;
    }

    public boolean isLoginButtonPresent(){
        return logInButton.isElementPresent();
    }

    public boolean isSignUpButtonPresent(){
        return signUpButton.isElementPresent();
    }

    public boolean isAccountButtonPresent(){
        return accountButton.isElementPresent();
    }

    public boolean isLogoutButtonPresent(){
        return logoutButton.isElementPresent();
    }

    public boolean isLogoutTitlePresent(){
        return logoutTitle.isElementPresent();
    }

    public String readAccountTitle(){
        return accountTitle.getText();
    }

    public String readLogoutTitle(){
        return logoutTitle.getText();
    }

    public TopNavbarComponent hoverAccountButton(){
        accountButton.hover();
        return this;
    }

    public TopNavbarComponent hoverLogoutButton(){
        logoutButton.hover();
        return this;
    }

    public RegisterPage openRegisterPage(){
        signUpButton.click();
        return new RegisterPage(driver);
    }

    public LoginComponent openLoginPopUp(){
        logInButton.click();
        return loginPopUp;
    }

    public AccountPage openAccountPage(){
        accountButton.click();
        return new AccountPage(driver);
    }
}
