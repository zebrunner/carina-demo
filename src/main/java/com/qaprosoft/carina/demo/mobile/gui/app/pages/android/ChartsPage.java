package com.qaprosoft.carina.demo.mobile.gui.app.pages.android;

import com.qaprosoft.carina.demo.mobile.gui.app.pages.common.ChartsPageBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import org.openqa.selenium.WebDriver;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = ChartsPageBase.class)
public class ChartsPage extends ChartsPageBase {

    public ChartsPage(WebDriver driver) {
        super(driver);
    }

}
