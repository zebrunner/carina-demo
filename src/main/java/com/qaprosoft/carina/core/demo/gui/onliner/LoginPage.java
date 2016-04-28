package com.qaprosoft.carina.core.demo.gui.onliner;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;

public class LoginPage extends AbstractPage
{
	@FindBy(xpath="//input[@data-field='login' and @type='text']")
	private ExtendedWebElement loginTextField;
	
	@FindBy(xpath="//input[@data-field='login' and @type='password']")
	private ExtendedWebElement passwordTextField;
	
	@FindBy(xpath="//button[text()='Войти ']")
	private ExtendedWebElement loginButton;

	public LoginPage(WebDriver driver)
	{
		super(driver);
		setPageAbsoluteURL("http://www.onliner.by/#login");
	}
	
	public HomePage login(String login, String password)
	{
		loginTextField.type(login);
		passwordTextField.type(password);
		loginButton.click();
		return new HomePage(driver);
	}
}