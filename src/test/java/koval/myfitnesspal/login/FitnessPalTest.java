package koval.myfitnesspal.login;

import com.zebrunner.agent.core.annotation.TestLabel;
import com.zebrunner.carina.core.registrar.ownership.MethodOwner;

import koval.mobile.myfitnesspal.gui.common.downMenuPages.DashboardPageBase;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.lang.invoke.MethodHandles;


public class FitnessPalTest extends LoginTest {

    private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());


    @Test()
    @MethodOwner(owner = "koval")
    @TestLabel(name = "feature", value = {"mobile", "regression"})
    public void loginSimpleUserTest() {

        DashboardPageBase dashboardPageBase = initPage(getDriver(), DashboardPageBase.class);
        dashboardPageBase.closeNoSubscriptionsPopUp();
        dashboardPageBase.closeUserTutorialBox();

        Assert.assertTrue(dashboardPageBase.isPageOpened(), "[ DASHBOARD PAGE ] Dashboard page is not opened!");

        Assert.assertFalse(dashboardPageBase.isUserPremium(),"[ DASHBOARD PAGE ] User is premium!" );
    }


}
