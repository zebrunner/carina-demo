package koval.web.myfitnesspal.pages.firstPages;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import koval.web.myfitnesspal.pages.MyAbstractPage;
import koval.web.myfitnesspal.pages.menuPages.mainMenu.HomePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends MyAbstractPage {


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
        return new LoginPage(driver);
    }


    public LoginPage typePassword(String password)
    {
        passwordField.click();
        passwordField.type(password);
        return new LoginPage(driver);
    }

    public HomePage clickLogInButton() throws InterruptedException {
        logInButton.click(TIMEOUT_TWENTY);
        return new HomePage(driver);
    }

}
