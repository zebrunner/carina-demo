package com.qaprosoft.carina.demo.beatsbydre.component.common;

import com.zebrunner.carina.webdriver.gui.AbstractUIObject;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;

import java.util.List;

public abstract class AbstractFooter extends AbstractUIObject {
    public AbstractFooter(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public abstract void interactWithLocalizedElements();
}
