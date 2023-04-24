package koval.mobile.myfitnesspal.service.enums;

import com.qaprosoft.carina.core.gui.AbstractPage;
import koval.mobile.myfitnesspal.gui.common.downMenuPages.diaryPageBase.addExercise.CardiovascularPageBase;
import koval.mobile.myfitnesspal.gui.common.downMenuPages.diaryPageBase.addExercise.StrengthPageBase;
import koval.mobile.myfitnesspal.gui.common.downMenuPages.diaryPageBase.addExercise.WorkoutRoutinesPageBase;

public enum ExercisesType {
    CARDIOVASCULAR("Cardiovascular", CardiovascularPageBase.class),
    STRENGTH("Strength", StrengthPageBase.class),
    WORKOUT_ROUTINES("Workout Routines", WorkoutRoutinesPageBase.class);

    public final String exerciseType;

    private final Class<? extends AbstractPage> className;

    ExercisesType(String exerciseType, Class<? extends AbstractPage> className) {
        this.exerciseType = exerciseType;
        this.className = className;
    }


    public String getExerciseType() {
        return exerciseType;
    }

    public Class<? extends AbstractPage> getClassName() {
        return className;
    }
}
