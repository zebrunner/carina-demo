package com.qaprosoft.carina.core.demo.gui.gsmarena.components.comparepage;

import com.qaprosoft.carina.core.gui.AbstractUIObject;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class CompareCondidatesBlock extends AbstractUIObject {

    @FindBy(xpath = ".//div[contains(@class, 'compare-col')]")
    private List<CompareColumn> compareColumnList;

    public CompareCondidatesBlock(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public CompareColumn getCompareColumn(Integer index) {
        return compareColumnList.get(index - 1);
    }
}
