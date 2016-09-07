package com.qaprosoft.carina.core.demo.gui.gsmarena.pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import com.qaprosoft.carina.core.demo.gui.gsmarena.components.FooterMenu;
import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;

public class HomePage extends AbstractPage
{
	@FindBy(id = "footmenu")
	private FooterMenu footerMenu;
	
	@FindBy(xpath = "//div[contains(@class, 'brandmenu-v2')]//a")
	private List<ExtendedWebElement> brandLinks;

	public HomePage(WebDriver driver)
	{
		super(driver);
		setPageAbsoluteURL("http://www.gsmarena.com");
	}

	public FooterMenu getFooterMenu()
	{
		return footerMenu;
	}
	
	public BrandModelsPage selectBrand(String brand)
	{
		for(ExtendedWebElement brandLink : brandLinks)
		{
			if(brand.equalsIgnoreCase(brandLink.getText()))
			{
				brandLink.click();
				return new BrandModelsPage(driver);
			}
		}
		throw new RuntimeException("Unable to open brand: " + brand);
	}
}
