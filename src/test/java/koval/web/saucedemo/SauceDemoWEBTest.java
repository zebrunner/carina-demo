package koval.web.saucedemo;

import com.qaprosoft.carina.core.foundation.IAbstractTest;
import com.zebrunner.carina.core.registrar.ownership.MethodOwner;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SauceDemoWEBTest implements IAbstractTest {


    @Test
    @MethodOwner(owner = "dkoval")
    public void loginTest()
    {
        LoginPage loginPage = new LoginPage(getDriver());
        loginPage.open();
        loginPage.enterValidCredentials();
        AllItemsPage allItemsPage = loginPage.login();
        Assert.assertTrue(allItemsPage.isUserLogged(), "no");

    }


}
