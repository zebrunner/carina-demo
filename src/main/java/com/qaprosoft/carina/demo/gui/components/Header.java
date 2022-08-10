package com.qaprosoft.carina.demo.gui.components;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractUIObject;
import com.qaprosoft.carina.demo.gui.pages.HomePage;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class Header extends AbstractUIObject {

    @FindBy(xpath = "//button[(contains(@class, 'lines-button minus focused'))]")
    private ExtendedWebElement hamburgerMenu;

    @FindBy(xpath = "//*[@id=\"logo\"]/a/object")
    private ExtendedWebElement logo;

    @FindBy(xpath = "//form[@id=\"topsearch\"]")
    private ExtendedWebElement searchForm;

    @FindBy(xpath = "//input[@id=\"topsearch-text\"]")
    private ExtendedWebElement searchLine;

    @FindBy(xpath = "//span[@id=\"quick-search-button\"]/input")
    private ExtendedWebElement searchButton;

    @FindBy(xpath = "//i[@class=\"head-icon icon-tip-us icomoon-liga\"]")
    private ExtendedWebElement iconTipUs;

    @FindBy(xpath = "//i[@class=\"head-icon icon-soc-youtube icomoon-liga\"]")
    private ExtendedWebElement iconYoutube;

    @FindBy(xpath = "//i[@class=\"head-icon icon-instagram icomoon-liga\"]")
    private ExtendedWebElement iconInstagram;

    @FindBy(xpath = "//i[@class=\"head-icon icon-soc-rss2 icomoon-liga\"]")
    private ExtendedWebElement iconRSS;

    @FindBy(xpath = "//i[@class=\"head-icon icon-specs-car icomoon-liga\"]")
    private ExtendedWebElement iconSpecsCar;

    @FindBy(xpath = "//i[@class=\"head-icon icon-cart icomoon-liga\"]")
    private ExtendedWebElement iconCart;

    @FindBy(xpath = "//i[@class=\"head-icon icon-login\"]")
    private ExtendedWebElement iconLogin;

    @FindBy(xpath = "//i[@class=\"head-icon icon-user-plus\"]")
    private ExtendedWebElement iconSignUp;

    public Header(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public boolean isHamburgerMenuPresent() {
        return hamburgerMenu.isElementPresent();
    }

    public boolean isLogoPresent() {
        return logo.isElementPresent();
    }

    public boolean isSearchFormPresent() {
        return searchForm.isElementPresent();
    }

    public boolean isSearchLinePresent(){
        return searchLine.isElementPresent();
    }

    public boolean isSearchButtonPresent(){
        return searchButton.isElementPresent();
    }

    public boolean isIconTipUsPresent(){
        return iconTipUs.isElementPresent();
    }

    public boolean isIconYoutubePresent(){
        return iconYoutube.isElementPresent();
    }

    public boolean isIconInstagramPresent(){
        return iconInstagram.isElementPresent();
    }

    public boolean isIconRSSPresent(){
        return iconRSS.isElementPresent();
    }

    public boolean isIconSpecsCarPresent(){
        return iconSpecsCar.isElementPresent();
    }

    public boolean isIconCartPresent(){
        return iconCart.isElementPresent();
    }

    public boolean isIconLoginPresent(){
        return iconLogin.isElementPresent();
    }

    public boolean isIconSignUpPresent(){
        return iconSignUp.isElementPresent();
    }


}



