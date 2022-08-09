package com.qaprosoft.carina.demo.mobile.gui.pages.hasiuk.pages.common;

import com.qaprosoft.carina.core.gui.AbstractPage;
import org.openqa.selenium.WebDriver;

public abstract class HomePageBase extends AbstractPage {
    public HomePageBase(WebDriver driver) {
        super(driver);
    }

    public abstract LoginPageBase clickNextButton();
}
