package com.qaprosoft.carina.demo.beatsbydre.gui.common;

import org.openqa.selenium.WebDriver;

import com.qaprosoft.carina.demo.beatsbydre.component.common.AbstractRegistrationError;
import com.zebrunner.carina.webdriver.gui.AbstractPage;

public abstract class RegisterBeatsPageBase extends AbstractPage {

    public RegisterBeatsPageBase(WebDriver driver) {
        super(driver);
    }

    public abstract String getPageTitle();

    public abstract void typeSerNumberField(String input);

    public abstract String getHowToFindSerNumberLink();

    public abstract void verifySerNumber();

    public abstract String getLengthErrMsg();

    public abstract String getInvalidCharsErrMsg();

    public abstract String getEmptyInputErrMsg();

    public abstract AbstractRegistrationError getRegistrationError();
}
