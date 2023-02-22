package koval.myfit.mobile.gui.ios.downMenuPages;

import com.qaprosoft.carina.core.gui.AbstractPage;
import com.zebrunner.carina.utils.factory.DeviceType;
import koval.myfit.mobile.gui.common.downMenuPages.ProfilePageBase;
import koval.myfit.mobile.service.enums.PersonCharacteristics;
import org.openqa.selenium.WebDriver;

import java.text.ParseException;
import java.util.Calendar;

@DeviceType(pageType = DeviceType.Type.IOS_PHONE, parentClass = ProfilePageBase.class)
public class ProfilePage extends ProfilePageBase {
    public ProfilePage(WebDriver driver) {
        super(driver);
    }

    @Override
    public AbstractPage clickOnCharacteristicsBtn(PersonCharacteristics personCharacteristics) {
        return null;
    }

    @Override
    public Calendar getCurrentBirthday() throws ParseException {
        return null;
    }

    @Override
    public String getCurrentGender() throws ParseException {
        return null;
    }

    @Override
    public String getCurrentWeightOrHeight(PersonCharacteristics personCharacteristics) {
        return null;
    }


}
