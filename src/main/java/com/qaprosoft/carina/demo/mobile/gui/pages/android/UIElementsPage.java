package com.qaprosoft.carina.demo.mobile.gui.pages.android;

import com.qaprosoft.carina.core.foundation.utils.factory.DeviceType;
import com.qaprosoft.carina.core.foundation.utils.mobile.MobileUtils;
import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.demo.mobile.gui.pages.common.UIElementsPageBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = UIElementsPageBase.class)
public class UIElementsPage extends UIElementsPageBase {
    @FindBy(id = "editText")
    private ExtendedWebElement textField;

    @FindBy(id = "editText2")
    private ExtendedWebElement emailField;

    @FindBy(id = "editText3")
    private ExtendedWebElement dateField;

    @FindBy(id = "checkBox2")
    private ExtendedWebElement checkBoxButton;

    @FindBy(id = "radioButton")
    private ExtendedWebElement maleRadioButton;

    @FindBy(id = "radioButton3")
    private ExtendedWebElement femaleRadioButton;

    @FindBy(id = "radioButton5")
    private ExtendedWebElement otherRadioButton;

    @FindBy(id = "radioButton5")
    private ExtendedWebElement seekBarRadioButton;

    @FindBy(className = "android.widget.ScrollView")
    private ExtendedWebElement container;

    public void typeText(String text) {
        textField.type(text);
    }

    public void typeEmail(String email) {
        emailField.type(email);
    }

    public void typeDate(String date) {
        dateField.type(date);
    }

    public void clickOnMaleRadioButton() {
        maleRadioButton.click();
    }

    public void clickOnFemaleRadioButton() {
        femaleRadioButton.click();
    }

    public void clickOnOtherRadioButton() {
        otherRadioButton.click();
    }

    @Override
    public void checkCopy() {
        MobileUtils.swipe(femaleRadioButton, container, 10);
        checkBoxButton.click();
    }

    public UIElementsPage(WebDriver driver) {
        super(driver);
    }

}
