package com.qaprosoft.carina.demo.mobile.gui.web.pages.common;

import com.qaprosoft.carina.core.gui.AbstractPage;
import org.openqa.selenium.WebDriver;

public abstract class ModelInfoPageBase extends AbstractPage {
    public ModelInfoPageBase(WebDriver driver) {
        super(driver);
    }

    public abstract String readDisplay();
    public abstract String readCamera();
    public abstract String readRam();
    public abstract String readBattery();
}
