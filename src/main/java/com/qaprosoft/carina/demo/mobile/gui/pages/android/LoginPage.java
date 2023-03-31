package com.qaprosoft.carina.demo.mobile.gui.pages.android;

import io.appium.java_client.pagefactory.AndroidFindBy;
import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import com.qaprosoft.carina.demo.mobile.gui.pages.common.CarinaDescriptionPageBase;
import com.qaprosoft.carina.demo.mobile.gui.pages.common.LoginPageBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.utils.factory.DeviceType.Type;
import com.zebrunner.carina.utils.mobile.IMobileUtils;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;

@DeviceType(pageType = Type.ANDROID_PHONE, parentClass = LoginPageBase.class)
public class LoginPage extends LoginPageBase implements IMobileUtils {

    @AndroidFindBy(id = "name")
    private ExtendedWebElement nameInputField;

    @AndroidFindBy(id = "password")
    private ExtendedWebElement passwordInputField;

    @AndroidFindBy(id = "radio_male")
    private ExtendedWebElement maleRadioBtn;

    @AndroidFindBy(id = "radio_female")
    private ExtendedWebElement femaleRadioBtn;

    @AndroidFindBy(id = "checkbox")
    private ExtendedWebElement privacyPolicyCheckbox;

    @AndroidFindBy(id = "login_button")
    private ExtendedWebElement loginBtn;

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public void typeName(String name) {
        nameInputField.type(name);
        hideKeyboard();
    }

    @Override
    public void typePassword(String password) {
        passwordInputField.type(password);
    }

    @Override
    public void selectMaleSex() {
        maleRadioBtn.click();
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

    @Override
    public boolean isLoginBtnActive() {
        return Boolean.parseBoolean(loginBtn.getAttribute("enabled"));
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
