package com.qaprosoft.carina.demo.beatsbydre.locale.generate.component.common;

import com.zebrunner.carina.webdriver.gui.AbstractUIObject;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;

public abstract class AbstractHeaderGen extends AbstractUIObject {

    public AbstractHeaderGen(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public abstract void hoverHeaderItems();
}
