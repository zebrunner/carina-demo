package koval.myfitnesspal.login;

import com.zebrunner.agent.core.annotation.TestLabel;
import com.zebrunner.carina.core.registrar.ownership.MethodOwner;

import com.zebrunner.carina.core.registrar.tag.TestTag;
import com.zebrunner.carina.utils.resources.L10N;
import koval.mobile.myfitnesspal.gui.common.actions.RecipesMealsFoodsPageBase;
import koval.mobile.myfitnesspal.gui.common.downMenuPages.dashboardPage.mePage.MePageBase;
import koval.mobile.myfitnesspal.gui.common.actions.addExercise.CardiovascularPageBase;
import koval.mobile.myfitnesspal.gui.common.actions.addExercise.NewCardioExercisePageBase;
import koval.mobile.myfitnesspal.gui.common.phoneInterface.PhoneHomePageBase;
import koval.mobile.myfitnesspal.gui.common.phoneInterface.PhoneWidgetPageBase;
import koval.mobile.myfitnesspal.gui.common.actions.addFood.SearchFoodPageBase;
import koval.mobile.myfitnesspal.gui.common.downMenuPages.dashboardPage.DashboardPageBase;
import koval.mobile.myfitnesspal.gui.common.downMenuPages.DiaryPageBase;
import koval.mobile.myfitnesspal.gui.common.actions.addFood.tabsCreatePages.myFoods.CreateFoodPageBase;
import koval.mobile.myfitnesspal.gui.common.actions.addFood.tabsCreatePages.myMeals.CreateMealPageBase;
import koval.mobile.myfitnesspal.gui.common.actions.addFood.tabsCreatePages.myRecipes.CreateRecipePageBase;
import koval.mobile.myfitnesspal.service.enums.*;
import koval.mobile.myfitnesspal.service.factories.exerciseFactory.CardioExercise;
import koval.mobile.myfitnesspal.service.factories.exerciseFactory.CardioExerciseFactory;
import koval.mobile.myfitnesspal.service.factories.foodFactory.Food;
import koval.mobile.myfitnesspal.service.factories.foodFactory.FoodFactory;
import koval.mobile.myfitnesspal.service.factories.recipeFactory.Recipe;
import koval.mobile.myfitnesspal.service.factories.recipeFactory.RecipeFactory;
import org.apache.commons.lang3.RandomStringUtils;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Random;


public class FitnessPalTest extends LoginTest {

    private static final List<String> FOOD = Arrays.asList("Apple", "Bread", "Water", "Cherries");

    private static final int FOOD_MEAL_INDEX = new Random().nextInt(FOOD.size());

    private static final String MEAL_NAME = "meal_" + RandomStringUtils.randomAlphabetic(FIVE_COUNT);

    private static final String APP_NAME = AppAndWidgets.FITNESSPAL.getAppName();

    private static final String WIDGET_NAME = AppAndWidgets.FITNESSPAL.getFirstWidget();


    @Test(groups = {"logout"})
    @MethodOwner(owner = "koval")
    @TestLabel(name = "feature", value = {"mobile", "regression"})
    @TestTag(name = "localized", value = "en_US")
    @TestTag(name = "localized", value = "es_ES")
    public void loginSimpleUserTest() {

        DashboardPageBase dashboardPageBase = initPage(getDriver(), DashboardPageBase.class);

        Assert.assertFalse(dashboardPageBase.isUserPremium(), "[ DASHBOARD PAGE ] User is premium!");
    }


