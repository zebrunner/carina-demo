package koval.web.gsmarena.modals;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractUIObject;
import com.zebrunner.carina.utils.R;
import koval.web.gsmarena.pages.HomePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class LoginModal extends AbstractUIObject {

    @FindBy(id = "email")
    ExtendedWebElement mailField;

    @FindBy(id = "upass")
    ExtendedWebElement passwordField;

    @FindBy(id = "nick-submit")
    ExtendedWebElement loginButton;

    public LoginModal(WebDriver driver) {
        super(driver);
    }

    public HomePage login() {
        mailField.type(R.TESTDATA.get("gsmarena_mail"));
        passwordField.type(R.TESTDATA.get("gsmarena_password"));
        loginButton.click(20);
        return new HomePage(driver);
    }

}
