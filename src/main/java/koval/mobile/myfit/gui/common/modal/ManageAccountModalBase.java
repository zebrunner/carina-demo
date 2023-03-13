package koval.mobile.myfit.gui.common.modal;


import koval.mobile.myfit.gui.MyAbstractPage;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;

import java.io.IOException;


public abstract class ManageAccountModalBase extends MyAbstractPage {


    public ManageAccountModalBase(WebDriver driver) {
        super(driver);
    }

    public ManageAccountModalBase(WebDriver driver, SearchContext searchContext) {
        super(driver);
    }

    public abstract int getAccountImageColor() throws IOException;
}
