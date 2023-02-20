package koval.myfit.mobile.gui.common.modal;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import koval.myfit.mobile.gui.MyAbstractPage;
import koval.myfit.mobile.gui.common.downMenuPages.HomePageBase;
import koval.myfit.mobile.service.enums.PlusButtonMenuElement;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;

import java.util.List;

public abstract class PlusButtonModalBase extends MyAbstractPage {

    public PlusButtonModalBase(WebDriver driver) {
        super(driver);
    }

    public PlusButtonModalBase(WebDriver driver, SearchContext searchContext) {
        super(driver);
    }

    public abstract AbstractPage openPageByName(PlusButtonMenuElement plusButtonMenuElement);

    public abstract List<String> getPlusButtonMenuElementsToList();

    public abstract boolean isPlusBtnStatic();

    public abstract boolean isPlusBtnOverElements();

    public abstract PlusButtonModalBase openPlusButtonMenu();

    public abstract HomePageBase closePlusButtonMenu();

    public abstract boolean isPlusButtonBelowBlockContainer();
}