    @Test(groups = {"logout"})
    @MethodOwner(owner = "koval")
    @TestLabel(name = "feature", value = {"mobile", "regression"})
    @TestTag(name = "localized", value = "en_US")
    @TestTag(name = "localized", value = "es_ES")
    public void addFoodTest() {

        DashboardPageBase dashboardPageBase = initPage(getDriver(), DashboardPageBase.class);

        DiaryPageBase diaryPageBase = (DiaryPageBase) dashboardPageBase.openPageFromDownMenuByName(DownMenuElement.DIARY);
        diaryPageBase.deleteAllItems();
        diaryPageBase.closePromoMessagesIfPresent();

        Meals[] mealsArr = Meals.values();


        for (int i = 0; i < Meals.values().length; i++) {

            SearchFoodPageBase searchFoodPageBase = diaryPageBase.clickAddFoodButton(mealsArr[i]);
            Assert.assertTrue(searchFoodPageBase.isPageOpened(mealsArr[i].getMeal()), String.format("[ '%s' PAGE ] '%s' page is not opened!",
                    mealsArr[i].getMeal().toUpperCase(), mealsArr[i].getMeal()));

            searchFoodPageBase.searchFood(FOOD.get(i));
            searchFoodPageBase.addFoodToMealByName(FOOD.get(i));

            diaryPageBase = (DiaryPageBase) searchFoodPageBase.clickBackButton(ReturnPages.DIARY);
            Assert.assertTrue(diaryPageBase.isFoodAddedToMeal(FOOD.get(i), mealsArr[i]), String.format("[ DIARY PAGE ] Food '%s' is not added! Meal: '%s'",
                    FOOD.get(i), mealsArr[i]));
        }

        diaryPageBase.deleteAllItems();
        Assert.assertTrue(diaryPageBase.isAllFoodDeletedForMeal(), "[ DIARY PAGE ] Food is not deleted!");
    }

    @Test(groups = {"logout"})
    @MethodOwner(owner = "koval")
    @TestLabel(name = "feature", value = {"mobile", "regression"})
    @TestTag(name = "localized", value = "en_US")
    @TestTag(name = "localized", value = "es_ES")
    public void addCreatedOwnFoodToBreakfastTest() {

        DashboardPageBase dashboardPageBase = initPage(getDriver(), DashboardPageBase.class);

        DiaryPageBase diaryPageBase = (DiaryPageBase) dashboardPageBase.openPageFromDownMenuByName(DownMenuElement.DIARY);
        diaryPageBase.deleteAllItems();


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
        searchFoodPageBase.searchFood(FOOD.get(FOOD_MEAL_INDEX));
        searchFoodPageBase.addFoodToMealByName(FOOD.get(FOOD_MEAL_INDEX));
        createMealPageBase = (CreateMealPageBase) searchFoodPageBase.clickBackButton(ReturnPages.CREATE_A_MEAL);
        createMealPageBase.clickSaveButton();

        searchFoodPageBase.addFoodToMealByName(MEAL_NAME);
        diaryPageBase = (DiaryPageBase) searchFoodPageBase.clickBackButton(ReturnPages.DIARY);


        Assert.assertTrue(diaryPageBase.isFoodAddedToMeal(FOOD.get(FOOD_MEAL_INDEX), Meals.BREAKFAST),
                String.format("[ DIARY PAGE ] Food '%s' is not added! Meal: Breakfast", FOOD.get(FOOD_MEAL_INDEX)));


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

        Food food = FoodFactory.generateFood();

        diaryPageBase = createFoodPageBase.createFood(food);
        Assert.assertTrue(diaryPageBase.isFoodAddedToMeal(food.getDescription(), Meals.BREAKFAST),
                String.format("[ DIARY PAGE ] Food '%s' is not added! Meal: Breakfast", food.getDescription()));

    }


