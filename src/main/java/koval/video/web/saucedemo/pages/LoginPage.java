package koval.video.web.saucedemo.pages;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import com.zebrunner.carina.utils.R;
import koval.web.saucedemo.AllItemsPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends AbstractPage {

    @FindBy(id = "user-name")
    ExtendedWebElement userNameField;

    @FindBy(id = "password")
    ExtendedWebElement passwordField;

    @FindBy(id = "login-button")
    ExtendedWebElement loginButton;

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public LoginPage enterValidCredentials()
    {
        userNameField.type(R.TESTDATA.get("saucedemo_username"));
        passwordField.type(R.TESTDATA.get("saucedemo_password"));
        return new LoginPage(driver);
    }

    public AllItemsPage login()
    {
        loginButton.click();
        return new AllItemsPage(driver);
    }


}
