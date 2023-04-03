package com.qaprosoft.carina.demo.example;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class HomePage extends AbstractPage {

    @FindBy(xpath = "//a[@data-testid='open-registration-form-button']")
    private ExtendedWebElement signUpButton;

    @FindBy(xpath = "//button[@data-testid='cookie-policy-manage-dialog-accept-button']")
    private ExtendedWebElement acceptСookiesButton;

    public HomePage(WebDriver driver) {
        super(driver);
        setPageAbsoluteURL("https://www.facebook.com/");
    }

    public RegistrationPage clickSignUpButton(){
        acceptСookiesButton.click();
        signUpButton.click();
        return new RegistrationPage(driver);
    }
}
