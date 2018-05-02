package com.qaprosoft.carina.demo.operations;

import com.qaprosoft.carina.core.foundation.AbstractTest;
import com.qaprosoft.carina.core.foundation.utils.Configuration;
import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.util.ArrayList;

public class InitialPage extends AbstractPage{


    @FindBy(xpath = "//input[@id='login-username']")
    public ExtendedWebElement username;

    @FindBy(xpath = "//input[@type='password']")
    private ExtendedWebElement password;

    @FindBy(xpath = "//input[@value='Next']")
    private ExtendedWebElement nextButton;

    @FindBy(xpath = "//button[@name='verifyPassword']")
    private ExtendedWebElement signIn;

    @FindBy(xpath = "//button[@id='uh-search-button']")
    private ExtendedWebElement searchButton;

    @FindBy(xpath = "//input[@id='uh-search-box']")
    private ExtendedWebElement searchField;

    public InitialPage(WebDriver driver) {
        super(driver);
    }


    public void login() {
        username.type("maxjaycob@yahoo.com");
        nextButton.click();
    }

    public void enterPassword() {
        password.type("pojo1234");
        signIn.click();
    }

    public void search() {
        searchField.type("qaprosoft");
        searchButton.click();
    }


}