package koval.web.myfitnesspal.service.factories.foodFactory;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class FoodFactory {

    private static final Random random = new Random();

    public static Food generateFood() {
        Food food = new Food();
        List<String> FOOD_LIST = Arrays.asList("Milk", "Honey", "Butter", "Apple", "Bread", "Water", "Cherries");
        String FOOD_DESCRIPTION = FOOD_LIST.get(random.nextInt(FOOD_LIST.size() - 2) + 1);
        String FOOD_SERVINGS = "2 cups";
        int SERVINGS_PER_CONTAINER = new Random().nextInt(5) + 1;

        food.setFoodDescription(FOOD_DESCRIPTION);
        food.setServingSize(FOOD_SERVINGS);
        food.setServingsPerContainer(SERVINGS_PER_CONTAINER);
        return food;
    }

}
