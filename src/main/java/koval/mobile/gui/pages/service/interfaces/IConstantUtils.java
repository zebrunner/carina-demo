package koval.mobile.gui.pages.service.interfaces;

import koval.mobile.gui.pages.service.enums.Gender;

import static com.zebrunner.agent.core.webdriver.RemoteWebDriverFactory.getDriver;


public interface IConstantUtils {

    Gender FEMALEGENDER = Gender.FEMALE;

    String SPACEFIELD = " ";

    String EMPTYFIELD = "";

    int TIMEOUT_FIVE = 5;

    int TIMEOUT_ONE = 1;

    int FOURTH_ELEMENT = 4;

    int HIGH_SPEED = 80;

    int COUNT_SIX = 6;

    String[] ExpectedEmailParts = {"support", "zebrunner.com"};
}
