package koval.mobile.myfitnesspal.service.enums;

public enum Location {
    TOP("top"),
    BOTTOM("bottom"),
    LEFT("left"),
    RIGHT("right");

    public final String location;

    Location(String location) {
        this.location = location;
    }


    public String getLocation() {
        return location;
    }
}
