package com.qaprosoft.carina.demo.beatsbydre.locale.generate.component.common;

import com.zebrunner.carina.webdriver.gui.AbstractUIObject;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;

public abstract class AbstractFooterGen extends AbstractUIObject {
    public AbstractFooterGen(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public abstract void hoverFooterItems();

}
