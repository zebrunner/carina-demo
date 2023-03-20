package koval.mobile.myfitnesspal.service.enums;

import java.util.Random;

public enum Gender {
    FEMALE("Female"),
    MALE("Male");


    public final String gender;

    Gender(String gender) {
        this.gender = gender;
    }


    public String getGender() {
        return gender;
    }

}
