package com.qaprosoft.carina.core.demo.gui.gsmarena.components;

import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import com.qaprosoft.carina.core.demo.gui.gsmarena.pages.CompareModelsPage;
import com.qaprosoft.carina.core.demo.gui.gsmarena.pages.HomePage;
import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractUIObject;

public class FooterMenu extends AbstractUIObject
{
	@FindBy(linkText = "Home")
	private ExtendedWebElement homeLink;

	@FindBy(linkText = "Compare")
	private ExtendedWebElement compareLink;

	public FooterMenu(WebDriver driver, SearchContext searchContext)
	{
		super(driver, searchContext);
	}

	public HomePage openHomePage()
	{
		homeLink.click();
		return new HomePage(driver);
	}

	public CompareModelsPage openComparePage()
	{
		compareLink.click();
		return new CompareModelsPage(driver);
	}
}
