package koval.mobile.myfitnesspal.service.factories.exerciseFactory;

import java.util.Random;

import static koval.mobile.myfitnesspal.utils.IConstantUtils.MY_EXERCISES;


public class StrengthExerciseFactory {


    public static StrengthExercise generateExercise() {

        StrengthExercise strengthExercise = new StrengthExercise();

        int REPS = new Random().nextInt(5) + 1;
        int SETS = new Random().nextInt(5) + 1;
        int RANDOM_EXERCISE_INDEX = new Random().nextInt(MY_EXERCISES.size() - 1);


        strengthExercise.setDescription(MY_EXERCISES.get(RANDOM_EXERCISE_INDEX));
        strengthExercise.setSets(SETS);
        strengthExercise.setReps(REPS);

        return strengthExercise;
    }

}
