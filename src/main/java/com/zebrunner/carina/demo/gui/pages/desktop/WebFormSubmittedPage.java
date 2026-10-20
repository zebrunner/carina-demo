package com.zebrunner.carina.demo.gui.pages.desktop;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.decorator.PageOpeningStrategy;
import com.zebrunner.carina.webdriver.gui.AbstractPage;

public class WebFormSubmittedPage extends AbstractPage {

    @FindBy(id = "message")
    private ExtendedWebElement message;

    public WebFormSubmittedPage(WebDriver driver) {
        super(driver);
        setUiLoadedMarker(message);
        setPageOpeningStrategy(PageOpeningStrategy.BY_ELEMENT);
    }

    public String getMessage() {
        return message.getText();
    }

    public String getSubmittedQuery() {
        return getDriver().getCurrentUrl();
    }
}
