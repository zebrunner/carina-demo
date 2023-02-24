package koval.myfit.mobile.service.enums;

public enum WeightMeasures {
    KILOGRAMS("Kilograms", "kg", "", ""),
    STONES("Stones", "st", " st", " lb"),
    POUNDS("Pounds", "lb", "", "");


    public final String measure;
    public final String shortMeasure;
    public final String firstShortMeasure;
    public final String secondShortMeasure;

    WeightMeasures(String measure, String shortMeasure, String firstShortMeasure, String secondShortMeasure) {
        this.measure = measure;
        this.shortMeasure = shortMeasure;
        this.firstShortMeasure = firstShortMeasure;
        this.secondShortMeasure = secondShortMeasure;
    }


    public String getMeasure() {
        return measure;
    }

    public String getFirstMeasure() {
        return firstShortMeasure;
    }

    public String getSecondMeasure() {
        return secondShortMeasure;
    }

    public String getShortMeasure() {
        return shortMeasure;
    }
}
