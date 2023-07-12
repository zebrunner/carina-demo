package koval.web.myfitnesspal.utils;

import koval.web.myfitnesspal.pages.MyAbstractPage;
import koval.web.myfitnesspal.pages.firstPages.WelcomePage;
import org.openqa.selenium.WebDriver;


public class CookiesPopUpUtils extends MyAbstractPage {
    public CookiesPopUpUtils(WebDriver driver) {
        super(driver);
    }

    public WelcomePage acceptCookiesPopUp() {
        itemByText.format(ACCEPT).click();
        return new WelcomePage(driver);
    }


}
