package koval.myfit.mobile.gui.common.downMenuPages;

import com.qaprosoft.carina.core.gui.AbstractPage;
import koval.myfit.mobile.gui.MyAbstractPage;
import koval.myfit.mobile.gui.common.profilePages.SettingsPageBase;
import koval.myfit.mobile.service.enums.DownMenuElement;
import koval.myfit.mobile.service.enums.PersonCharacteristics;
import org.openqa.selenium.WebDriver;

import java.io.IOException;
import java.text.ParseException;
import java.util.Calendar;


public abstract class ProfilePageBase extends MyAbstractPage {

    public ProfilePageBase(WebDriver driver) {
        super(driver);
    }


    public abstract AbstractPage openPageFromDownMenuByName(DownMenuElement downMenuElement);

    public abstract int getAccountImageColor() throws IOException;

    public abstract String getSleepSwitchColor() throws IOException;

    public abstract SettingsPageBase openSettingsButton() throws IOException;

    public abstract String getSettingsTitlesColor(String settingsTitleName) throws IOException;

    public abstract void checkSleepSwitch();

    public abstract void uncheckSleepSwitch();

    public abstract AbstractPage clickOnCharacteristicsBtn(PersonCharacteristics personCharacteristics);

    public abstract Calendar getCurrentBirthday() throws ParseException;

    public abstract String getCurrentGender() throws ParseException;

    public abstract float getCurrentWeight(PersonCharacteristics personCharacteristics);

    public abstract String getCurrentWeightMeasure(PersonCharacteristics personCharacteristics);

    public abstract float getCurrentHeight(PersonCharacteristics personCharacteristics);
}
