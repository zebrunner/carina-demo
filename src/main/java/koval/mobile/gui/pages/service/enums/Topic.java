package koval.mobile.gui.pages.service.enums;

public enum Topic {
    WELCOME_TO_CARINA("Welcome to CARINA", 0),

//    HOW_CARINA_WORKS("How CARINA works"),
    SEAMLESS_INTEGRATION("Seamless integration", 1);

    public final String topicName;

    public final int topicIndex;


    Topic(String topicName, int topicIndex) {
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

