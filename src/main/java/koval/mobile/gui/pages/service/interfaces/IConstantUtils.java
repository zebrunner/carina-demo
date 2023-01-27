package koval.mobile.gui.pages.service.interfaces;

import koval.mobile.gui.pages.service.enums.Gender;

import static com.zebrunner.agent.core.webdriver.RemoteWebDriverFactory.getDriver;


public interface IConstantUtils {

    Gender FEMALEGENDER = Gender.FEMALE;

    String SPACEFIELD = " ";

    String EMPTYFIELD = "";

    int TIMEOUT_FIVE = 5;

    int FOURTH_ELEMENT = 4;

}
