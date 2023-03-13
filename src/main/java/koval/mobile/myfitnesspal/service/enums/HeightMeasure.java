package koval.mobile.myfitnesspal.service.enums;

public enum HeightMeasure {
    FEET_INCHES("Feet & Inches"),
    CENTIMETERS("Centimeters");


    public final String heightMeasure;

    HeightMeasure(String heightMeasure) {
        this.heightMeasure = heightMeasure;
    }


    public String getHeightMeasure() {
        return heightMeasure;
    }
}
