package com.qaprosoft.carina.demo.beatsbydre.gui.common;

import com.qaprosoft.carina.demo.beatsbydre.component.desktop.Header;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;

public abstract class HomePageBase extends AbstractPage {
    public HomePageBase(WebDriver driver) {
        super(driver);
    }

    public abstract Header getHeader();
}
