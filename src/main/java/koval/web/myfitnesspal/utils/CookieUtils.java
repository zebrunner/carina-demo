package koval.web.myfitnesspal.utils;
import org.openqa.selenium.WebDriver;


public class CookieUtils {

    public static void refreshPage(WebDriver driver) {
        driver.navigate().refresh();
    }

}

