package koval.mobile.myfitnesspal.service.recipeFactory;


import koval.mobile.myfitnesspal.service.foodFactory.Food;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

import static koval.mobile.myfitnesspal.utils.IConstantUtils.*;

public class RecipeFactory {


    private static final Random random = new Random();

    public static Recipe generateRecipe() {

        Recipe recipe = new Recipe();

        String RECIPE_NAME = "Honey milk";
        int SERVINGS = random.nextInt(5) + 1;
        List<String> RECIPE_INGREDIENTS = Arrays.asList("Milk", "Honey", "Butter");

        recipe.setRecipeName(RECIPE_NAME);
        recipe.setRecipeIngredients(RECIPE_INGREDIENTS);
        recipe.setServings(SERVINGS);

        return recipe;
    }

}
