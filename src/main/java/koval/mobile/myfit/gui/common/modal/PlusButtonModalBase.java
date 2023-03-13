package koval.mobile.myfit.gui.common.modal;

import com.qaprosoft.carina.core.gui.AbstractPage;
import koval.mobile.myfit.gui.MyAbstractPage;
import koval.mobile.myfit.gui.common.downMenuPages.HomePageBase;
import koval.mobile.myfit.service.enums.PlusButtonMenuElement;
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
