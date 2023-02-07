package koval.myfit.mobile.gui.pages.service.interfaces;

import java.util.Arrays;
import java.util.List;

public interface IConstantUtils {

    int TIMEOUT_FIVE = 5;

    int LOW_SPEED = 1000;

    int MEDIUM_SPEED = 800;

    int HIGH_SPEED = 150;

    List<String> EXPECTED_LIST_OF_MATERIAL_CARD_TOPICS =
            Arrays.asList("Your daily goals", "Your weekly target", "Activity tracking is off", "Weight", "Energy expended",
                    "A simple way to stay healthy", "How much sleep you need", "The YouTube logo and slogan Stay Fit With Me",
                    "Set a pace for your walks", "Your sleep in Fit");
    List<String> EXPECTED_LIST_OF_PLAYLIST_TITLES =
            Arrays.asList("Workout", "Yoga", "Dance", "Meditate", "Mental Health", "Sleep");


}
