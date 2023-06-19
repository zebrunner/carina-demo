package koval.web.myfitnesspal.pages;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import com.zebrunner.carina.utils.Configuration;
import com.zebrunner.carina.utils.R;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.invoke.MethodHandles;

public class LoginPage extends AbstractPage {

    private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());


    public LoginPage(WebDriver driver) {
        super(driver);
    }


    @FindBy(id = "email")
    ExtendedWebElement mailField;

    @FindBy(id = "password")
    ExtendedWebElement passwordField;


    @FindBy(xpath = "//*[@id='__next']/div/main/div/div/form/div/div[2]/button[1]")
    ExtendedWebElement logInButton;

    public LoginPage typeMail(String mail)
    {
        mailField.click(10);
        mailField.type(mail);
        return new LoginPage(driver);
    }


    public LoginPage typePassword(String password)
    {
        passwordField.click();
        passwordField.type(password);
        return new LoginPage(driver);
    }

    public LoginPage clickLogInButton() {
        logInButton.click();
        return new LoginPage(driver);
    }

}
