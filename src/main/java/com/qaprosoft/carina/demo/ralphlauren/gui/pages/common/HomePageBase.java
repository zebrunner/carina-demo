package com.qaprosoft.carina.demo.ralphlauren.gui.pages.common;

import com.qaprosoft.carina.demo.ralphlauren.gui.component.Header;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;

public abstract class HomePageBase extends AbstractPage {
    public HomePageBase(WebDriver driver) {
        super(driver);
    }

    public abstract Header getHeader();

}
