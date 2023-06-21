package koval.web;

import com.qaprosoft.carina.core.foundation.IAbstractTest;
import com.zebrunner.agent.core.annotation.TestLabel;
import com.zebrunner.carina.core.registrar.ownership.MethodOwner;
import com.zebrunner.carina.utils.R;
import koval.web.myfitnesspal.modal.MainMenuModal;
import koval.web.myfitnesspal.pages.*;
import koval.web.myfitnesspal.pages.menuPages.*;
import koval.web.myfitnesspal.service.enums.MainMenu;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.*;

import java.lang.invoke.MethodHandles;



public class MyFitnessPalWebTest implements IAbstractTest {


    private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

    WelcomePage welcomePage = new WelcomePage(getDriver());

    @BeforeMethod()
    public void login() {

        getDriver().get(R.CONFIG.get("url"));
        getDriver().manage().deleteAllCookies();
        getDriver().navigate().refresh();

        LoginPage loginPage = welcomePage.clickLogInButton();
        loginPage.typeMail(R.TESTDATA.get("fitnessPal_mail"));
        loginPage.typePassword(R.TESTDATA.get("fitnessPal_password"));
        HomePage homePage = loginPage.clickLogInButton();
        Assert.assertTrue(homePage.isPageOpened(), "no");
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
    public void openFoodMenuTest() {
        MainMenuModal mainMenuModal = new MainMenuModal(getDriver());
        FoodPage foodPage = mainMenuModal.openPageFromMenu(MainMenu.FOOD);
    }


    @AfterMethod
    public void openWelcomePage() {
        welcomePage.openURL(R.CONFIG.get("url"), 60);
    }

}
