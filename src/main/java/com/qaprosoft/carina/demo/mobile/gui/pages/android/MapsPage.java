package com.qaprosoft.carina.demo.mobile.gui.pages.android;

import com.qaprosoft.carina.core.foundation.utils.factory.DeviceType;
import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.foundation.webdriver.locator.ExtendedFindBy;
import com.qaprosoft.carina.demo.mobile.gui.pages.common.MapsPageBase;
import com.qaprosoft.carina.demo.mobile.gui.pages.common.WebViewPageBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = MapsPageBase.class)
public class MapsPage extends MapsPageBase {

    @ExtendedFindBy(androidUIAutomator = "new UiSelector().description(\"Zoom in\")")
    private ExtendedWebElement zoomInButton;

    @ExtendedFindBy(androidUIAutomator = "new UiSelector().description(\"Zoom out\")")
    private ExtendedWebElement zoomOutButton;

    @ExtendedFindBy(androidUIAutomator = "new UiSelector().className(\"android.widget.TextView\").text(\"Map\")")
    private ExtendedWebElement title;

//    @FindBy(xpath = "//android.widget.TextView[@text='Map']")
//    private ExtendedWebElement title;

    public MapsPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isZoomInButtonPresent() {
        return zoomInButton.isElementPresent();
    }

    @Override
    public boolean isZoomOutButtonPresent() {
        return zoomOutButton.isElementPresent();
    }

    @Override
    public boolean isZoomInAboutZoomOutButton() {
        int zoomIn = zoomInButton.getLocation().getY();
        int zoomOut = zoomOutButton.getLocation().getY();
        if (zoomIn < zoomOut) {
            return true;
        }
        return false;
    }

    @Override
    public boolean isPageOpened() {
        return title.isElementPresent();
    }
}
