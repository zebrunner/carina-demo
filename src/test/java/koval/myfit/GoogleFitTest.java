package koval.myfit;

import com.zebrunner.agent.core.annotation.TestLabel;
import com.zebrunner.carina.core.registrar.ownership.MethodOwner;
import koval.mobile.myfit.gui.android.plusButtonPages.AddActivityPage;
import koval.mobile.myfit.gui.common.ActivityPageBase;
import koval.mobile.myfit.gui.common.browsePages.VitalsPageBase;
import koval.mobile.myfit.gui.common.downMenuPages.BrowsePageBase;
import koval.mobile.myfit.gui.common.aboutMePages.BirthdayPageBase;
import koval.mobile.myfit.gui.common.aboutMePages.GenderPageBase;
import koval.mobile.myfit.gui.common.aboutMePages.HeightPageBase;
import koval.mobile.myfit.gui.common.aboutMePages.WeightPageBase;
import koval.mobile.myfit.gui.common.downMenuPages.HomePageBase;
import koval.mobile.myfit.gui.common.downMenuPages.JournalPageBase;
import koval.mobile.myfit.gui.common.downMenuPages.ProfilePageBase;
import koval.mobile.myfit.gui.common.modal.DownMenuModalBase;
import koval.mobile.myfit.gui.common.modal.PlusButtonModalBase;
import koval.mobile.myfit.gui.common.plusButtonPages.AddActivityPageBase;
import koval.mobile.myfit.gui.common.plusButtonPages.AddBloodPressurePageBase;
import koval.mobile.myfit.service.enums.*;
import org.apache.commons.lang3.time.DateUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.Test;


import java.io.IOException;
import java.lang.invoke.MethodHandles;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.List;


public class GoogleFitTest extends LoginTest {

