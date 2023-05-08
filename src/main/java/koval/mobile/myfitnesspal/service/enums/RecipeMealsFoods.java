package koval.mobile.myfitnesspal.service.enums;


import com.zebrunner.carina.utils.resources.L10N;

public enum RecipeMealsFoods {

    MEALS("meals"),

    RECIPES("recipes"),

    FOODS("foods");


    public final String itemName;


    RecipeMealsFoods(String itemName) {
        this.itemName = itemName;

    }


    public String getItemName() {
        return L10N.getText(itemName);
    }

    }
