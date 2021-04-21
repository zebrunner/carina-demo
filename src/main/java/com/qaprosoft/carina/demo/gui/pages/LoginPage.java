package com.qaprosoft.carina.demo.gui.pages;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import com.qaprosoft.carina.demo.gui.model.User;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends AbstractPage {
    private static final Logger LOGGER = LogManager.getRootLogger();

    @FindBy(css = ".head-icon.icon-login")
    private ExtendedWebElement iconLogin;

    @FindBy(id = "email")
    private ExtendedWebElement inputEmail;

    @FindBy(id = "upass")
    private ExtendedWebElement inputPassword;

    @FindBy(id = "nick-submit")
    private ExtendedWebElement loginBtn;

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public LoginPage openPage() {
        open();
        LOGGER.info("Login page opened");
        return this;
    }

    public HomePage login(User user) {
        iconLogin.click();
        inputEmail.type(user.getEmail());
        inputPassword.type(user.getPassword());
        loginBtn.click();
        LOGGER.info("Login performed");
        return new HomePage(getDriver());
    }

    public HomePage loginWithWrongEmail(User user) {
        iconLogin.click();
        inputEmail.type(user.getWrongEmail());
        inputPassword.type(user.getPassword());
        loginBtn.click();
        LOGGER.info("Login is not performed");
        return new HomePage(getDriver());
    }

    public HomePage loginWithWrongPassword(User user) {
        iconLogin.click();
        inputEmail.type(user.getEmail());
        inputPassword.type(user.getWrongPassword());
        loginBtn.click();
        LOGGER.info("Login is not performed");
        return new HomePage(getDriver());
    }
}
