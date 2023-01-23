package koval.mobile.gui.pages.common;

import com.qaprosoft.carina.core.gui.AbstractPage;
import koval.mobile.gui.pages.android.LoginPage;
import koval.mobile.gui.pages.service.enums.Gender;
import org.openqa.selenium.WebDriver;

public abstract class LoginPageBase extends AbstractPage {

    public LoginPageBase(WebDriver driver) {
        super(driver);
    }

    public abstract LoginPageBase typeName(String name);

    public abstract LoginPageBase typePassword(String password);

    public abstract LoginPageBase selectGender(Gender gender);

    public abstract boolean isSelectedGenderChecked(Gender gender);

    public abstract LoginPageBase checkPrivacyPolicyCheckbox();

    public abstract LoginPageBase checkPrivacyPolicyCheckbox(boolean status);

    public abstract CarinaDescriptionPageBase clickLoginBtn();

    public abstract boolean isLoginBtnActive();

}
