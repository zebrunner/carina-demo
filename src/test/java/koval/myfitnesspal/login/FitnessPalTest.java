package koval.myfitnesspal.login;

import com.zebrunner.agent.core.annotation.TestLabel;
import com.zebrunner.carina.core.registrar.ownership.MethodOwner;

import koval.mobile.myfitnesspal.gui.android.searchFood.tabsCreatePages.myMeals.CreateMealPage;
import koval.mobile.myfitnesspal.gui.common.searchFood.SearchFoodPageBase;
import koval.mobile.myfitnesspal.gui.common.downMenuPages.DashboardPageBase;
import koval.mobile.myfitnesspal.gui.common.downMenuPages.DiaryPageBase;
import koval.mobile.myfitnesspal.gui.common.searchFood.tabsCreatePages.myFoods.CreateFoodPageBase;
import koval.mobile.myfitnesspal.gui.common.searchFood.tabsCreatePages.myMeals.CopyMealPageBase;
import koval.mobile.myfitnesspal.gui.common.searchFood.tabsCreatePages.myMeals.CreateMealPageBase;
import koval.mobile.myfitnesspal.gui.common.searchFood.tabsCreatePages.myRecipes.CreateRecipePageBase;
import koval.mobile.myfitnesspal.service.accountFactory.Account;
import koval.mobile.myfitnesspal.service.accountFactory.AccountFactory;
import koval.mobile.myfitnesspal.service.enums.ActionsFromTabsSearchFood;
import koval.mobile.myfitnesspal.service.enums.DownMenuElement;
import koval.mobile.myfitnesspal.service.enums.Meals;
import koval.mobile.myfitnesspal.service.enums.TabsFromSearchFoodPage;
import koval.mobile.myfitnesspal.service.foodFactory.Food;
import koval.mobile.myfitnesspal.service.foodFactory.FoodFactory;
import koval.mobile.myfitnesspal.service.recipeFactory.Recipe;
import koval.mobile.myfitnesspal.service.recipeFactory.RecipeFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.lang.invoke.MethodHandles;
import java.util.Arrays;
import java.util.List;
import java.util.Random;


public class FitnessPalTest extends LoginTest {

    private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

    private static final Random random = new Random();

    private static final List<String> FOOD = Arrays.asList("Apple", "Bread", "Water", "Cherries");

    final String FOOD_MEAL = "Apple";

    final String MEAL_NAME = "MyMeal " + random.nextInt(100) + 1;


    @Test()
    @MethodOwner(owner = "koval")
    @TestLabel(name = "feature", value = {"mobile", "regression"})
    public void loginSimpleUserTest() {

        DashboardPageBase dashboardPageBase = initPage(getDriver(), DashboardPageBase.class);

        Assert.assertFalse(dashboardPageBase.isUserPremium(), "[ DASHBOARD PAGE ] User is premium!");
    }


    @Test()
    @MethodOwner(owner = "koval")
    @TestLabel(name = "feature", value = {"mobile", "regression"})
    public void addFoodTest() {

        DashboardPageBase dashboardPageBase = initPage(getDriver(), DashboardPageBase.class);

        DiaryPageBase diaryPageBase = (DiaryPageBase) dashboardPageBase.openPageFromDownMenuByName(DownMenuElement.DIARY);
        Assert.assertTrue(diaryPageBase.isPageOpened(), "[ DIARY PAGE ] Diary page is not opened!");

        diaryPageBase.deleteAllFood();
        diaryPageBase.closePromoMessagesIfPresent();

        Meals[] mealsArr = Meals.values();

        for (int i = 0; i < Meals.values().length; i++) {

            SearchFoodPageBase searchFoodPageBase = diaryPageBase.clickAddFoodButton(mealsArr[i]);
            Assert.assertTrue(searchFoodPageBase.isPageOpened(mealsArr[i].getMeal()), String.format("[ '%s' PAGE ] '%s' page is not opened!",
                    mealsArr[i].getMeal().toUpperCase(), mealsArr[i].getMeal()));

            searchFoodPageBase.searchFood(FOOD.get(i));
            searchFoodPageBase.addFoodToMealByName(FOOD.get(i));

            diaryPageBase = searchFoodPageBase.clickBackButton();
            Assert.assertTrue(diaryPageBase.isFoodAddedToMeal(FOOD.get(i), mealsArr[i]), String.format("[ DIARY PAGE ] Food '%s' is not added! Meal: '%s'",
                    FOOD.get(i), mealsArr[i]));
        }

        diaryPageBase.deleteAllFood();

        for (Meals meals : Meals.values()) {
            Assert.assertTrue(diaryPageBase.isAllFoodDeletedForMeal(meals), String.format("[ DIARY PAGE ] Food is not deleted! Meal: '%s'",
                    meals));

        }
    }

