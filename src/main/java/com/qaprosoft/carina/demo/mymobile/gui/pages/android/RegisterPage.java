package com.qaprosoft.carina.demo.mymobile.gui.pages.android;

import com.qaprosoft.carina.core.foundation.utils.factory.DeviceType;
import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.demo.mymobile.gui.pages.common.RegisterPageBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = RegisterPageBase.class)
public class RegisterPage extends RegisterPageBase {

    @FindBy(id = "backButton")
    ExtendedWebElement backBtn;

    @FindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.FrameLayout/android.widget.TextView")
    ExtendedWebElement carinaLogo;

    @FindBy(id = "name")
    ExtendedWebElement nameInput;

    @FindBy(id = "password")
    ExtendedWebElement passwordInput;

    @FindBy(id = "radio_male")
    ExtendedWebElement maleRadio;

    @FindBy(id = "radio_female")
    ExtendedWebElement femaleRadio;

    @FindBy(id = "checkbox")
    ExtendedWebElement checkbox;

    @FindBy(id = "login_button")
    ExtendedWebElement signUpBtn;

    public RegisterPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isBackBtnPresent() {
        return backBtn.isElementPresent();
    }

    @Override
    public boolean isCarinaLogoPresent() {
        return carinaLogo.isElementPresent();
    }

    @Override
    public boolean isNameInputPresent() {
        return nameInput.isElementPresent();
    }

    @Override
    public boolean isPasswordInputPresent() {
        return passwordInput.isElementPresent();
    }

    @Override
    public boolean isMaleRadioPresent() {
        return maleRadio.isElementPresent();
    }

    @Override
    public boolean isFemaleRadioPresent() {
        return femaleRadio.isElementPresent();
    }

    @Override
    public boolean isCheckboxPresent() {
        return checkbox.isElementPresent();
    }

    @Override
    public boolean isSignUpBtnPresent() {
        return signUpBtn.isElementPresent();
    }

    @Override
    public boolean isMaleRadioChecked() {
        return maleRadio.isChecked();
    }

    @Override
    public boolean isFemaleRadioChecked() {
        return femaleRadio.isChecked();
    }

    @Override
    public boolean isCheckboxChecked() {
        return checkbox.isChecked();
    }

    @Override
    public String readCarinaLogo() {
        return carinaLogo.getText();
    }

    @Override
    public void clickMaleRadio() {
        maleRadio.click();
    }

    @Override
    public void clickFemaleRadio() {
        femaleRadio.click();
    }

    @Override
    public void clickCheckbox() {
        checkbox.click();
    }
}
