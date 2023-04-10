package com.qaprosoft.carina.demo.beatsbydre.gui.android;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import com.qaprosoft.carina.demo.beatsbydre.component.android.RegistrationError;
import com.qaprosoft.carina.demo.beatsbydre.gui.common.RegisterBeatsPageBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.decorator.PageOpeningStrategy;
import com.zebrunner.carina.webdriver.decorator.annotations.Localized;
import com.zebrunner.carina.webdriver.locator.Context;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = RegisterBeatsPageBase.class)
public class RegisterBeatsPage extends RegisterBeatsPageBase {

    @Localized(focus = Localized.NameFocus.CLASS_DECLARE)
    @FindBy(tagName = "h1")
    private ExtendedWebElement pageTitle;

    @FindBy(id = "serialnum")
    private ExtendedWebElement serNumberField;

    @Localized(focus = Localized.NameFocus.CLASS_DECLARE)
    @Context(dependsOn = "serNumberField")
    @FindBy(xpath = ".//following-sibling::a")
    private ExtendedWebElement howToFindSerNumberLink;

    @Localized(focus = Localized.NameFocus.CLASS_DECLARE)
    @FindBy(xpath = "//button[@class='beats-btn beats-btn--button validate-serial-num']")
    private ExtendedWebElement verifySerNumberButton;

    @Localized(focus = Localized.NameFocus.CLASS_DECLARE)
    @FindBy(xpath = "//*[contains(@class,'serial-number-invalid-length registration-invalid-input-field')]")
    private ExtendedWebElement lengthErrMsg;

    @Localized(focus = Localized.NameFocus.CLASS_DECLARE)
    @FindBy(xpath = "//*[contains(@class,'serial-number-invalid-chars registration-invalid-input-field')]")
    private ExtendedWebElement invalidCharsErrMsg;

    @Localized(focus = Localized.NameFocus.CLASS_DECLARE)
    @FindBy(xpath = "//*[contains(@class,'serial-number-empty-input registration-invalid-input-field')]")
    private ExtendedWebElement emptyInputErrMsg;

    @FindBy(xpath = "//div[@class='modal-inner' and @role='dialog']")
    private RegistrationError registrationError;

    public RegisterBeatsPage(WebDriver driver) {
        super(driver);
        setPageOpeningStrategy(PageOpeningStrategy.BY_ELEMENT);
        setUiLoadedMarker(pageTitle);
    }

    public String getPageTitle() {
        return pageTitle.getText();
    }

    public void typeSerNumberField(String input) {
        serNumberField.type(input);
    }

    public String getHowToFindSerNumberLink() {
        return howToFindSerNumberLink.getText();
    }

    public void verifySerNumber() {
        verifySerNumberButton.click();
    }

    public String getLengthErrMsg() {
        if (lengthErrMsg.isVisible()) {
            return lengthErrMsg.getText();
        } else {
            return "";
        }
    }

    public String getInvalidCharsErrMsg() {
        if (invalidCharsErrMsg.isVisible()) {
            return invalidCharsErrMsg.getText();
        } else {
            return "";
        }
    }

    public String getEmptyInputErrMsg() {
        if (emptyInputErrMsg.isVisible()) {
            return emptyInputErrMsg.getText();
        } else {
            return "";
        }
    }

    public RegistrationError getRegistrationError() {
        return registrationError;
    }
}
