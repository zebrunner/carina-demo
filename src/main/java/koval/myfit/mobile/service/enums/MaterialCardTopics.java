package koval.myfit.mobile.service.enums;

public enum MaterialCardTopics {
    YOUR_DAILY_GOALS("Your daily goals", 0),
    YOUR_WEEKLY_TARGET("Your weekly target", 1),
    ACTIVITY_TRACKING_IS_OFF("Activity tracking is off", 2),
    WEIGHT("Weight", 3),
    ENERGY_EXPENDED("Energy expended", 3),
    A_SIMPLE_WAY_TO_STAY_HEALTHY("A simple way to stay healthy", 3),
    SET_A_PACE_FOR_YOUR_WALKS("Set a pace for your walks", 3),
    YOUR_SLEEP_IN_FIT("Your sleep in Fit", 3);

    public final String topicName;
    public final int topicIndex;

    MaterialCardTopics(String topicName, int topicIndex) {
        this.topicName = topicName;
        this.topicIndex = topicIndex;
    }

    public String getTopicName() {
        return topicName;
    }

    public int getTopicIndex() {
        return topicIndex;
    }

}
