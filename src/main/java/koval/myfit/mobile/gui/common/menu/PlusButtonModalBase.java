package koval.myfit.mobile.gui.common.menu;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import koval.myfit.mobile.gui.MyAbstractPage;
import koval.myfit.mobile.gui.common.downMenuPages.HomePageBase;
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

    public abstract List<String> getPlusButtonMenuElementsToList();

    public abstract boolean isPlusBtnStatic();

    public abstract boolean isPlusBtnOverElements();

    public abstract ExtendedWebElement openPlusButtonMenu();

    public abstract HomePageBase closePlusButtonMenu();

    public abstract boolean isPlusButtonBelowBlockContainer();
}
