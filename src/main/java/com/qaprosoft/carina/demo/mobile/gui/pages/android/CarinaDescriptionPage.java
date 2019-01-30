package com.qaprosoft.carina.demo.mobile.gui.pages.android;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import com.qaprosoft.carina.core.foundation.utils.factory.DeviceType;
import com.qaprosoft.carina.core.foundation.utils.factory.DeviceType.Type;
import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.demo.mobile.gui.pages.common.CarinaDescriptionPageBase;

@DeviceType(pageType = Type.ANDROID_PHONE, parentClass = CarinaDescriptionPageBase.class)
public class CarinaDescriptionPage extends CarinaDescriptionPageBase {

	@FindBy(xpath = "//android.webkit.WebView[@text = 'Carina - open source test automation framework']")
	private ExtendedWebElement webViewTitle;

	@FindBy(xpath = "//android.view.View[@text = 'CARINA facts']")
	private ExtendedWebElement carinaFactsSubTitle;

	public CarinaDescriptionPage(WebDriver driver) {
		super(driver);
	}

	@Override
	public boolean isPageOpened() {
		return webViewTitle.isElementPresent();
	}

}
