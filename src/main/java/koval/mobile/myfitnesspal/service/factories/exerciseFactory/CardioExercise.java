package koval.mobile.myfitnesspal.service.factories.exerciseFactory;

public class CardioExercise {


    private String description;

    private int intervals;

    private int caloriesBurned;


    public CardioExercise(){}

    public CardioExercise(String description, int intervals, int caloriesBurned){
        this.description = description;
        this.intervals = intervals;
        this.caloriesBurned = caloriesBurned;
    }


    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }


    public int getCaloriesBurned() {
        return caloriesBurned;
    }

    public void setCaloriesBurned(int caloriesBurned) {
        this.caloriesBurned = caloriesBurned;
    }

    public int getIntervals() {
        return intervals;
    }

    public void setIntervals(int intervals) {
        this.intervals = intervals;
    }
}
