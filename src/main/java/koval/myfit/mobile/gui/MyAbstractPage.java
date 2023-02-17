package koval.myfit.mobile.gui;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import koval.myfit.mobile.gui.common.ActivityPageBase;
import koval.myfit.mobile.gui.common.downMenuPages.JournalPageBase;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public abstract class MyAbstractPage extends AbstractPage implements IMyInterface{

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
