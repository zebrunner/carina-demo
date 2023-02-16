package koval.myfit.mobile.gui.android.modal;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.utils.factory.DeviceType.Type;
import koval.myfit.mobile.gui.common.modal.DatePickerModalBase;

import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.invoke.MethodHandles;
import java.util.Calendar;


@DeviceType(pageType = Type.ANDROID_PHONE, parentClass = DatePickerModalBase.class)
public class DatePickerModal extends DatePickerModalBase {

    @FindBy(id = "com.google.android.apps.fitness:id/mtrl_picker_title_text")
    private ExtendedWebElement title;

    @FindBy(id = "com.google.android.apps.fitness:id/mtrl_picker_header_toggle")
    private ExtendedWebElement datePickerModeButton;

    @FindBy(id = "com.google.android.apps.fitness:id/mtrl_calendar_frame")
    private ExtendedWebElement calendarImage;

    @FindBy(id = "com.google.android.apps.fitness:id/confirm_button")
    private ExtendedWebElement okayButton;

    @FindBy(xpath = "//*[contains(@resource-id, 'mtrl_picker_text_input_date')]/child::*//*[@class='android.widget.EditText']")
    private ExtendedWebElement inputDateField;

    private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

    public DatePickerModal(WebDriver driver) {
        super(driver);
    }

    public DatePickerModal(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }


    @Override
    public boolean isPageOpened() {

        return isPageOpened(title, "SELECT DATE");
    }


    @Override
    public DatePickerModalBase setDate(Calendar calendar) {

        if (calendarImage.isElementPresent(TIMEOUT_FIVE)) {
            datePickerModeButton.click();
        }

        inputDateField.type((calendar.get(Calendar.MONTH) + 1) + "/" + calendar.get(Calendar.DAY_OF_MONTH) + "/" + calendar.get(Calendar.YEAR));

        okayButton.click();

        return initPage(getDriver(), DatePickerModalBase.class);
    }

}
