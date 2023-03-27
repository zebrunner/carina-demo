package koval.myfitnesspal.login;

import com.zebrunner.agent.core.annotation.TestLabel;
import com.zebrunner.carina.core.registrar.ownership.MethodOwner;

import koval.mobile.myfitnesspal.gui.common.searchFood.SearchFoodPageBase;
import koval.mobile.myfitnesspal.gui.common.downMenuPages.DashboardPageBase;
import koval.mobile.myfitnesspal.gui.common.downMenuPages.DiaryPageBase;
import koval.mobile.myfitnesspal.gui.common.searchFood.tabsCreatePages.myFoods.CreateFoodPageBase;
import koval.mobile.myfitnesspal.gui.common.searchFood.tabsCreatePages.myMeals.CopyMealPageBase;
import koval.mobile.myfitnesspal.gui.common.searchFood.tabsCreatePages.myRecipes.CreateRecipePageBase;
import koval.mobile.myfitnesspal.service.enums.ActionsFromTabsSearchFood;
import koval.mobile.myfitnesspal.service.enums.DownMenuElement;
import koval.mobile.myfitnesspal.service.enums.Meals;
import koval.mobile.myfitnesspal.service.enums.TabsFromSearchFoodPage;
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


        List<String> FOOD = Arrays.asList("Apple", "Bread", "Milk", "Cherry");
        Meals[] mealsArr = Meals.values();

        for (int i = 0; i < Meals.values().length; i++) {

            SearchFoodPageBase searchFoodPageBase = diaryPageBase.clickAddFoodButton(mealsArr[i]);
            Assert.assertTrue(searchFoodPageBase.isPageOpened(mealsArr[i].getMeal()), String.format("[ '%s' PAGE ] '%s' page is not opened!",
                    mealsArr[i].getMeal().toUpperCase(), mealsArr[i].getMeal()));

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
        CopyMealPageBase copyMealPageBase = (CopyMealPageBase)
                searchFoodPageBase.openActionPageByName(ActionsFromTabsSearchFood.COPY_A_MEAL);

        copyMealPageBase.closeTimestampsPopUpIfPresent();
             Assert.assertTrue(copyMealPageBase.isPageOpened(),
                     "[ COPY MEAL PAGE ] Copy meal page is not opened!");

        final String COPY_MEAL ="Apple";
        diaryPageBase = copyMealPageBase.copyMeal();

        Assert.assertTrue(diaryPageBase.isFoodAddedToMeal(COPY_MEAL, Meals.BREAKFAST),
                String.format("[ DIARY PAGE ] Food '%s' is not added! Meal: Breakfast", COPY_MEAL));



        searchFoodPageBase = diaryPageBase.clickAddFoodButton(Meals.BREAKFAST);

        final List<String> RECIPE_INGREDIENTS = Arrays.asList("Milk", "Honey", "Butter");
        final String RECIPE_NAME = "Sweet milk";
        final int SERVINGS = 2;

        searchFoodPageBase.openTabByName(TabsFromSearchFoodPage.MY_RECIPES);
        CreateRecipePageBase createRecipePageBase = (CreateRecipePageBase)
                searchFoodPageBase.openActionPageByName(ActionsFromTabsSearchFood.CREATE_A_RECIPE);

        Assert.assertTrue(createRecipePageBase.isPageOpened(),
                "[ CREATE RECIPE PAGE ] Create recipe page is not opened!");

        diaryPageBase = createRecipePageBase.createRecipe(RECIPE_NAME, SERVINGS, RECIPE_INGREDIENTS);
        Assert.assertTrue(diaryPageBase.isFoodAddedToMeal(RECIPE_NAME, Meals.BREAKFAST),
                String.format("[ DIARY PAGE ] Recipe '%s' is not added! Meal: Breakfast", RECIPE_NAME));




        searchFoodPageBase = diaryPageBase.clickAddFoodButton(Meals.BREAKFAST);

        final List<String> MY_FOOD = Arrays.asList("Milk with honey", "Apple with sugar", "Bread and Butter", "Water with honey");
        final String UNITS_VALUE = "units";
        final int RANDOM_FOOD_INDEX = random.nextInt(MY_FOOD.size() - 1);
        final String BRAND_NAME = "";
        final int SERVINGS_PER_CONTAINER = 1;
        final int CALORIES = 65;

        searchFoodPageBase.openTabByName(TabsFromSearchFoodPage.MY_FOODS);
        CreateFoodPageBase createFoodPageBase = (CreateFoodPageBase)
                searchFoodPageBase.openActionPageByName(ActionsFromTabsSearchFood.CREATE_A_FOOD);

        Assert.assertTrue(createFoodPageBase.isPageOpened(),
                "[ CREATE FOOD PAGE ] Create food page is not opened!");


        diaryPageBase = createFoodPageBase.createFood(BRAND_NAME, MY_FOOD.get(RANDOM_FOOD_INDEX), SERVINGS,
                UNITS_VALUE, SERVINGS_PER_CONTAINER, CALORIES);
        Assert.assertTrue(diaryPageBase.isFoodAddedToMeal(MY_FOOD.get(RANDOM_FOOD_INDEX), Meals.BREAKFAST),
                String.format("[ DIARY PAGE ] Food '%s' is not added! Meal: Breakfast", MY_FOOD.get(RANDOM_FOOD_INDEX)));

    }

}
