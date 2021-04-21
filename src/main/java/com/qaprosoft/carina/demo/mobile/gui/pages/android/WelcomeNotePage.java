package com.qaprosoft.carina.demo.mobile.gui.pages.android;

import com.qaprosoft.carina.core.foundation.utils.factory.DeviceType;
import com.qaprosoft.carina.core.foundation.utils.mobile.IMobileUtils;
import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = WelcomeNotePageBase.class)
public class WelcomeNotePage extends WelcomeNote implements IMobileUtils {

    @FindBy(id = "btn_start")
    private ExtendedWebElement nextBtn;

    public WelcomeNotePage(WebDriver driver) {
        super(driver);
    }

    @Override
    public HomePageBase clickNextBtn() {
        nextBtn.click();
        return initPage(getDriver(), HomePageBase.class);
    }
}
