package com.qaprosoft.carina.demo.gui.services;

import com.qaprosoft.carina.core.foundation.utils.R;
import com.qaprosoft.carina.demo.gui.components.User;
import org.apache.commons.lang3.RandomStringUtils;

public class UserService {

    public static User getRealUser() {
        User user = new User();
        user.setEmail(R.TESTDATA.get("user_email"));
        user.setPassword(R.TESTDATA.get("user_password"));
        return user;
    }

    public static User getRandomUser() {
        User user = new User();
        user.setEmail(RandomStringUtils.randomAlphabetic(5, 8) + "@gmail.com");
        user.setPassword(RandomStringUtils.random(8));
        return user;
    }

}
