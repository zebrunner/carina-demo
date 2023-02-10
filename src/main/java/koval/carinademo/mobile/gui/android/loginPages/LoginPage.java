package koval.carinademo.mobile.gui.android.loginPages;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.utils.mobile.IMobileUtils;
import koval.carinademo.mobile.gui.common.leftMenuPages.WebViewPageBase;
import koval.carinademo.mobile.gui.common.loginPages.LoginPageBase;
import koval.carinademo.mobile.service.enums.Gender;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.invoke.MethodHandles;


@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = LoginPageBase.class)
public class LoginPage extends LoginPageBase implements IMobileUtils {

    private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

    @FindBy(id = "com.solvd.carinademoapplication:id/name")
    private ExtendedWebElement nameInputField;

    @FindBy(id = "com.solvd.carinademoapplication:id/password")
    private ExtendedWebElement passwordInputField;

    /**
     * LoginPage: Gender-RadioButton
     * male and female gender in one webelement
     */
    @FindBy(xpath = "//android.widget.RadioButton[@text='%s']")
    private ExtendedWebElement genderRadioBtn;

    @FindBy(id = "com.solvd.carinademoapplication:id/checkbox")
    private ExtendedWebElement privacyPolicyCheckbox;

    @FindBy(id = "com.solvd.carinademoapplication:id/login_button")
    private ExtendedWebElement loginBtn;

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public LoginPageBase typeName(String name) {
        nameInputField.type(name);
        hideKeyboard();
        return initPage(getDriver(), LoginPageBase.class);
    }

    @Override
    public LoginPageBase typePassword(String password) {
        passwordInputField.type(password);
        return initPage(getDriver(), LoginPageBase.class);
    }

    /**
     * LoginPage: Select gender-method
     * enter selected gender into xpath and click
     */
    @Override
    public LoginPageBase selectGender(Gender gender) {
        genderRadioBtn.format(gender.getName()).check();
        return initPage(getDriver(), LoginPageBase.class);
    }

    @Override
    public boolean isGenderChecked(Gender gender) {
        return genderRadioBtn.format(gender.getName()).isChecked();
    }

    @Override
    public LoginPageBase checkPrivacyPolicyCheckbox() {
        return checkPrivacyPolicyCheckbox(true);
    }

    @Override
    public LoginPageBase checkPrivacyPolicyCheckbox(boolean status) {

        LOGGER.info("[ Privacy Police Checkbox status ] Expected: {} . Actual: {}", status, privacyPolicyCheckbox.isChecked());

        if (status) {
            privacyPolicyCheckbox.check();
        } else {
            privacyPolicyCheckbox.uncheck();
        }
        return initPage(getDriver(), LoginPageBase.class);
    }

    @Override
    public WebViewPageBase clickLoginBtn() {
        loginBtn.click();
        return initPage(getDriver(), WebViewPageBase.class);
    }

    @Override
    public boolean isLoginBtnActive() {
        return Boolean.parseBoolean(loginBtn.getAttribute("enabled"));
    }

}
