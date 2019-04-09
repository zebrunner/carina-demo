package com.qaprosoft.carina.demo.mobile.gui.pages.android;

import com.qaprosoft.carina.core.foundation.utils.factory.DeviceType;
import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.demo.mobile.gui.pages.common.ContactUsPageBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = ContactUsPageBase.class)
public class ContactUsPage extends ContactUsPageBase {

    @FindBy(xpath = "//input[@name='Email']")
    private ExtendedWebElement emailField;

    @FindBy(xpath = "//input[@name='Name']")
    private ExtendedWebElement nameField;

    @FindBy(xpath = "//textarea[@name='Textarea']")
    private ExtendedWebElement questionField;

    @FindBy(xpath = "//button[@type='submit' and text()='Send']")
    private ExtendedWebElement submitButton;

    @FindBy(xpath = "//div[contains(@class,'t-form__successbox')]")
    private ExtendedWebElement successLabel;

    public ContactUsPage(WebDriver driver) {
        super(driver);
    }

    public void typeName(String name) {
        nameField.type(name);
    }

    public void typeEmail(String email) {
        emailField.type(email);
    }

    public void typeQuestion(String question) {
        questionField.type(question);
    }

    public void submit() {
        submitButton.click();
    }

    public boolean isSuccessMessagePresent() {
        return successLabel.isElementPresent();
    }
}
