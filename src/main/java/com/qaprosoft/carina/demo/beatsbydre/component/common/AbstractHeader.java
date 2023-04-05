package com.qaprosoft.carina.demo.beatsbydre.component.common;

import com.zebrunner.carina.webdriver.gui.AbstractUIObject;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;

import java.util.List;

public abstract class AbstractHeader extends AbstractUIObject {

    public AbstractHeader(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public abstract String getPromoText();

    public abstract List<String> getTitles();
}
