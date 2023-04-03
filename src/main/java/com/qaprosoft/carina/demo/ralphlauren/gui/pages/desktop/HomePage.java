package com.qaprosoft.carina.demo.ralphlauren.gui.pages.desktop;

import com.qaprosoft.carina.demo.ralphlauren.gui.component.Header;
import com.qaprosoft.carina.demo.ralphlauren.gui.pages.common.HomePageBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

@DeviceType(pageType = DeviceType.Type.DESKTOP, parentClass = HomePageBase.class)
public class HomePage extends HomePageBase {
    @FindBy(className = "transparent inverse navy show-promotion")
    private Header header;

    public HomePage(WebDriver driver) {
        super(driver);
    }

    @Override
    public Header getHeader() {
        return header;
    }
}
