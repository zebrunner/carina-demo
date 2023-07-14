package koval.video.web.gsmarena.pages;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import koval.video.web.gsmarena.modals.LoginModal;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class WelcomePage extends AbstractPage {

    @FindBy(id = "login-active")
    ExtendedWebElement loginButton;

    public WelcomePage(WebDriver driver) {
        super(driver);
    }

    public LoginModal clickOnLoginButton()
    {
        loginButton.click();
        return new LoginModal(driver);
    }


}
