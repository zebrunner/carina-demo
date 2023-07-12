package koval.web.myfitnesspal.service.enums;

public enum ExerciseTypes {

    STRENGTH("Strength Training"),
    CARDIOVASCULAR("Cardiovascular");

    private String typeName;

    ExerciseTypes(String typeName) {
        this.typeName = typeName;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }
}
