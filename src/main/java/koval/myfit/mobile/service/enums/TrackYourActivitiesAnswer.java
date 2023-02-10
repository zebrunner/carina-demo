package koval.myfit.mobile.service.enums;

public enum TrackYourActivitiesAnswer {
    YES("Turn on"),
    NO("No thanks");

    public final String answer;

    TrackYourActivitiesAnswer(String answer) {
        this.answer = answer;
    }


    public String getAnswer() {
        return answer;
    }
}
