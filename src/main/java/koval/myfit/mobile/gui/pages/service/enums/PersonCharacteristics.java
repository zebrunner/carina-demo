package koval.myfit.mobile.gui.pages.service.enums;

public enum PersonCharacteristics {
    GENDER("gender"),
    BIRTHDAY("birthday"),
    WEIGHT("weight"),
    HEIGHT("height");

    public final String characteristic;

    PersonCharacteristics(String characteristic) {
        this.characteristic = characteristic;
    }


    public String getCharacteristic() {
        return characteristic;
    }
}
