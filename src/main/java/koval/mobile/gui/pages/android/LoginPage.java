package koval.mobile.gui.pages.android;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.utils.mobile.IMobileUtils;
import koval.mobile.gui.pages.common.CarinaDescriptionPageBase;
import koval.mobile.gui.pages.common.LoginPageBase;
import koval.mobile.gui.pages.service.enums.Gender;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;


@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = LoginPageBase.class)
public class LoginPage extends LoginPageBase implements IMobileUtils {

    @FindBy(id = "name")
    private ExtendedWebElement nameInputField;

    @FindBy(id = "password")
    private ExtendedWebElement passwordInputField;

    /**
     * LoginPage: Gender-RadioButton
     * male and female gender in one webelement
     */
    @FindBy(xpath = "//*[@text='%s']")
    private ExtendedWebElement genderRadioBtn;

    @FindBy(id = "checkbox")
    private ExtendedWebElement privacyPolicyCheckbox;

    @FindBy(id = "login_button")
    private ExtendedWebElement loginBtn;

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public LoginPageBase typeName(String name) {
        nameInputField.type(name);
        hideKeyboard();
        return this;
    }

    @Override
    public LoginPageBase typePassword(String password) {
        passwordInputField.type(password);
        return this;
    }

    /**
     * LoginPage: Select gender-method
     * enter selected gender into xpath and click
     */
    @Override
    public LoginPageBase selectGender(Gender gender) {
        genderRadioBtn.format(gender.toString()).check();
        return this;
    }

    @Override
    public boolean isSelectedGenderChecked(Gender gender) {
        return genderRadioBtn.format(gender.toString()).isChecked();
    }

    @Override
    public LoginPageBase checkPrivacyPolicyCheckbox() {
        privacyPolicyCheckbox.click();
        return this;
    }

    @Override
    public CarinaDescriptionPageBase clickLoginBtn() {
        loginBtn.click();
        return initPage(getDriver(), CarinaDescriptionPageBase.class);
    }

    @Override
    public boolean isLoginBtnActive() {
        return Boolean.parseBoolean(loginBtn.getAttribute("enabled"));
    }

}
