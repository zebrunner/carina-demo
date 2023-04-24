package koval.mobile.myfitnesspal.service.factories.accountFactory;


import koval.mobile.myfitnesspal.service.enums.Gender;
import koval.mobile.myfitnesspal.service.enums.WeightMeasure;

public class Account {


    private int age;
    private String country;
    private Gender gender;
    private int heightCentimeters;
    private int weightKilograms;
    private int kilograms;
    private WeightMeasure weightMeasure;


    public Account(){}

    public Account(int age, String country, Gender gender, int heightCentimeters, int weightKilograms, int kilograms, WeightMeasure weightMeasure){
        this.age = age;
        this.country = country;
        this.gender = gender;
        this.heightCentimeters = heightCentimeters;
        this.weightKilograms = weightKilograms;
        this.kilograms = kilograms;
        this.weightMeasure =weightMeasure;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public int getHeightCentimeters() {
        return heightCentimeters;
    }

    public void setHeightCentimeters(int heightCentimeters) {
        this.heightCentimeters = heightCentimeters;
    }

    public int getWeightKilograms() {
        return weightKilograms;
    }

    public void setWeightKilograms(int weightKilograms) {
        this.weightKilograms = weightKilograms;
    }

    public int getKilograms() {
        return kilograms;
    }

    public void setKilograms(int kilograms) {
        this.kilograms = kilograms;
    }

    public WeightMeasure getWeightMeasure() {
        return weightMeasure;
    }

    public void setWeightMeasure(WeightMeasure weightMeasure) {
        this.weightMeasure = weightMeasure;
    }
}
