package com.qaprosoft.carina.demo.gui.components;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractUIObject;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class Header extends AbstractUIObject {
    @FindBy(xpath = "//button[contains(@aria-label,'Toggle Navigation')]")
    private ExtendedWebElement burgerMenuBtn;

    @FindBy(id = "logo")
    private ExtendedWebElement homeTitle;

    @FindBy(id = "topsearch")
    private ExtendedWebElement searchField;

    @FindBy(xpath = "//i[@class='head-icon icon-tip-us icomoon-liga']")
    private ExtendedWebElement tipIcon;

    @FindBy(xpath = "//div[@id='social-connect']//a[@class='yt-icon']")
    private ExtendedWebElement youTubeIcon;

    @FindBy(xpath = "//div[@id='social-connect']//a[@href='https://www.instagram.com/gsmarenateam/']")
    private ExtendedWebElement instagramIcon;

    @FindBy(xpath = "//div[@id='social-connect']//a[@href='rss-news-reviews.php3']")
    private ExtendedWebElement rssIcon;

    @FindBy(xpath = "//div[@id='social-connect']//a[@href='https://www.arenaev.com/']")
    private ExtendedWebElement iconEV;

    @FindBy(xpath = "//div[@id='social-connect']//a[@href='https://merch.gsmarena.com/']")
    private ExtendedWebElement iconMerch;

    @FindBy(xpath = "//a[@class='login-icon']")
    private ExtendedWebElement loginIcon;

    @FindBy(xpath = "//a[@class='signup-icon no-margin-right']")
    private ExtendedWebElement signUpIcon;

    @FindBy(xpath = "//i[@class='head-icon icon-signout']")
    private ExtendedWebElement logOutIcon;

    public Header(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public boolean isBurgerMenuPresent() {
        return burgerMenuBtn.isPresent();
    }

    public boolean isLogoPresent() {
        return homeTitle.isPresent();
    }

    public boolean isSearchFieldPresent() {
        return searchField.isPresent();
    }

    public boolean isTipIconPresent() {
        return tipIcon.isPresent();
    }

    public boolean isYouTubeIconPresent() {
        return youTubeIcon.isPresent();
    }

    public boolean isInstagramIconPresent() {
        return instagramIcon.isPresent();
    }

    public boolean isRssIconPresent() {
        return rssIcon.isPresent();
    }

    public boolean isEvIconPresent() {
        return iconEV.isPresent();
    }

    public boolean isMerchIconPresent() {
        return iconMerch.isPresent();
    }

    public boolean isLoginIconPresent() {
        return loginIcon.isPresent();
    }

    public boolean isSignUpIconPresent() {
        return signUpIcon.isPresent();
    }

    public boolean isLogOutIconPresent() {
        return logOutIcon.isPresent();
    }

    public void loginButtonClick() {
        loginIcon.click();
    }

    public LoginForm openLoginForm(){
        loginIcon.click();
        return new LoginForm(driver);
    }
}
