package com.qaprosoft.carina.core.demo.gui.gsmarena.components.productinfopage;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractUIObject;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class AccentedElement extends AbstractUIObject {

    @FindBy(xpath = ".")
    private ExtendedWebElement elementName;

    @FindBy(xpath = ".//strong")
    private ExtendedWebElement elementText;

    @FindBy(xpath = ".")
    private ExtendedWebElement elementDescription;

    public AccentedElement(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public String getElementText() {
        return elementText.getText();
    }

    public String getElementName() {
        return elementName.getAttribute("class");
    }
}