    @Test(groups = {"closeAppAndDeleteWidget"})
    @MethodOwner(owner = "dkoval")
    @TestLabel(name = "feature", value = {"mobile", "regression"})
    @TestTag(name = "localized", value = "en_US")
    @TestTag(name = "localized", value = "es_ES")
    public void searchButtonFromWidget2x2Test() {

        PhoneHomePageBase phoneHomePageBase = goHome();
        phoneHomePageBase.holdPhoneDesktop();

        PhoneWidgetPageBase phoneWidgetPageBase = phoneHomePageBase.tapWidgetButton();
        phoneHomePageBase = phoneWidgetPageBase.addWidgetToDesktop(APP_NAME, WIDGET_NAME);
        phoneHomePageBase.resizeWidgetFromTo(WidgetSize.SIZE_4X2, WidgetSize.SIZE_2X2);


        Assert.assertTrue(phoneHomePageBase.isSearchButtonPresent(TIMEOUT_FIFTEEN),
                "[ PHONE HOME PAGE ] Search Button is not present in the widget!");


        SearchFoodPageBase searchFoodPageBase = phoneHomePageBase.pressSearchButton();
        Assert.assertTrue(searchFoodPageBase.isPageOpened(), "[ SEARCH FOOD PAGE ] Search Food page is not opened!");
        Assert.assertTrue(searchFoodPageBase.isKeyboardShown(), "[ SEARCH FOOD PAGE ] KeyBoard is not opened!");

    }


    @Test(groups = {"closeAppAndDeleteWidget"})
    @MethodOwner(owner = "dkoval")
    @TestLabel(name = "feature", value = {"mobile", "regression"})
    @TestTag(name = "localized", value = "en_US")
    @TestTag(name = "localized", value = "es_ES")
    public void logFoodFromWidget2x1Test() {

        PhoneHomePageBase phoneHomePageBase = goHome();

        phoneHomePageBase.holdPhoneDesktop();

        PhoneWidgetPageBase phoneWidgetPageBase = phoneHomePageBase.tapWidgetButton();
        phoneHomePageBase = phoneWidgetPageBase.addWidgetToDesktop(APP_NAME, WIDGET_NAME);
        phoneHomePageBase.resizeWidgetFromTo(WidgetSize.SIZE_4X2, WidgetSize.SIZE_2X1);


        double wasCaloriesCount = phoneHomePageBase.getCaloriesValueFromWidget(Calories.CALS_REMAINING);
        DashboardPageBase dashboardPageBase = phoneHomePageBase.openAppFromWidget();

        SearchFoodPageBase searchFoodPageBase = dashboardPageBase.clickSearchForFoodContainer();
        searchFoodPageBase.searchFood(FOOD.get(FOOD_MEAL_INDEX));
        searchFoodPageBase.addFoodToMealByName(FOOD.get(FOOD_MEAL_INDEX));
        phoneHomePageBase = goHome();

        double isCaloriesCount = phoneHomePageBase.getCaloriesValueFromWidget(Calories.CALS_REMAINING);

        Assert.assertTrue(isCaloriesCount <= wasCaloriesCount,
                "[ PHONE HOME PAGE ] Cals Remaining is not updated after logging food in the main app!");
    }


