package com.qaprosoft.carina.demo.beatsbydre.component.common;

import com.zebrunner.carina.webdriver.gui.AbstractUIObject;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;

import java.util.List;

public abstract class AbstractFooter extends AbstractUIObject {
    public AbstractFooter(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public abstract String getCopyright();

    public abstract String getProductsTitle();

    public abstract List<String> getProductsList();

    public abstract String getSupportTitle();

    public abstract List<String> getSupportList();

    public abstract String getCompanyTitle();

    public abstract List<String> getCompanyList();

    public abstract String getLicenseTitle();

    public abstract List<String> getLicenseList();

    public abstract String getMediaTitle();

    public abstract String getLocationTitle();

    public abstract String getLocationCountry();

    public abstract String getChangeLocationButton();

    public abstract String getEmailTitle();

    public abstract String getSignUpButton();
}
