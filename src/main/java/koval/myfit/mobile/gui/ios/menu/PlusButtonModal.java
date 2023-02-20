package koval.myfit.mobile.gui.ios.menu;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.utils.exception.NotImplementedException;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.utils.factory.DeviceType.Type;
import koval.myfit.mobile.gui.common.downMenuPages.HomePageBase;
import koval.myfit.mobile.gui.common.menu.PlusButtonModalBase;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;

import java.util.List;


@DeviceType(pageType = Type.IOS_PHONE, parentClass = PlusButtonModalBase.class)
public class PlusButtonModal extends PlusButtonModalBase {

    public PlusButtonModal(WebDriver driver) {
        super(driver);
    }

    public PlusButtonModal(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    @Override
    public List<String> getPlusButtonMenuElementsToList() {
        throw new NotImplementedException();
    }

    @Override
    public boolean isPlusBtnStatic() {

        throw new NotImplementedException();
    }


    @Override
    public boolean isPlusBtnOverElements() {
        throw new NotImplementedException();
    }

    @Override
    public ExtendedWebElement openPlusButtonMenu() {
        throw new NotImplementedException();
    }

    @Override
    public HomePageBase closePlusButtonMenu() {
        throw new NotImplementedException();
    }


    @Override
    public boolean isPlusButtonBelowBlockContainer() {
        throw new NotImplementedException();
    }


}