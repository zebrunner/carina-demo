package koval.web.myfitnesspal.pages.firstPages;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import koval.web.myfitnesspal.pages.MyAbstractPage;
import koval.web.myfitnesspal.pages.menuPages.mainMenu.myhomeMenu.HomePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends MyAbstractPage {


    public LoginPage(WebDriver driver) {
        super(driver);
        setPageAbsoluteURL("https://www.myfitnesspal.com/account/login");
    }


    @FindBy(id = "email")
    ExtendedWebElement mailField;

    @FindBy(id = "password")
    ExtendedWebElement passwordField;

    @FindBy(xpath = "//*[@id='__next']/div/main/div/div/form/div/div[2]/button[1]")
    ExtendedWebElement logInButton;


    @FindBy(xpath = "//*[@id=\"__next\"]/div/main/div/div/form/div/div[1]/div[2]")
    ExtendedWebElement captchaMessage;

    public LoginPage typeMail(String mail)
    {
        mailField.click(TIMEOUT_TEN);
        mailField.type(mail, TIMEOUT_TEN);
        return new LoginPage(driver);
    }


    public LoginPage typePassword(String password)
    {
        passwordField.click(TIMEOUT_TEN);
        passwordField.type(password, TIMEOUT_TEN);
        return new LoginPage(driver);
    }

    public HomePage clickLogInButton(){
        logInButton.click(TIMEOUT_FIFTEEN);
        return new HomePage(driver);
    }

    public HomePage captchaReLogin(){
        if(captchaMessage.isElementPresent())
        {
            logInButton.click();
        }
        return new HomePage(driver);
    }

}
