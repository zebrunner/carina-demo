package koval.web;

import com.zebrunner.agent.core.annotation.TestLabel;
import com.zebrunner.carina.core.registrar.ownership.MethodOwner;
import com.zebrunner.carina.utils.R;
import koval.web.myfitnesspal.pages.IMyInterface;
import koval.web.myfitnesspal.pages.MyAbstractPage;
import koval.web.myfitnesspal.pages.firstPages.LoginPage;
import koval.web.myfitnesspal.pages.firstPages.WelcomePage;
import koval.web.myfitnesspal.pages.menuPages.foodMenu.foodDiaryPages.AddFoodPage;
import koval.web.myfitnesspal.pages.menuPages.foodMenu.foodDiaryPages.FoodDiaryPage;
import koval.web.myfitnesspal.pages.menuPages.mainMenu.FoodPage;
import koval.web.myfitnesspal.pages.menuPages.mainMenu.HomePage;
import koval.web.myfitnesspal.service.enums.FoodMenu;
import koval.web.myfitnesspal.service.enums.MainMenu;
import koval.web.myfitnesspal.service.enums.Meals;
import koval.web.myfitnesspal.service.factories.foodFactory.Food;
import koval.web.myfitnesspal.service.factories.foodFactory.FoodFactory;
import org.testng.Assert;
import org.testng.annotations.*;

import static koval.web.myfitnesspal.utils.CookieUtils.refreshPage;


public class MyFitnessPalWebTest implements IMyInterface {

    WelcomePage welcomePage = new WelcomePage(getDriver());
    MyAbstractPage myAbstractPage = new MyAbstractPage(getDriver());
    @BeforeTest()
    public void setUpDriver() {
        startDriver();
    }

    @BeforeMethod()
    public void login() throws InterruptedException {

        refreshPage(getDriver());
        myAbstractPage.acceptCookies();

        LoginPage loginPage = welcomePage.clickLogInButton();
        loginPage.typeMail(R.TESTDATA.get("fitnessPal_mail"));
        loginPage.typePassword(R.TESTDATA.get("fitnessPal_password"));
        HomePage homePage = loginPage.clickLogInButton();
        Assert.assertTrue(homePage.isPageOpened(), "[ HOME PAGE ] Home Page is not opened!");

    }


    @Test()
    @MethodOwner(owner = "dkoval")
    @TestLabel(name = "feature", value = {"web", "regression"})
    public void openWelcomePageTest() {
        Assert.assertTrue(welcomePage.isPageOpened(), "[ WELCOME PAGE ] Welcome page is not opened");
    }


    @Test()
    @MethodOwner(owner = "dkoval")
    @TestLabel(name = "feature", value = {"web", "regression"})
    public void addFoodTest() {

        HomePage homePage = new HomePage(getDriver());
        FoodPage foodPage = (FoodPage) homePage.getMainMenu().openPageFromMenu(MainMenu.FOOD);
        FoodDiaryPage foodDiaryPage = (FoodDiaryPage) foodPage.getFoodMenu().openPageFromSubMenu(FoodMenu.FOOD_DIARY);
        foodDiaryPage.deleteAllFood();

        for (Meals meals : Meals.values()) {
            AddFoodPage addFoodPage = foodDiaryPage.addFoodToMeal(meals);
            Assert.assertTrue(addFoodPage.isPageOpened(meals), "[ ADD FOOD PAGE ] Add Food Page is not opened!");

            Food food = FoodFactory.generateFood();
            addFoodPage.searchForFood(food);
            foodDiaryPage = addFoodPage.addFoundFood();
            Assert.assertTrue(foodDiaryPage.isFoodAdded(meals, food), String.format("[ FOOD DIARY ] Food '%s' is not added", food.getFoodName()));
        }
    }


    @AfterMethod
    public void openWelcomePage() {
        quitDriver();
    }

}
