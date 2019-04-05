package com.qaprosoft.carina.demo.mobile.gui.pages.android;

import com.qaprosoft.carina.core.foundation.utils.factory.DeviceType;
import com.qaprosoft.carina.core.foundation.utils.mobile.MobileUtils;
import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.demo.mobile.gui.pages.common.WebViewPageBase;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import java.util.Set;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = WebViewPageBase.class)
public class WebViewPage extends WebViewPageBase {

    private AppiumDriver webViewDriver;
    private final String webViewContext;
    private final String NATIVE_APP = "NATIVE_APP";

    @FindBy(className = "t708__btn")
    private ExtendedWebElement contactUsLink;

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

    public WebViewPage(WebDriver driver) {
        super(driver);
        webViewDriver = (AppiumDriver) (((EventFiringWebDriver) getDriver()).getWrappedDriver());
        Set contextNames = webViewDriver.getContextHandles();
        contextNames.forEach(System.out::println);
        webViewContext = contextNames.toArray()[1].toString();
    }

    @Override
    public void goToContactUsPage() {
        webViewDriver.context(webViewContext);
        webViewDriver.findElement(contactUsLink.getBy()).click();
        webViewDriver.context(NATIVE_APP);
    }

    public void fillContactPage() {
        final String EMAIL = "contact@email.com";
        final String NAME = "John Doe";
        final String MESSAGE = "Your framework is awesome";
        webViewDriver.context(webViewContext);
        webViewDriver.findElement(emailField.getBy()).sendKeys(EMAIL);
        webViewDriver.findElement(nameField.getBy()).sendKeys(NAME);
        webViewDriver.findElement(questionField.getBy()).sendKeys(MESSAGE);
        MobileUtils.hideKeyboard();
        webViewDriver.findElement(submitButton.getBy()).click();
        webViewDriver.context(NATIVE_APP);
    }

    public boolean isSuccessfullMessagePresent() {
        boolean found = false;
        webViewDriver.context(webViewContext);
        if (webViewDriver.findElements(successLabel.getBy()).size() == 1) {
            found = true;
        }
        webViewDriver.context(NATIVE_APP);
        return found;
    }

}
