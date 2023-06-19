package koval.web;

import com.qaprosoft.carina.core.foundation.IAbstractTest;
import com.zebrunner.agent.core.annotation.TestLabel;
import com.zebrunner.carina.core.registrar.ownership.MethodOwner;
import com.zebrunner.carina.utils.R;
import koval.web.myfitnesspal.pages.LoginPage;
import koval.web.myfitnesspal.pages.WelcomePage;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


public class MyFitnessPalWebTest implements IAbstractTest {

    WelcomePage welcomePage;

    @BeforeTest
    public void startDriver() {

        getDriver().manage().window().minimize();
        welcomePage = new WelcomePage(getDriver());
        welcomePage.openURL(R.CONFIG.get("url"), 40);

        getDriver().manage().deleteAllCookies();

    }

    @Test()
    @MethodOwner(owner = "dkoval")
    @TestLabel(name = "feature", value = {"web", "regression"})
    public void test() throws InterruptedException {
        //  pause(900000);
       // welcomePage.closeCookiesPopUpIfPresent();



       //driver.ExecuteChromeCommand("Storage.clearCookies", new Dictionary<string, object>())
    }


    @Test()
    @MethodOwner(owner = "dkoval")
    @TestLabel(name = "feature", value = {"web", "regression"})
    public void openWelcomePageTest() {
        Assert.assertTrue(welcomePage.isPageOpened(), "[ WELCOME PAGE ] Welcome page is not opened");
    }


    @Test()
    @MethodOwner(owner = "dkoval")
    @TestLabel(name = "feature", value = {"web", "regression"})
    public void loginSimpleUserTest() {

        //welcomePage.closeCookiesPopUpIfPresent();

        getDriver().navigate().refresh();

        LoginPage loginPage = welcomePage.clickLogInButton();

        loginPage.typeMail(R.TESTDATA.get("fitnessPal_mail"));
        loginPage.typePassword(R.TESTDATA.get("fitnessPal_password"));
        loginPage.clickLogInButton();


    }


//    @AfterTest
//    public void quitDriver() {
//        getDriver().quit();
//    }


}
