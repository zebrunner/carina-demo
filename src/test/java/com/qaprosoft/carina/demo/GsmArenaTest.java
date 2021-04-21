package com.qaprosoft.carina.demo;

import com.qaprosoft.carina.core.foundation.AbstractTest;
import com.qaprosoft.carina.core.foundation.utils.ownership.MethodOwner;
import com.qaprosoft.carina.demo.gui.model.User;
import com.qaprosoft.carina.demo.gui.pages.HomePage;
import com.qaprosoft.carina.demo.gui.pages.LoginPage;
import com.qaprosoft.carina.demo.gui.service.UserCreator;
import org.testng.Assert;
import org.testng.annotations.Test;

public class GsmArenaTest extends AbstractTest {

    @Test(description = "JIRA#AUTO-0001", enabled = false)
    @MethodOwner(owner = "Kolchyba Yevhenii")
    public void verifyHeaderComponents() {
        HomePage homePage = new HomePage(getDriver());
        homePage.open();
        Assert.assertTrue(homePage.isPageOpened(), "Home page is not opened");
        Assert.assertTrue(homePage.isTipUsIconPresent(), "Tip Us icon is not present");
        Assert.assertTrue(homePage.isFaceBookIconPresent(), "Facebook icon is not present");
        Assert.assertTrue(homePage.isTwitterIconPresent(), "Twitter icon in not present");
        Assert.assertTrue(homePage.isInstagramIconPresent(), "Instagram icon is not present");
        Assert.assertTrue(homePage.isYoutubeIconPresent(), "Youtube icon is not present");
        Assert.assertTrue(homePage.isRssIconPresent(), "Rss icon is not present");
        Assert.assertTrue(homePage.isLoginIconPresent(), "Login icon is not present");
        Assert.assertTrue(homePage.isUserIconPresent(), "Login icon is not present");
    }

    @Test(description = "JIRA#AUTO-0002")
    @MethodOwner(owner = "Kolchyba Yevhenii")
    public void verifySuccessLogin() {
        String titleFromLoginPage = "Login - GSMArena.com";
        User testUser = UserCreator.withCredentialsFromProperty();
        String userLoggedIn = new LoginPage(getDriver())
                .openPage()
                .login(testUser)
                .getTitleFromLoginPage();
        Assert.assertEquals(userLoggedIn, titleFromLoginPage);
    }

    @Test(description = "JIRA#AUTO-0003")
    @MethodOwner(owner = "Kolchyba Yevhenii")
    public void verifyUnsuccessfulLogin() {
        String loginFailed = "Reason: User record not found.";
        User testUser = UserCreator.withCredentialsFromProperty();
        String userRecordNotFound = new LoginPage(getDriver())
                .openPage()
                .loginWithWrongEmail(testUser)
                .getTextFromLoginPage();
        Assert.assertEquals(userRecordNotFound, loginFailed);
    }

    @Test(description = "JIRA#AUTO-0004")
    @MethodOwner(owner = "Kolchyba Yevhenii")
    public void verifyUnsuccessfulPassword() {
        String loginFailed = "Reason: Wrong password.";
        User testUser = UserCreator.withCredentialsFromProperty();
        String userRecordNotFound = new LoginPage(getDriver())
                .openPage()
                .loginWithWrongPassword(testUser)
                .getTextFromLoginPage();
        Assert.assertEquals(userRecordNotFound, loginFailed);
    }
}
