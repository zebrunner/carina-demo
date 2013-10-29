package com.qaprosoft.carina.core.demo.gui.mobile;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractScreen;

public class MobileScreen extends AbstractScreen
{
	@FindBy(xpath="//window[1]/textfield[1]")
	public ExtendedWebElement operand1TextField;
	
	@FindBy(xpath="//window[1]/textfield[2]")
	public ExtendedWebElement operand2TextField;
	
	@FindBy(name="ComputeSumButton")
	public ExtendedWebElement computeSumButton;
	
	@FindBy(xpath="//window[1]/text[1]")
	public ExtendedWebElement sumLabel;
	
	@FindBy(name="show alert")
	public ExtendedWebElement showAlertButton;
	
	@FindBy(xpath="//window[1]/slider[1]")
	public ExtendedWebElement slider;
	
	@FindBy(name="Test Gesture")
	public ExtendedWebElement testGestureButton;
	
	public MobileScreen(WebDriver driver)
	{
		super(driver);
	}
	
	public String performSum(String oper1, String oper2)
	{
		type(operand1TextField, oper1);
		type(operand2TextField, oper2);
		click(computeSumButton);
		return sumLabel.getText();
	}

	@Override
	public boolean isOpened()
	{
		return isElementPresent(computeSumButton);
	}
}
