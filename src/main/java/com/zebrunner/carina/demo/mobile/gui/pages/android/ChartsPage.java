package com.zebrunner.carina.demo.mobile.gui.pages.android;

import com.zebrunner.carina.demo.mobile.gui.pages.common.ChartsPageBase;
import org.openqa.selenium.WebDriver;

import com.zebrunner.carina.utils.factory.DeviceType;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = ChartsPageBase.class)
public class ChartsPage extends ChartsPageBase {

    public ChartsPage(WebDriver driver) {
        super(driver);
    }

}
