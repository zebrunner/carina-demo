package com.qaprosoft.carina.demo.beatsbydre.component.common;

import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;

import com.zebrunner.carina.webdriver.gui.AbstractUIObject;

public abstract class AbstractHeader extends AbstractUIObject {

    public AbstractHeader(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public abstract void interactWithLocalizedElements();
}
