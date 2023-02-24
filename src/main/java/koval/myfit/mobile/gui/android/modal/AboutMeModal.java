package koval.myfit.mobile.gui.android.modal;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.utils.factory.DeviceType.Type;
import koval.myfit.mobile.gui.common.modal.AboutMeModalBase;
import koval.myfit.mobile.service.enums.PersonCharacteristics;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


import java.lang.invoke.MethodHandles;


@DeviceType(pageType = Type.ANDROID_PHONE, parentClass = AboutMeModalBase.class)
public class AboutMeModal extends AboutMeModalBase {

    private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

    @FindBy(id = "com.google.android.apps.fitness:id/%s_field")
    private ExtendedWebElement characteristicByID;


    public AboutMeModal(WebDriver driver) {
        super(driver);
    }

    public AboutMeModal(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }


    @Override
    public AbstractPage clickOnCharacteristicsBtn(PersonCharacteristics personCharacteristics) {
        characteristicByID.format(personCharacteristics.getCharacteristic()).click();
        return initPage(getDriver(), personCharacteristics.getClassName());
    }

    @Override
    public String getCurrentCharacteristicValue(PersonCharacteristics personCharacteristics) {
        return characteristicByID.format(personCharacteristics.getCharacteristic()).getText();
    }

}
