package koval.mobile.myfitnesspal.gui;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import koval.mobile.myfitnesspal.gui.android.modal.DownMenuModal;
import koval.mobile.myfitnesspal.gui.common.loginPages.SignUpPageBase;
import koval.mobile.myfitnesspal.service.enums.DownMenuElement;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


import java.lang.invoke.MethodHandles;
import java.util.Random;


public abstract class MyAbstractPage extends AbstractPage implements IMyInterface {

    private static final Random random = new Random();

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
