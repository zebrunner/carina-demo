package com.qaprosoft.carina.demo.mobile.gui.app.pages.android;

import com.qaprosoft.carina.demo.mobile.gui.app.pages.common.MapsPageBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import org.openqa.selenium.WebDriver;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = MapsPageBase.class)
public class MapsPage extends MapsPageBase {

    public MapsPage(WebDriver driver) {
        super(driver);
    }

}
