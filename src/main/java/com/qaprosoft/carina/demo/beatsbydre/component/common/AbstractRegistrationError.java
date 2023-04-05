package com.qaprosoft.carina.demo.beatsbydre.component.common;

import com.zebrunner.carina.webdriver.gui.AbstractUIObject;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;

public abstract class AbstractRegistrationError extends AbstractUIObject {

    public AbstractRegistrationError(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public abstract String getErrorTitle();

    public abstract String getSerNumberError();

    public abstract void closeModal();
}
