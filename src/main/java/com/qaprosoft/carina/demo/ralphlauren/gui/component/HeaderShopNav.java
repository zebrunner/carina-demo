package com.qaprosoft.carina.demo.ralphlauren.gui.component;

import com.zebrunner.carina.utils.factory.ICustomTypePageFactory;
import com.zebrunner.carina.webdriver.gui.AbstractUIObject;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;

public class HeaderShopNav extends AbstractUIObject implements ICustomTypePageFactory {


    public HeaderShopNav(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }
}
