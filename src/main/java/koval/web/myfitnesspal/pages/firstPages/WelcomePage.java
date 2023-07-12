package koval.web.myfitnesspal.pages.firstPages;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.utils.Configuration;
import com.zebrunner.carina.utils.R;
import koval.web.myfitnesspal.pages.MyAbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;


public class WelcomePage extends MyAbstractPage {

    public WelcomePage(WebDriver driver) {
        super(driver);
        setPageAbsoluteURL(R.CONFIG.get(Configuration.Parameter.URL.getKey()));
    }

    @FindBy(xpath = "//*[@id=\"__next\"]/div/header/div/div/a/span")
    ExtendedWebElement logInButton;


    public boolean isPageOpened() {
        return logInButton.isElementPresent(TIMEOUT_TWENTY);
    }

    public LoginPage clickLogInButton() {
        logInButton.click(TIMEOUT_TWENTY);
        return new LoginPage(driver);
    }

}
