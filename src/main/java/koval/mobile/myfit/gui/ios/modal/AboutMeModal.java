package koval.mobile.myfit.gui.ios.modal;

import com.qaprosoft.carina.core.gui.AbstractPage;
import com.zebrunner.carina.utils.exception.NotImplementedException;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.utils.factory.DeviceType.Type;
import koval.mobile.myfit.gui.common.modal.AboutMeModalBase;
import koval.mobile.myfit.service.enums.PersonCharacteristics;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;


@DeviceType(pageType = Type.IOS_PHONE, parentClass = AboutMeModalBase.class)
public class AboutMeModal extends AboutMeModalBase {

    public AboutMeModal(WebDriver driver) {
        super(driver);
    }

    public AboutMeModal(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    @Override
    public AbstractPage clickOnCharacteristicsBtn(PersonCharacteristics personCharacteristics) {
        throw new NotImplementedException();
    }

    @Override
    public String getCurrentCharacteristicValue(PersonCharacteristics personCharacteristics) {
        throw new NotImplementedException();
    }

}
