package koval.mobile.myfit.service.enums;

public enum MaterialCardTopics {
    YOUR_DAILY_GOALS("Your daily goals"),
    YOUR_WEEKLY_TARGET("Your weekly target"),
    WEIGHT("Weight"),
    ENERGY_EXPENDED("Energy expended"),
    A_SIMPLE_WAY_TO_STAY_HEALTHY("A simple way to stay healthy"),
    HOW_MUCH_SLEEP_YOU_NEED("How much sleep you need"),
    SET_A_PACE_FOR_YOUR_WALKS("Set a pace for your walks"),
    YOUR_SLEEP_IN_FIT("Your sleep in Fit");

    public final String topicName;

    MaterialCardTopics(String topicName) {
        this.topicName = topicName;
    }

    public String getTopicName() {
        return topicName;
    }

}
