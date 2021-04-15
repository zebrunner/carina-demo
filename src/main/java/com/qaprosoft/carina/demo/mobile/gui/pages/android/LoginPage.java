package com.qaprosoft.carina.demo.mobile.gui.pages.android;

import com.qaprosoft.carina.demo.mobile.gui.pages.common.WebViewPageBase;
import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import com.qaprosoft.carina.core.foundation.utils.factory.DeviceType;
import com.qaprosoft.carina.core.foundation.utils.factory.DeviceType.Type;
import com.qaprosoft.carina.core.foundation.utils.mobile.IMobileUtils;
import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.demo.mobile.gui.pages.common.CarinaDescriptionPageBase;
import com.qaprosoft.carina.demo.mobile.gui.pages.common.LoginPageBase;

@DeviceType(pageType = Type.ANDROID_PHONE, parentClass = LoginPageBase.class)
public class LoginPage extends LoginPageBase implements IMobileUtils {

    @FindBy(id = "name")
    private ExtendedWebElement nameInputField;

    @FindBy(xpath = "//*[@text='CARINA']")
    private ExtendedWebElement title;

    @FindBy(id = "password")
    private ExtendedWebElement passwordInputField;

    @FindBy(id = "radio_male")
    private ExtendedWebElement maleRadioBtn;

    @FindBy(id = "radio_female")
    private ExtendedWebElement femaleRadioBtn;

    @FindBy(id = "checkbox")
    private ExtendedWebElement privacyPolicyCheckbox;

    @FindBy(id = "login_button")
    private ExtendedWebElement loginBtn;

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isNameFieldPresent() {
        return nameInputField.isElementPresent();
    }

    @Override
    public void typeName(String name) {
        nameInputField.type(name);
        hideKeyboard();
    }

    public String getFieldName() {
        return nameInputField.getText();
    }

    public String getFieldPassword() {
        return passwordInputField.getText();
    }

    @Override
    public boolean isPasswordFieldPresent() {
        return passwordInputField.isElementPresent();
    }

    @Override
    public void typePassword(String password) {
        passwordInputField.type(password);
    }

    @Override
    public boolean isMaleRadioBtnPresent() {
        return maleRadioBtn.isElementPresent();
    }

    @Override
    public boolean isFemaleRadioBtnPresent() {
        return femaleRadioBtn.isElementPresent();
    }

    @Override
    public boolean isMaleRadioBtnChecked() {
        return maleRadioBtn.isChecked();
    }

    @Override
    public boolean isFemaleRadioBtnChecked() {
        return femaleRadioBtn.isChecked();
    }

    @Override
    public boolean isPrivacyPolicyCheckboxPresent() {
        return privacyPolicyCheckbox.isElementPresent();
    }

    @Override
    public void selectMaleSex() {
        maleRadioBtn.click();
    }

    @Override
    public void selectFemaleSex() {
        femaleRadioBtn.click();
    }

    @Override
    public boolean isPrivacyPolicyCheckboxChecked() {
        return privacyPolicyCheckbox.isChecked();
    }

    @Override
    public void checkPrivacyPolicyCheckbox() {
        privacyPolicyCheckbox.click();
    }

    @Override
    public CarinaDescriptionPageBase clickLoginBtn() {
        loginBtn.click();
        return initPage(getDriver(), CarinaDescriptionPageBase.class);
    }

    public WebViewPageBase clickLoginButton() {
        loginBtn.click();
        return initPage(getDriver(), WebViewPageBase.class);
    }

    @Override
    public boolean isLoginBtnActive() {
        return Boolean.parseBoolean(loginBtn.getAttribute("enabled"));
    }

    @Override
    public boolean isPageOpened() {
        return title.isElementPresent();
    }

    @Override
    public CarinaDescriptionPageBase login() {
        String username = "Test user";
        String password = RandomStringUtils.randomAlphabetic(10);
        typeName(username);
        typePassword(password);
        selectMaleSex();
        checkPrivacyPolicyCheckbox();
        return clickLoginBtn();
    }
}
