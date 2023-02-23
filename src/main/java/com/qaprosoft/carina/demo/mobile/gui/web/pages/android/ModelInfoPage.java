package com.qaprosoft.carina.demo.mobile.gui.web.pages.android;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.demo.mobile.gui.web.pages.common.ModelInfoPageBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = ModelInfoPageBase.class)
public class ModelInfoPage extends ModelInfoPageBase {
    @FindBy(xpath = "//span[@data-spec='displaysize-hl']")
    private ExtendedWebElement displayInfoLabel;

    @FindBy(xpath = "//span[@data-spec='camerapixels-hl']")
    private ExtendedWebElement cameraInfoLabel;

    @FindBy(xpath = "//span[@data-spec='ramsize-hl']")
    private ExtendedWebElement displayRamLabel;

    @FindBy(xpath = "//span[@data-spec='batsize-hl']")
    private ExtendedWebElement batteryInfoLabel;

    public ModelInfoPage(WebDriver driver) {
        super(driver);
    }

    public String readDisplay() {
        assertElementPresent(displayInfoLabel);
        return displayInfoLabel.getText();
    }

    public String readCamera() {
        assertElementPresent(cameraInfoLabel);
        return cameraInfoLabel.getText();
    }

    public String readRam() {
        assertElementPresent(displayRamLabel);
        return displayRamLabel.getText();
    }

    public String readBattery() {
        assertElementPresent(displayInfoLabel);
        return batteryInfoLabel.getText();
    }
}
