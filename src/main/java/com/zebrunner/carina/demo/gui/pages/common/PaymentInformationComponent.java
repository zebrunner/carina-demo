package com.zebrunner.carina.demo.gui.pages.common;

import com.zebrunner.carina.utils.R;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class PaymentInformationComponent extends AbstractPage {
    private static final String NAME = "CustomerName CustomerSurname";
    private static final String ADDRESS = "Address street";
    private static final String APARTMENT = "41";
    private static final String CITY = "New Castle";
    private static final String COUNTRY = "United States";
    private static final String STATE = "Delaware";
    private static final String ZIPCODE = "19720";
    private static final String PHONENUMBER = "380000000000";

    public PaymentInformationComponent(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//*[@id=\"main\"]/form/div[2]/div[2]/button")
    private ExtendedWebElement contToInfButton;

    @FindBy(id = "email.address__input")
    private ExtendedWebElement emailField;

    @FindBy(id = "shippingAddress.name__input")
    private ExtendedWebElement nameField;

    @FindBy(id = "shippingAddress.address1__input")
    private ExtendedWebElement addressField;

    @FindBy(id = "shippingAddress.address2__input")
    private ExtendedWebElement apartmentField;

    @FindBy(id = "shippingAddress.city__input")
    private ExtendedWebElement cityField;

    @FindBy(name = "shippingAddress.country")
    private ExtendedWebElement countrySelect;

    @FindBy(name = "shippingAddress.state")
    private ExtendedWebElement stateSelect;

    @FindBy(id = "shippingAddress.zip__input")
    private ExtendedWebElement zipCodeField;

    @FindBy(id = "shippingAddress.phone__input")
    private ExtendedWebElement phoneField;

    @FindBy(xpath = "//*[@id=\"main\"]/form/div[3]/div[2]/button")
    private ExtendedWebElement continueToShippingButton;
    private static final String COUNTRY_MENU_ITEM = ".//span[@class='mat-option-text' and contains(text(),'%s')]";
    private static final String STATE_MENU_ITEM = ".//span[@class='mat-option-text' and contains(text(),'%s')]";


    public PaymentInformationComponent setEmail() {
        emailField.type(R.TESTDATA.get("email"));
        return this;
    }

    public PaymentInformationComponent setFullName(String name) {
        nameField.type(name);
        return this;
    }

    public PaymentInformationComponent setAddress(String address) {
        addressField.type(address);
        return this;
    }

    public PaymentInformationComponent setApartment(String apartment) {
        apartmentField.type(apartment);
        return this;
    }

    public PaymentInformationComponent setCity(String city) {
        cityField.type(city);
        return this;
    }

    public PaymentInformationComponent setCountry(String country) {
        ExtendedWebElement menuItem = findExtendedWebElement(By.xpath(String.format(COUNTRY_MENU_ITEM, country.toString())));
        menuItem.scrollTo();
        menuItem.click();
        return this;
    }

    public PaymentInformationComponent setState(String state) {
        ExtendedWebElement menuItem = findExtendedWebElement(By.xpath(String.format(STATE_MENU_ITEM, state.toString())));
        menuItem.scrollTo();
        menuItem.click();
        return this;
    }

    public PaymentInformationComponent setZipCode(String zipCode) {
        zipCodeField.type(zipCode);
        return this;
    }

    public PaymentInformationComponent typePhoneNumber(String phoneNumber) {
        if (phoneField.isPresent()) {
            phoneField.type(phoneNumber);
        }
        return this;
    }

    public PaymentInformationComponent clickContinueButton() {
        continueToShippingButton.click();
        return this;
    }

    public void setShippingData() {
        if (contToInfButton.isPresent()) {
            contToInfButton.click();
        }
        setEmail();
        setFullName(NAME);
        setAddress(ADDRESS);
        setApartment(APARTMENT);
        setCity(CITY);
        //setCountry(COUNTRY);  //Failed to select from dropdown list
        //setState(STATE);  //Failed to select from dropdown list
        setZipCode(ZIPCODE);
        typePhoneNumber(PHONENUMBER);
        clickContinueButton();
    }

}
