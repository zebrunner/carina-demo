package koval.web.myfitnesspal.pages.menuPages;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.invoke.MethodHandles;

public class HomePage extends AbstractPage {

    private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());


    public HomePage(WebDriver driver) {
        super(driver);
    }


    @FindBy(xpath = "//*[@id='__next']/div/header/div[2]/div/div")
    ExtendedWebElement mainMenuModal;


    public boolean isPageOpened()
    {
        return mainMenuModal.isElementPresent();
    }


}
