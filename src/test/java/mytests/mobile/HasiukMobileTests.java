package mytests.mobile;

import com.qaprosoft.carina.core.foundation.IAbstractTest;
import com.qaprosoft.carina.demo.mobile.gui.pages.android.CarinaDescriptionPage;
import com.qaprosoft.carina.demo.mobile.gui.pages.common.CarinaDescriptionPageBase;
import com.qaprosoft.carina.demo.mobile.gui.pages.common.WelcomePageBase;
import com.qaprosoft.carina.demo.mobile.gui.pages.hasiuk.pages.common.HomePageBase;
import com.qaprosoft.carina.demo.mobile.gui.pages.hasiuk.pages.common.LoginPageBase;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HasiukMobileTests implements IAbstractTest {

    @Test
    public void verifyLoginPage(){
        HomePageBase homePageBase = initPage(getDriver(), HomePageBase.class);
        Assert.assertTrue(homePageBase.isPageOpened(), "Home page was not opened");
        LoginPageBase loginPageBase = homePageBase.clickNextButton();
        Assert.assertTrue(loginPageBase.isPageOpened(), "Login page was not opened");
    }

    @Test
    public void verifySignButtonIsAlive(){
        WelcomePageBase welcomePage = initPage(getDriver(), WelcomePageBase.class);
        Assert.assertTrue(welcomePage.isPageOpened(), "Welcome page was not opened");
        com.qaprosoft.carina.demo.mobile.gui.pages.common.LoginPageBase loginPage =
                welcomePage.clickNextBtn();
        loginPage.typeName("Dima");
        loginPage.typePassword("123");
        loginPage.selectFemaleSex();
        loginPage.checkPrivacyPolicyCheckbox();
        Assert.assertTrue(loginPage.isLoginBtnActive());
    }

    @Test
    public void verifyMapFeature(){
        WelcomePageBase welcomePage = initPage(getDriver(), WelcomePageBase.class);
        Assert.assertTrue(welcomePage.isPageOpened(), "Welcome page was not opened");
        com.qaprosoft.carina.demo.mobile.gui.pages.common.LoginPageBase loginPage =
                welcomePage.clickNextBtn();
        CarinaDescriptionPageBase descriptionPage = loginPage.login();
        descriptionPage.navigateToMapPage();
    }
}
