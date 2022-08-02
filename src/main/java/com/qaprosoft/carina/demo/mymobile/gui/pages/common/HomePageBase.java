package com.qaprosoft.carina.demo.mymobile.gui.pages.common;

import com.qaprosoft.carina.core.gui.AbstractPage;
import org.openqa.selenium.WebDriver;

public abstract class HomePageBase extends AbstractPage {

    public HomePageBase(WebDriver driver) {
        super(driver);
    }

    public abstract boolean isNextBtnPresent();

    public abstract boolean isCarinaLogoPresent();

    public abstract RegisterPageBase clickNextBtn();
}
