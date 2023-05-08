package koval.mobile.myfitnesspal.service.factories.foodFactory;


import org.apache.commons.lang3.RandomStringUtils;

import java.util.Random;

import static koval.mobile.myfitnesspal.utils.IConstantUtils.*;

public class FoodFactory {


    private static final Random random = new Random();

    public static Food generateFood() {

        Food food = new Food();

        String RANDOM_FOOD_DESCRIPTION = "food_" + RandomStringUtils.randomNumeric(FIVE_COUNT);
        int SERVINGS = random.nextInt(FIVE_COUNT) + 1;
        int SERVINGS_PER_CONTAINER = random.nextInt(FIVE_COUNT) + 1;
        int CALORIES = random.nextInt(100 - 22) + 1;


        food.setBrandName(SPACE_FIELD);
        food.setDescription(RANDOM_FOOD_DESCRIPTION);
        food.setServingsSize(SERVINGS);
        food.setServingsSizeQuantity(UNITS_VALUE);
        food.setServingsPerContainer(SERVINGS_PER_CONTAINER);
        food.setCalories(CALORIES);

        return food;
    }

}
