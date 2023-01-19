package koval.mobile.gui.pages.common;

import com.qaprosoft.carina.core.gui.AbstractPage;
import koval.mobile.gui.pages.service.enums.Tab;
import org.openqa.selenium.WebDriver;

public abstract class CarinaDescriptionPageBase extends AbstractPage {

    public CarinaDescriptionPageBase(WebDriver driver) {
        super(driver);
    }

    public abstract boolean isElementPresent();

    public abstract CarinaDescriptionPageBase clickOnBurgerMenu();

    public abstract boolean isSelectedElementPresent(Tab tab);


    public abstract AbstractPage clickOnTab(Tab tab);
}
