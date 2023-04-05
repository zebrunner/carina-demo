package com.qaprosoft.carina.demo.beatsbydre.gui.common;

import com.qaprosoft.carina.demo.beatsbydre.component.common.AbstractFooter;
import com.qaprosoft.carina.demo.beatsbydre.component.common.AbstractHeader;
import org.openqa.selenium.WebDriver;

import com.zebrunner.carina.webdriver.gui.AbstractPage;

public abstract class HomePageBase extends AbstractPage {
    public HomePageBase(WebDriver driver) {
        super(driver);
    }

    public abstract AbstractHeader getHeader();

    public abstract AbstractFooter getFooter();

    public abstract void interactWithLocalizedElements();

    public abstract RegisterBeatsPageBase toRegisterBeatsPage();
}
