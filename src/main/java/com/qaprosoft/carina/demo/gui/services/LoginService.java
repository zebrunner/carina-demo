package com.qaprosoft.carina.demo.gui.services;

import com.qaprosoft.carina.core.foundation.webdriver.IDriverPool;
import com.qaprosoft.carina.demo.gui.components.HeaderItem;
import com.qaprosoft.carina.demo.gui.components.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;

import java.lang.invoke.MethodHandles;

public class LoginService implements IDriverPool {

    private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

    public void login(String email, String pass) {
        HeaderItem headerItem = new HeaderItem(getDriver());
        if (headerItem.isLoginButtonPresented()) {
            headerItem.login(email, pass);
        } else {
            LOGGER.info("User already logged in.");
        }
    }

    public void login(User user) {
        HeaderItem headerItem = new HeaderItem(getDriver());
        if (headerItem.isLoginButtonPresented()) {
            headerItem.login(user.getEmail(), user.getPassword());
            Assert.assertTrue(headerItem.isUserLogged(), "User isn't logged in.");
        } else {
            LOGGER.info("User already logged in.");
        }
    }

    public void logout() {
        HeaderItem headerItem = new HeaderItem(getDriver());
        if (headerItem.isLogoutButtonPresented()) {
            headerItem.clickLogoutButton();
            Assert.assertTrue(headerItem.isSignUpButtonPresented(), "Can't logout.");
        } else {
            LOGGER.info("User isn't logged in, can't logout.");
        }
    }

}
