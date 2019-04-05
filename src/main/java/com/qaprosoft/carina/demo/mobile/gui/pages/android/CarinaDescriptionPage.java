package com.qaprosoft.carina.demo.mobile.gui.pages.android;

import com.qaprosoft.carina.demo.mobile.gui.pages.common.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import com.qaprosoft.carina.core.foundation.utils.factory.DeviceType;
import com.qaprosoft.carina.core.foundation.utils.factory.DeviceType.Type;
import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;

@DeviceType(pageType = Type.ANDROID_PHONE, parentClass = CarinaDescriptionPageBase.class)
public class CarinaDescriptionPage extends CarinaDescriptionPageBase {

	@FindBy(xpath = "//android.webkit.WebView[@text = 'Carina - open source test automation framework']")
	private ExtendedWebElement webViewTitle;

	@FindBy(xpath = "//android.view.View[@text = 'CARINA facts']")
	private ExtendedWebElement carinaFactsSubTitle;

	@FindBy(xpath = "//android.widget.CheckedTextView[@text = 'Web View']")
	private ExtendedWebElement webviewLink;

	@FindBy(xpath = "//android.widget.CheckedTextView[@text = 'ChartsPage']")
	private ExtendedWebElement chartsLink;

	@FindBy(xpath = "//android.widget.CheckedTextView[@text = 'Map']")
	private ExtendedWebElement mapLink;

	@FindBy(xpath = "//android.widget.CheckedTextView[@text = 'UI elements']")
	private ExtendedWebElement uiElementsLink;


	@FindBy(className = "android.widget.ImageButton")
	private ExtendedWebElement leftMenuButton;

	public CarinaDescriptionPage(WebDriver driver) {
		super(driver);
	}

	@Override
	public WebViewPageBase navigateToWebviewPage() {
		leftMenuButton.click();
		webviewLink.click();
		return initPage(getDriver(), WebViewPageBase.class);
	}

	@Override
	public ChartsPageBase navigateToChartsPage() {
		leftMenuButton.click();
		chartsLink.click();
		return initPage(getDriver(), ChartsPageBase.class);
	}

	@Override
	public MapsPageBase navigateToMapPage() {
		leftMenuButton.click();
		mapLink.click();
		return initPage(getDriver(), MapsPageBase.class);
	}

	@Override
	public UIElementsPageBase navigateToUIElementsPage() {
		leftMenuButton.click();
		uiElementsLink.click();
		return initPage(getDriver(), UIElementsPageBase.class);
	}

	@Override
	public boolean isPageOpened() {
		return webViewTitle.isElementPresent();
	}

}
