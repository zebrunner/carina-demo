package com.qaprosoft.carina.demo.gui.components;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractUIObject;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class Header extends AbstractUIObject {

    @FindBy(className="searchFor")
    private ExtendedWebElement burgerMenu;

    @FindBy(id = "logo")
    private ExtendedWebElement logoGSM;

    @FindBy(name = "sSearch")
    private ExtendedWebElement searchInput;

    @FindBy(className = "tipIcon")
    private ExtendedWebElement tipIcon;

    @FindBy(className = "fb-icon")
    private ExtendedWebElement fbIcon;

    @FindBy(className = "tw-icon")
    private ExtendedWebElement twIcon;

    @FindBy(className = "ig-icon")
    private ExtendedWebElement igIcon;

    @FindBy(className = "yt-icon")
    private ExtendedWebElement ytIcon;

    @FindBy(className = "rss-icon")
    private ExtendedWebElement rssIcon;

    @FindBy(className = "login-icon")
    private ExtendedWebElement loginIcon;

    @FindBy(className = "icon-count")
    private ExtendedWebElement signUpIcon;


    public Header(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }



}
