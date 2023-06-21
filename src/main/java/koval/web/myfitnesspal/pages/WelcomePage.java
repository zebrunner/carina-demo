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

public class WelcomePage extends AbstractPage {

    private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());


    public WelcomePage(WebDriver driver) {
        super(driver);
        setPageAbsoluteURL(R.CONFIG.get(Configuration.Parameter.URL.getKey()));
    }

    @FindBy(xpath = "//*[@id='__next']/div/header/div/div/a")
    ExtendedWebElement logInButton;

    public boolean isPageOpened() {
        return logInButton.isElementPresent();
    }

    public LoginPage clickLogInButton() {
        logInButton.click();
        return new LoginPage(driver);
    }


}
