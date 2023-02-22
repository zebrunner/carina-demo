package koval.myfit.mobile.gui.android.plusButtonPages;


import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.utils.factory.DeviceType;
import koval.myfit.mobile.gui.android.modal.TimePickerModal;
import koval.myfit.mobile.gui.common.downMenuPages.HomePageBase;
import koval.myfit.mobile.gui.common.modal.TimePickerModalBase;
import koval.myfit.mobile.gui.common.plusButtonPages.AddActivityPageBase;
import koval.myfit.mobile.gui.common.plusButtonPages.AddBloodPressurePageBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;

import java.lang.invoke.MethodHandles;
import java.util.Calendar;


@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = AddBloodPressurePageBase.class)
public class AddBloodPressurePage extends AddBloodPressurePageBase {

    @FindBy(id = "com.google.android.apps.fitness:id/expanded_title")
    private ExtendedWebElement title;

    @FindBy(id = "com.google.android.apps.fitness:id/container_action_button")
    private ExtendedWebElement saveActivityButton;

    @FindBy(id = "com.google.android.apps.fitness:id/time_button")
    private ExtendedWebElement timeButton;

    @FindBy(xpath = "//*[contains(@resource-id, 'pickers_container')]/child::*[@class='android.widget.NumberPicker'][1]")
    private ExtendedWebElement topNumberBloodPressureContainer;

    @FindBy(xpath = "//*[contains(@resource-id, 'pickers_container')]/child::*[@class='android.widget.NumberPicker'][2]")
    private ExtendedWebElement bottomNumberBloodPressureContainer;

    @FindBy(xpath = "//android.widget.EditText[@text='%s']")
    private ExtendedWebElement bloodPressureByTextPicker;

    @FindBy(xpath = "//*[@text='%s']")
    private ExtendedWebElement itemByText;

    @FindBy(xpath = "//*[contains(@resource-id, 'pickers_container')]/child::*[@class='android.widget.NumberPicker'][1]/child::*[@class='android.widget.EditText']")
    private ExtendedWebElement topNumberBloodPressurePicker;

    @FindBy(xpath = "//*[contains(@resource-id, 'pickers_container')]/child::*[@class='android.widget.NumberPicker'][2]/child::*[@class='android.widget.EditText']")
    private ExtendedWebElement bottomNumberBloodPressurePicker;

    @FindBy(id = "android:id/content")
    private TimePickerModal timePickerModal;


    @FindBy(id = "com.google.android.apps.fitness:id/action_bar_root")
    private ExtendedWebElement saveVitalsAllowPopUp;


    private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());


    public AddBloodPressurePage(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isPageOpened() {

        return isPageOpened(title, "Add data");
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
    public AddActivityPageBase setBloodPressure(int topNumberBloodPressure, int bottomNumberBloodPressure) {

        setBloodPressure(topNumberBloodPressure, topNumberBloodPressureContainer, topNumberBloodPressurePicker);

        setBloodPressure(bottomNumberBloodPressure,bottomNumberBloodPressureContainer, bottomNumberBloodPressurePicker);


        return initPage(getDriver(), AddActivityPageBase.class);
    }



    @Override
    public AddBloodPressurePageBase setBloodPressure(int bloodPressureNumber, ExtendedWebElement bloodPressureContainer, ExtendedWebElement bloodPressureElement) {

        Direction direction = Direction.UP;

        int actualBloodPressureNumber = Integer.parseInt(bloodPressureElement.getText());
        LOGGER.info(String.valueOf(actualBloodPressureNumber));

        if (bloodPressureNumber < actualBloodPressureNumber) {
            direction = Direction.DOWN;
        }

        ExtendedWebElement bloodPressurePicker = bloodPressureByTextPicker.format(bloodPressureNumber);
        swipe(bloodPressurePicker, bloodPressureContainer, direction, FORTY_COUNT, HIGH_SPEED_200);

        return initPage(getDriver(), AddBloodPressurePageBase.class);
    }

    @Override
    public HomePageBase saveBloodPressure() {

        saveActivityButton.click();

        if(saveVitalsAllowPopUp.isElementPresent(TIMEOUT_FIVE))
        {
            itemByText.format("Allow").click();
        }

        return initPage(getDriver(), HomePageBase.class);
    }


}