    @Test(groups = {"closeAppAndDeleteWidget"})
    @MethodOwner(owner = "dkoval")
    @TestLabel(name = "feature", value = {"mobile", "regression"})
    @TestTag(name = "localized", value = "en_US")
    @TestTag(name = "localized", value = "es_ES")
    public void resizeWidgetTo5x1Test() {

        DashboardPageBase dashboardPageBase = initPage(getDriver(), DashboardPageBase.class);

        DiaryPageBase diaryPageBase = (DiaryPageBase) dashboardPageBase.openPageFromDownMenuByName(DownMenuElement.DIARY);
        Assert.assertTrue(diaryPageBase.isPageOpened(), "[ DIARY PAGE ] Diary page is not opened!");
        diaryPageBase.deleteAllItems();

        dashboardPageBase = (DashboardPageBase) diaryPageBase.openPageFromDownMenuByName(DownMenuElement.DASHBOARD);
        dashboardPageBase.closeUserTutorialBoxIfPresent();
        Assert.assertTrue(dashboardPageBase.isPageOpened(), "[ DASHBOARD PAGE ] Dashboard page is not opened!");

        PhoneHomePageBase phoneHomePageBase = goHome();
        phoneHomePageBase.holdPhoneDesktop();

        PhoneWidgetPageBase phoneWidgetPageBase = phoneHomePageBase.tapWidgetButton();
        phoneHomePageBase = phoneWidgetPageBase.addWidgetToDesktop(APP_NAME, WIDGET_NAME);
        phoneHomePageBase.resizeWidgetFromTo(WidgetSize.SIZE_4X2, WidgetSize.SIZE_5X1);

        int foodCaloriesFromWidget = phoneHomePageBase.getCaloriesValueFromWidget(Calories.FOOD);
        int exerciseCaloriesFromWidget = phoneHomePageBase.getCaloriesValueFromWidget(Calories.EXERCISE);
        int caloriesRemainingFromWidget = phoneHomePageBase.getCaloriesValueFromWidget(Calories.CALS_REMAINING);

        dashboardPageBase = phoneHomePageBase.openAppFromWidget();

        SearchFoodPageBase searchFoodPageBase = dashboardPageBase.clickSearchForFoodContainer();
        Assert.assertTrue(searchFoodPageBase.isPageOpened(), "[ SEARCH FOOD PAGE ] Search Food page is not opened!");
        searchFoodPageBase.searchFood(FOOD.get(FOOD_MEAL_INDEX));
        searchFoodPageBase.addFoodToMealByName(FOOD.get(FOOD_MEAL_INDEX));
        dashboardPageBase = (DashboardPageBase) searchFoodPageBase.clickBackButton(ReturnPages.DASHBOARD);

        diaryPageBase = (DiaryPageBase) dashboardPageBase.openPageFromDownMenuByName(DownMenuElement.DIARY);
        Assert.assertTrue(diaryPageBase.isPageOpened(), "[ DIARY PAGE ] Diary page is not opened!");

        int foodCalories = diaryPageBase.getCaloriesFromCategory(Meals.BREAKFAST.getMeal());

        CardiovascularPageBase cardiovascularPageBase = (CardiovascularPageBase) diaryPageBase.clickAddExerciseButton(ExercisesType.CARDIOVASCULAR);
        NewCardioExercisePageBase newCardioExercisePage = cardiovascularPageBase.clickOnCreateExerciseButton();

        CardioExercise cardioExercise = CardioExerciseFactory.generateExercise();
        diaryPageBase = newCardioExercisePage.createAnExercise(cardioExercise);
        diaryPageBase.closeAdvertisingPopUpIfPresent();

        int exerciseCalories = diaryPageBase.getCaloriesFromCategory(EXERCISE_STRING);

        phoneHomePageBase = goHome();

        int actualFoodCaloriesFromWidget = phoneHomePageBase.getCaloriesValueFromWidget(Calories.FOOD);
        int actualExerciseCaloriesFromWidget = phoneHomePageBase.getCaloriesValueFromWidget(Calories.EXERCISE);
        int actualCaloriesRemainingFromWidget = phoneHomePageBase.getCaloriesValueFromWidget(Calories.CALS_REMAINING);

        int expectedFoodCaloriesFromWidget = foodCaloriesFromWidget + foodCalories;
        int expectedExerciseCaloriesFromWidget = exerciseCaloriesFromWidget + exerciseCalories;
        int expectedCaloriesRemainingFromWidget = caloriesRemainingFromWidget - expectedFoodCaloriesFromWidget + expectedExerciseCaloriesFromWidget;

        Assert.assertEquals(actualCaloriesRemainingFromWidget, expectedCaloriesRemainingFromWidget, "[ PHONE HOME PAGE ] Cals Remaining is not updated!");
        Assert.assertEquals(actualFoodCaloriesFromWidget, expectedFoodCaloriesFromWidget, "[ PHONE HOME PAGE ] Total food logged Value is not updated!");
        Assert.assertEquals(actualExerciseCaloriesFromWidget, expectedExerciseCaloriesFromWidget, "[ PHONE HOME PAGE ] Total exercise logged Value is not updated!");


    }


