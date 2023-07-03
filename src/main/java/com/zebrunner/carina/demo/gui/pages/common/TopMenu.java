package com.zebrunner.carina.demo.gui.pages.common;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
public class TopMenu extends AbstractPage {
    public TopMenu(WebDriver driver) {
        super(driver);
    }

    @FindBy(className = "login-icon")
    private ExtendedWebElement loginIcon;

    @FindBy(id = "login-active")
    private ExtendedWebElement loginName;

    @FindBy(name = "sEmail")
    private ExtendedWebElement emailField;

    @FindBy(id = "upass")
    private ExtendedWebElement passwordField;

    @FindBy(id = "nick-submit")
    private ExtendedWebElement loginButton;

    @FindBy(id = "topsearch-text")
    private ExtendedWebElement searchBar;

    @FindBy(xpath = "//*[@id=\"social-connect\"]/a[6]")
    private ExtendedWebElement merchButton;

    @FindBy(className = "article-info-name")
    private ExtendedWebElement searchResultRowField;

    @FindBy(id = "review-body")
    private ExtendedWebElement searchResultPageField;

    @FindBy(xpath = "//span[contains(.,'Alena')]")
    private ExtendedWebElement getLoginUser;

    public void clickLoginIcon() {
        loginIcon.click();
    }

    public void setEmail(String text) {
        emailField.type(text);
    }

    public void setPass(String text) {
        passwordField.type(text);
    }

    public void clickLoginButton() {
        loginButton.click();
    }

    public void typeTextToSearchBar(String text) {
        searchBar.type(text);
        searchBar.sendKeys(Keys.ENTER);
    }

    public void clickMerchButton() {
        merchButton.click();
    }

    public String getLoginName() {
        return loginName.getText();
    }

    public String getSearchRowResult() {
        return searchResultRowField.getText();
    }

    public String getSearchPageResult() {
        return getLoginUser.getText();
    }
}
