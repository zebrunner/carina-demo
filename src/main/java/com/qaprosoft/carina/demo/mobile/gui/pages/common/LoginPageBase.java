package com.qaprosoft.carina.demo.mobile.gui.pages.common;

import org.openqa.selenium.WebDriver;

import com.qaprosoft.carina.core.gui.AbstractPage;

public abstract class LoginPageBase extends AbstractPage {

    public LoginPageBase(WebDriver driver) {
        super(driver);
    }

    public abstract void typeName(String name);

    public abstract void typePassword(String password);

    public abstract void selectMaleSex();

    public abstract void checkPrivacyPolicyCheckbox();

    public abstract CarinaDescriptionPageBase clickLoginBtn();

    public abstract WebViewPageBase clickLoginButton();

    public abstract boolean isLoginBtnActive();

    public abstract boolean verifyFieldsArePresented();

    public abstract boolean isMaleRadioBtnUnchecked();

    public abstract boolean isFemaleRadioBtnChecked();

    public abstract boolean isPrivacyPolicyCheckboxUnchecked();

    public abstract boolean isPrivacyPolicyCheckboxChecked();


    public abstract String getTypeName();

    public abstract String getTypePassword();


    public abstract CarinaDescriptionPageBase login();

}