    @Test(groups = {"logout"})
    @MethodOwner(owner = "koval")
    @TestLabel(name = "feature", value = "l10n")
    @TestTag(name = "localized", value = "en_US")
    @TestTag(name = "localized", value = "es_ES")
    public void localizationTest() {

        DashboardPageBase dashboardPageBase = initPage(getDriver(), DashboardPageBase.class);

        DiaryPageBase diaryPageBase = (DiaryPageBase) dashboardPageBase.openPageFromDownMenuByName(DownMenuElement.DIARY);
        Assert.assertTrue(diaryPageBase.isPageOpened(), "[ DIARY PAGE ] Diary page is not opened!");

        L10N.assertAll();
    }


    @Test(groups = {"closeApp"})
    @MethodOwner(owner = "koval")
    @TestLabel(name = "feature", value = "l10n")
    @TestTag(name = "localized", value = "en_US")
    @TestTag(name = "localized", value = "es_ES")
    public void myFoodsListTest() {

        DashboardPageBase dashboardPageBase = initPage(getDriver(), DashboardPageBase.class);
        MePageBase mePageBase = dashboardPageBase.openMePage();
        mePageBase.openTabFromMenuByName(MePageMenuTab.MY_ITEMS);
        int expectedFoodValue = mePageBase.getItemValueByName(Items.FOODS) + 1;

        RecipesMealsFoodsPageBase recipesMealsFoodsPageBase = mePageBase.openItemByName(Items.FOODS);
        List<String> expectedListOfMyFoods = recipesMealsFoodsPageBase.getItemElementsToList();
        mePageBase = recipesMealsFoodsPageBase.clickBackButton();
        CreateFoodPageBase createFoodPageBase = (CreateFoodPageBase) mePageBase.clickCreateButtonByItemName(Items.FOODS);

        Food food = FoodFactory.generateFood();
        createFoodPageBase.createFood(food);
        expectedListOfMyFoods.add(0, food.getDescription());
        int actualFoodValue = mePageBase.getItemValueByName(Items.FOODS);
        LOGGER.info("Actual value of foods {}", actualFoodValue);
        LOGGER.info("Expected value of foods {}", expectedFoodValue);
        Assert.assertEquals(actualFoodValue, expectedFoodValue,
                "[ ME PAGE ] Actual value of foods is not what expected!");

        recipesMealsFoodsPageBase = mePageBase.openItemByName(Items.FOODS);
        List<String> actualListOfMyFoods = recipesMealsFoodsPageBase.getItemElementsToList();
        LOGGER.info("Actual list of foods {}", actualListOfMyFoods);
        LOGGER.info("Expected list of foods {}", expectedListOfMyFoods);
        Assert.assertEquals(actualListOfMyFoods, expectedListOfMyFoods,
                "[RECIPES, MEALS & FOODS PAGE] Actual list of foods is not what expected!");

        dashboardPageBase = login();

        DiaryPageBase diaryPageBase = (DiaryPageBase) dashboardPageBase.openPageFromDownMenuByName(DownMenuElement.DIARY);
        SearchFoodPageBase searchFoodPageBase = diaryPageBase.clickAddFoodButton(Meals.BREAKFAST);
        searchFoodPageBase.openTabByName(TabsFromSearchFoodPage.MY_FOODS);
        actualListOfMyFoods = searchFoodPageBase.getListOfFoodElementsToList(expectedFoodValue);
        LOGGER.info("Actual list of foods {}", actualListOfMyFoods);
        LOGGER.info("Expected list of foods {}", expectedListOfMyFoods);
        Assert.assertEquals(actualListOfMyFoods, expectedListOfMyFoods,
                "[RECIPES, MEALS & FOODS PAGE] Actual list of foods is not what expected!");

    }
}
