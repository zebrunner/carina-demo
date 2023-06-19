package koval.mobile.myfitnesspal.login;

import com.zebrunner.carina.utils.R;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import koval.mobile.Apps;
import koval.mobile.myfitnesspal.gui.IMyInterface;
import koval.mobile.myfitnesspal.gui.common.downMenuPages.dashboardPage.DashboardPageBase;
import koval.mobile.myfitnesspal.gui.common.loginPages.LogInPageBase;
import koval.mobile.myfitnesspal.gui.common.loginPages.WelcomePageBase;
import koval.mobile.myfitnesspal.service.AdbService;
import org.testng.Assert;


public class LoginUserMyStepdefs implements IMyInterface {

    WelcomePageBase welcomePageBase = initPage(getDriver(), WelcomePageBase.class);
    LogInPageBase logInPageBase;
    DashboardPageBase dashboardPageBase;

    @Given("^Welcome page is opened$")
    public void welcomePageIsOpened() {
        Apps.downloadAndroidApp(AdbService.AppPackage.MY_FITNESS_PAL);

        adbService.installApp(AdbService.AppPackage.MY_FITNESS_PAL);

        adbService.clearAppCache(AdbService.AppPackage.MY_FITNESS_PAL);

        adbService.startApp(AdbService.AppPackage.MY_FITNESS_PAL);

         welcomePageBase.notificationSendPopUpIfPresent(ALLOW_ANSWER);

         Assert.assertTrue(welcomePageBase.isPageOpened(), "[ WELCOME PAGE ] Welcome page is not opened!");
    }

    @When("I click Log In button in Welcome Page")
    public void iClickButton() {
       logInPageBase = welcomePageBase.logIn();
    }

    @Then("Login page is opened")
    public void loginPageIsOpened() {
        Assert.assertTrue(logInPageBase.isPageOpened(), "[ LOGIN PAGE ] Login page is not opened!");
    }

    @When("I enter login and password")
    public void iEnterAnd() {
        logInPageBase.typeMail(R.TESTDATA.get("fitnessPal_mail"));
        logInPageBase.typePassword(R.TESTDATA.get("fitnessPal_password"));
    }


    @When("I click Log In button")
    public void iClickLoginButton() {
        dashboardPageBase = logInPageBase.clickLoginButton();

    }

    @Then("Dashboard page is opened")
    public void dashboardPageIsOpened() {
        dashboardPageBase.closeLoginFailedPopUpIfPresent();
        dashboardPageBase.closeNoSubscriptionsPopUpIfPresent();
        dashboardPageBase.closeUserTutorialBoxIfPresent();

        Assert.assertTrue(dashboardPageBase.isPageOpened(TIMEOUT_TEN), "[ DASHBOARD PAGE ] Dashboard page is not opened!");
    }

}
