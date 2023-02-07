package koval.myfit;

import com.qaprosoft.carina.core.foundation.IAbstractTest;
import com.zebrunner.carina.utils.mobile.IMobileUtils;
import koval.myfit.mobile.gui.pages.service.AdbService;
import koval.myfit.mobile.gui.pages.common.loginPages.AboutMePageBase;
import koval.myfit.mobile.gui.pages.common.loginPages.TrackActivitiesPageBase;
import koval.myfit.mobile.gui.pages.common.loginPages.WelcomePageBase;
import koval.myfit.mobile.gui.pages.service.MyAbstractPage;
import koval.myfit.mobile.gui.pages.service.enums.PersonCharacteristics;
import koval.myfit.mobile.gui.pages.service.enums.TrackYourActivitiesAnswer;
import koval.myfit.mobile.gui.pages.service.interfaces.IConstantUtils;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.*;

import java.lang.invoke.MethodHandles;

public class LoginTest implements IAbstractTest, IMobileUtils, IConstantUtils {

    private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());
    AdbService adbService = new AdbService();

    @BeforeMethod
    public void login() {

        adbService.clearAppCache(AdbService.AppPackage.GOOGLE_FIT);

        adbService.startApp(AdbService.AppPackage.GOOGLE_FIT);
        try {
            WelcomePageBase welcomePageBase = initPage(getDriver(), WelcomePageBase.class);
            Assert.assertTrue(welcomePageBase.isPageOpened(), "[ WELCOME PAGE ] Welcome page is not opened!");

            AboutMePageBase aboutMePageBase = welcomePageBase.clickLoginBtn();
            Assert.assertTrue(aboutMePageBase.isPageOpened(), "[ ABOUT YOU PAGE ] About You page is not opened!");
            aboutMePageBase.clickOnBtn(PersonCharacteristics.WEIGHT);

            TrackActivitiesPageBase trackActivitiesPageBase = aboutMePageBase.clickNextBtn();
            Assert.assertTrue(trackActivitiesPageBase.isPageOpened(), "[ TRACK ACTIVITIES PAGE ] Track Activities page is not opened!");
            trackActivitiesPageBase.clickBtn(TrackYourActivitiesAnswer.NO);

        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

    @AfterMethod
    public void logout() {
        adbService.clearAppCache(AdbService.AppPackage.GOOGLE_FIT);
    }

}
