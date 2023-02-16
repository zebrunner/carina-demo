package koval.myfit.mobile.gui.android.modal;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.utils.factory.DeviceType.Type;
import koval.myfit.mobile.gui.common.modal.TimePickerModalBase;
import org.openqa.selenium.By;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.invoke.MethodHandles;
import java.util.Calendar;

@DeviceType(pageType = Type.ANDROID_PHONE, parentClass = TimePickerModalBase.class)
public class TimePickerModal extends TimePickerModalBase {


    @FindBy(id = "com.google.android.apps.fitness:id/header_title")
    private ExtendedWebElement title;

    @FindBy(xpath = "//*[contains(@resource-id,'material_hour_text_input')]/child::*//*[@class='android.widget.EditText']")
    private ExtendedWebElement hourField;

    @FindBy(xpath = "//*[contains(@resource-id,'material_minute_text_input')]")
    private ExtendedWebElement minuteField;

    @FindBy(id = "com.google.android.apps.fitness:id/material_timepicker_ok_button")
    private ExtendedWebElement okayButton;

    @FindBy(id = "com.google.android.apps.fitness:id/material_timepicker_mode_button")
    private ExtendedWebElement timePickerModeButton;

    @FindBy(xpath = "//*[contains(@resource-id,'material_clock_period_toggle')]")
    private ExtendedWebElement clockPeriodToggleButton;

    @FindBy(id = "com.google.android.apps.fitness:id/material_clock_hand")
    private ExtendedWebElement clockImage;

    private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());


    public TimePickerModal(WebDriver driver) {
        super(driver);
    }

    public TimePickerModal(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }


    @Override
    public boolean isPageOpened() {

        return isPageOpened(title, "SELECT TIME");
    }


    @Override
    public TimePickerModalBase setTime(Calendar calendar) {

        if (clockImage.isElementPresent(TIMEOUT_FIVE)) {
            timePickerModeButton.click();
        }


        hourField.type(String.valueOf(calendar.get(Calendar.HOUR)));

        minuteField.click();
        minuteField.findExtendedWebElement(By.className("android.widget.EditText")).
                type(String.valueOf(calendar.get(Calendar.MINUTE)));


        String timePeriodButtonId = "com.google.android.apps.fitness:id/material_clock_period_am_button";

        if (calendar.get(Calendar.AM_PM) == Calendar.PM) {
            timePeriodButtonId = "com.google.android.apps.fitness:id/material_clock_period_pm_button";
        }

        clockPeriodToggleButton.findExtendedWebElement(By.id(timePeriodButtonId)).check();

        okayButton.click();

        return initPage(getDriver(), TimePickerModalBase.class);
    }
}
