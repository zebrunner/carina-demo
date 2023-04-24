package koval.mobile.myfitnesspal.service.factories.recipeFactory;


import java.util.List;

public class Recipe {


    private String recipeName;

    private int servings;

    private List<String> recipeIngredients;


    public Recipe(){}

    public Recipe(String recipeName, int servings,   List<String> recipeIngredients){
        this.recipeName = recipeName;
        this.servings = servings;
        this.recipeIngredients = recipeIngredients;
    }


    public String getRecipeName() {
        return recipeName;
    }

    public void setRecipeName(String recipeName) {
        this.recipeName = recipeName;
    }

    public int getServings() {
        return servings;
    }

    public void setServings(int servings) {
        this.servings = servings;
    }

    public List<String> getRecipeIngredients() {
        return recipeIngredients;
    }

    public void setRecipeIngredients(List<String> recipeIngredients) {
        this.recipeIngredients = recipeIngredients;
    }
}
