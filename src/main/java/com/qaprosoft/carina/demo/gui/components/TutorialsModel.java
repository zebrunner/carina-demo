package com.qaprosoft.carina.demo.gui.components;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractUIObject;
import com.qaprosoft.carina.demo.utils.WaitUtil;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class TutorialsModel extends AbstractUIObject {
    public TutorialsModel(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    @FindBy(xpath = ".//md-toolbar[contains(@class,'toolbar')]//md-icon[contains(@class,'material-icons')]")
    private ExtendedWebElement closedTutorialIcon;

    public void closeTutorials() {
        WaitUtil.waitForElementPresent(driver, closedTutorialIcon);
        closedTutorialIcon.click();
    }
}
