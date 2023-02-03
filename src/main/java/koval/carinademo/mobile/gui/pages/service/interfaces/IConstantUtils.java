package koval.carinademo.mobile.gui.pages.service.interfaces;

import koval.carinademo.mobile.gui.pages.service.enums.Gender;

import java.util.Arrays;
import java.util.List;



public interface IConstantUtils {

    Gender FEMALEGENDER = Gender.FEMALE;

    String SPACEFIELD = " ";

    String EMPTYFIELD = "";

    String EXPECTED_EMAIL_NAME = "support";

    String EXPECTED_EMAIL_AGENT = "zebrunner.com";

    int TIMEOUT_FIVE = 5;

    int HIGH_SPEED = 60;

    int MEDIUM_SPEED = 620;

    int LOW_SPEED = 2000;

    int COUNT_THREE = 3;

    List<String> EXPECTED_LIST_OF_TOPICS = Arrays.asList("Welcome to CARINA", "How CARINA works\n", "Seamless integration");

}
