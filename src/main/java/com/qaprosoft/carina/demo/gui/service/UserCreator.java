package com.qaprosoft.carina.demo.gui.service;

import com.qaprosoft.carina.demo.gui.model.User;

public class UserCreator {
    public static final String TEST_DATA_USER_NICKNAME = "test.data.user.nickname";
    public static final String TEST_DATA_USER_EMAIL = "test.data.user.email";
    public static final String TEST_DATA_USER_PASSWORD = "test.data.user.password";
    public static final String TEST_DATA_WRONG_USER_EMAIL = "test.data.user.wrong.email";
    public static final String TEST_DATA_WRONG_USER_PASSWORD = "test.data.user.wrong.password";

    public static User withCredentialsFromProperty () {
        return new User(TestDataReader.getTestData(TEST_DATA_USER_NICKNAME),
                TestDataReader.getTestData(TEST_DATA_USER_EMAIL),
                TestDataReader.getTestData(TEST_DATA_USER_PASSWORD),
                TestDataReader.getTestData(TEST_DATA_WRONG_USER_EMAIL),
                TestDataReader.getTestData(TEST_DATA_WRONG_USER_PASSWORD));
}

    public static User withEmptyUserNickname() {
        return new User("", TEST_DATA_USER_EMAIL, TEST_DATA_USER_PASSWORD,
                TEST_DATA_WRONG_USER_EMAIL, TEST_DATA_WRONG_USER_PASSWORD);
    }

    public static User withEmptyUserEmail() {
        return new User(TEST_DATA_USER_NICKNAME, "", TEST_DATA_USER_PASSWORD, TEST_DATA_WRONG_USER_EMAIL, TEST_DATA_WRONG_USER_PASSWORD);
    }

    public static User withEmptyUserPassword() {
        return new User(TEST_DATA_USER_NICKNAME, TEST_DATA_USER_EMAIL, "", TEST_DATA_WRONG_USER_EMAIL, TEST_DATA_WRONG_USER_PASSWORD);
    }

    public static User withEmptyUserWrongEmail() {
        return new User(TEST_DATA_USER_NICKNAME, TEST_DATA_USER_EMAIL, TEST_DATA_USER_PASSWORD, "", TEST_DATA_WRONG_USER_PASSWORD);
    }

    public static User withEmptyUserWrongPassword() {
        return new User(TEST_DATA_USER_NICKNAME, TEST_DATA_USER_EMAIL, TEST_DATA_USER_PASSWORD, TEST_DATA_WRONG_USER_PASSWORD, "");
    }
}
