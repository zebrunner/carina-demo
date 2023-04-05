package com.qaprosoft.carina.demo.beatsbydre.component.desktop;

import com.qaprosoft.carina.demo.beatsbydre.component.common.AbstractFooter;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.decorator.annotations.Localized;
import com.zebrunner.carina.webdriver.locator.Context;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import java.util.List;
import java.util.stream.Collectors;

public class Footer extends AbstractFooter {
    @Localized
    @FindBy(xpath = ".//div[@class='copyright']/p")
    private ExtendedWebElement copyright;

    @Localized
    @FindBy(xpath = ".//div[@class='grid-item'][1]//h2[contains(@id,'footer-')]")
    private ExtendedWebElement productsTitle;

    @Localized
    @Context(dependsOn = "productsTitle")
    @FindBy(xpath = ".//following-sibling::nav//li")
    private List<ExtendedWebElement> productsList;

    @Localized
    @FindBy(xpath = ".//div[@class='grid-item'][2]//h2[contains(@id,'footer-')]")
    private ExtendedWebElement supportTitle;

    @Localized
    @Context(dependsOn = "supportTitle")
    @FindBy(xpath = ".//following-sibling::nav//li")
    private List<ExtendedWebElement> supportList;

    @Localized
    @FindBy(xpath = ".//div[@class='grid-item'][3]//div//div[1]//h2[contains(@id,'footer-')]")
    private ExtendedWebElement companyTitle;

    @Localized
    @Context(dependsOn = "companyTitle")
    @FindBy(xpath = ".//following-sibling::nav//li")
    private List<ExtendedWebElement> companyList;

    @Localized
    @FindBy(xpath = ".//div[@class='grid-item'][3]//div//div[2]//h2[contains(@id,'footer-')]")
    private ExtendedWebElement licenseTitle;

    @Localized
    @Context(dependsOn = "licenseTitle")
    @FindBy(xpath = ".//following-sibling::nav//li")
    private List<ExtendedWebElement> licenseList;

    @Localized
    @FindBy(id = "footerBeatsArmy")
    private ExtendedWebElement mediaTitle;

    @Localized
    @FindBy(className = "footerDirectoryTitle")
    private ExtendedWebElement locationTitle;

    @Localized
    @FindBy(xpath = ".//span[contains(@class,'country')]")
    private ExtendedWebElement locationCountry;

    @Localized
    @FindBy(className = "change-location")
    private ExtendedWebElement changeLocationButton;

    @Localized
    @FindBy(xpath = ".//h2[not(@*)]")
    private ExtendedWebElement emailTitle;

    @Localized
    @FindBy(xpath = ".//li[@class='newsletter-cta']")
    private ExtendedWebElement signUpButton;

    public Footer(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public String getCopyright() {
        return copyright.getText();
    }

    public String getProductsTitle() {
        return productsTitle.getText();
    }

    public List<String> getProductsList() {
        return elementsListToString(productsList);
    }

    public String getSupportTitle() {
        return supportTitle.getText();
    }

    public List<String> getSupportList() {
        return elementsListToString(supportList);
    }

    public String getCompanyTitle() {
        return companyTitle.getText();
    }

    public List<String> getCompanyList() {
        return elementsListToString(companyList);
    }

    public String getLicenseTitle() {
        return licenseTitle.getText();
    }

    public List<String> getLicenseList() {
        return elementsListToString(licenseList);
    }

    public String getMediaTitle() {
        return mediaTitle.getText();
    }

    public String getLocationTitle() {
        return locationTitle.getText();
    }

    public String getLocationCountry() {
        return locationCountry.getText();
    }

    public String getChangeLocationButton() {
        return changeLocationButton.getText();
    }

    public String getEmailTitle() {
        return emailTitle.getText();
    }

    public String getSignUpButton() {
        return signUpButton.getText();
    }

    private List<String> elementsListToString(List<ExtendedWebElement> elementList) {
        return elementList.stream().map(ExtendedWebElement::getText).collect(Collectors.toList());
    }
}
