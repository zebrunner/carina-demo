package com.qaprosoft.carina.demo.mobile.gui.pages.common;

import org.openqa.selenium.WebDriver;

import com.qaprosoft.carina.core.gui.AbstractPage;

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
	
	public abstract boolean isFieldNamePresent();
	
	public abstract boolean isFieldPassPresent();
	
	public abstract boolean isMaleSexRadioButtonPresent();
	
	public abstract boolean isFemaleSexRadioButtonPresent();
	
	public abstract boolean isPrivacyPolicyCheckboxPresent();
	
	public abstract boolean isMaleSexRadioButtonCheck();
	public abstract boolean isFemaleSexRadioButtonCheck();
	
	public abstract boolean isPrivacyPolicyCheckboxCheck();
	
	public abstract boolean isSexCheck();

}
