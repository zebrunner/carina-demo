package koval.myfitnesspal;

import com.zebrunner.agent.core.annotation.TestLabel;
import com.zebrunner.carina.core.registrar.ownership.MethodOwner;
import com.zebrunner.carina.utils.R;
import com.zebrunner.carina.utils.resources.L10N;
import koval.mobile.myfitnesspal.gui.IMyInterface;
import koval.mobile.myfitnesspal.gui.common.downMenuPages.PlansPageBase;
import koval.mobile.myfitnesspal.gui.common.downMenuPages.dashboardPage.DashboardPageBase;
import koval.mobile.myfitnesspal.gui.common.loginPages.LogInPageBase;
import koval.mobile.myfitnesspal.gui.common.loginPages.WelcomePageBase;
import koval.mobile.myfitnesspal.gui.common.webPages.PlansGoogleDocWebPageBase;
import koval.mobile.myfitnesspal.service.AdbService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.lang.invoke.MethodHandles;
import java.net.URISyntaxException;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class Login implements IMyInterface {


    private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

    private static final List<String> FOOD = Arrays.asList("Apple", "Bread", "Water", "Cherries");

    private static final int FOOD_MEAL_INDEX = new Random().nextInt(FOOD.size());


    @Test(groups = "closeApp")
    @MethodOwner(owner = "dkoval")
    @TestLabel(name = "feature", value = {"mobile", "regression"})
    public void loginTest() {


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

        L10N.assertAll();
    }


    @Test(groups = "closeApp")
    @MethodOwner(owner = "dkoval")
    @TestLabel(name = "feature", value = {"mobile", "regression"})
    public void test() throws URISyntaxException {

        String url = "docs.google.com/forms/d/e/1FAIpQLSdXJDLwt3_Ugbnnc1XDwdzoUObCeZxtypxCnM4rBSEWu9tNzQ/viewform";

        PlansPageBase pageBase = initPage(getDriver(), PlansPageBase.class);

        pageBase.clickTakeSurvey();
        PlansGoogleDocWebPageBase plansPageBase = initPage(getDriver(), PlansGoogleDocWebPageBase.class);


        Assert.assertTrue(plansPageBase.isPageOpened(15, url));



    }


}
