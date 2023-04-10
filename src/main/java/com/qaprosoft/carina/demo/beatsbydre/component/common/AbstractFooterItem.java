package com.qaprosoft.carina.demo.beatsbydre.component.common;

import com.zebrunner.carina.webdriver.gui.AbstractUIObject;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;

public abstract class AbstractFooterItem extends AbstractUIObject {

    public AbstractFooterItem(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public abstract void hoverElements();
}
