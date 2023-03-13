package koval.myfitnesspal.signUp;


import com.zebrunner.carina.utils.R;
import koval.mobile.myfitnesspal.gui.IMyInterface;
import koval.mobile.myfitnesspal.gui.common.loginPages.SignUpPageBase;
import koval.mobile.myfitnesspal.gui.common.loginPages.WelcomePageBase;
import koval.mobile.myfitnesspal.service.AdbService;
import koval.mobile.myfitnesspal.service.enums.ActivityLevel;
import koval.mobile.myfitnesspal.service.enums.Gender;
import koval.mobile.myfitnesspal.service.enums.HeightMeasure;
import koval.mobile.myfitnesspal.service.enums.WeightMeasure;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.lang.invoke.MethodHandles;
import java.util.Random;

public class SignUpTest implements IMyInterface {

    private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());
    AdbService adbService = new AdbService();

    @BeforeMethod
    public void signUp() {

        adbService.clearAppCache(AdbService.AppPackage.MY_FITNESS_PAL);

        adbService.startApp(AdbService.AppPackage.MY_FITNESS_PAL);


        WelcomePageBase welcomePageBase = initPage(getDriver(), WelcomePageBase.class);
        welcomePageBase.notificationSendPopUp(ALLOW_ANSWER);
        Assert.assertTrue(welcomePageBase.isPageOpened(), "[ WELCOME PAGE ] Welcome page is not opened!");


        SignUpPageBase signUpPageBase = welcomePageBase.signUp();
        Assert.assertTrue(signUpPageBase.isPageOpened("Sign Up"), "[ SIGN UP PAGE ] Sign Up page is not opened!");

        signUpPageBase.clickButtonByText(CONTINUE);
        Assert.assertTrue(signUpPageBase.isPageOpened("Goals"), "[ SIGN UP / GOALS PAGE ] Goals page is not opened!");

        Random rand = new Random();
        int goalIndex = rand.nextInt(7);

        signUpPageBase.selectItemFromGoalsListByIndex(goalIndex);
        Assert.assertTrue(signUpPageBase.isItemFromGoalListSelectedByIndex(goalIndex), String.format("[ SIGN UP / GOALS PAGE ] Goal is not selected! Index:  '%s'", goalIndex));

        signUpPageBase.clickButtonByText(NEXT);
        signUpPageBase.clickButtonByText(NEXT);

        int goalResultIndex = 1;
        signUpPageBase.selectItemFromGoalsListByIndex(goalResultIndex);
        Assert.assertTrue(signUpPageBase.isItemFromGoalListSelectedByIndex(goalResultIndex), String.format("[ SIGN UP / GOALS PAGE ] Goal is not selected! Index:  '%s'", goalIndex));

        signUpPageBase.clickButtonByText(NEXT);
        signUpPageBase.clickButtonByText(NEXT);

        Assert.assertTrue(signUpPageBase.isPageOpened("Activity Level"), "[ SIGN UP / ACTIVITY LEVEL PAGE ] Activity Level page is not opened!");

        ActivityLevel activityLevel = ActivityLevel.ACTIVE;
        signUpPageBase.selectItemFromActivityLevelListByIndex(activityLevel);

        int age = 21;
        String country = "Ukraine";
        Gender gender = Gender.FEMALE;
        int heightCentimeters = 174;
        int weightKilograms = 70;
        int kilograms = 4;
        WeightMeasure weightMeasure = WeightMeasure.KILOGRAMS;

        Assert.assertTrue(signUpPageBase.isPageOpened("You"), "[ SIGN UP / YOU PAGE ] About You page is not opened!");
        signUpPageBase.checkGenderByName(gender);
        signUpPageBase.setAge(age);
        signUpPageBase.setCountry(country);
        signUpPageBase.clickButtonByText(NEXT);

        signUpPageBase.setHeight(heightCentimeters, HeightMeasure.CENTIMETERS);
        signUpPageBase.setWeight(weightKilograms, weightMeasure);
        signUpPageBase.clickButtonByText(NEXT);

        if (goalIndex == 0) {
            signUpPageBase.setWeight(weightKilograms - kilograms, weightMeasure);
            signUpPageBase.clickButtonByText(NEXT);
        }

        if (goalIndex == 2) {
            signUpPageBase.setWeight(weightKilograms + kilograms, weightMeasure);
            signUpPageBase.clickButtonByText(NEXT);
        }


        Assert.assertTrue(signUpPageBase.isPageOpened("Create Account"), "[ SIGN UP / CREATE ACCOUNT PAGE ] Create Account page is not opened!");
        signUpPageBase.setMail(R.TESTDATA.get("fitnessPal_mail"));
        signUpPageBase.setPassword(R.TESTDATA.get("fitnessPal_password"));


        if (signUpPageBase.isPrivacyPolicyTermsPresent()) {
            signUpPageBase.privacyPolicyTermsAgreement();
            signUpPageBase.clickButtonByText(NEXT);
            signUpPageBase.acceptAllConsents();
        } else {
            signUpPageBase.clickButtonByText(NEXT);
        }


        signUpPageBase.selectItemFromSourceListByIndex(2);
        signUpPageBase.clickButtonByText(NEXT);

        Assert.assertTrue(signUpPageBase.isPageOpened("Account Created"), "[ SIGN UP / ACCOUNT CREATED PAGE ] Account Created page is not opened!");
        signUpPageBase.clickButtonByText(NEXT);

    }

    @AfterMethod
    public void clearCash() {
        adbService.clearAppCache(AdbService.AppPackage.MY_FITNESS_PAL);
    }

}
