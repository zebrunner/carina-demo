package com.qaprosoft.carina.demo.gui.components;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractUIObject;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class HeaderItem extends AbstractUIObject {
    @FindBy(xpath = "//*[@class='lines-button minus focused']")
    private ExtendedWebElement menu;

    @FindBy(xpath = "//*[@id='anchor']")
    private ExtendedWebElement siteLogo;

    @FindBy(xpath = "//*[@class='tip-icon']")
    private ExtendedWebElement tipLogo;

    @FindBy(xpath = "//*[@name='sSearch']")
    private ExtendedWebElement searchBar;

    @FindBy(xpath = "//*[@class='head-icon icon-soc-fb2 icomoon-liga']")
    private ExtendedWebElement fbIcon;

    @FindBy(xpath = "//*[@class='head-icon icon-soc-twitter2 icomoon-liga']")
    private ExtendedWebElement twIcon;

    @FindBy(xpath = "//*[@class='head-icon icon-instagram icomoon-liga']")
    private ExtendedWebElement instIcon;

    @FindBy(xpath = "//*[@class='head-icon icon-soc-youtube icomoon-liga']")
    private ExtendedWebElement ytIcon;

    @FindBy(xpath = "//*[@class='head-icon icon-soc-rss2 icomoon-liga']")
    private ExtendedWebElement rssIcon;

    @FindBy(xpath = "//*[@class='head-icon icon-login']")
    private ExtendedWebElement loginButton;

    @FindBy(xpath = "//*[@id='email']")
    private ExtendedWebElement emailField;

    @FindBy(xpath = "//*[@id='upass']")
    private ExtendedWebElement passField;

    @FindBy(xpath = "//*[@class='button']")
    private ExtendedWebElement loginFormButton;

    @FindBy(xpath ="//*[@class='head-icon icon-user-plus']")
    private ExtendedWebElement signUpButton;


    public HeaderItem(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public HeaderItem(WebDriver driver) {
        super(driver);
    }

    public boolean isMenuPresented() {
        return menu.isPresent();
    }

    public boolean isSiteLogoPresented() {
        return siteLogo.isPresent();
    }

    public boolean isTipLogoPresented() {
        return tipLogo.isPresent();
    }

    public boolean isSearchBarPresented() {
        return searchBar.isPresent();
    }

    public boolean isFbIconPresented() {
        return fbIcon.isPresent();
    }

    public boolean isTwIconPresented() {
        return twIcon.isPresent();
    }

    public boolean isInstIconPresented() {
        return instIcon.isPresent();
    }

    public boolean isYtIconPresented() {
        return ytIcon.isPresent();
    }

    public boolean isRssIconPresented() {
        return rssIcon.isPresent();
    }

    public void login(String name, String pass) {
        loginButton.click();
        emailField.click();
        emailField.type(name);
        passField.click();
        passField.type(pass);
        loginFormButton.click();
    }

    public boolean isLoginButtonPresented() {
        return loginButton.isPresent();
    }

    public boolean isSignUpButtonPresented(){
        return signUpButton.isPresent();
    }

}
