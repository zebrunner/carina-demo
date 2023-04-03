package com.qaprosoft.carina.demo.ralphlauren.gui.component;

import com.qaprosoft.carina.demo.ralphlauren.gui.pages.common.HomePageBase;
import com.zebrunner.carina.utils.factory.ICustomTypePageFactory;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractUIObject;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.invoke.MethodHandles;
import java.util.List;

public class Country extends AbstractUIObject implements ICustomTypePageFactory {

    private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

    private static final String BASE_LOCALE = "en";

    @FindBy(xpath = ".//*[contains(@class,'country-item')]")
    private ExtendedWebElement countryName;

    @FindBy(className = "locale lang")
    private List<ExtendedWebElement> locales;

    public Country(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public HomePageBase selectCountry() {
        return selectLocale(BASE_LOCALE);
    }

    public HomePageBase selectLocale(String localeToSelect) {
        if (countryName.getAttribute("href").isEmpty()) {
            for (ExtendedWebElement locale : locales) {
                if (localeToSelect.equals(locale.getText())) {
                    locale.click();
                    return initPage(driver, HomePageBase.class);
                }
            }
            LOGGER.info("Couldn't select country " + countryName.getText());
        } else {
            countryName.click();
            return initPage(HomePageBase.class, driver);
        }

        throw new RuntimeException("Locale " + localeToSelect + " for " + countryName.getText() + " not found");
    }

    public String getName() {
        return countryName.getText().trim();
    }
}
