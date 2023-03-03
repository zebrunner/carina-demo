package com.qaprosoft.carina.demo.mobile.gui.pages.common;

import com.qaprosoft.carina.core.gui.AbstractPage;
import com.zebrunner.carina.utils.mobile.IMobileUtils;
import org.openqa.selenium.WebDriver;

public abstract class ContactUsPageBase extends AbstractPage implements IMobileUtils {

    public ContactUsPageBase(WebDriver driver) {
        super(driver);
    }

    public abstract void typeName(String name);

    public abstract void typeEmail(String email);

    public abstract void typeQuestion(String question);

    public abstract void submit();

    public abstract boolean isErrorMessagePresent();

    public abstract boolean isRecaptchaPresent();

    public abstract boolean isSuccessMessagePresent();

}
