package koval.mobile.gui.pages.android;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.utils.mobile.IMobileUtils;
import koval.mobile.gui.pages.common.CarinaDescriptionPageBase;
import koval.mobile.gui.pages.common.LoginPageBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = LoginPageBase.class)
public class LoginPage extends LoginPageBase implements IMobileUtils {

    public enum Gender {
        MALE("Male"), FEMALE("Female");

        public final String label;

        Gender(String label) {
            this.label = label;
        }

        @Override
        public String toString() { //return values Male/Female
            return label;
        }
    }

    @FindBy(id = "name")
    private ExtendedWebElement nameInputField;

    @FindBy(id = "password")
    private ExtendedWebElement passwordInputField;

    @FindBy(xpath = "//*[@text='%s']") //male female gender radiobuttons in one webelement
    private ExtendedWebElement genderRadioBtn;

    @FindBy(id = "checkbox")
    private ExtendedWebElement privacyPolicyCheckbox;

    @FindBy(id = "login_button")
    private ExtendedWebElement loginBtn;

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public void typeName(String name) {
        nameInputField.type(name);
        hideKeyboard();
    }

    @Override
    public void typePassword(String password) {
        passwordInputField.type(password);
    }

    @Override
    public void selectGender(String gender) { //enter selected gender into xpath and click
        genderRadioBtn.format(gender).check();
    }

    @Override
    public boolean isSelectedGenderChecked(String gender) {
        return genderRadioBtn.format(gender).isChecked();
    }

    @Override
    public boolean isAnyGenderChecked() {

        Gender[] genders = Gender.values();

        for (Gender gender : genders)
            if (genderRadioBtn.format(gender).isChecked()) return true;

        return false;
    }

    @Override
    public void checkPrivacyPolicyCheckbox() {
        privacyPolicyCheckbox.click();
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
