package koval.carinademo;

import com.qaprosoft.carina.core.foundation.IAbstractTest;
import com.zebrunner.carina.utils.R;
import com.zebrunner.carina.utils.mobile.IMobileUtils;
import koval.carinademo.mobile.gui.common.loginPages.LoginPageBase;
import koval.carinademo.mobile.gui.common.loginPages.WelcomePageBase;
import koval.carinademo.mobile.service.interfaces.IConstantUtils;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;

public class LoginTest implements IAbstractTest, IMobileUtils, IConstantUtils {
    @BeforeMethod
    public void login()
    {
        WelcomePageBase welcomePage = initPage(getDriver(), WelcomePageBase.class);
        Assert.assertTrue(welcomePage.isPageOpened(), "[ WELCOME PAGE ] Welcome page is not opened!");

        LoginPageBase loginPageBase = welcomePage.clickNextBtn();
        Assert.assertFalse(loginPageBase.isLoginBtnActive(), "[ LOGIN PAGE ] Login button is active!");
        loginPageBase.typeName("Diana");
        loginPageBase.typePassword(R.TESTDATA.get("password"));
        loginPageBase.selectGender(FEMALEGENDER);
        loginPageBase.checkPrivacyPolicyCheckbox();
        loginPageBase.clickLoginBtn();
    }
}