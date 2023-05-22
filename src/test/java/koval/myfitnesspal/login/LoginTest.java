package koval.myfitnesspal.login;


import com.zebrunner.carina.utils.R;
import com.zebrunner.carina.utils.resources.L10N;
import koval.Apps;
import koval.mobile.myfitnesspal.gui.common.downMenuPages.dashboardPage.DashboardPageBase;
import koval.mobile.myfitnesspal.gui.common.loginPages.LogInPageBase;
import koval.mobile.myfitnesspal.gui.IMyInterface;
import koval.mobile.myfitnesspal.gui.common.loginPages.WelcomePageBase;
import koval.mobile.myfitnesspal.gui.common.phoneInterface.PhoneHomePageBase;
import koval.mobile.myfitnesspal.service.AdbService;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.io.FileOutputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;


public class LoginTest implements IMyInterface {


    @BeforeMethod
    public DashboardPageBase login() {

       // Apps.downloadAndroidApp(AdbService.AppPackage.MY_FITNESS_PAL);

        adbService.installApp(AdbService.AppPackage.MY_FITNESS_PAL);

        adbService.clearAppCache(AdbService.AppPackage.MY_FITNESS_PAL);

        simpleLogin();

        return (initPage(getDriver(), DashboardPageBase.class));
    }


    public DashboardPageBase simpleLogin() {

        adbService.startApp(AdbService.AppPackage.MY_FITNESS_PAL);

        hideKeyboard();
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

       Assert.assertTrue(dashboardPageBase.isPageOpened(TIMEOUT_FIFTY), "[ DASHBOARD PAGE ] Dashboard page is not opened!");

        return (initPage(getDriver(), DashboardPageBase.class));
    }


    @AfterMethod(onlyForGroups = {"logout"})
    public void logout() {
        adbService.clearAppCache(AdbService.AppPackage.MY_FITNESS_PAL);

    }

    @AfterMethod(onlyForGroups = {"closeApp"})
    public void closeApplication() {
        adbService.closeApp(AdbService.AppPackage.MY_FITNESS_PAL);
    }

    @AfterMethod(onlyForGroups = {"closeAppAndDeleteWidget"})
    public void deleteWidgetAndLogout() {
        adbService.closeApp(AdbService.AppPackage.MY_FITNESS_PAL);

        PhoneHomePageBase phoneHomePageBase = initPage(getDriver(), PhoneHomePageBase.class);

        phoneHomePageBase.deleteWidget(FITNESSPAL);

        Assert.assertFalse(phoneHomePageBase.isFitnessPalWidgetPresent(TIMEOUT_FIVE),
                String.format("[ PHONE HOME PAGE ] '%s' widget is not deleted! App name '%s'", FITNESSPAL, CALORIES_WIDGET));

    }

}
