package com.qaprosoft.carina.core.demo.gui.gsmarena.components.compare;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractUIObject;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class CompareColumn extends AbstractUIObject
{
	@FindBy(xpath = ".//input[contains(@id, 'sSearch')]")
	private ExtendedWebElement inputField;

	@FindBy(xpath = ".//input[@type='submit']")
	private ExtendedWebElement submitBtn;

	@FindBy(xpath = ".//div[contains(@class, 'autocomplete-search')]")
	private AutocompleteSearch autocompleteSearch;

	public CompareColumn(WebDriver driver, SearchContext searchContext)
	{
		super(driver, searchContext);
	}

	public void sendKeysToInputFieldAndClick(String data, Integer index)
	{
		click(inputField);
		type(inputField, data);
		clickAutocompleteSearchItem(index);
	}

	private void clickAutocompleteSearchItem(Integer index)
	{
		autocompleteSearch.getElement(index).click();
	}
}
