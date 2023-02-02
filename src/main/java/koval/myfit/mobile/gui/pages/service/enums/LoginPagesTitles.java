package koval.myfit.mobile.gui.pages.service.enums;

public enum LoginPagesTitles {
    ABOUT_ME("About you"),
    TRACK_YOUR_ACTIVITIES("Track your activities");


    public final String title;

    LoginPagesTitles(String title) {
        this.title = title;
    }


    public String getTitle() {
        return title;
    }
}
