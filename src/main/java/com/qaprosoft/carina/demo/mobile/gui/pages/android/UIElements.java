package com.qaprosoft.carina.demo.mobile.gui.pages.android;

import com.qaprosoft.carina.core.foundation.utils.factory.DeviceType;
import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.demo.mobile.gui.pages.common.UIElementsBase;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import static io.appium.java_client.touch.offset.PointOption.point;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = UIElementsBase.class)
public class UIElements extends UIElementsBase {
    @FindBy(id = "editText")
    private ExtendedWebElement text;

    @FindBy(id = "editText2")
    private ExtendedWebElement email;

    @FindBy(id = "editText3")
    private ExtendedWebElement date;


    @FindBy(id = "checkBox2")
    private ExtendedWebElement checkBox;

    @FindBy(id = "radioButton")
    private ExtendedWebElement maleRadioButton;

    @FindBy(id = "radioButton3")
    private ExtendedWebElement femaleRadioButton;

    @FindBy(id = "radioButton5")
    private ExtendedWebElement otherRadioButton;

    @FindBy(id = "radioButton5")
    private ExtendedWebElement seekBar;


    public void fillInText(String text) {
        this.text.type(text);
    }

    public void fillInEmail(String email) {
        this.email.type(email);
    }

    public void fillInDate(String date) {
        this.date.type(date);
    }

    public void selectMale() {
        this.maleRadioButton.click();
    }

    public void selectFemale() {
        this.femaleRadioButton.click();
    }

    public void selectOther() {
        this.otherRadioButton.click();
    }

    @Override
    public void checkCopy() {
        ScrollToElement(checkBox);
        this.checkBox.click();
    }


    public UIElements(WebDriver driver) {
        super(driver);
    }

    private AndroidElement ScrollToElement(ExtendedWebElement element) {
        AndroidDriver driver = (AndroidDriver) (((EventFiringWebDriver) getDriver()).getWrappedDriver());
        AndroidElement output = null;
        int numberOfTimes = 10;
        Dimension size = driver.manage().window().getSize();
        int anchor = size.width / 2;
        // Swipe up to scroll down
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
