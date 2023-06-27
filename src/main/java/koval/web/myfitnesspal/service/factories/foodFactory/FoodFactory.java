package koval.web.myfitnesspal.service.factories.foodFactory;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class FoodFactory {

    private static final Random random = new Random();

    public static Food generateFood() {
        Food food = new Food();
        List<String> FOOD_LIST = Arrays.asList("Milk", "Honey", "Butter", "Apple", "Bread", "Water", "Cherries");
        String FOOD_NAME = FOOD_LIST.get(random.nextInt(FOOD_LIST.size() - 2) + 1);
        food.setFoodName(FOOD_NAME);
        return food;
    }

}
