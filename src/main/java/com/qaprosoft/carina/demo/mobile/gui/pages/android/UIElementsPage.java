package com.qaprosoft.carina.demo.mobile.gui.pages.android;

import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebDriver;

import com.qaprosoft.carina.demo.mobile.gui.pages.common.UIElementsPageBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.utils.mobile.IMobileUtils;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = UIElementsPageBase.class)
public class UIElementsPage extends UIElementsPageBase implements IMobileUtils {

    @AndroidFindBy(id = "editText%s")
    private ExtendedWebElement textField;

    @AndroidFindBy(id = "checkBox2")
    private ExtendedWebElement checkBoxButton;

    @AndroidFindBy(id = "radioButton")
    private ExtendedWebElement maleRadioButton;

    @AndroidFindBy(id = "radioButton3")
    private ExtendedWebElement femaleRadioButton;

    @AndroidFindBy(id = "radioButton5")
    private ExtendedWebElement otherRadioButton;

    @AndroidFindBy(className = "android.widget.ScrollView")
    private ExtendedWebElement container;

    public UIElementsPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public void typeText(String text) {
        textField.format("").type(text);
    }

    @Override
    public String getText(){
        return textField.format("").getText();
    }


    @Override
    public void typeEmail(String email) {
        textField.format("2").type(email);
    }

    @Override
    public String getEmail(){
        return textField.format("2").getText();
    }

    @Override
    public String getDate(){
        return textField.format("3").getText();
    }

    @Override
    public void typeDate(String date) {
        textField.format("3").type(date);
    }

    @Override
    public void clickOnMaleRadioButton() {
        maleRadioButton.click();
    }

    @Override
    public void clickOnFemaleRadioButton() {
        femaleRadioButton.click();
    }

    @Override
    public void clickOnOtherRadioButton() {
        otherRadioButton.click();
    }

    @Override
    public boolean isFemaleRadioButtonSelected(){
        return femaleRadioButton.isChecked();
    }

    @Override
    public boolean isOthersRadioButtonSelected(){
        return otherRadioButton.isChecked();
    }

    @Override
    public void checkCopy() {
        checkBoxButton.click();
    }

    @Override
    public boolean isCopyChecked(){
        return checkBoxButton.isChecked();
    }

    public void swipeToFemaleRadioButton() {
        swipe(femaleRadioButton, container, 10);
    }

}
