package com.qaprosoft.carina.demo.mobile.gui.pages.common;

import com.qaprosoft.carina.core.gui.AbstractPage;
import com.zebrunner.carina.utils.mobile.IMobileUtils;
import org.openqa.selenium.WebDriver;

public abstract class WebViewPageBase extends AbstractPage implements IMobileUtils {

    public WebViewPageBase(WebDriver driver) {
        super(driver);
    }

    public abstract ContactUsPageBase goToContactUsPage();

}
