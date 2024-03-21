package com.qaprosoft.carina.demo.beatsbydre.component.ios;

import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.qaprosoft.carina.demo.beatsbydre.component.common.AbstractRegistrationError;
import com.zebrunner.carina.utils.Configuration;
import com.zebrunner.carina.utils.mobile.IMobileUtils;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.decorator.annotations.Localized;

public class RegistrationError extends AbstractRegistrationError implements IMobileUtils {
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
        waitUntil(ExpectedConditions.visibilityOf(errorTitle.getElement()),
                Configuration.getLong(Configuration.Parameter.EXPLICIT_TIMEOUT));
        return errorTitle.getText();
    }

    public String getSerNumberError() {
        return serNumberError.getText();
    }

    public void closeModal() {
        tap(closeButton);
    }
}
