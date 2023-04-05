package com.qaprosoft.carina.demo.beatsbydre.component.android;

import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import com.qaprosoft.carina.demo.beatsbydre.component.common.AbstractRegistrationError;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.decorator.annotations.Localized;

public class RegistrationError extends AbstractRegistrationError {
    @FindBy(xpath = ".//button[@class='modal-close']")
    private ExtendedWebElement closeButton;

    @Localized
    @FindBy(xpath = ".//h2//div")
    private ExtendedWebElement errorTitle;

    @Localized
    @FindBy(xpath = ".//p[contains(@class,'serial-number-error')]")
    private ExtendedWebElement serNumberError;

    public RegistrationError(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public String getErrorTitle() {
        return errorTitle.getText();
    }

    public String getSerNumberError() {
        return serNumberError.getText();
    }

    public void closeModal() {
        closeButton.click();
    }
}
