package com.qaprosoft.carina.demo.example;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class RegistrationPage extends AbstractPage {

    @FindBy(xpath = "//input[@name='firstname']")
    private ExtendedWebElement nameInput;

    @FindBy(xpath = "//input[@name='lastname']")
    private ExtendedWebElement surnameInput;

    @FindBy(xpath = "//button[@name='websubmit']")
    private ExtendedWebElement registrationButton;
    public RegistrationPage(WebDriver driver) {
        super(driver);
    }
    public void typeData(String name, String surname){
        nameInput.type(name);
        surnameInput.type(surname);
        registrationButton.click();
    }

}
