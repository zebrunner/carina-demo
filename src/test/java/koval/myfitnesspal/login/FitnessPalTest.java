package koval.myfitnesspal.login;

import com.zebrunner.agent.core.annotation.TestLabel;
import com.zebrunner.carina.core.registrar.ownership.MethodOwner;

import koval.mobile.myfitnesspal.gui.common.AddFoodPageBase;
import koval.mobile.myfitnesspal.gui.common.downMenuPages.DashboardPageBase;
import koval.mobile.myfitnesspal.gui.common.downMenuPages.DiaryPageBase;
import koval.mobile.myfitnesspal.service.enums.DownMenuElement;
import koval.mobile.myfitnesspal.service.enums.Meals;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.lang.invoke.MethodHandles;


public class FitnessPalTest extends LoginTest {

    private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());


    @Test()
    @MethodOwner(owner = "koval")
    @TestLabel(name = "feature", value = {"mobile", "regression"})
    public void loginSimpleUserTest() {

        DashboardPageBase dashboardPageBase = initPage(getDriver(), DashboardPageBase.class);
        dashboardPageBase.closeNoSubscriptionsPopUp();
        dashboardPageBase.closeUserTutorialBox();

        Assert.assertTrue(dashboardPageBase.isPageOpened(), "[ DASHBOARD PAGE ] Dashboard page is not opened!");

        Assert.assertFalse(dashboardPageBase.isUserPremium(), "[ DASHBOARD PAGE ] User is premium!");
    }


    @Test()
    @MethodOwner(owner = "koval")
    @TestLabel(name = "feature", value = {"mobile", "regression"})
    public void addFoodTest() {

        DashboardPageBase dashboardPageBase = initPage(getDriver(), DashboardPageBase.class);

        dashboardPageBase.closeNoSubscriptionsPopUp();
        dashboardPageBase.closeUserTutorialBox();

        Assert.assertTrue(dashboardPageBase.isPageOpened(), "[ DASHBOARD PAGE ] Dashboard page is not opened!");


        DiaryPageBase diaryPageBase = (DiaryPageBase) dashboardPageBase.openPageFromDownMenuByName(DownMenuElement.DIARY);
        Assert.assertTrue(diaryPageBase.isPageOpened(), "[ DIARY PAGE ] Diary page is not opened!");

        diaryPageBase.deleteAllFood();
        diaryPageBase.closePromoMessages();


        String[] food = {"apple", "milk", "bread", "cherry"};
        Meals[] mealsArr = Meals.values();

        for (int i = 0; i < Meals.values().length; i++) {

            AddFoodPageBase addFoodPageBase = diaryPageBase.clickAddFoodButton(mealsArr[i]);
            Assert.assertTrue(addFoodPageBase.isPageOpened(mealsArr[i].getMeal()), String.format("[ '%s' PAGE ] '%s' page is not opened!",
                    mealsArr[i].getMeal().toUpperCase(), mealsArr[i].getMeal()));

            addFoodPageBase.addFoodToMealByName(food[i]);

            diaryPageBase = addFoodPageBase.clickBackButton();
            Assert.assertTrue(diaryPageBase.isFoodAddedToMeal(food[i], mealsArr[i]), String.format("[ DIARY PAGE ] Food '%s' is not deleted! Meal: '%s'",
                    food[i], mealsArr[i]));
        }


    }


    @Test()
    @MethodOwner(owner = "koval")
    @TestLabel(name = "feature", value = {"mobile", "regression"})
    public void deleteFoodTest() {

        DashboardPageBase dashboardPageBase = initPage(getDriver(), DashboardPageBase.class);

        dashboardPageBase.closeNoSubscriptionsPopUp();
        dashboardPageBase.closeUserTutorialBox();

        Assert.assertTrue(dashboardPageBase.isPageOpened(), "[ DASHBOARD PAGE ] Dashboard page is not opened!");


        DiaryPageBase diaryPageBase = (DiaryPageBase) dashboardPageBase.openPageFromDownMenuByName(DownMenuElement.DIARY);
        Assert.assertTrue(diaryPageBase.isPageOpened(), "[ DIARY PAGE ] Diary page is not opened!");


        diaryPageBase.deleteAllFood();
        diaryPageBase.closePromoMessages();

        for (Meals meals : Meals.values()) {
            Assert.assertTrue(diaryPageBase.isAllFoodDeleted(meals), String.format("[ DIARY PAGE ] Food is not deleted! Meal: '%s'",
                    meals));

    }


    }
}