    @Test()
    @MethodOwner(owner = "koval")
    @TestLabel(name = "feature", value = {"mobile", "regression"})
    public void addCreatedOwnFoodToBreakfastTest() {

        DashboardPageBase dashboardPageBase = initPage(getDriver(), DashboardPageBase.class);

        DiaryPageBase diaryPageBase = (DiaryPageBase) dashboardPageBase.openPageFromDownMenuByName(DownMenuElement.DIARY);
        diaryPageBase.deleteAllFood();


        SearchFoodPageBase searchFoodPageBase = diaryPageBase.clickAddFoodButton(Meals.BREAKFAST);
        Assert.assertTrue(searchFoodPageBase.isPageOpened(Meals.BREAKFAST.getMeal()),
                "[ BREAKFAST PAGE ] Breakfast page is not opened!");


        searchFoodPageBase.openTabByName(TabsFromSearchFoodPage.MY_MEALS);
        CreateMealPageBase createMealPageBase = (CreateMealPageBase)
                searchFoodPageBase.openActionPageByName(ActionsFromTabsSearchFood.CREATE_A_MEAL);

        createMealPageBase.closeTimestampsPopUpIfPresent();
        Assert.assertTrue(createMealPageBase.isPageOpened(),
                "[ COPY MEAL PAGE ] Copy meal page is not opened!");


        searchFoodPageBase = createMealPageBase.createMeal(MEAL_NAME);
        searchFoodPageBase.searchFood(FOOD_MEAL);
        searchFoodPageBase.addFoodToMealByName(FOOD_MEAL);
        searchFoodPageBase.clickBackButton();
        createMealPageBase.clickSaveButton();

        searchFoodPageBase.addFoodToMealByName(MEAL_NAME);


        diaryPageBase = searchFoodPageBase.clickBackButton();


        Assert.assertTrue(diaryPageBase.isFoodAddedToMeal(FOOD_MEAL, Meals.BREAKFAST),
                String.format("[ DIARY PAGE ] Food '%s' is not added! Meal: Breakfast", FOOD_MEAL));


        searchFoodPageBase = diaryPageBase.clickAddFoodButton(Meals.BREAKFAST);

        searchFoodPageBase.openTabByName(TabsFromSearchFoodPage.MY_RECIPES);
        CreateRecipePageBase createRecipePageBase = (CreateRecipePageBase)
                searchFoodPageBase.openActionPageByName(ActionsFromTabsSearchFood.CREATE_A_RECIPE);

        Assert.assertTrue(createRecipePageBase.isPageOpened(),
                "[ CREATE RECIPE PAGE ] Create recipe page is not opened!");


        Recipe recipe = RecipeFactory.generateRecipe();
        diaryPageBase = createRecipePageBase.createRecipeByEnteringIngredientsPerLine(recipe);
        Assert.assertTrue(diaryPageBase.isFoodAddedToMeal(recipe.getRecipeName(), Meals.BREAKFAST),
                String.format("[ DIARY PAGE ] Recipe '%s' is not added! Meal: Breakfast", recipe.getRecipeName()));


        searchFoodPageBase = diaryPageBase.clickAddFoodButton(Meals.BREAKFAST);

        searchFoodPageBase.openTabByName(TabsFromSearchFoodPage.MY_FOODS);
        CreateFoodPageBase createFoodPageBase = (CreateFoodPageBase)
                searchFoodPageBase.openActionPageByName(ActionsFromTabsSearchFood.CREATE_A_FOOD);

        Assert.assertTrue(createFoodPageBase.isPageOpened(),
                "[ CREATE FOOD PAGE ] Create food page is not opened!");


        Food food = FoodFactory.generateFood();

        diaryPageBase = createFoodPageBase.createFood(food);
        Assert.assertTrue(diaryPageBase.isFoodAddedToMeal(food.getDescription(), Meals.BREAKFAST),
                String.format("[ DIARY PAGE ] Food '%s' is not added! Meal: Breakfast", food.getDescription()));

    }


}
