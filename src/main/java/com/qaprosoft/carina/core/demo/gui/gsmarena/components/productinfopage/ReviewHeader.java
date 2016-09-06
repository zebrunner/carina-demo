package com.qaprosoft.carina.core.demo.gui.gsmarena.components.productinfopage;

import com.qaprosoft.carina.core.gui.AbstractUIObject;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import java.util.List;

public class ReviewHeader extends AbstractUIObject {

    @FindBy(xpath = ".//li[contains(@class, 'help accented')]")
    private List<AccentedElement> accentedElementList;

    public ReviewHeader(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public void checkElementText(String actualName, String actualText) {
        Assert.assertTrue(checkElementTextByName(actualName, actualText), "Element is not contains text '" + actualText + "'");
    }

    private boolean checkElementTextByName(String actualName, String actualText) {
        for(AccentedElement accentedElement: accentedElementList) {
            if(accentedElement.getElementName().contains(actualName.toLowerCase())) {
                return accentedElement.getElementText().toLowerCase().contains(actualText.toLowerCase());
            }
        }
        throw new RuntimeException("Element with name '" + actualName + "' is not found");
    }
}
