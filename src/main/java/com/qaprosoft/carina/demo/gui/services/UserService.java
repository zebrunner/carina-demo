package com.qaprosoft.carina.demo.gui.services;

import com.qaprosoft.carina.demo.constants.IConstant;
import com.qaprosoft.carina.demo.gui.components.User;
import org.apache.commons.lang3.RandomStringUtils;

public class UserService implements IConstant {

    public static User getUser() {
        User user = new User();
        user.setEmail(EMAIL);
        user.setPassword(PASS);
        return user;
    }

    public static User getRandomUser() {
        User user = new User();
        user.setEmail(RandomStringUtils.randomAlphabetic(5, 8) + "@gmail.com");
        user.setPassword(RandomStringUtils.random(8));
        return user;
    }

}
