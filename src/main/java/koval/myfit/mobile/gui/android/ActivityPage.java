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
    public Date getDateTime(Calendar calendar, Calendar calendarTest) throws ParseException {

        String dateTime = dateTimeDurationLabel.getText();

        String startTime = StringUtils.split(dateTime, "–")[0];
        String endTime = StringUtils.split(dateTime, "–")[1];



        Calendar cal = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat("MMM dd, hh:mm");
        cal.setTime(sdf.parse(startTime));


//        Calendar calendar = new GregorianCalendar();
//        calendar.set(23, Calendar.JANUARY, 7, 11, 10, Calendar.AM);
//
//        Calendar calendarTest = new GregorianCalendar();
//        calendarTest.set(Calendar.HOUR, 0);
//        calendarTest.set(Calendar.MINUTE, 30);


        Calendar calSec = Calendar.getInstance();
        SimpleDateFormat sd = new SimpleDateFormat("hh:mm a");
        calSec.setTime(sd.parse(endTime));

        Date newYearsDay = DateUtils.addMinutes(cal.getTime(), calendarTest.get(Calendar.MINUTE));


        Assert.assertEquals(sd.format(newYearsDay), sd.format(calSec.getTime()));
//        Assert.assertEquals(cal.get(Calendar.MINUTE) + calendarTest.get(Calendar.MINUTE), calSec.get(Calendar.MINUTE));



        Assert.assertEquals(cal.get(Calendar.MONTH), calendar.get(Calendar.MONTH), "month");
        Assert.assertEquals(cal.get(Calendar.DAY_OF_MONTH), calendar.get(Calendar.DAY_OF_MONTH), "DAY_OF_MONTH");
        Assert.assertEquals(cal.get(Calendar.HOUR), calendar.get(Calendar.HOUR), "HOUR");
        Assert.assertEquals(cal.get(Calendar.MINUTE), calendar.get(Calendar.MINUTE), "MINUTE");

//        if(cal.get(Calendar.MONTH) == calendar.get(Calendar.MONTH) && cal.get(Calendar.DAY_OF_MONTH) == calendar.get(Calendar.DAY_OF_MONTH)
//        && cal.get(Calendar.HOUR) == calendar.get(Calendar.HOUR) && cal.get(Calendar.MINUTE) == calendar.get(Calendar.MINUTE))
//        {
//
//            LOGGER.info("equal");
//        } else {
//            LOGGER.info("no");
//        }


        return cal.getTime();
    }

}
