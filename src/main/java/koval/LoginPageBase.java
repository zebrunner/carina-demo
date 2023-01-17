package koval;

import com.qaprosoft.carina.core.gui.AbstractPage;
import org.openqa.selenium.WebDriver;

public abstract class LoginPageBase extends AbstractPage {

	public LoginPageBase(WebDriver driver) {
		super(driver);
	}

	public abstract void typeName(String name);

	public abstract void typePassword(String password);

	public abstract void selectFemaleSex();

	public abstract void checkPrivacyPolicyCheckbox();

	public abstract CarinaDescriptionPageBase clickLoginBtn();

	public abstract boolean isLoginBtnActive();

}
