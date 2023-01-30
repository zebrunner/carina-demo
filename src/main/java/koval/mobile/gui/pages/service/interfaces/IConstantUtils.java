package koval.mobile.gui.pages.service.interfaces;

import koval.mobile.gui.pages.service.enums.Gender;

import static com.zebrunner.agent.core.webdriver.RemoteWebDriverFactory.getDriver;


public interface IConstantUtils {

    Gender FEMALEGENDER = Gender.FEMALE;

    String SPACEFIELD = " ";

    String EMPTYFIELD = "";

    String EXPECTED_EMAIL_NAME = "support";

    String EXPECTED_EMAIL_AGENT = "zebrunner.com";

    int TIMEOUT_FIVE = 5;

    int TIMEOUT_ONE = 1;

    int FOURTH_ELEMENT = 4;

    int HIGH_SPEED = 60;

    int MEDIUM_SPEED = 660;

    int LOW_SPEED = 1600;

    int COUNT_THREE = 3;

    int COUNT_FIVE = 5;

    int COUNT_TWENTY_NINE = 29;

    int COUNT_TWO = 2;

    String[] ExpectedEmailParts = {"support", "zebrunner.com"};
}
