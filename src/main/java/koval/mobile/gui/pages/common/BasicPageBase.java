package koval.mobile.gui.pages.common;

import com.qaprosoft.carina.core.gui.AbstractPage;
import org.openqa.selenium.WebDriver;

public abstract class BasicPageBase extends AbstractPage {

    public BasicPageBase(WebDriver driver) {
        super(driver);
    }


    public abstract void getBack();
}
