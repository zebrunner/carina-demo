package com.qaprosoft.carina.core.demo.gui.gsmarena.components.comparepage;

import com.qaprosoft.carina.core.gui.AbstractUIObject;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class CondidateDescriptionBlock extends AbstractUIObject {

    @FindBy(xpath = ".//table")
    private List<CompareDescriptionTable> compareDescriptionTableList;

    public CondidateDescriptionBlock(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public CompareDescriptionTable getCompareDescriptionTable(String tableName) {
        for(CompareDescriptionTable compareDescriptionTable: compareDescriptionTableList) {
            if(compareDescriptionTable.getTableName().toLowerCase().contains(tableName.toLowerCase())) {
                return compareDescriptionTable;
            }
        }
        throw new RuntimeException("Table '" + tableName + "' is not found");
    }
}
