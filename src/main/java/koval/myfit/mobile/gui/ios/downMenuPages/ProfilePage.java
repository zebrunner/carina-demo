package koval.myfit.mobile.gui.ios.downMenuPages;

import com.qaprosoft.carina.core.gui.AbstractPage;
import com.zebrunner.carina.utils.exception.NotImplementedException;
import com.zebrunner.carina.utils.factory.DeviceType;
import koval.myfit.mobile.gui.common.downMenuPages.ProfilePageBase;
import koval.myfit.mobile.service.enums.PersonCharacteristics;
import org.openqa.selenium.WebDriver;

import java.util.Calendar;

@DeviceType(pageType = DeviceType.Type.IOS_PHONE, parentClass = ProfilePageBase.class)
public class ProfilePage extends ProfilePageBase {
    public ProfilePage(WebDriver driver) {
        super(driver);
    }

    @Override
    public AbstractPage clickOnCharacteristicsBtn(PersonCharacteristics personCharacteristics) {
        throw new NotImplementedException();
    }

    @Override
    public Calendar getCurrentBirthday() {
        throw new NotImplementedException();
    }

    @Override
    public String getCurrentGender() {
        throw new NotImplementedException();
    }

    @Override
    public float getCurrentWeight(PersonCharacteristics personCharacteristics) {
        throw new NotImplementedException();
    }

    @Override
    public String getCurrentWeightMeasure(PersonCharacteristics personCharacteristics) {
        throw new NotImplementedException();
    }

    @Override
    public float getCurrentHeight(PersonCharacteristics personCharacteristics) {
        throw new NotImplementedException();
    }


}
