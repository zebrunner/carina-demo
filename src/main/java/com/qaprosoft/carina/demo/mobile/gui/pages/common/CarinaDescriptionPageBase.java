package com.qaprosoft.carina.demo.mobile.gui.pages.common;

import com.qaprosoft.carina.core.gui.AbstractPage;
import org.openqa.selenium.WebDriver;

public abstract class CarinaDescriptionPageBase extends AbstractPage {

	public CarinaDescriptionPageBase(WebDriver driver) {
		super(driver);
	}

	public abstract WebViewBase navitateToWebview();

	public abstract ChartsBase navigateToCharts();

	public abstract MapsBase navigateToMap();

	public abstract UIElementsBase navigateToUIElements();

}
