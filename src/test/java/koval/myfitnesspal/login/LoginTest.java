package koval.myfitnesspal.login;


import com.zebrunner.carina.utils.R;
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



public class LoginTest implements IMyInterface {


    @BeforeMethod
    public DashboardPageBase login() {

        Apps.downloadAndroidApp(AdbService.AppPackage.MY_FITNESS_PAL);

        adbService.installApp(AdbService.AppPackage.MY_FITNESS_PAL);

        simpleLogin();

        return (initPage(getDriver(), DashboardPageBase.class));
    }


    public DashboardPageBase simpleLogin() {

        adbService.clearAppCache(AdbService.AppPackage.MY_FITNESS_PAL);

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
        loginPageBase.closeLoginFailedPopUpIfPresent();

        loginPageBase.closeNoSubscriptionsPopUpIfPresent();
        loginPageBase.closeUserTutorialBoxIfPresent();
        if (loginPageBase.closeNotRespondingPopUpIfPresent()) {
            simpleLogin();
        } else {

            DashboardPageBase dashboardPageBase = initPage(getDriver(), DashboardPageBase.class);

            Assert.assertTrue(dashboardPageBase.isPageOpened(TIMEOUT_TEN), "[ DASHBOARD PAGE ] Dashboard page is not opened!");
        }
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
