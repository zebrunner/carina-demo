package com.qaprosoft.carina.demo.ralphlauren.gui.component;

import com.qaprosoft.carina.demo.ralphlauren.gui.pages.common.HomePageBase;
import com.zebrunner.carina.utils.factory.ICustomTypePageFactory;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractUIObject;
import com.zebrunner.carina.webdriver.locator.Context;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class HeaderRegionNav extends AbstractUIObject implements ICustomTypePageFactory {

    @FindBy(tagName = "title")
    private ExtendedWebElement findStoreButton;

    @FindBy(className = "country-selector-wrapper desktop-only")
    private ExtendedWebElement countrySelectButton;

    @FindBy(xpath = ".//div[@class='current-country']//span")
    private ExtendedWebElement currentCountryLabel;

    @FindBy(className = "logo-image")
    private ExtendedWebElement homeLink;

    @FindBy(className = "select-shipping-country")
    private ExtendedWebElement selectCountryLabel;

    @FindBy(xpath = ".//li[contains(@class,'region')]")
    private List<Region> regions;

    public HeaderRegionNav(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public void toStoresPage() {
        findStoreButton.click();
        // return initPage(StoresBasePage.class, driver);
    }

    public HomePageBase selectCountry(String regionToSelect, String countryToSelect) {
        return findCountry(regionToSelect, countryToSelect).selectCountry();
    }

    public HomePageBase selectLocale(String regionToSelect, String countryToSelect, String localeToSelect) {
        return findCountry(regionToSelect, countryToSelect).selectLocale(localeToSelect);
    }

    private Country findCountry(String regionToSelect, String countryToSelect) {
        Region region = regions.stream()
                .filter(reg -> regionToSelect.equals(reg.getRegionName()))
                .findFirst()
                .orElse(null);

        if (region == null) {
            throw new RuntimeException("Region " + regionToSelect + " not found");
        }

        List<Country> countryList = region.openCountries();
        for (Country country : countryList) {
            if (countryToSelect.equals(country.getName())) {
                return country;
            }
        }

        throw new RuntimeException("Country " + countryToSelect + " not found");
    }
}
