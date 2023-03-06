package koval.myfit.mobile.gui.ios.downMenuPages;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import com.zebrunner.carina.utils.exception.NotImplementedException;
import com.zebrunner.carina.utils.factory.DeviceType;
import koval.myfit.mobile.gui.common.downMenuPages.ProfilePageBase;
import koval.myfit.mobile.gui.common.profilePages.SettingsPageBase;
import koval.myfit.mobile.service.enums.DownMenuElement;
import koval.myfit.mobile.service.enums.PersonCharacteristics;
import org.openqa.selenium.WebDriver;

import java.io.IOException;
import java.util.Calendar;

@DeviceType(pageType = DeviceType.Type.IOS_PHONE, parentClass = ProfilePageBase.class)
public class ProfilePage extends ProfilePageBase {
    public ProfilePage(WebDriver driver) {
        super(driver);
    }

    @Override
    public AbstractPage openPageFromDownMenuByName(DownMenuElement downMenuElement) {
        throw new NotImplementedException();
    }

    @Override
    public int getAccountImageColor() throws IOException {
        throw new NotImplementedException();
    }

    @Override
    public String getSleepSwitchColor() {
        throw new NotImplementedException();
    }


    @Override
    public SettingsPageBase openSettingsButton() {
        throw new NotImplementedException();
    }

    @Override
    public String getSettingsTitlesColor(String settingsTitleName) {
        throw new NotImplementedException();
    }

    @Override
    public ProfilePageBase checkSleepSwitch(boolean status) {
        throw new NotImplementedException();
    }

    @Override
    public String getColorByName(ExtendedWebElement test) {
        throw new NotImplementedException();
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
