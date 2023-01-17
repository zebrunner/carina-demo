package koval.mobile.gui.pages.ios;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.utils.mobile.IMobileUtils;
import koval.mobile.gui.pages.common.CarinaDescriptionPageBase;
import koval.mobile.gui.pages.common.LoginPageBase;
import org.apache.commons.lang3.NotImplementedException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

@DeviceType(pageType = DeviceType.Type.IOS_PHONE, parentClass = LoginPageBase.class)
public class LoginPage extends LoginPageBase implements IMobileUtils {

    @FindBy(id = "name")
    private ExtendedWebElement nameInputField;

    @FindBy(id = "password")
    private ExtendedWebElement passwordInputField;

    @FindBy(id = "radio_male")
    private ExtendedWebElement maleRadioBtn;

    @FindBy(id = "radio_female")
    private ExtendedWebElement femaleRadioBtn;

    @FindBy(id = "checkbox")
    private ExtendedWebElement privacyPolicyCheckbox;

    @FindBy(id = "login_button")
    private ExtendedWebElement loginBtn;

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public void typeName(String name) {
        throw new NotImplementedException("");
    }

    @Override
    public void typePassword(String password) {
        throw new NotImplementedException("");
    }

    @Override
    public void selectGender(String gender) {
        throw new NotImplementedException("");
    }

    @Override
    public boolean isSelectedGenderChecked(String gender) {
        throw new NotImplementedException("");
    }

    @Override
    public boolean isAnyGenderChecked() {
        throw new NotImplementedException("");
    }

    @Override
    public void checkPrivacyPolicyCheckbox() {
        throw new NotImplementedException("");
    }

    @Override
    public CarinaDescriptionPageBase clickLoginBtn() {
        throw new NotImplementedException("");
    }

    @Override
    public boolean isLoginBtnActive() {
        throw new NotImplementedException("");
    }

}
