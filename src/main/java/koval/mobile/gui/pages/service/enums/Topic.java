package koval.mobile.gui.pages.service.enums;

public enum Topic {
    WELCOME_TO_CARINA("Welcome to Carina"),
    HOW_CARINA_WORKS("How Carina works"),
    SEAMLESS_INTEGRATION("Seamless Integration");

    public final String topicName;

    Topic(String topicName) {
        this.topicName = topicName;
    }


    public String getTopicName() {
        return topicName;
    }
}

