package koval.myfit.mobile.gui;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import koval.myfit.mobile.service.ColorUtils;
import org.openqa.selenium.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


import java.lang.invoke.MethodHandles;



public abstract class MyAbstractPage extends ColorUtils implements IMyInterface {

    private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

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
