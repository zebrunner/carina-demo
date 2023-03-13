package koval.mobile.myfit.gui.android.downMenuPages;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.utils.mobile.IMobileUtils;
import koval.mobile.myfit.gui.android.modal.DownMenuModal;
import koval.mobile.myfit.gui.common.downMenuPages.ProfilePageBase;
import koval.mobile.myfit.gui.android.modal.AboutMeModal;
import koval.mobile.myfit.gui.android.modal.ManageAccountModal;
import koval.mobile.myfit.gui.common.profilePages.SettingsPageBase;
import koval.mobile.myfit.service.enums.DownMenuElement;
import koval.mobile.myfit.service.enums.PersonCharacteristics;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.lang.invoke.MethodHandles;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;


@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = ProfilePageBase.class)
public class ProfilePage extends ProfilePageBase {

    private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

    @FindBy(id = "com.google.android.apps.fitness:id/og_apd_internal_image_view")
    private ManageAccountModal accountImageModal;

    @FindBy(id = "com.google.android.apps.fitness:id/about_you_placeholder")
    private AboutMeModal aboutMeModal;

    @FindBy(id = "com.google.android.apps.fitness:id/bottom_navigation")
    private DownMenuModal downMenuModal;

    @FindBy(id = "com.google.android.apps.fitness:id/profile_sleep_switch")
    private ExtendedWebElement sleepSwitch;

    @FindBy(xpath = "//*[@text='%s']")
    private ExtendedWebElement itemByText;

    @FindBy(id = "com.google.android.apps.fitness:id/action_settings")
    private ExtendedWebElement settingsButton;

    @FindBy(id = "com.google.android.apps.fitness:id/collapsing_toolbar")
    private ExtendedWebElement title;


    public ProfilePage(WebDriver driver) {
        super(driver);
    }


    @Override
    public boolean isPageOpened() {

        return title.isElementPresent(TIMEOUT_FIVE) && title.getAttribute("content-desc").equals("Profile");
    }

    @Override
    public AbstractPage openPageFromDownMenuByName(DownMenuElement downMenuElement) {
        return downMenuModal.openPageByName(downMenuElement);
    }


    @Override
    public int getAccountImageColor() throws IOException {

        return accountImageModal.getAccountImageColor();
    }


    @Override
    public String getSleepSwitchColor() throws IOException {

        return getCenterColorByName(sleepSwitch);
    }

    @Override
    public SettingsPageBase openSettingsButton() {

        settingsButton.click();

        return initPage(getDriver(), SettingsPageBase.class);
    }


    @Override
    public String getSettingsTitlesColor(String settingsTitleName) throws IOException {

        ExtendedWebElement settingsTitle = itemByText.format(settingsTitleName);
        swipe(settingsTitle, IMobileUtils.Direction.UP, FIFTEEN_COUNT, MEDIUM_SPEED);

        return getColorByName(settingsTitle);
    }


    @Override
    public ProfilePageBase checkSleepSwitch(boolean status) {

        if (status) {
            sleepSwitch.check();
        } else {
            sleepSwitch.uncheck();
        }

        return initPage(getDriver(), ProfilePageBase.class);
    }


    @Override
    public AbstractPage clickOnCharacteristicsBtn(PersonCharacteristics personCharacteristics) {
        return aboutMeModal.clickOnCharacteristicsBtn(personCharacteristics);
    }


    @Override
    public Calendar getCurrentBirthday() throws ParseException {

        String actualBirthdayString = aboutMeModal.getCurrentCharacteristicValue(PersonCharacteristics.BIRTHDAY);

        Calendar actualBirthday = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat(BIRTHDAY_DATE_FORMAT);
        actualBirthday.setTime(sdf.parse(actualBirthdayString));

        return actualBirthday;
    }

    @Override
    public String getCurrentGender() {
        return aboutMeModal.getCurrentCharacteristicValue(PersonCharacteristics.GENDER);
    }

    @Override
    public float getCurrentWeight(PersonCharacteristics personCharacteristics) {
        return Float.parseFloat(aboutMeModal.getCurrentCharacteristicValue(personCharacteristics).
                replaceAll(STONES_MEASURE, DOT_VALUE).replaceAll(NUMBERS_AND_DOT_ONLY, EMPTY_FIELD));
    }

    @Override
    public String getCurrentWeightMeasure(PersonCharacteristics personCharacteristics) {
        return aboutMeModal.getCurrentCharacteristicValue(personCharacteristics).replaceAll(STRING_ONLY, EMPTY_FIELD).
                replaceAll(STLB_MEASURE, STONES_MEASURE);
    }

    @Override
    public float getCurrentHeight(PersonCharacteristics personCharacteristics) {

        float currentHeight = Float.parseFloat(aboutMeModal.getCurrentCharacteristicValue(personCharacteristics).
                replaceAll(NUMBERS_ONLY, EMPTY_FIELD));

        if (aboutMeModal.getCurrentCharacteristicValue(personCharacteristics).contains(APOSTROPHE_VALUE)) {
            currentHeight = Float.parseFloat(aboutMeModal.getCurrentCharacteristicValue(personCharacteristics).
                    replaceAll(APOSTROPHE_VALUE, DOT_VALUE).replaceAll(QUOTES_VALUE, EMPTY_FIELD));
        }

        return currentHeight;
    }

}
