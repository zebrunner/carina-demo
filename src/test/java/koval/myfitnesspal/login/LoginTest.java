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

        adbService.clearAppCache(AdbService.AppPackage.MY_FITNESS_PAL);

        simpleLogin();

        return (initPage(getDriver(), DashboardPageBase.class));
    }


    public DashboardPageBase simpleLogin() {

//      //  String apkUrl = "https://drive.google.com/file/d/1RrKzzGJLhlAHykBP4A6Dd451sFUXRM5s/view?usp=share_link";
//
//        String apkUrl = "https://github.com/DianaKovall/carina-demo/releases/tag/v.1.1/MyFitnessPal.apk";
//
//
//        String outputFile = System.getProperty("user.dir") + "/apk/MyFitnessPal.apk";
//
//        try {
//            URL url = new URL(apkUrl);
//            ReadableByteChannel rbc = Channels.newChannel(url.openStream());
//            FileOutputStream fos = new FileOutputStream(outputFile);
//            fos.getChannel().transferFrom(rbc, 0, Long.MAX_VALUE);
//            fos.close();
//            rbc.close();
//            System.out.println("APK file downloaded successfully.");
//        } catch (IOException e) {
//            e.printStackTrace();
//        }

        Apps.downloadAndroidApp(AdbService.AppPackage.MY_FITNESS_PAL);

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

        Assert.assertTrue(dashboardPageBase.isPageOpened(), "[ DASHBOARD PAGE ] Dashboard page is not opened!");

        L10N.assertAll();
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
