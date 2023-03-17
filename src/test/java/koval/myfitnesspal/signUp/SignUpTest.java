package koval.myfitnesspal.signUp;


import com.zebrunner.carina.utils.R;
import koval.mobile.myfitnesspal.gui.IMyInterface;
import koval.mobile.myfitnesspal.gui.common.loginPages.CreateAccountPageBase;
import koval.mobile.myfitnesspal.gui.common.loginPages.SignUpPageBase;
import koval.mobile.myfitnesspal.gui.common.loginPages.WelcomePageBase;
import koval.mobile.myfitnesspal.service.AdbService;
import koval.mobile.myfitnesspal.service.accountFactory.Account;
import koval.mobile.myfitnesspal.service.accountFactory.AccountFactory;
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

        Account account = AccountFactory.generateAccount();

        welcomePageBase.signUp().createRandomAccount(account);

    }

    @AfterMethod
    public void clearCash() {
        adbService.clearAppCache(AdbService.AppPackage.MY_FITNESS_PAL);
    }

}
