package com.qaprosoft.carina.demo.beatsbydre.component.common;

import java.util.List;

import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;

import com.zebrunner.carina.webdriver.gui.AbstractUIObject;

public abstract class AbstractFooter extends AbstractUIObject {
    public AbstractFooter(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public abstract void interactWithLocalizedElements();

    public abstract List<? extends AbstractFooterItem> getFooterItems();
}
