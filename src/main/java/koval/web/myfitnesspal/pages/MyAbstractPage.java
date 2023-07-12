package koval.web.myfitnesspal.pages;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import koval.web.myfitnesspal.utils.CookiesPopUpUtils;
import koval.web.myfitnesspal.utils.IConstantUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.invoke.MethodHandles;

public class MyAbstractPage extends AbstractPage implements IConstantUtils {
    public MyAbstractPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//*[text()='%s']")
    public ExtendedWebElement itemByText;

    @FindBy(xpath = "//*[@id=\"notice\"]")
    private ExtendedWebElement cookiesPopUp;

    public static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());


    public void acceptCookies() {
        waitUntil(ExpectedConditions.visibilityOfElementLocated(cookiesPopUp.getBy()), 60);

        CookiesPopUpUtils cookies = new CookiesPopUpUtils(driver);
        driver.switchTo().frame(cookiesPopUp.getElement());
        cookies.acceptCookiesPopUp();
        getDriver().switchTo().defaultContent();
    }

}
