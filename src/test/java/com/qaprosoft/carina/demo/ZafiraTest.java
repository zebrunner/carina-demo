package com.qaprosoft.carina.demo;

import com.qaprosoft.carina.core.foundation.AbstractTest;
import com.qaprosoft.carina.core.foundation.utils.R;
import com.qaprosoft.carina.demo.constant.ConfigConstant;
import com.qaprosoft.carina.demo.gui.pages.ZafiraDashboardsPage;
import com.qaprosoft.carina.demo.gui.pages.ZafiraSigninPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ZafiraTest extends AbstractTest {

    @Test
    public void createDashboardScreenshot() {
        ZafiraSigninPage zafiraSigninPage = new ZafiraSigninPage(getDriver());
        zafiraSigninPage.open();
        Assert.assertTrue(zafiraSigninPage.isOpened(), "Zafira login page is not open!");
        zafiraSigninPage.inputUsername(R.TESTDATA.get(ConfigConstant.USERNAME));
        zafiraSigninPage.inputPassword(R.TESTDATA.get(ConfigConstant.PASSWORD));
        ZafiraDashboardsPage zafiraDashboardsPage = zafiraSigninPage.clickLoginBtn();
        Assert.assertTrue(zafiraDashboardsPage.isOpened(), "Zafira dashboard page is not open!");
        zafiraDashboardsPage.getTutorialsWindow().closeTutorials();
        zafiraDashboardsPage.createScreenshot();
    }
}
