package koval.myfit;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.agent.core.annotation.TestLabel;
import com.zebrunner.carina.core.registrar.ownership.MethodOwner;
import koval.myfit.mobile.gui.android.modal.PlusButtonModal;
import koval.myfit.mobile.gui.android.plusButtonPages.AddActivityPage;
import koval.myfit.mobile.gui.common.ActivityPageBase;
import koval.myfit.mobile.gui.common.downMenuPages.HomePageBase;
import koval.myfit.mobile.gui.common.downMenuPages.JournalPageBase;
import koval.myfit.mobile.gui.common.modal.PlusButtonModalBase;
import koval.myfit.mobile.gui.common.plusButtonPages.AddActivityPageBase;
import koval.myfit.mobile.service.enums.DownMenuElement;
import koval.myfit.mobile.service.enums.MaterialCardTopics;
import koval.myfit.mobile.service.enums.PlusButtonMenuElement;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.time.DateUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.lang.invoke.MethodHandles;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.*;
import java.util.concurrent.TimeUnit;


public class GoogleFitTest extends LoginTest {

    private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());


    @Test()
    @MethodOwner(owner = "koval")
    @TestLabel(name = "feature", value = {"mobile", "regression"})
    public void testPlusButtonTest() {

        HomePageBase homePageBase = initPage(getDriver(), HomePageBase.class);
        Assert.assertTrue(homePageBase.isPageOpened(), "[ HOME PAGE ] Home page is not opened!");

        Assert.assertTrue(homePageBase.isPlusBtnStatic(), "[ HOME PAGE ] Plus-Button is not static while swiping");

        Assert.assertTrue(homePageBase.isPlusBtnOverElements(), "[ HOME PAGE ] Plus-Button is under element!");
        homePageBase.closePlusButtonMenu();

        Assert.assertTrue(homePageBase.isPlusButtonBelowBlockContainer(),
                "[ HOME PAGE ] Container is not above plus button!");

    }

    @Test()
    @MethodOwner(owner = "koval")
    @TestLabel(name = "feature", value = {"mobile", "regression"})
    public void compareListOfTopicsTest() throws InterruptedException {

        HomePageBase homePageBase = initPage(getDriver(), HomePageBase.class);
        Assert.assertTrue(homePageBase.isPageOpened(), "[ HOME PAGE ] Home page is not opened!");


        for (MaterialCardTopics topic : MaterialCardTopics.values()) {
            Assert.assertTrue(homePageBase.isBlockByTitlePresent(topic),
                    String.format("[ HOME PAGE  ] '%s' block with this topic is not present!", topic));
        }

        List<String> EXPECTED_LIST_OF_PLAYLIST_TITLES = Arrays.asList("Workout", "Yoga", "Dance", "Meditate", "Mental Health", "Sleep");
        List<String> actualPlaylistTitlesList = homePageBase.getPlaylistTitlesToList();
        Assert.assertEquals(actualPlaylistTitlesList, EXPECTED_LIST_OF_PLAYLIST_TITLES,
                "[ HOME PAGE / actualPlaylistTitlesList ] Actual list of Playlist titles is not equals to expected list!");


    }


    @Test()
    @MethodOwner(owner = "koval")
    @TestLabel(name = "feature", value = {"mobile", "regression"})
    public void addActivityTest() throws ParseException {

        HomePageBase homePageBase = initPage(getDriver(), HomePageBase.class);
        Assert.assertTrue(homePageBase.isPageOpened(), "[ HOME PAGE ] Home page is not opened!");


        JournalPageBase journalPageBase = (JournalPageBase) homePageBase.openPageFromDownMenuByName(DownMenuElement.JOURNAL);
        Assert.assertTrue(journalPageBase.isPageOpened(), "[ JOURNAL PAGE ] Journal page is not opened!");

        journalPageBase.clearActivityList();

        PlusButtonModalBase plusButtonModal = journalPageBase.openPlusButtonMenu();

        AddActivityPageBase addActivityPageBase = (AddActivityPage) plusButtonModal.openPageByName(PlusButtonMenuElement.ADD_ACTIVITY);
        Assert.assertTrue(addActivityPageBase.isPageOpened(), "[ ADD ACTIVITY PAGE ] Add Activity page is not opened!");


        Calendar calendar = Calendar.getInstance();
        int currentHour = calendar.get(Calendar.HOUR);
        int currentMinutes = calendar.get(Calendar.MINUTE);
        int currentAmPm = calendar.get(Calendar.AM_PM);
        int currentDay = calendar.get(Calendar.DAY_OF_MONTH);
        int currentMonth = calendar.get(Calendar.MONTH);
        int currentYear = calendar.get(Calendar.YEAR);

        Calendar expectedActivityDateTime = new GregorianCalendar();
        expectedActivityDateTime.set(currentYear, currentMonth, currentDay, currentHour, currentMinutes, currentAmPm);

        Calendar expectedActivityDuration = new GregorianCalendar();
        expectedActivityDuration.set(Calendar.HOUR, NULL);
        expectedActivityDuration.set(Calendar.MINUTE, 35);

        Random rand = new Random();
        List<String> listOfActivities = Arrays.asList("Rowing", "Flossing", "Skiing", "Kettlebell", "Squash");
        int randomIndex = rand.nextInt(listOfActivities.size());

        String activityName = addActivityPageBase.selectActivity(listOfActivities.get(randomIndex)).toLowerCase();
        addActivityPageBase.setTime(expectedActivityDateTime);
        addActivityPageBase.setDate(expectedActivityDateTime);
        addActivityPageBase.setDuration(expectedActivityDuration);


        journalPageBase = addActivityPageBase.saveActivity();


        Assert.assertTrue(journalPageBase.isActivityPresent(activityName),
                String.format("[ JOURNAL PAGE ] Activity '%s' is not present!", activityName));


        int actualDuration = journalPageBase.getDuration().get(Calendar.MINUTE);
        int actualTimeHour = journalPageBase.getStartTime().get(Calendar.HOUR);
        int actualTimeMinute = journalPageBase.getStartTime().get(Calendar.MINUTE);

        Assert.assertEquals(actualDuration, expectedActivityDuration.get(Calendar.MINUTE),
                "[ JOURNAL PAGE ] Actual duration is not what expected!");
        Assert.assertEquals(actualTimeHour, expectedActivityDateTime.get(Calendar.HOUR),
                "[ JOURNAL PAGE ] Actual start time(hour) is not what expected!");
        Assert.assertEquals(actualTimeMinute, expectedActivityDateTime.get(Calendar.MINUTE),
                "[ JOURNAL PAGE ] Actual start time(minute) is not what expected!");


        ActivityPageBase activityPageBase = journalPageBase.openActivity();
        Assert.assertTrue(activityPageBase.isPageOpened(activityName),
                String.format("[ ACTIVITY PAGE ] Activity page '%s' is not opened!", activityName));


        Calendar startTime = activityPageBase.getStartDateTime();
        Calendar endTime = activityPageBase.getEndTime();
        Date expectedEndTime = DateUtils.addMinutes(startTime.getTime(), expectedActivityDuration.get(Calendar.MINUTE));
        SimpleDateFormat sd = new SimpleDateFormat(END_TIME_FORMAT);


        Assert.assertEquals(startTime.get(Calendar.MONTH) + 1, expectedActivityDateTime.get(Calendar.MONTH),
                "[ ACTIVITY PAGE ] Actual month is not what expected!");
        Assert.assertEquals(startTime.get(Calendar.DAY_OF_MONTH), expectedActivityDateTime.get(Calendar.DAY_OF_MONTH),
                "[ ACTIVITY PAGE ] Actual day of month is not what expected!");
        Assert.assertEquals(startTime.get(Calendar.HOUR), expectedActivityDateTime.get(Calendar.HOUR),
                "[ ACTIVITY PAGE ] Actual hour is not what expected!");
        Assert.assertEquals(startTime.get(Calendar.MINUTE), expectedActivityDateTime.get(Calendar.MINUTE),
                "[ ACTIVITY PAGE ] Actual minute is not what expected!");
        Assert.assertEquals(sd.format(endTime.getTime()), sd.format(expectedEndTime),
                "[ ACTIVITY PAGE ] Actual end time is not what expected!");


        activityPageBase.deleteActivity();

        Assert.assertEquals(journalPageBase.getActivityListSize(), 0,
                "[ JOURNAL PAGE ] Activity list is not empty!");
    }
}