    private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());
    Calendar calendar = Calendar.getInstance();
    int currentHour = calendar.get(Calendar.HOUR);
    int currentMinutes = calendar.get(Calendar.MINUTE);
    int currentAmPm = calendar.get(Calendar.AM_PM);
    int currentDay = calendar.get(Calendar.DAY_OF_MONTH);
    int currentMonth = calendar.get(Calendar.MONTH);
    int currentYear = calendar.get(Calendar.YEAR);


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


        List<String> expectedListOfPlaylistTitles = Arrays.asList("Workout", "Yoga", "Dance", "Meditate", "Mental Health", "Sleep");
        List<String> actualPlaylistTitlesList = homePageBase.getPlaylistTitlesToList();
        Assert.assertEquals(actualPlaylistTitlesList, expectedListOfPlaylistTitles,
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


        Calendar expectedActivityDateTime = new GregorianCalendar();
        expectedActivityDateTime.set(currentYear, currentMonth, currentDay, currentHour, currentMinutes);
        expectedActivityDateTime.set(Calendar.AM_PM, currentAmPm);

        Calendar expectedActivityDuration = new GregorianCalendar();
        expectedActivityDuration.set(Calendar.HOUR, 0);
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


    @Test()
    @MethodOwner(owner = "koval")
    @TestLabel(name = "feature", value = {"mobile", "regression"})
    public void addBloodPressureTest() {

        HomePageBase homePageBase = initPage(getDriver(), HomePageBase.class);
        Assert.assertTrue(homePageBase.isPageOpened(), "[ HOME PAGE ] Home page is not opened!");


        PlusButtonModalBase plusButtonModal = homePageBase.openPlusButtonMenu();

        AddBloodPressurePageBase addBloodPressurePageBase = (AddBloodPressurePageBase)
                plusButtonModal.openPageByName(PlusButtonMenuElement.ADD_BLOOD_PRESSURE);
        Assert.assertTrue(addBloodPressurePageBase.isPageOpened(),
                "[ ADD BLOOD PRESSURE PAGE ] Add Blood Pressure page is not opened!");


        Calendar expectedBloodPressureTime = new GregorianCalendar();
        expectedBloodPressureTime.set(currentYear, currentMonth, currentDay, currentHour, currentMinutes);
        expectedBloodPressureTime.set(Calendar.AM_PM, currentAmPm);


        int expectedTopNumberBloodPressure = 129;
        int expectedBottomNumberBloodPressure = 78;

        addBloodPressurePageBase.setTime(expectedBloodPressureTime);
        addBloodPressurePageBase.setBloodPressure(expectedTopNumberBloodPressure, expectedBottomNumberBloodPressure);

        homePageBase = addBloodPressurePageBase.saveBloodPressure();


        BrowsePageBase browsePageBase = (BrowsePageBase) homePageBase.openPageFromDownMenuByName(DownMenuElement.BROWSE);
        VitalsPageBase vitalsPageBase = (VitalsPageBase) browsePageBase.openCategoryByName(BrowseMenuElement.VITALS);

        int actualTopNumberBloodPressure = vitalsPageBase.getTopNumberBloodPressure();
        int actualBottomNumberBloodPressure = vitalsPageBase.getBottomNumberBloodPressure();

        Assert.assertEquals(actualTopNumberBloodPressure, expectedTopNumberBloodPressure,
                String.format("[ VITALS PAGE ] Expected top number blood pressure  '%s', Actual: '%s'!",
                        expectedTopNumberBloodPressure, actualTopNumberBloodPressure));
        Assert.assertEquals(actualBottomNumberBloodPressure, expectedBottomNumberBloodPressure,
                String.format("[ VITALS PAGE ] Expected bottom number blood pressure  '%s', Actual: '%s'!",
                        expectedBottomNumberBloodPressure, actualBottomNumberBloodPressure));

    }


    @Test()
    @MethodOwner(owner = "koval")
    @TestLabel(name = "feature", value = {"mobile", "regression"})
    public void changeProfileDataTest() throws ParseException {

        HomePageBase homePageBase = initPage(getDriver(), HomePageBase.class);
        Assert.assertTrue(homePageBase.isPageOpened(), "[ HOME PAGE ] Home page is not opened!");

        ProfilePageBase profilePageBase = (ProfilePageBase) homePageBase.openPageFromDownMenuByName(DownMenuElement.PROFILE);
        Assert.assertTrue(profilePageBase.isPageOpened(), "[ PROFILE PAGE ] Profile page is not opened!");

        Calendar actualBirthday = profilePageBase.getCurrentBirthday();
        String actualGender = profilePageBase.getCurrentGender();
        float actualHeight = profilePageBase.getCurrentHeight(PersonCharacteristics.HEIGHT);
        float actualWeight = profilePageBase.getCurrentWeight(PersonCharacteristics.WEIGHT);
        String actualWeightMeasure = profilePageBase.getCurrentWeightMeasure(PersonCharacteristics.WEIGHT);


        Calendar expectedBirthday = Calendar.getInstance();
        expectedBirthday.set(Calendar.DAY_OF_MONTH, currentDay + 3);
        expectedBirthday.set(Calendar.MONTH, currentMonth + 3);
        expectedBirthday.set(Calendar.YEAR, currentYear - 25);

        String expectedGender = Gender.FEMALE.getGender();

        int expectedHeightCentimeters = 176;
        float expectedHeightFeet = 4.5F;

        float expectedWeightKilograms = 69.5F;
        float expectedWeightPounds = 175.4F;
        float expectedWeightStones = 13.5F;
        WeightMeasures expectedWeightMeasure = WeightMeasures.POUNDS;


        SimpleDateFormat birthFormat = new SimpleDateFormat(BIRTHDAY_DATE_FORMAT);

        if (!birthFormat.format(expectedBirthday.getTime()).equals(birthFormat.format(actualBirthday.getTime()))) {

            BirthdayPageBase birthdayPageBase = (BirthdayPageBase)
                    profilePageBase.clickOnCharacteristicsBtn(PersonCharacteristics.BIRTHDAY);
            Assert.assertTrue(birthdayPageBase.isPageOpened(), "[ BIRTHDAY PAGE ] Birthday page is not opened!");


            birthdayPageBase.setDate(expectedBirthday);
            birthdayPageBase.saveChanges();
            birthdayPageBase.returnBack();
        }

        actualBirthday = profilePageBase.getCurrentBirthday();
        Assert.assertEquals(birthFormat.format(actualBirthday.getTime()), birthFormat.format(expectedBirthday.getTime()),
                "[ PROFILE PAGE ] Actual birthday is not what expected!");


        if (!actualGender.equals(expectedGender)) {

            GenderPageBase genderPageBase = (GenderPageBase)
                    profilePageBase.clickOnCharacteristicsBtn(PersonCharacteristics.GENDER);
            Assert.assertTrue(genderPageBase.isPageOpened(), "[ GENDER PAGE ] Gender page is not opened!");

            genderPageBase.checkGenderByName(expectedGender);
        }

        actualGender = profilePageBase.getCurrentGender();
        Assert.assertEquals(actualGender, expectedGender, "[ PROFILE PAGE ] Actual gender is not what expected!");


        if (actualHeight != expectedHeightCentimeters) {

            HeightPageBase heightPageBase = (HeightPageBase)
                    profilePageBase.clickOnCharacteristicsBtn(PersonCharacteristics.HEIGHT);
            Assert.assertTrue(heightPageBase.isPageOpened(), "[ HEIGHT PAGE ] Height page is not opened!");

            heightPageBase.setHeight(expectedHeightCentimeters);
        }

        actualHeight = profilePageBase.getCurrentHeight(PersonCharacteristics.HEIGHT);
        Assert.assertEquals(actualHeight, expectedHeightCentimeters,
                "[ PROFILE PAGE ] Actual height is not what expected!");


        if (actualWeight != expectedWeightPounds || !actualWeightMeasure.equals(expectedWeightMeasure.getShortMeasure())) {

            WeightPageBase weightPageBase = (WeightPageBase)
                    profilePageBase.clickOnCharacteristicsBtn(PersonCharacteristics.WEIGHT);
            Assert.assertTrue(weightPageBase.isPageOpened(), "[ WEIGHT PAGE ] Weight page is not opened!");

            weightPageBase.setWeight(expectedWeightPounds, expectedWeightMeasure);
        }

        actualWeight = profilePageBase.getCurrentWeight(PersonCharacteristics.WEIGHT);
        actualWeightMeasure = profilePageBase.getCurrentWeightMeasure(PersonCharacteristics.WEIGHT);
        Assert.assertEquals(actualWeight, expectedWeightPounds,
                "[ PROFILE PAGE ] Actual weight is not what expected!");
        Assert.assertEquals(actualWeightMeasure, actualWeightMeasure,
                "[ PROFILE PAGE ] Actual weight measure is not what expected!");

    }

    @Test()
    @MethodOwner(owner = "koval")
    @TestLabel(name = "feature", value = {"mobile", "regression"})
    public void checkElementsColorTest() throws IOException {


        HomePageBase homePageBase = initPage(getDriver(), HomePageBase.class);
        Assert.assertTrue(homePageBase.isPageOpened(), "[ HOME PAGE ] Home page is not opened!");

        Assert.assertEquals(homePageBase.getChartTitleColor(), BLUE_COLOR,
                "[ HOME PAGE ] Chart title element color is not blue!");

        Assert.assertEquals(homePageBase.getHeartPointsTitleColor(), GREEN_COLOR,
                "[ HOME PAGE ] Heart Points Title element color is not green!");

        for (int i = 0; i < homePageBase.getMetricValueListSize(); i++) {
            Assert.assertEquals(homePageBase.getMetricValueColor(i), BLUE_COLOR,
                    "[ HOME PAGE ] Metric Value element color is not blue!");
        }

        Assert.assertEquals(homePageBase.getHeartPtsLabelColor(), GREEN_COLOR,
                "[ HOME PAGE ] Heart Pts Label element color is not green!");

        Assert.assertEquals(homePageBase.getHeartCardImage(), RED_COLOR,
                "[ HOME PAGE ] Heart card element color is not red!");

    }


    @Test()
    @MethodOwner(owner = "koval")
    @TestLabel(name = "feature", value = {"mobile", "regression"})
    public void isSelectedMenuBlueTest() throws IOException {

        HomePageBase homePageBase = initPage(getDriver(), HomePageBase.class);
        Assert.assertTrue(homePageBase.isPageOpened(), "[ HOME PAGE ] Home page is not opened!");

        DownMenuModalBase downMenuModal = initPage(getDriver(), DownMenuModalBase.class);

        Assert.assertEquals(downMenuModal.getIconColor(DownMenuElement.HOME), BLUE_COLOR,
                "[ HOME PAGE ] Home page Menu Icon is not blue!");
        Assert.assertEquals(downMenuModal.getLabelColor(DownMenuElement.HOME), BLUE_COLOR,
                "[ HOME PAGE ] Home page Menu Label is not blue!");


        downMenuModal.openPageByName(DownMenuElement.PROFILE);
        Assert.assertEquals(downMenuModal.getIconColor(DownMenuElement.PROFILE), BLUE_COLOR,
                "[ PROFILE PAGE ] Profile page Menu Icon is not blue!");
        Assert.assertEquals(downMenuModal.getLabelColor(DownMenuElement.PROFILE), BLUE_COLOR,
                "[ PROFILE PAGE ] Profile page Menu Label is not blue!");

    }

    @Test()
    @MethodOwner(owner = "koval")
    @TestLabel(name = "feature", value = {"mobile", "regression"})
    public void checkSwitchButtonColorTest() throws IOException {


        HomePageBase homePageBase = initPage(getDriver(), HomePageBase.class);
        Assert.assertTrue(homePageBase.isPageOpened(), "[ HOME PAGE ] Home page is not opened!");

        ProfilePageBase profilePageBase = (ProfilePageBase) homePageBase.openPageFromDownMenuByName(DownMenuElement.PROFILE);
        Assert.assertTrue(profilePageBase.isPageOpened(), "[ PROFILE PAGE ] Profile page is not opened!");

        profilePageBase.checkSleepSwitch(TRUE_BOOLEAN);
        Assert.assertEquals(profilePageBase.getSleepSwitchColor(), BLUE_COLOR,
                "[ PROFILE PAGE ] Sleep Switch is not blue!");

        profilePageBase.checkSleepSwitch(FALSE_BOOLEAN);
        Assert.assertEquals(profilePageBase.getSleepSwitchColor(), WHITE_COLOR,
                "[ PROFILE PAGE ] Sleep Switch is not white!");

    }


    @Test()
    @MethodOwner(owner = "koval")
    @TestLabel(name = "feature", value = {"mobile", "regression"})
    public void checkSettingsTitleColorTest() throws IOException {


        HomePageBase homePageBase = initPage(getDriver(), HomePageBase.class);
        Assert.assertTrue(homePageBase.isPageOpened(), "[ HOME PAGE ] Home page is not opened!");

        ProfilePageBase profilePageBase = (ProfilePageBase) homePageBase.openPageFromDownMenuByName(DownMenuElement.PROFILE);
        Assert.assertTrue(profilePageBase.isPageOpened(), "[ PROFILE PAGE ] Profile page is not opened!");

        profilePageBase.openSettingsButton();

        List<String> listOfSettingsTitles = Arrays.asList("Units", "Google Fit data and personalization",
                "Tracking preferences", "Notifications", "Diagnostics", "Display");

        for (String listOfSettingsTitle : listOfSettingsTitles) {
            Assert.assertEquals(profilePageBase.getSettingsTitlesColor(listOfSettingsTitle), BLUE_COLOR,
                    "[ PROFILE PAGE ] Setting Title element color is not blue!");
        }

    }


    @Test()
    @MethodOwner(owner = "koval")
    @TestLabel(name = "feature", value = {"mobile", "regression"})
    public void checkProfilePictureTest() throws IOException {


        HomePageBase homePageBase = initPage(getDriver(), HomePageBase.class);
        Assert.assertTrue(homePageBase.isPageOpened(), "[ HOME PAGE ] Home page is not opened!");

        int currentAccountImageColor = homePageBase.getAccountImageColor();


        ProfilePageBase profilePageBase = (ProfilePageBase) homePageBase.openPageFromDownMenuByName(DownMenuElement.PROFILE);
        Assert.assertTrue(profilePageBase.isPageOpened(), "[ PROFILE PAGE ] Profile page is not opened!");

        Assert.assertEquals(currentAccountImageColor, profilePageBase.getAccountImageColor(),
                "[ PROFILE PAGE ] Account Image Color is not what expected!");


        JournalPageBase journalPageBase = (JournalPageBase) profilePageBase.openPageFromDownMenuByName(DownMenuElement.JOURNAL);
        Assert.assertTrue(journalPageBase.isPageOpened(), "[ JOURNAL PAGE ] Journal page is not opened!");

        Assert.assertEquals(currentAccountImageColor, journalPageBase.getAccountImageColor(),
                "[ JOURNAL PAGE ] Account Image Color is not what expected!");


        homePageBase = (HomePageBase) journalPageBase.openPageFromDownMenuByName(DownMenuElement.HOME);
        Assert.assertTrue(homePageBase.isPageOpened(), "[ HOME PAGE ] Home page is not opened!");

        Assert.assertEquals(currentAccountImageColor, homePageBase.getAccountImageColor(),
                "[ HOME PAGE ] Account Image Color is not what expected!");
    }


}
