package com.qaprosoft.carina.demo.mobile.gui.pages.android;

import com.qaprosoft.carina.core.foundation.utils.factory.DeviceType;
import com.qaprosoft.carina.core.foundation.utils.mobile.MobileUtils;
import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.demo.mobile.gui.pages.common.UIElementsPageBase;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import static io.appium.java_client.touch.offset.PointOption.point;

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
    private ExtendedWebElement seekBarButton;

    public void typeText(String text) {
        textField.type(text);
    }

    public void typeEmail(String email) {
        emailField.type(email);
    }

    public void typeDate(String date) {
        dateField.type(date);
    }

    public void selectMale() {
        maleRadioButton.click();
    }

    public void selectFemale() {
        femaleRadioButton.click();
    }

    public void selectOther() {
        otherRadioButton.click();
    }

    @Override
    public void checkCopy() {
        MobileUtils.swipe(checkBoxButton, MobileUtils.Direction.DOWN);
        checkBoxButton.click();
    }

    public UIElementsPage(WebDriver driver) {
        super(driver);
    }

    private AndroidElement scrollToElement(ExtendedWebElement element) {
        AndroidDriver driver = (AndroidDriver) (((EventFiringWebDriver) getDriver()).getWrappedDriver());
        AndroidElement output = null;
        int numberOfTimes = 10;
        Dimension size = driver.manage().window().getSize();
        int anchor = size.width / 2;
        int startPoint = size.height - 10;
        int endPoint = size.height / 2;

        for (int i = 0; i < numberOfTimes; i++) {
            try {
                new TouchAction(driver)
                        .longPress(point(anchor, startPoint))
                        .moveTo(point(anchor, endPoint))
                        .release()
                        .perform();
                output = (AndroidElement) driver.findElement(element.getBy());
                i = numberOfTimes;
            } catch (NoSuchElementException ex) {
                System.out.println(String.format("Element not available. Scrolling (%s) times...", i + 1));
            }
        }
        return output;
    }
}
