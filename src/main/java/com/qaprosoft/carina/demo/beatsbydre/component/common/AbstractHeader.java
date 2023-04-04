package com.qaprosoft.carina.demo.beatsbydre.component.common;

import com.zebrunner.carina.webdriver.gui.AbstractUIObject;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;

public abstract class AbstractHeader extends AbstractUIObject {
    public AbstractHeader(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }
}
