package koval.myfit.mobile.gui.android.plusButtonPages;


import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.utils.factory.DeviceType;
import koval.myfit.mobile.gui.android.modal.DatePickerModal;
import koval.myfit.mobile.gui.android.modal.TimePickerModal;
import koval.myfit.mobile.gui.common.downMenuPages.JournalPageBase;
import koval.myfit.mobile.gui.common.modal.DatePickerModalBase;
import koval.myfit.mobile.gui.common.modal.TimePickerModalBase;
import koval.myfit.mobile.gui.common.plusButtonPages.AddActivityPageBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;

import java.lang.invoke.MethodHandles;
import java.util.Calendar;
import java.util.List;


@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = AddActivityPageBase.class)
public class AddActivityPage extends AddActivityPageBase {

    @FindBy(id = "com.google.android.apps.fitness:id/expanded_title")
    private ExtendedWebElement title;

    @FindBy(xpath = "//*[@text='%s']")
    private ExtendedWebElement itemByText;

    @FindBy(id = "com.google.android.apps.fitness:id/activity_spinner")
    private ExtendedWebElement activityButton;

    @FindBy(id = "com.google.android.apps.fitness:id/container_action_button")
    private ExtendedWebElement saveActivityButton;

    @FindBy(xpath = "//*[contains(@resource-id, 'time_field')]/child::*[contains(@resource-id, 'time_button')]\n")
    private ExtendedWebElement timeButton;

    @FindBy(xpath = "//*[contains(@resource-id, 'duration_field')]/child::*[contains(@resource-id, 'time_button')]")
    private ExtendedWebElement durationButton;

    @FindBy(id = "com.google.android.apps.fitness:id/date_button")
    private ExtendedWebElement dateButton;

    @FindBy(id = "com.google.android.apps.fitness:id/material_timepicker_ok_button")
    private ExtendedWebElement durationPickerOkayButton;

    @FindBy(id = "com.google.android.apps.fitness:id/material_timepicker_view")
    private TimePickerModal timePickerModal;

    @FindBy(id = "com.google.android.apps.fitness:id/mtrl_picker_header")
    private DatePickerModal datePickerModal;

    @FindBy(xpath = "//*[@resource-id='com.google.android.apps.fitness:id/select_dialog_listview']/child::*[@class='android.widget.TextView']")
    private List <ExtendedWebElement> activityNameList;

    @FindBy(xpath = "//*[contains(@resource-id,'material_hour_text_input')]/child::*//*[@class='android.widget.EditText']")
    private ExtendedWebElement durationPickerHourField;

    @FindBy(xpath = "//*[contains(@resource-id,'material_minute_text_input')]")
    private ExtendedWebElement durationPickerMinuteField;

    @FindBy(xpath = "//*[contains(@resource-id,'material_minute_text_input')]/child::*//*[@class='android.widget.EditText']")
    private ExtendedWebElement activeDurationPickerMinuteField;


    private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

    public AddActivityPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isPageOpened() {

        return isPageOpened(title, "Add activity");
    }

    @Override
    public TimePickerModalBase setTime(Calendar calendar) {

        timeButton.click();

        if (!timePickerModal.isPageOpened()) {
            Assert.fail("[ TIMEPICKER PAGE ] TimePicker is not opened!");
        }

        timePickerModal.setTime(calendar);

        return initPage(getDriver(), TimePickerModalBase.class);
    }

    @Override
    public AddActivityPageBase setDuration(Calendar calendarTest) {

        durationButton.click();

        durationPickerHourField.type(String.valueOf(calendarTest.get(Calendar.HOUR)));

        durationPickerMinuteField.click();
        activeDurationPickerMinuteField.type(String.valueOf(calendarTest.get(Calendar.MINUTE)));

        hideKeyboard();

        durationPickerOkayButton.click();

        return initPage(getDriver(), AddActivityPageBase.class);
    }

    @Override
    public DatePickerModalBase setDate(Calendar calendar) {

        dateButton.click();

        if (!datePickerModal.isPageOpened()) {
            Assert.fail("[ DATE PICKER PAGE ] Date Picker is not opened!");
        }

        datePickerModal.setDate(calendar);

        return initPage(getDriver(), DatePickerModalBase.class);
    }

    @Override
    public String selectActivity(String activityTitle) {

        activityButton.click();

        String firstActivityTitle = activityNameList.get(0).getText();

        int compareResult = firstActivityTitle.compareTo(activityTitle);

        Direction direction = Direction.UP;

        if (compareResult > 0) {
            direction = Direction.DOWN;
        }

        ExtendedWebElement activityTitleElement = itemByText.format(activityTitle);
        swipe(activityTitleElement, direction, FORTY_COUNT, MEDIUM_SPEED);
        activityTitleElement.click();

        return activityTitle;
    }


    @Override
    public JournalPageBase saveActivity() {

        saveActivityButton.click();

        return initPage(getDriver(), JournalPageBase.class);
    }
}
