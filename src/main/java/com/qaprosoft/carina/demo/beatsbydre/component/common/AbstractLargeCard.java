package com.qaprosoft.carina.demo.beatsbydre.component.common;

import com.zebrunner.carina.webdriver.gui.AbstractUIObject;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;

public abstract class AbstractLargeCard extends AbstractUIObject {
    public AbstractLargeCard(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }
    public abstract void interactWithElements();
}
