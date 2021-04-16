package com.qaprosoft.carina.demo.mobile.gui.pages.android;

import com.qaprosoft.carina.core.foundation.utils.factory.DeviceType;
import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.foundation.webdriver.locator.ExtendedFindBy;
import com.qaprosoft.carina.demo.mobile.gui.pages.common.ContactUsPageBase;
import com.qaprosoft.carina.demo.mobile.gui.pages.common.WebViewPageBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = WebViewPageBase.class)
public class WebViewPage extends WebViewPageBase {

    @FindBy(className = "t708__btn")
    private ExtendedWebElement contactUsLink;

//    @FindBy(id = "content_frame")
//    private ExtendedWebElement webViewContent;

    @ExtendedFindBy(androidUIAutomator = "new UiSelector().resourceIdMatches(\".*id/content_frame\")")
    private ExtendedWebElement webViewContent;

    public WebViewPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public ContactUsPageBase goToContactUsPage() {
        contactUsLink.click();
        return initPage(getDriver(), ContactUsPageBase.class);
    }

    @Override
    public boolean isPageOpened() {
        return webViewContent.isElementPresent();
    }
}
