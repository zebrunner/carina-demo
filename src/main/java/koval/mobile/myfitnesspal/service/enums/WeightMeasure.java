package koval.mobile.myfitnesspal.service.enums;

public enum WeightMeasure {
    POUNDS("Pounds"),
    KILOGRAMS("Kilograms"),
    STONE("Stone");


    public final String weightMeasure;

    WeightMeasure(String weightMeasure) {
        this.weightMeasure = weightMeasure;
    }


    public String getWeightMeasure() {
        return weightMeasure;
    }
}
