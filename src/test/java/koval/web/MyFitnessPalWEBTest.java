package koval.web;

import com.zebrunner.agent.core.annotation.TestLabel;
import com.zebrunner.carina.core.registrar.ownership.MethodOwner;
import com.zebrunner.carina.utils.R;
import koval.web.myfitnesspal.pages.IMyInterface;
import koval.web.myfitnesspal.pages.MyAbstractPage;
import koval.web.myfitnesspal.pages.firstPages.LoginPage;
import koval.web.myfitnesspal.pages.firstPages.WelcomePage;
import koval.web.myfitnesspal.pages.menuPages.mainMenu.exerciseMenu.ExerciseDiary;
import koval.web.myfitnesspal.pages.menuPages.mainMenu.exerciseMenu.myExercise.CreateExercise;
import koval.web.myfitnesspal.pages.menuPages.mainMenu.exerciseMenu.myExercise.MyExercises;
import koval.web.myfitnesspal.pages.menuPages.mainMenu.foodMenu.myFoods.MyFoodsPage;
import koval.web.myfitnesspal.pages.menuPages.mainMenu.foodMenu.foodDiaryPages.AddFoodPage;
import koval.web.myfitnesspal.pages.menuPages.mainMenu.foodMenu.foodDiaryPages.FoodDiaryPage;
import koval.web.myfitnesspal.pages.menuPages.mainMenu.foodMenu.myFoods.NutritionalInformationPage;
import koval.web.myfitnesspal.pages.menuPages.mainMenu.foodMenu.myFoods.SubmitNewFood;
import koval.web.myfitnesspal.pages.menuPages.mainMenu.myhomeMenu.HomePage;
import koval.web.myfitnesspal.service.enums.menus.ExerciseMenu;
import koval.web.myfitnesspal.service.enums.menus.FoodMenu;
import koval.web.myfitnesspal.service.enums.menus.MainMenu;
import koval.web.myfitnesspal.service.enums.Meals;
import koval.web.myfitnesspal.service.factories.exerciseFactory.Exercise;
import koval.web.myfitnesspal.service.factories.exerciseFactory.ExerciseFactory;
import koval.web.myfitnesspal.service.factories.foodFactory.Food;
import koval.web.myfitnesspal.service.factories.foodFactory.FoodFactory;
import org.testng.Assert;
import org.testng.annotations.*;

import java.lang.reflect.InvocationTargetException;

import static koval.web.myfitnesspal.utils.IConstantUtils.TIMEOUT_TWENTY_FIVE;


public class MyFitnessPalWEBTest implements IMyInterface {


    MyAbstractPage myAbstractPage = new MyAbstractPage(getDriver());

    WelcomePage welcomePage = new WelcomePage(getDriver());

    @BeforeTest()
    public void setUpDriver() {
        welcomePage.open();
        myAbstractPage.acceptCookies();
        welcomePage.clickLogInButton();
    }


    @BeforeMethod()
    public void login() throws InterruptedException {
        LoginPage loginPage = new LoginPage(getDriver());
        loginPage.openURL(R.CONFIG.get("url") + "account/login", TIMEOUT_TWENTY_FIVE);

        loginPage.typeMail(R.TESTDATA.get("fitnessPal_mail"));
        loginPage.typePassword(R.TESTDATA.get("fitnessPal_password"));
        HomePage homePage = loginPage.clickLogInButton();
        //loginPage.captchaReLogin();
        Assert.assertTrue(homePage.isPageOpened(), "[ HOME PAGE ] Home Page is not opened!");

    }


    @Test()
    @MethodOwner(owner = "dkoval")
    @TestLabel(name = "feature", value = {"web", "regression"})
    public void addFoodTest() throws InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {

        HomePage homePage = new HomePage(getDriver());
        FoodDiaryPage foodDiaryPage = (FoodDiaryPage) homePage.getMainMenu().openPageFromMenu(MainMenu.FOOD);
        foodDiaryPage.deleteAllFood();

        for (Meals meals : Meals.values()) {
            AddFoodPage addFoodPage = foodDiaryPage.clickOnAddFoodButton(meals);
            Assert.assertTrue(addFoodPage.isPageOpened(meals), "[ ADD FOOD PAGE ] Add Food Page is not opened!");

            Food food = FoodFactory.generateFood();
            addFoodPage.searchForFood(food);
            foodDiaryPage = addFoodPage.addFoundFood();
            Assert.assertTrue(foodDiaryPage.isFoodAdded(meals, food), String.format("[ FOOD DIARY ] Food '%s' is not added", food.getFoodDescription()));

        }
    }

    @Test()
    @MethodOwner(owner = "dkoval")
    @TestLabel(name = "feature", value = {"web", "regression"})
    public void addCreateOwnFood() throws InvocationTargetException, InstantiationException, IllegalAccessException, NoSuchMethodException {

        HomePage homePage = new HomePage(getDriver());
        FoodDiaryPage foodDiaryPage = (FoodDiaryPage) homePage.getMainMenu().openPageFromMenu(MainMenu.FOOD);
        MyFoodsPage myFoodsPage = (MyFoodsPage) foodDiaryPage.getSubMenu().openPageFromSubMenu(FoodMenu.MY_FOODS);
        myFoodsPage.deleteAllFoodButton();
        SubmitNewFood submitNewFood = myFoodsPage.clickOnCreateButton();
        Food food = FoodFactory.generateFood();
        submitNewFood.typeDescription(food);
        NutritionalInformationPage nutritionalInformationPage = submitNewFood.clickOnContinueButton();
        nutritionalInformationPage.typeServingsPerContainer(food);
        nutritionalInformationPage.typeServingSize(food);
        foodDiaryPage = nutritionalInformationPage.clickOnSaveButton();
        foodDiaryPage.deleteAllFood();


        myFoodsPage = (MyFoodsPage) foodDiaryPage.getSubMenu().openPageFromSubMenu(FoodMenu.MY_FOODS);
        Assert.assertTrue(myFoodsPage.isCreatedFoodAdded(food), String.format("[ MY FOODS PAGE ] Created food '%s' was not added!", food.getFoodDescription()));

        foodDiaryPage = (FoodDiaryPage) myFoodsPage.getSubMenu().openPageFromSubMenu(FoodMenu.FOOD_DIARY);
        AddFoodPage addFoodPage = foodDiaryPage.clickOnAddFoodButton(Meals.BREAKFAST);
        addFoodPage.searchForFood(food);
        foodDiaryPage = addFoodPage.addFoundFood();
        Assert.assertTrue(foodDiaryPage.isFoodAdded(Meals.BREAKFAST, food), String.format("[ FOOD DIARY ] Food '%s' is not added", food.getFoodDescription()));

    }

    @Test()
    @MethodOwner(owner = "dkoval")
    @TestLabel(name = "feature", value = {"web", "regression"})
    public void addExerciseTest() throws InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        HomePage homePage = new HomePage(getDriver());
        ExerciseDiary exerciseDiary = (ExerciseDiary) homePage.getMainMenu().openPageFromMenu(MainMenu.EXERCISE);
        exerciseDiary.deleteAllExercises();

        MyExercises myExercises = (MyExercises) exerciseDiary.getSubMenu().openPageFromSubMenu(ExerciseMenu.MY_EXERCISES);
        CreateExercise createExercise = myExercises.clickOnCreateExerciseButton();
        Exercise exercise = ExerciseFactory.generateExercise();
        exerciseDiary = createExercise.createExercise(exercise);
        Assert.assertTrue(exerciseDiary.isExerciseAdded(exercise), "[ EXERCISE DIARY ] Exercise was not added!");
    }

}
