package koval.mobile.myfitnesspal.service.factories.recipeFactory;



import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;


public class RecipeFactory {



    public static Recipe generateRecipe() {

        Recipe recipe = new Recipe();

        String RECIPE_NAME = "recipe_" + new Random().nextInt(100);
        int SERVINGS = new Random().nextInt(5) + 1;

        List<String> INGREDIENTS_FOR_RECIPE = Arrays.asList("Milk", "Honey", "Butter", "Apple", "Bread", "Water", "Cherries");
        List<String> RECIPE_INGREDIENTS = new ArrayList<>();

        for(int i = 0; i < 2; i ++)
        {
            RECIPE_INGREDIENTS.add(INGREDIENTS_FOR_RECIPE.get(new Random().nextInt(INGREDIENTS_FOR_RECIPE.size())));
        }

        recipe.setRecipeName(RECIPE_NAME);
        recipe.setRecipeIngredients(RECIPE_INGREDIENTS);
        recipe.setServings(SERVINGS);

        return recipe;
    }

}
