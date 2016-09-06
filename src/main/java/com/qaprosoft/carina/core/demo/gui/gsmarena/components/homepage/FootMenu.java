package com.qaprosoft.carina.core.demo.gui.gsmarena.components.homepage;

import com.qaprosoft.carina.core.demo.gui.gsmarena.pages.ComparePage;
import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractUIObject;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class FootMenu extends AbstractUIObject {

    @FindBy(xpath = ".//a")
    private List<ExtendedWebElement> menuElementList;

    public FootMenu(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public ComparePage clickMenuElement(String menuElementName) {
        ExtendedWebElement menuElement = getMenuElement(menuElementName);
        menuElement.click();
        return new ComparePage(driver);
    }

    private ExtendedWebElement getMenuElement(String menuElementName) {
        for(ExtendedWebElement menuElement: menuElementList) {
            if(menuElementName.toLowerCase().contains(menuElement.getText().toLowerCase())) {
                return menuElement;
            }
        }
        throw new RuntimeException("Menu element '" + menuElementName + "' is not found");
    }
}
