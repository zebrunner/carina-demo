package koval.myfit;

import com.zebrunner.agent.core.annotation.TestLabel;
import com.zebrunner.carina.core.registrar.ownership.MethodOwner;
import koval.myfit.mobile.gui.android.plusButtonPages.AddActivityPage;
import koval.myfit.mobile.gui.common.ActivityPageBase;
import koval.myfit.mobile.gui.common.downMenuPages.HomePageBase;
import koval.myfit.mobile.gui.common.downMenuPages.JournalPageBase;
import koval.myfit.mobile.service.enums.DownMenuElement;
import koval.myfit.mobile.service.enums.MaterialCardTopics;
import koval.myfit.mobile.service.enums.PlusButtonMenuElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.lang.invoke.MethodHandles;
import java.text.ParseException;
import java.time.LocalDate;
import java.util.*;
import java.util.concurrent.TimeUnit;


public class GoogleFitTest extends LoginTest {

    private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());


    @Test()
    @MethodOwner(owner = "koval")
    @TestLabel(name = "feature", value = {"mobile", "regression"})
    public void testPlusButton() {

        HomePageBase homePageBase = initPage(getDriver(), HomePageBase.class);
        Assert.assertTrue(homePageBase.isPageOpened(), "[ HOME PAGE ] Home page is not opened!");

        Assert.assertTrue(homePageBase.isPlusBtnStatic(), "[ HOME PAGE ] Plus-Button is not static while swiping");

        Assert.assertTrue(homePageBase.isPlusBtnOverElements(), "[ HOME PAGE ] Plus-Button is under element!");
        homePageBase.closePlusButtonMenu();

        Assert.assertTrue(homePageBase.isPlusButtonBelowBlockContainer(), "[ HOME PAGE ] Container is not above plus button!");

    }

    @Test()
    @MethodOwner(owner = "koval")
    @TestLabel(name = "feature", value = {"mobile", "regression"})
    public void compareListOfTopics() throws InterruptedException {

        HomePageBase homePageBase = initPage(getDriver(), HomePageBase.class);
        Assert.assertTrue(homePageBase.isPageOpened(), "[ HOME PAGE ] Home page is not opened!");

        TimeUnit.SECONDS.sleep(TIMEOUT_FIVE);

        for (MaterialCardTopics topic : MaterialCardTopics.values()) {
            Assert.assertTrue(homePageBase.isBlockByTitlePresent(topic),
                    String.format("[ HOME PAGE  ] '%s' block with this topic is not present!", topic));
        }

        List<String> EXPECTED_LIST_OF_PLAYLIST_TITLES =
                Arrays.asList("Workout", "Yoga", "Dance", "Meditate", "Mental Health", "Sleep");
        List<String> actualPlaylistTitlesList = homePageBase.getPlaylistTitlesToList();
        Assert.assertEquals(actualPlaylistTitlesList, EXPECTED_LIST_OF_PLAYLIST_TITLES,
                "[ HOME PAGE / actualPlaylistTitlesList ] Actual list of Playlist titles is not equals to expected list!");

    }


    @Test()
    @MethodOwner(owner = "koval")
    @TestLabel(name = "feature", value = {"mobile", "regression"})
    public void addActivity() throws InterruptedException, ParseException {

        HomePageBase homePageBase = initPage(getDriver(), HomePageBase.class);
        Assert.assertTrue(homePageBase.isPageOpened(), "[ HOME PAGE ] Home page is not opened!");

        TimeUnit.SECONDS.sleep(TIMEOUT_FIVE);

        JournalPageBase journalPageBase = (JournalPageBase) homePageBase.openPageFromDownMenuByName(DownMenuElement.JOURNAL);
        Assert.assertTrue(journalPageBase.isPageOpened(), "[ JOURNAL PAGE ] Journal page is not opened!");

        while (journalPageBase.getActivityListSize() != 0) {

            String firstActivityName = journalPageBase.getActivityName();

            ActivityPageBase activityPageBase = journalPageBase.openActivity();

            Assert.assertTrue(activityPageBase.isPageOpened(firstActivityName),
                    String.format("[ ACTIVITY PAGE ] Activity page  '%s' is not opened!", firstActivityName));

            activityPageBase.deleteActivity();
        }

        journalPageBase.openPlusButtonMenu();


        AddActivityPage addActivityPage =
                (AddActivityPage) journalPageBase.openPageFromPlusButtonMenuByName(PlusButtonMenuElement.ADD_ACTIVITY);
        Assert.assertTrue(addActivityPage.isPageOpened(), "[ ADD ACTIVITY PAGE ] Activity page is not opened!");


        int todayDay = LocalDate.now().getDayOfMonth();
        Random rand = new Random();
        int randomDayOfMonth = rand.nextInt(todayDay) + 1;
        int randomMinute = rand.nextInt(59) + 1;

        Calendar expectedActivityDateTime = new GregorianCalendar();
        expectedActivityDateTime.set(23, Calendar.JANUARY, randomDayOfMonth, 11, randomMinute, Calendar.AM);

        Calendar expectedActivityDuration = new GregorianCalendar();
        expectedActivityDuration.set(Calendar.HOUR, 0);
        expectedActivityDuration.set(Calendar.MINUTE, 35);


        String activityName = addActivityPage.selectRandomActivity().toLowerCase();
        addActivityPage.setTime(expectedActivityDateTime);
        addActivityPage.setDate(expectedActivityDateTime);
        addActivityPage.setDuration(expectedActivityDuration);

        addActivityPage.saveActivity();

        TimeUnit.SECONDS.sleep(TIMEOUT_FIVE);

        Assert.assertTrue(journalPageBase.isActivityPresent(activityName));
        int activityIndex = journalPageBase.getActivityIndex(activityName);

        int actualDuration = journalPageBase.getDuration(activityIndex).get(Calendar.MINUTE);
        int actualTimeHour = journalPageBase.getStartTime(activityIndex).get(Calendar.HOUR);
        int actualTimeMinute = journalPageBase.getStartTime(activityIndex).get(Calendar.MINUTE);

        Assert.assertEquals(actualDuration, expectedActivityDuration.get(Calendar.MINUTE));
        Assert.assertEquals(actualTimeHour, expectedActivityDateTime.get(Calendar.HOUR));
        Assert.assertEquals(actualTimeMinute, expectedActivityDateTime.get(Calendar.MINUTE));


        ActivityPageBase activityPageBase = journalPageBase.openActivityByIndex(activityIndex);
        Assert.assertTrue(activityPageBase.getDateTime(expectedActivityDateTime, expectedActivityDuration),
                "Actual time is not what expected ");


    }

}
