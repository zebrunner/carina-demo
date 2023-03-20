package com.qaprosoft.carina.demo.reglog;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class HomePage extends AbstractPage {

    @FindBy(xpath = "//a[text()='Log in']")
    private ExtendedWebElement logInButton;

    @FindBy(xpath = "//a[text()='Sign up']")
    private ExtendedWebElement signUpButton;

    @FindBy(xpath = "//img[@class='D1hjc ihzXr']")
    private ExtendedWebElement personalMenuButton;

    public HomePage(WebDriver driver) {
        super(driver);
        setPageAbsoluteURL("https://unsplash.com/");
    }

    public RegistrationPage goToRegistrationPage() {
        signUpButton.click();
        return new RegistrationPage(getDriver());
    }

    public LoginPage goToLoginPage() {
        logInButton.click();
        return new LoginPage(getDriver());
    }

    public boolean isPersonalMenuButtonPresent() {
        return personalMenuButton.isElementPresent();
    }

}
