package com.qaprosoft.carina.demo.mobile.gui.pages.common;

import com.qaprosoft.carina.core.gui.AbstractPage;
import org.openqa.selenium.WebDriver;

public abstract class MapsPageBase extends AbstractPage {

    public MapsPageBase(WebDriver driver) {
        super(driver);
    }

    public abstract boolean isPageOpened();

    public abstract boolean isZoomInPresented();

    public abstract boolean isZoomOutPresented();

    public abstract boolean areBtnsRightOrder();

}
