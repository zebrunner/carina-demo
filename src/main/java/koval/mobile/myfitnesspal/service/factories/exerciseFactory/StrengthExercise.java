package koval.mobile.myfitnesspal.service.factories.exerciseFactory;

public class StrengthExercise {


    private String description;

    private int sets;

    private int reps;


    public StrengthExercise(){}

    public StrengthExercise(String description, int sets, int reps){
        this.description = description;
        this.sets = sets;
        this.reps = reps;
    }


    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getSets() {
        return sets;
    }

    public void setSets(int sets) {
        this.sets = sets;
    }

    public int getReps() {
        return reps;
    }

    public void setReps(int reps) {
        this.reps = reps;
    }
}
