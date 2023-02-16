package koval.myfit.mobile.gui.android;


import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.utils.factory.DeviceType;
import koval.myfit.mobile.gui.common.ActivityPageBase;
import koval.myfit.mobile.gui.common.downMenuPages.JournalPageBase;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.time.DateUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;

import java.lang.invoke.MethodHandles;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;


@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = ActivityPageBase.class)
public class ActivityPage extends ActivityPageBase {


    @FindBy(id = "com.google.android.apps.fitness:id/subtitle")
    private ExtendedWebElement dateTimeDurationLabel;

    @FindBy(xpath = "//*[@text='%s']")
    private ExtendedWebElement itemByText;

    @FindBy(id = "com.google.android.apps.fitness:id/title")
    private ExtendedWebElement title;

    @FindBy(id = "android:id/button1")
    private ExtendedWebElement deleteButton;

    @FindBy(xpath = "//android.widget.ImageView[@content-desc='More options']")
    private ExtendedWebElement moreActionButton;

    @FindBy(id = "android:id/button1")
    private ExtendedWebElement okayButton;

    private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());


    public ActivityPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isPageOpened(String activityName) {

        return isPageOpened(title, activityName);
    }

    @Override
    public JournalPageBase deleteActivity() {

        moreActionButton.click();
        itemByText.format("Delete").click();
        deleteButton.click();

        return initPage(getDriver(), JournalPageBase.class);
    }

    @Override
    public Date getDateTime(Calendar expectedActivityDateTime, Calendar expectedActivityDuration) throws ParseException {

        String dateTimeString = dateTimeDurationLabel.getText();

        String startTimeString = StringUtils.split(dateTimeString, "–")[0];
        String endTimeString = StringUtils.split(dateTimeString, "–")[1];

        Calendar startTime = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat("MMM dd, hh:mm");
        startTime.setTime(sdf.parse(startTimeString));


        Calendar endTime = Calendar.getInstance();
        SimpleDateFormat sd = new SimpleDateFormat("hh:mm a");
        endTime.setTime(sd.parse(endTimeString));

        Date expectedEndTime = DateUtils.addMinutes(startTime.getTime(), expectedActivityDuration.get(Calendar.MINUTE));

        Assert.assertEquals(sd.format(endTime.getTime()), sd.format(expectedEndTime));

        Assert.assertEquals(startTime.get(Calendar.MONTH), expectedActivityDateTime.get(Calendar.MONTH),
                "[ ACTIVITY PAGE ] Actual month is not what expected!");
        Assert.assertEquals(startTime.get(Calendar.DAY_OF_MONTH), expectedActivityDateTime.get(Calendar.DAY_OF_MONTH),
                "[ ACTIVITY PAGE ] Actual day of month is not what expected!");
        Assert.assertEquals(startTime.get(Calendar.HOUR), expectedActivityDateTime.get(Calendar.HOUR),
                "[ ACTIVITY PAGE ] Actual hour is not what expected!");
        Assert.assertEquals(startTime.get(Calendar.MINUTE), expectedActivityDateTime.get(Calendar.MINUTE),
                "[ ACTIVITY PAGE ] Actual minute is not what expected!");

        return startTime.getTime();
    }

}
