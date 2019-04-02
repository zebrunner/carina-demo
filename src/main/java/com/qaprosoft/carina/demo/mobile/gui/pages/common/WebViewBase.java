package com.qaprosoft.carina.demo.mobile.gui.pages.common;

import com.qaprosoft.carina.core.gui.AbstractPage;
import org.openqa.selenium.WebDriver;

public abstract class WebViewBase extends AbstractPage {

    public WebViewBase(WebDriver driver) {
        super(driver);
    }

    public abstract void goToContactUsPage();

    public abstract void fillContactPage();

    public abstract boolean wasSuccessfulMessageSent();


}
