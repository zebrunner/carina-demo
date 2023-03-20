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

    public RegistrationPage(WebDriver driver) {
        super(driver);
        setPageAbsoluteURL("https://unsplash.com/join");
    }

    public ExtendedWebElement getUserFirstNameInput() {
        return userFirstNameInput;
    }

    public ExtendedWebElement getUserLastNameInput() {
        return userLastNameInput;
    }

    public ExtendedWebElement getUserEmailInput() {
        return userEmailInput;
    }

    public ExtendedWebElement getUserNameInput() {
        return userNameInput;
    }

    public ExtendedWebElement getUserPasswordInput() {
        return userPasswordInput;
    }

    public ExtendedWebElement getJoinButton() {
        return joinButton;
    }
}
