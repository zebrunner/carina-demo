package com.qaprosoft.carina.demo.ui.components;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractUIObject;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class NavigationElementItem extends AbstractUIObject {

    @FindBy(xpath = ".//label[contains(text(),'Automation')]")
    private ExtendedWebElement automation;

    @FindBy(xpath = ".//a[contains(text(),'Web')]")
    private ExtendedWebElement web;

    public NavigationElementItem(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public boolean isAutomationSectionPresent() {
        return automation.isElementPresent();
    }

    public boolean isWebSectionPresent() {
        return web.isElementPresent(5);
    }

    public void expandAutomationSection(){
        automation.click();
    }
}
