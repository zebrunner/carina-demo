package koval.mobile.myfitnesspal.service.factories.exerciseFactory;

import org.apache.commons.lang3.RandomStringUtils;

import java.util.Random;

import static koval.mobile.myfitnesspal.utils.IConstantUtils.MY_EXERCISES;


public class CardioExerciseFactory {


    public static CardioExercise generateExercise() {

        CardioExercise cardioExercise  = new CardioExercise();

        int INTERVALS = new Random().nextInt(50) + 5;
        int CALORIES_BURNED = new Random().nextInt(200) + 10;
        String RANDOM_EXERCISE = "exercise_" + RandomStringUtils.randomNumeric(5);


        cardioExercise.setDescription(RANDOM_EXERCISE);
        cardioExercise.setIntervals(INTERVALS);
        cardioExercise.setCaloriesBurned(CALORIES_BURNED);

        return cardioExercise;
    }

}
