package koval.mobile.myfitnesspal.service.foodFactory;


import java.util.Random;

import static koval.mobile.myfitnesspal.utils.IConstantUtils.*;

public class FoodFactory {


    private static final Random random = new Random();

    public static Food generateFood() {

        Food food = new Food();

        int RANDOM_FOOD_INDEX = random.nextInt(MY_FOOD.size() - 1);
        int SERVINGS = random.nextInt(5) + 1;
        int SERVINGS_PER_CONTAINER = random.nextInt(5) + 1;
        int CALORIES = random.nextInt(100 - 22) + 1;


        food.setBrandName(SPACE_FIELD);
        food.setDescription(MY_FOOD.get(RANDOM_FOOD_INDEX));
        food.setServingsSize(SERVINGS);
        food.setServingsSizeQuantity(UNITS_VALUE);
        food.setServingsPerContainer(SERVINGS_PER_CONTAINER);
        food.setCalories(CALORIES);

        return food;
    }

}
