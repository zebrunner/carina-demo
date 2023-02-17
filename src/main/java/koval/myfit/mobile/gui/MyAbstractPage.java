package koval.myfit.mobile.gui;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import org.openqa.selenium.WebDriver;


public abstract class MyAbstractPage extends AbstractPage implements IMyInterface {

    public MyAbstractPage(WebDriver driver) {
        super(driver);
    }


    public boolean isPageOpened(ExtendedWebElement title, String textTitle) {
        return title.isElementPresent(TIMEOUT_FIVE) && title.getText().equals(textTitle);
    }

    public void hideKeyboard() {
        getDriver().navigate().back();
    }


}
