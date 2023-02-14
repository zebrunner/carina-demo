package koval.myfit;

import com.zebrunner.agent.core.annotation.TestLabel;
import com.zebrunner.carina.core.registrar.ownership.MethodOwner;
import koval.myfit.mobile.gui.android.plusButtonPages.AddActivityPage;
import koval.myfit.mobile.gui.common.ActivityPageBase;
import koval.myfit.mobile.gui.common.downMenuPages.HomePageBase;
import koval.myfit.mobile.gui.common.downMenuPages.JournalPageBase;
import koval.myfit.mobile.service.enums.DownMenuElement;
import koval.myfit.mobile.service.enums.PlusButtonMenuElement;
import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.lang.invoke.MethodHandles;
import java.util.*;
import java.util.concurrent.TimeUnit;


public class GoogleFitTest extends LoginTest {

    private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());


    @Test()
    @MethodOwner(owner = "koval")
    @TestLabel(name = "1. Check if Home page is open and Plus button is present while swiping " +
            "/1.2. Check if Plus-Button is static while swiping->check if Plus-Button is below container at the end", value = {"mobile"})
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
    @TestLabel(name = "2. Compare playlist titles and block card topics Lists with expected lists", value = {"mobile"})
    public void compareListOfTopics() throws InterruptedException {

        HomePageBase homePageBase = initPage(getDriver(), HomePageBase.class);
        Assert.assertTrue(homePageBase.isPageOpened(), "[ HOME PAGE ] Home page is not opened!");

        TimeUnit.SECONDS.sleep(TIMEOUT_FIVE);

//        for (MaterialCardTopics topic : MaterialCardTopics.values()) {
//            Assert.assertTrue(homePageBase.isBlockByTitlePresent(topic),
//                    String.format("[ HOME PAGE  ] '%s' block with this topic is not present!", topic));
//        }

        List<String> EXPECTED_LIST_OF_PLAYLIST_TITLES =
                Arrays.asList("Workout", "Yoga", "Dance", "Meditate", "Mental Health", "Sleep");
        List<String> actualPlaylistTitlesList = homePageBase.getPlaylistTitlesToList();
        Assert.assertEquals(actualPlaylistTitlesList, EXPECTED_LIST_OF_PLAYLIST_TITLES,
                "[ HOME PAGE / actualPlaylistTitlesList ] Actual list of Playlist titles is not equals to expected list!");

    }


    @Test()
    @MethodOwner(owner = "koval")
    @TestLabel(name = "3. Add Activity -> Check this Activity in Journal Page -> Delete Activity", value = {"mobile"})
    public void addActivity() throws InterruptedException {

        HomePageBase homePageBase = initPage(getDriver(), HomePageBase.class);
        Assert.assertTrue(homePageBase.isPageOpened(), "[ HOME PAGE ] Home page is not opened!");

        TimeUnit.SECONDS.sleep(TIMEOUT_FIVE);


//        homePageBase.openPlusButtonMenu();
//
//        AddActivityPage addActivityPage =
//                (AddActivityPage) homePageBase.openPageFromPlusButtonMenuByName(PlusButtonMenuElement.ADD_ACTIVITY);
//        Assert.assertTrue(addActivityPage.isPageOpened(), "[ ADD ACTIVITY PAGE ] Activity page is not opened!");


        Random rand = new Random();
        int randomDayOfMonth = rand.nextInt(28) + 1;
        int randomMonth = rand.nextInt(12) + 1;


        Calendar calendar = new GregorianCalendar();
        calendar.set(Calendar.DAY_OF_MONTH, randomDayOfMonth);
        calendar.set(Calendar.MONTH, randomMonth);
        calendar.set(Calendar.YEAR, 23);

        calendar.set(Calendar.HOUR, 14);
        calendar.set(Calendar.MINUTE, 20);
        calendar.set(Calendar.AM_PM, Calendar.AM);


        Calendar calendarTest = new GregorianCalendar();
       calendarTest.set(Calendar.HOUR, 0);
        calendarTest.set(Calendar.MINUTE, 35);


 //     String activityName =  addActivityPage.selectRandomActivity();
//        addActivityPage.setTime(calendar);
//        addActivityPage.setDate(calendar);
 //        addActivityPage.setDuration(calendarTest);

//        addActivityPage.saveActivity();
//
//
//
//
//
        JournalPageBase journalPageBase = (JournalPageBase) homePageBase.openPageFromDownMenuByName(DownMenuElement.JOURNAL);
        Assert.assertTrue(journalPageBase.isPageOpened(), "[ JOURNAL PAGE ] Journal page is not opened!");

        Assert.assertTrue(journalPageBase.isActivityPresent("fencing")); //activityName


//        while (journalPageBase.getActivityListSize() != 0) {
//
//            String activityName = journalPageBase.getActivityName();
//
//            ActivityPageBase activityPageBase = journalPageBase.openActivity();
//
//            Assert.assertTrue(activityPageBase.isPageOpened(activityName), String.format("[ ACTIVITY PAGE ] Activity page  '%s' is not opened!", activityName));
//
//            activityPageBase.deleteActivity();
//        }

        //   Login -> Click on PlusButton -> Add Activity(Select random activity, enter Start and Duration)
///-> Click Save -> Check this Activity in Journal Page(Compare Activity, Time and Duration)
        //-> Delete Selected Activity -> Clear List of Activities
    }


}
