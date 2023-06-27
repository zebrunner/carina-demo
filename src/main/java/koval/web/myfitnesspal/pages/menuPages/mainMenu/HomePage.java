package koval.web.myfitnesspal.pages.menuPages.mainMenu;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import koval.web.myfitnesspal.modal.MainMenuModal;
import koval.web.myfitnesspal.pages.MyAbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;


public class HomePage extends MyAbstractPage {

    public HomePage(WebDriver driver) {
        super(driver);
        setPageURL("https://www.myfitnesspal.com/");
    }

    @FindBy(xpath = "//*[@id='__next']/div/header/div[2]/div/div")
    MainMenuModal mainMenuModal;

    @FindBy(xpath = "//*[@id=\"__next\"]/div/div/main/div[1]/div/div/div[1]/div[1]/div[1]/h1")
    ExtendedWebElement title;


    public boolean isPageOpened() {
        waitUntil(ExpectedConditions.visibilityOfElementLocated(title.getBy()), TIMEOUT_FORTY);
        return title.isElementPresent(TIMEOUT_TWENTY) &&
                title.getText().equals(DAILY_SUMMARY);
    }


    public MainMenuModal getMainMenu() {
        return mainMenuModal;
    }


}
