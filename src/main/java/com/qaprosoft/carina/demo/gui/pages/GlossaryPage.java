package com.qaprosoft.carina.demo.gui.pages;

import static com.qaprosoft.carina.core.foundation.webdriver.IDriverPool.LOGGER;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import org.hibernate.validator.constraints.Length;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.owlike.genson.convert.DefaultConverters.PrimitiveConverterFactory.booleanConverter;
import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;

public class GlossaryPage extends AbstractPage {

	public GlossaryPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(xpath = "//div[@class='st-text']/h3[text()='%s']/following-sibling::p[1]")
	private List<ExtendedWebElement> items;

	@FindBy(xpath = "//div[@class='st-text']/h3[text()='%s']")
	private List<ExtendedWebElement> itemsLetter;

	public boolean isOpened() {
		LOGGER.info("Page is opened ");
		return getDriver().getCurrentUrl().contains("glossary.php3");
	}

	public boolean isGlossarySectionSortedAlphabetically(String s) {

		for (int i = 0, j = i + 1; j < items.size(); i++, j++) {

			if (items.get(i).format(s).getText().compareToIgnoreCase(items.get(j).getText()) < 0) {
				return false;
			}
		}
		return true;
	}

	public boolean isStartLetterSectionEqualsTo(String str) {
		List<String> list = items.stream().map(c -> c.getText()).collect(Collectors.toList());

		for (String word : list) {
			if (!word.startsWith(str)) {
				return false;
			}
		}

		return true;
	}

}
