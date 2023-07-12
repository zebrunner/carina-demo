package koval.web.myfitnesspal.service.factories.exerciseFactory;

public class Exercise {

    private String description;

    private String type;

    private int sets;

    private int repetitions;

    public Exercise() {
    }


    public Exercise(String description, String type, int sets, int repetitions) {
        this.description = description;
        this.type = type;
        this.sets = sets;
        this.repetitions = repetitions;
    }


    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getRepetitions() {
        return repetitions;
    }

    public void setRepetitions(int repetitions) {
        this.repetitions = repetitions;
    }

    public int getSets() {
        return sets;
    }

    public void setSets(int sets) {
        this.sets = sets;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
