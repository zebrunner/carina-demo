package com.qaprosoft.carina.demo.mobile.gui.pages.common;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.demo.gui.components.FooterMenu;
import org.openqa.selenium.WebDriver;

import com.qaprosoft.carina.core.gui.AbstractPage;
import org.openqa.selenium.support.FindBy;

public abstract class LoginPageBase extends AbstractPage {

	@FindBy(id = "com.solvd.carinademoapplication:id/name")
	private ExtendedWebElement nameField;

	@FindBy(id = "com.solvd.carinademoapplication:id/password")
	private ExtendedWebElement passwordField;

	@FindBy(id = "com.solvd.carinademoapplication:id/radio_male")
	private ExtendedWebElement maleButton;

	@FindBy(id = "com.solvd.carinademoapplication:id/radio_female")
	private ExtendedWebElement femaleButton;

	@FindBy(id = "com.solvd.carinademoapplication:id/checkbox")
	private ExtendedWebElement privacyCheckbox;

	@FindBy(id = "com.solvd.carinademoapplication:id/login_button")
	private ExtendedWebElement loginButton;

	public ExtendedWebElement getNameField() {
		return nameField;
	}

	public ExtendedWebElement getPasswordField() {
		return passwordField;
	}

	public ExtendedWebElement getMaleButton() {
		return maleButton;
	}

	public ExtendedWebElement getFemaleButton() {
		return femaleButton;
	}

	public ExtendedWebElement getPrivacyCheckbox() {
		return privacyCheckbox;
	}

	public ExtendedWebElement getLoginButton() {
		return loginButton;
	}

	public LoginPageBase(WebDriver driver) {
		super(driver);
	}

	public abstract void typeName(String name);

	public abstract void typePassword(String password);

	public abstract void selectMaleSex();

	public abstract void checkPrivacyPolicyCheckbox();

	public abstract CarinaDescriptionPageBase clickLoginBtn();

	public abstract boolean isLoginBtnActive();

	public abstract CarinaDescriptionPageBase login();

}
