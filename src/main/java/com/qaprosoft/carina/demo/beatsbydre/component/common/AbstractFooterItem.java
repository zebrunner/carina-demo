package com.qaprosoft.carina.demo.beatsbydre.component.common;

import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;

import com.zebrunner.carina.webdriver.gui.AbstractUIObject;

public abstract class AbstractFooterItem extends AbstractUIObject {

    public AbstractFooterItem(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public abstract void hoverElements();
}
