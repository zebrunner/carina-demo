package com.qaprosoft.carina.demo.mobile.gui.pages.common;

import com.qaprosoft.carina.core.gui.AbstractPage;
import org.openqa.selenium.WebDriver;

public abstract class UIElementsBase extends AbstractPage {
    public UIElementsBase(WebDriver driver) { super(driver); }

    public abstract void fillInText(String text);

    public abstract void fillInEmail(String email);

    public abstract void fillInDate(String date);

    public abstract void selectMale();

    public abstract void selectFemale();

    public abstract void selectOther();

    public abstract void checkCopy();

}
