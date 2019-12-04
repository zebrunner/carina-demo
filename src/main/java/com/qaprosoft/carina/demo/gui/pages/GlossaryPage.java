package com.qaprosoft.carina.demo.gui.pages;

import java.util.List;
import java.util.stream.Collectors;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import com.sun.java_cup.internal.runtime.virtual_parse_stack;

public class GlossaryPage extends AbstractPage {
	Logger LOGGER = Logger.getLogger(GlossaryPage.class);

	public GlossaryPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(xpath = "//div[@class='st-text']/h3[text()='%s']")
	private ExtendedWebElement itemsLetter;
	
	@FindBy(xpath = "//h1[@class='article-info-name' and text()='Mobile terms glossary']")
	private ExtendedWebElement mobileTermsGlossatyIcon;
	

	public boolean isOpened() {
		LOGGER.info("Page is opened ");
		
		mobileTermsGlossatyIcon.isElementPresent();
		return getDriver().getCurrentUrl().contains("glossary.php3");
	}

	public boolean isGlossarySectionSortedAlphabetically(String s) {
		List<ExtendedWebElement> items = findExtendedWebElements(
				By.xpath(String.format("//div[@class='st-text']/h3[text()='%s']/following-sibling::p[1]/a", s)));
		for (int i = 0, j = i + 1; j < items.size(); i++, j++) {

			if (items.get(i).getText().compareToIgnoreCase(items.get(j).getText()) > 0) {
				return false;
			}
		}
		return true;
	}

	public boolean isStartLetterSectionEqualsTo(String s) {
		List<ExtendedWebElement> items = findExtendedWebElements(
				By.xpath(String.format("//div[@class='st-text']/h3[text()='%s']/following-sibling::p[1]/a", s)));
		List<String> list = items.stream().map(c -> c.getText()).map(c -> c.toUpperCase()).collect(Collectors.toList());

		for (String word : list) {
			if (!word.startsWith(itemsLetter.format(s).getText())) {
				return false;
			}
		}

		return true;
	}

}
