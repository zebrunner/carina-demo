package koval.myfit.mobile.gui.android.plusButtonPages;


import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.utils.factory.DeviceType;
import koval.myfit.mobile.gui.android.modal.TimePickerModal;
import koval.myfit.mobile.gui.common.modal.TimePickerModalBase;
import koval.myfit.mobile.gui.common.plusButtonPages.AddActivityPageBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;

import java.lang.invoke.MethodHandles;
import java.util.Arrays;
import java.util.Calendar;
import java.util.List;
import java.util.Random;


@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = AddActivityPageBase.class)
public class AddActivityPage extends AddActivityPageBase {

    @FindBy(id = "com.google.android.apps.fitness:id/expanded_title")
    private ExtendedWebElement title;

    @FindBy(xpath = "//*[@text='%s']")
    private ExtendedWebElement itemByText;

    @FindBy(id = "com.google.android.apps.fitness:id/activity_spinner")
    private ExtendedWebElement activityButton;

    @FindBy(id = "com.google.android.apps.fitness:id/time_button")
    private ExtendedWebElement timeButton;

    @FindBy(id = "android:id/content")
    private TimePickerModal timePickerModal;

    @FindBy(id = "com.google.android.apps.fitness:id/select_dialog_listview")
    private ExtendedWebElement activityContainer;

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

        Assert.assertTrue(timePickerModal.isPageOpened(), "[ TIMEPICKER PAGE ] TimePicker is not opened!");

        timePickerModal.setTime(calendar);

        return initPage(getDriver(), TimePickerModalBase.class);
    }

    @Override
    public AddActivityPageBase selectActivity(String activityTitle) {

        activityButton.click();

        String firstActivityTitle = activityContainer.findExtendedWebElement(By.className("android.widget.TextView")).getText();

        int compareResult = firstActivityTitle.compareTo(activityTitle);

        Direction direction = Direction.UP;

        if (compareResult > 0) {
            direction = Direction.DOWN;
        }

        swipe(itemByText.format(activityTitle), direction);
        itemByText.format(activityTitle).click();

        return initPage(getDriver(), AddActivityPageBase.class);
    }

    @Override
    public AddActivityPageBase selectRandomActivity() {

        Random rand = new Random();

        List<String> listOfActivities = Arrays.asList("Badminton", "Golf", "Fencing", "Hockey", "Polo", "Skiing", "Yoga");

        int randomIndex = rand.nextInt(listOfActivities.size());

        return selectActivity(listOfActivities.get(randomIndex));
    }
}
