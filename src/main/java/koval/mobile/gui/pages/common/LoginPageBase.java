package koval.mobile.gui.pages.common;

import com.qaprosoft.carina.core.gui.AbstractPage;
import koval.mobile.gui.pages.android.LoginPage;
import org.openqa.selenium.WebDriver;

public abstract class LoginPageBase extends AbstractPage {

    public LoginPageBase(WebDriver driver) {
        super(driver);
    }

    public abstract void typeName(String name);

    public abstract void typePassword(String password);

    public abstract void selectGender(String gender);

    public abstract boolean isSelectedGenderChecked(String gender);

    public abstract boolean isAnyGenderChecked();

    public abstract void checkPrivacyPolicyCheckbox();

    public abstract CarinaDescriptionPageBase clickLoginBtn();

    public abstract boolean isLoginBtnActive();

}
