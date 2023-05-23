package koval;

import com.zebrunner.carina.core.registrar.ownership.MethodOwner;
import com.zebrunner.carina.utils.R;
import koval.mobile.myfitnesspal.gui.IMyInterface;
import koval.mobile.myfitnesspal.gui.common.downMenuPages.dashboardPage.DashboardPageBase;
import koval.mobile.myfitnesspal.gui.common.loginPages.LogInPageBase;
import koval.mobile.myfitnesspal.gui.common.loginPages.WelcomePageBase;
import org.testng.Assert;
import org.testng.annotations.Test;


public class myTest implements IMyInterface {



    @Test(enabled = false)
    @MethodOwner(owner = "dkoval")
    public void loginSimpleUserTest() {

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


        Assert.assertFalse(dashboardPageBase.isUserPremium(), "[ DASHBOARD PAGE ] User is premium!");
    }


}
