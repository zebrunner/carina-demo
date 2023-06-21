package koval.web.myfitnesspal.pages;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import koval.web.myfitnesspal.pages.menuPages.HomePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.invoke.MethodHandles;

import static koval.web.myfitnesspal.utils.IConstant.TIMEOUT_FIFTEEN;

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
        mailField.click(TIMEOUT_FIFTEEN);
        mailField.type(mail);
        return new LoginPage(getDriver());
    }


    public LoginPage typePassword(String password)
    {
        passwordField.click();
        passwordField.type(password);
        return new LoginPage(getDriver());
    }

    public HomePage clickLogInButton() {
        logInButton.click();
        return new HomePage(getDriver());
    }

}
