package com.qaprosoft.carina.demo.mymobile.gui.pages.common;

import com.qaprosoft.carina.core.gui.AbstractPage;
import org.openqa.selenium.WebDriver;

public abstract class RegisterPageBase extends AbstractPage {
    public RegisterPageBase(WebDriver driver) {
        super(driver);
    }

    public abstract boolean isBackBtnPresent();

    public abstract boolean isCarinaLogoPresent();

    public abstract boolean isNameInputPresent();

    public abstract boolean isPasswordInputPresent();

    public abstract boolean isMaleRadioPresent();

    public abstract boolean isFemaleRadioPresent();

    public abstract boolean isCheckboxPresent();

    public abstract boolean isSignUpBtnPresent();

    public abstract boolean isMaleRadioChecked();

    public abstract boolean isFemaleRadioChecked();

    public abstract boolean isCheckboxChecked();

    public abstract String readCarinaLogo();

    public abstract void clickMaleRadio();

    public abstract void clickFemaleRadio();

    public abstract void clickCheckbox();
}
