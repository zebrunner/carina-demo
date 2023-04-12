package com.qaprosoft.carina.demo.beatsbydre.component.common;

import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;

import com.zebrunner.carina.webdriver.gui.AbstractUIObject;

public abstract class AbstractCustomCard extends AbstractUIObject {
    public AbstractCustomCard(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public abstract void interactWithElements();
}
