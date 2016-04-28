package com.qaprosoft.carina.core.demo.gui.onliner;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;

public class HomePage extends AbstractPage
{
	@FindBy(xpath="//div[text()='Вход ']")
	private ExtendedWebElement loginLink;
	
	@FindBy(xpath="//p[@class='user-name']/a")
	private ExtendedWebElement usernameLink;
	
	public HomePage(WebDriver driver)
	{
		super(driver);
		setPageAbsoluteURL("http://www.onliner.by");
	}
	
	public LoginPage openLoginPage()
	{
		loginLink.click();
		return new LoginPage(driver);
	}
	
	public boolean isUserLoggedIn(String username)
	{
		return usernameLink.isElementWithTextPresent(username);
	}
}