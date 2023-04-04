package com.qaprosoft.carina.demo.beatsbydre.gui.desktop;

import com.qaprosoft.carina.demo.beatsbydre.component.desktop.Header;
import com.qaprosoft.carina.demo.beatsbydre.gui.common.HomePageBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

@DeviceType(pageType = DeviceType.Type.DESKTOP, parentClass = HomePageBase.class)
public class HomePage extends HomePageBase {

    @FindBy(className = "pdp-header-section")
    private Header header;

    public HomePage(WebDriver driver) {
        super(driver);
    }

    @Override
    public Header getHeader() {
        return header;
    }
}
