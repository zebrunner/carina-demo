package com.qaprosoft.carina.core.demo.gui.gsmarena.components.compare;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractUIObject;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class CondidateBlock extends AbstractUIObject {

    @FindBy(xpath = ".//input[contains(@id, 'sSearch')]")
    private ExtendedWebElement inputField;

    @FindBy(xpath = ".//div[contains(@class, 'autocomplete-search')]//a[not(@class)]")
    private List<ExtendedWebElement> autocompleteSearchElements;

    public CondidateBlock(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public void sendKeysToInputField(String text) {
        click(inputField);
        type(inputField, text);
    }

    public void getFirstPhone() {
        click(autocompleteSearchElements.get(0));
    }
}
