package koval.myfitnesspal.login;


import com.zebrunner.carina.utils.R;
import koval.mobile.myfitnesspal.gui.MyAbstractPage;
import koval.mobile.myfitnesspal.gui.common.downMenuPages.DashboardPageBase;
import koval.mobile.myfitnesspal.gui.common.loginPages.LogInPageBase;
import koval.mobile.myfitnesspal.gui.IMyInterface;
import koval.mobile.myfitnesspal.gui.common.loginPages.WelcomePageBase;
import koval.mobile.myfitnesspal.service.AdbService;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.lang.invoke.MethodHandles;

public class LoginTest implements IMyInterface {


    private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());
    AdbService adbService = new AdbService();



    @BeforeMethod
    public void login() {

        adbService.clearAppCache(AdbService.AppPackage.MY_FITNESS_PAL);

        adbService.startApp(AdbService.AppPackage.MY_FITNESS_PAL);

        WelcomePageBase welcomePageBase = initPage(getDriver(), WelcomePageBase.class);
        welcomePageBase.notificationSendPopUpIfPresent(ALLOW_ANSWER);
        Assert.assertTrue(welcomePageBase.isPageOpened(), "[ WELCOME PAGE ] Welcome page is not opened!");


        LogInPageBase loginPageBase = welcomePageBase.logIn();
        Assert.assertTrue(loginPageBase.isPageOpened(), "[ LOGIN PAGE ] Login page is not opened!");

        loginPageBase.typeMail(R.TESTDATA.get("fitnessPal_mail"));
        loginPageBase.typePassword(R.TESTDATA.get("fitnessPal_password"));
        loginPageBase.clickLoginButton();


        loginPageBase.closeNoSubscriptionsPopUpIfPresent();
        loginPageBase.closeUserTutorialBoxIfPresent();


        DashboardPageBase dashboardPageBase = initPage(getDriver(), DashboardPageBase.class);

        Assert.assertTrue(dashboardPageBase.isPageOpened(), "[ DASHBOARD PAGE ] Dashboard page is not opened!");

    }

    @AfterMethod
    public void logout() {
        adbService.clearAppCache(AdbService.AppPackage.MY_FITNESS_PAL);
    }

}
