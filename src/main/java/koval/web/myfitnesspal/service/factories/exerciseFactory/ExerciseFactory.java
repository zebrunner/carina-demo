package koval.web.myfitnesspal.service.factories.exerciseFactory;

import koval.web.myfitnesspal.service.enums.ExerciseTypes;
import org.apache.commons.lang3.RandomStringUtils;

import java.util.Random;

public class ExerciseFactory {


    public static Exercise generateExercise() {
        Exercise exercise = new Exercise();
        String EXERCISE_TYPE = ExerciseTypes.STRENGTH.getTypeName();
        String EXERCISE_DESCRIPTION = String.format("exercise_%s", RandomStringUtils.randomNumeric(5));
        int SETS = new Random().nextInt(5) + 1;
        int REPETITION = new Random().nextInt(5) + 1;

        exercise.setDescription(EXERCISE_DESCRIPTION);
        exercise.setType(EXERCISE_TYPE);
        exercise.setSets(SETS);
        exercise.setRepetitions(REPETITION);
        return exercise;

    }


}
