package com.qaprosoft.carina.demo.gui.services;

import com.qaprosoft.carina.core.foundation.webdriver.IDriverPool;
import com.qaprosoft.carina.demo.gui.components.HeaderItem;
import com.qaprosoft.carina.demo.gui.components.User;
import org.testng.Assert;

public class LoginService implements IDriverPool {

    public void login(String email, String pass) {
        HeaderItem headerItem = new HeaderItem(getDriver());
        Assert.assertTrue(headerItem.isLoginButtonPresented(), "Login button isn't present.");
        headerItem.login(email, pass);
        Assert.assertTrue(headerItem.isUserLogged(), "User isn't logged in.");
    }
    public void login(User user) {
        HeaderItem headerItem = new HeaderItem(getDriver());
        Assert.assertTrue(headerItem.isLoginButtonPresented(), "Login button isn't present.");
        headerItem.login(user.getEmail(), user.getPassword());
        Assert.assertTrue(headerItem.isUserLogged(), "User isn't logged in.");
    }

    public void logout() {
        HeaderItem headerItem = new HeaderItem(getDriver());
        Assert.assertTrue(headerItem.isLogoutButtonPresented(), "Logout button isn't presented.");
        headerItem.logout();
        Assert.assertTrue(headerItem.isSignUpButtonPresented(), "Can't logout.");
    }

}
