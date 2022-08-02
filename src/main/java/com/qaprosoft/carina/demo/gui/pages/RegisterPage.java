package com.qaprosoft.carina.demo.gui.pages;

import java.util.Objects;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class RegisterPage extends AbstractPage {

    @FindBy(id = "uname")
    private ExtendedWebElement usernameTextField;

    @FindBy(xpath = "//fieldset[@id='udata-f']/input[@name='sEmail']")
    private ExtendedWebElement emailTextField;

    @FindBy(xpath = "//form[@name='frmOpin']/input[@id='upass']")
    private ExtendedWebElement passwordTextField;

    @FindBy(xpath = "//label[@for='iagree1']")
    private ExtendedWebElement agreementCheckBox;

    @FindBy(xpath = "//label[@for='iagree2']")
    private ExtendedWebElement ageConfirmationCheckBox;

    @FindBy(xpath = "//div[@id='ucsubmit-f']/input[@type='submit']")
    private ExtendedWebElement submitButton;

    @FindBy(xpath = "//div[contains(@class, 'res-success')]/h3")
    private ExtendedWebElement successTitle;

    public RegisterPage(WebDriver driver) {
        super(driver);
        setPageURL("/register.php3");
    }

    public boolean isUsernameTextFieldPresent(){
        return usernameTextField.isElementPresent();
    }

    public boolean isEmailTextFieldPresent(){
        return emailTextField.isElementPresent();
    }

    public boolean isPasswordTextFieldPresent(){
        return passwordTextField.isElementPresent();
    }

    public boolean isAgreementCheckBoxPresent(){
        return agreementCheckBox.isElementPresent();
    }

    public boolean isAgeConfirmationCheckBoxPresent(){
        return ageConfirmationCheckBox.isElementPresent();
    }

    public boolean isSubmitButtonDisabled(){
        return Objects.equals(submitButton.getAttribute("disabled"), "true");
    }

    public boolean isSuccessTitlePresent(){
        return successTitle.isElementPresent();
    }

    public String getSuccessTitleString(){
        return successTitle.getText();
    }

    public RegisterPage clickSubmitButton(){
        submitButton.click();
        return this;
    }

    public RegisterPage fillForm(String username, String email, String password){
        usernameTextField.type(username);
        emailTextField.type(email);
        passwordTextField.type(password);
        agreementCheckBox.click();
        ageConfirmationCheckBox.click();
        return this;
    }
}
