package com.qaprosoft.carina.demo.gui.pages.localizationSample;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.foundation.webdriver.decorator.annotations.Localized;
import com.qaprosoft.carina.core.gui.AbstractUIObject;
import org.openqa.selenium.By;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class WikipediaBody extends AbstractUIObject {

    @Localized
    @FindBy(id = "pt-anoncontribs")
    private ExtendedWebElement contribElem;


    @Localized
    @FindBy(id = "pt-anontalk")
    private ExtendedWebElement discussionElem;

    public WikipediaBody(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public void hoverContribElem() {
        contribElem.hover();
    }

    public void clickDiscussionBtn() {
            discussionElem.click();
    }

}
