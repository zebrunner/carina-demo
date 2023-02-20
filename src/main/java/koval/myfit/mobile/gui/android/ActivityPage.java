package koval.myfit.mobile.gui.android;


import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.utils.factory.DeviceType;
import koval.myfit.mobile.gui.common.ActivityPageBase;
import koval.myfit.mobile.gui.common.downMenuPages.JournalPageBase;
import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.invoke.MethodHandles;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;


@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = ActivityPageBase.class)
public class ActivityPage extends ActivityPageBase {


    @FindBy(id = "com.google.android.apps.fitness:id/subtitle")
    private ExtendedWebElement dateTimeDurationLabel;

    @FindBy(xpath = "//*[@text='%s']")
    private ExtendedWebElement itemByText;

    @FindBy(id = "com.google.android.apps.fitness:id/title")
    private ExtendedWebElement title;

    @FindBy(xpath = "//android.widget.ImageView[@content-desc='More options']")
    private ExtendedWebElement moreActionButton;


    private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());


    public ActivityPage(WebDriver driver) {
        super(driver);
    }

    public boolean isPageOpened(String activityName) {

        return title.isElementPresent(TIMEOUT_FIVE) && title.getText().contains(activityName);
    }

    @Override
    public JournalPageBase deleteActivity() {

        moreActionButton.click();
        itemByText.format("Delete").click();
        itemByText.format("Delete").click();

        return initPage(getDriver(), JournalPageBase.class);
    }



    @Override
    public Calendar getStartDateTime() throws ParseException {


        String dateTimeString = dateTimeDurationLabel.getText();
        String startTimeString = StringUtils.split(dateTimeString, "–")[0];

        Calendar startTime = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat(START_TIME_DATE_FORMAT);
        startTime.setTime(sdf.parse(startTimeString));

return startTime;
    }


    @Override
    public Calendar getEndTime() throws ParseException {


        String dateTimeString = dateTimeDurationLabel.getText();
        String endTimeString = StringUtils.split(dateTimeString, "–")[1];

        Calendar endTime = Calendar.getInstance();
        SimpleDateFormat sd = new SimpleDateFormat(END_TIME_FORMAT);
        endTime.setTime(sd.parse(endTimeString));

return endTime;
    }


}
