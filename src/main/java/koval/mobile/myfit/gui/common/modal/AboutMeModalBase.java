package koval.mobile.myfit.gui.common.modal;


import com.qaprosoft.carina.core.gui.AbstractPage;
import koval.mobile.myfit.gui.MyAbstractPage;

import koval.mobile.myfit.service.enums.PersonCharacteristics;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;



public abstract class AboutMeModalBase extends MyAbstractPage {


    public AboutMeModalBase(WebDriver driver) {
        super(driver);
    }

    public AboutMeModalBase(WebDriver driver, SearchContext searchContext) {
        super(driver);
    }

    public abstract AbstractPage clickOnCharacteristicsBtn(PersonCharacteristics personCharacteristics);

    public abstract String getCurrentCharacteristicValue(PersonCharacteristics personCharacteristics);
}
