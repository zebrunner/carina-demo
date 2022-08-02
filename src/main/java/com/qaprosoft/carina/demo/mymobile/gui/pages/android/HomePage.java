package com.qaprosoft.carina.demo.mymobile.gui.pages.android;

import com.qaprosoft.carina.core.foundation.utils.factory.DeviceType;
import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.demo.mymobile.gui.pages.common.HomePageBase;
import com.qaprosoft.carina.demo.mymobile.gui.pages.common.RegisterPageBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = HomePageBase.class)
public class HomePage extends HomePageBase {

    @FindBy(id = "carina_logo")
    private ExtendedWebElement carinaLogo;

    @FindBy(id = "next_button")
    ExtendedWebElement nextBtn;

    public HomePage(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isNextBtnPresent() {
        return nextBtn.isElementPresent();
    }

    @Override
    public boolean isCarinaLogoPresent() {
        return carinaLogo.isElementPresent();
    }

    @Override
    public RegisterPageBase clickNextBtn() {
        nextBtn.click();
        return initPage(getDriver(), RegisterPageBase.class);
    }
}
