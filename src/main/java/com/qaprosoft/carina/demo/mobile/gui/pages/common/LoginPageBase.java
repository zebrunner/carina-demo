package com.qaprosoft.carina.demo.mobile.gui.pages.common;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.WebDriver;

import com.qaprosoft.carina.core.gui.AbstractPage;
import org.openqa.selenium.support.FindBy;

public abstract class LoginPageBase extends AbstractPage {



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

	public abstract boolean isNamePresented() throws Exception;

	public abstract boolean isPassPresented() throws Exception;

	public abstract boolean isNameEntered(String name) throws Exception;

	public abstract boolean isPassEntered(String pass) throws Exception;

	public abstract boolean isGenderPresented() throws Exception;

	public abstract boolean isPageOpened();

	public abstract boolean isMaleSelected() throws Exception;

	public abstract boolean isPrivacyChecked() throws Exception;





}
