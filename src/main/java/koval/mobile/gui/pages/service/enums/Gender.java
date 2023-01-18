package koval.mobile.gui.pages.service.enums;

public enum Gender {
    MALE("Male"),
    FEMALE("Female");

    public final String label;

    Gender(String label) {
        this.label = label;
    }

    @Override
    public String toString() { //return values Male/Female
        return label;
    }
}

