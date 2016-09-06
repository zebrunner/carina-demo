package com.qaprosoft.carina.core.demo.gui.gsmarena.components.comparepage;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractUIObject;
import org.apache.log4j.Logger;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class CompareRow extends AbstractUIObject {

    private static final Logger LOG = Logger.getLogger(CompareRow.class);

    @FindBy(xpath = ".//td/a[not(@class)]")
    private ExtendedWebElement rowName;

    @FindBy(xpath = ".//td[@class='nfo']")
    private List<ExtendedWebElement> rowData;

    public CompareRow(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public String getRowName() {
        return rowName.getText();
    }

    public void printRows() {
        for(ExtendedWebElement rowText: rowData) {
            LOG.info(rowText.getText());
        }
    }
}
