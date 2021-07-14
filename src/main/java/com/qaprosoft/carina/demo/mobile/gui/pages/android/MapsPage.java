package com.qaprosoft.carina.demo.mobile.gui.pages.android;

import com.qaprosoft.carina.core.foundation.utils.factory.DeviceType;
import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.demo.mobile.gui.pages.common.MapsPageBase;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = MapsPageBase.class)
public class MapsPage extends MapsPageBase {


    @FindBy(xpath = "//android.widget.ImageView[@content-desc='Zoom in']")
    private ExtendedWebElement zoomInBtn;

    @FindBy(xpath = "//android.widget.ImageView[@content-desc='Zoom out']")
    private ExtendedWebElement zoomOutBtn;

    @FindBy(xpath = "//android.view.View[@content-desc='Google Map']")
    private ExtendedWebElement googleMap;

    public MapsPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isPageOpened() {
        return googleMap.isPresent();
    }

    @Override
    public boolean isZoomInPresented() {
       return zoomInBtn.isPresent();
    }

    @Override
    public boolean isZoomOutPresented() {
        return zoomOutBtn.isPresent();
    }

    @Override
    public boolean areBtnsRightOrder() {
       Point zoomInCoord = zoomInBtn.getLocation();
       Point zoomOutCoord = zoomOutBtn.getLocation();
       return (zoomInCoord.y < zoomOutCoord.y);
    }

}
