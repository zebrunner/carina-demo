package com.qaprosoft.carina.demo.mobile.gui.pages.common;

import com.qaprosoft.carina.core.gui.AbstractPage;
import org.openqa.selenium.WebDriver;

public abstract class UIElementsPageBase extends AbstractPage {
    public UIElementsPageBase(WebDriver driver) {
        super(driver);
    }

    public abstract void typeText(String text);

    public abstract void typeEmail(String email);

    public abstract void typeDate(String date);

    public abstract void clickOnMaleRadioButton();

    public abstract void clickOnFemaleRadioButton();

    public abstract void clickOnOtherRadioButton();

    public abstract void checkCopy();

}
