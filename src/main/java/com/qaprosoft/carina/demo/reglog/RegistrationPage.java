package com.qaprosoft.carina.demo.reglog;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class RegistrationPage extends AbstractPage {

    @FindBy(id = "user_first_name")
    private ExtendedWebElement userFirstNameInput;

    @FindBy(id = "user_last_name")
    private ExtendedWebElement userLastNameInput;

    @FindBy(id = "user_email")
    private ExtendedWebElement userEmailInput;

    @FindBy(id = "user_username")
    private ExtendedWebElement userNameInput;

    @FindBy(id = "user_password")
    private ExtendedWebElement userPasswordInput;

    @FindBy(xpath = "//input[@value='Join']")
    private ExtendedWebElement joinButton;

    @FindBy(xpath = "//div//h3[@class='epsilon']")
    private ExtendedWebElement errorMessage;

    public RegistrationPage(WebDriver driver) {
        super(driver);
        setPageAbsoluteURL("https://unsplash.com/join");
    }

    public HomePage signUp(String firstName, String lastName, String email, String userName, String password){
        userFirstNameInput.type(firstName);
        userLastNameInput.type(lastName);
        userEmailInput.type(email);
        userNameInput.type(userName);
        userPasswordInput.type(password);
        joinButton.click();
        return new HomePage(getDriver());
    }

    public boolean isErrorMessagePresent() {
        return errorMessage.isElementPresent();
    }

    public String getErrorMessageText() {
        return errorMessage.getText();
    }

}
