package koval.mobile.myfitnesspal.service.enums;

import com.qaprosoft.carina.core.gui.AbstractPage;
import com.zebrunner.carina.utils.resources.L10N;
import koval.mobile.myfitnesspal.gui.common.actions.addExercise.CardiovascularPageBase;
import koval.mobile.myfitnesspal.gui.common.actions.addExercise.StrengthPageBase;
import koval.mobile.myfitnesspal.gui.common.actions.addExercise.WorkoutRoutinesPageBase;

public enum ExercisesType {
    CARDIOVASCULAR(L10N.getText("cardiovascular"), CardiovascularPageBase.class),
    STRENGTH(L10N.getText("strength"), StrengthPageBase.class),
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
