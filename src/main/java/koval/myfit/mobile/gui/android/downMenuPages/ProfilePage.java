package koval.myfit.mobile.gui.android.downMenuPages;

import com.qaprosoft.carina.core.gui.AbstractPage;
import com.zebrunner.carina.utils.factory.DeviceType;
import koval.myfit.mobile.gui.android.modal.AboutMeModal;
import koval.myfit.mobile.gui.common.downMenuPages.ProfilePageBase;
import koval.myfit.mobile.service.enums.PersonCharacteristics;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;


@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = ProfilePageBase.class)
public class ProfilePage extends ProfilePageBase {

    @FindBy(id = "com.google.android.apps.fitness:id/about_you_placeholder")
    private AboutMeModal aboutMeModal;


    public ProfilePage(WebDriver driver) {
        super(driver);
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
