package koval.mobile.myfitnesspal.gui.android.loginPages;


import com.zebrunner.carina.utils.R;
import com.zebrunner.carina.utils.factory.DeviceType;
import koval.mobile.myfitnesspal.gui.common.loginPages.CreateAccountPageBase;
import koval.mobile.myfitnesspal.gui.common.loginPages.SignUpPageBase;
import koval.mobile.myfitnesspal.service.accountFactory.Account;
import koval.mobile.myfitnesspal.service.enums.ActivityLevel;
import koval.mobile.myfitnesspal.service.enums.HeightMeasure;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import java.util.Random;


@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = CreateAccountPageBase.class)
public class CreateAccountPage extends CreateAccountPageBase {

    public CreateAccountPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public SignUpPageBase createRandomAccount(Account account) {
        SignUpPageBase signUpPageBase = initPage(getDriver(), SignUpPageBase.class);
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


        Assert.assertTrue(signUpPageBase.isPageOpened("You"), "[ SIGN UP / YOU PAGE ] About You page is not opened!");
        signUpPageBase.checkGenderByName(account.getGender());
        signUpPageBase.setAge(account.getAge());
        signUpPageBase.setCountry(account.getCountry());
        signUpPageBase.clickButtonByText(NEXT);

        signUpPageBase.setHeight(account.getHeightCentimeters(), HeightMeasure.CENTIMETERS);
        signUpPageBase.setWeight(account.getWeightKilograms(), account.getWeightMeasure());
        signUpPageBase.clickButtonByText(NEXT);

        if (goalIndex == 0) {
            signUpPageBase.setWeight(account.getWeightKilograms() - account.getKilograms(), account.getWeightMeasure());
            signUpPageBase.clickButtonByText(NEXT);
        }

        if (goalIndex == 2) {
            signUpPageBase.setWeight(account.getWeightKilograms() + account.getKilograms(), account.getWeightMeasure());
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


        signUpPageBase.savePasswordToGoogleAgreement(false);
        signUpPageBase.selectItemFromSourceListByIndex(2);
        signUpPageBase.clickButtonByText(NEXT);

        Assert.assertTrue(signUpPageBase.isPageOpened("Account Created"), "[ SIGN UP / ACCOUNT CREATED PAGE ] Account Created page is not opened!");
        signUpPageBase.clickButtonByText(NEXT);

        signUpPageBase.closeNoSubscriptionsPopUpIfPresent();
        return initPage(getDriver(), SignUpPageBase.class);
    }

}
