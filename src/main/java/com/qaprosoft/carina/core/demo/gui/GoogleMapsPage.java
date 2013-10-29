/*
 * Copyright 2013 QAPROSOFT (http://qaprosoft.com/).
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.qaprosoft.carina.core.demo.gui;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;

public class GoogleMapsPage extends AbstractPage 
{
	@FindBy(name="q")
	public ExtendedWebElement searchTextField;
	
	@FindBy(id="gbqfb")
	public ExtendedWebElement searchButton;
	
	@FindBy(linkText="Get directions")
	public ExtendedWebElement getDirectionsLink;
	
	@FindBy(id="d_sub")
	public ExtendedWebElement getDirectionsButton;

	@FindBy(id="d_d")
	public ExtendedWebElement pointATextField;
	
	@FindBy(id="d_daddr")
	public ExtendedWebElement pointBTextField;
	
	@FindBy(xpath="//div[@class='dir-altroute-inner']")
	public List<ExtendedWebElement> routes;
	
	public GoogleMapsPage(WebDriver driver) 
	{
		super(driver);
		setPageAbsoluteURL("https://maps.google.com/");
	}
	
	public void search(String q)
	{
		type(searchTextField, q);
		click(searchButton);
	}
	
	public List<ExtendedWebElement> getDirections(String from, String to)
	{
		type(pointATextField, from);
		pressEnter(pointATextField);
		type(pointBTextField, to);
		pressEnter(pointBTextField);
		click(getDirectionsButton);
		pause(5);
		return routes;
	}
}
