package com.qaprosoft.carina.demo.mobile.gui.pages.android;

import com.qaprosoft.carina.core.foundation.utils.factory.DeviceType;
import com.qaprosoft.carina.demo.mobile.gui.pages.common.WebViewPageBase;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import java.util.Set;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = WebViewPageBase.class)
public class WebViewPagePage extends WebViewPageBase {

    private AppiumDriver webViewDriver;
    private final String webViewContext;
    private final String NATIVE_APP = "NATIVE_APP";

    private final By BY_CONTACT_US = By.className("t708__btn");
    private final By BY_EMAIL = By.xpath("//input[@name='Email']");
    private final By BY_NAME = By.xpath("//input[@name='Name']");
    private final By BY_QUESTION = By.xpath("//textarea[@name='Textarea']");
    private final By BY_SUBMIT = By.xpath("//button[@type='submit' and text()='Send']");
    private final By BY_SUCCESS_MESSAGE = By.xpath("//div[contains(@class,'t-form__successbox')]");

    public WebViewPagePage(WebDriver driver) {
        super(driver);
        webViewDriver = (AppiumDriver)(((EventFiringWebDriver) getDriver()).getWrappedDriver());
        Set contextNames = webViewDriver.getContextHandles();
        contextNames.forEach(System.out::println);
        webViewContext = contextNames.toArray()[1].toString();
    }

    @Override
    public void goToContactUsPage() {
        webViewDriver.context(webViewContext);
        webViewDriver.findElement(BY_CONTACT_US).click();
        webViewDriver.context(NATIVE_APP);
    }

    public void fillContactPage() {
        webViewDriver.context(webViewContext);
        webViewDriver.findElement(BY_EMAIL).sendKeys("contact@email.com");
        webViewDriver.findElement(BY_NAME).sendKeys("John Doe");
        webViewDriver.findElement(BY_QUESTION).sendKeys("Your framework is awesome");
        webViewDriver.hideKeyboard();
        webViewDriver.findElement(BY_SUBMIT).click();
        webViewDriver.context(NATIVE_APP);
    }

    public boolean wasSuccessfulMessageSent(){
        boolean found= false;
        webViewDriver.context(webViewContext);
        if (webViewDriver.findElements(BY_SUCCESS_MESSAGE).size()==1){
            found = true;
        }
        webViewDriver.context(NATIVE_APP);
        return found;
    }


}
