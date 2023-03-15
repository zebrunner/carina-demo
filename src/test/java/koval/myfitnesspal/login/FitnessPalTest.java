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

        for (Meals meals : Meals.values()) {
            Assert.assertTrue(diaryPageBase.isAllFoodDeleted(meals));
        }

        AddFoodPageBase addFoodPageBase = diaryPageBase.clickAddFoodButton(Meals.BREAKFAST);
        Assert.assertTrue(addFoodPageBase.isPageOpened(Meals.BREAKFAST.getMeal()), "[ BREAKFAST PAGE ] Breakfast page is not opened!");

        addFoodPageBase.addFoodToMealByName("apple");


        diaryPageBase = addFoodPageBase.clickBackButton();
        Assert.assertTrue(diaryPageBase.isFoodAddedToMeal("apple", Meals.BREAKFAST));


        addFoodPageBase = diaryPageBase.clickAddFoodButton(Meals.LUNCH);
        Assert.assertTrue(addFoodPageBase.isPageOpened(Meals.LUNCH.getMeal()), "[ LUNCH PAGE ] LUNCH page is not opened!");

        addFoodPageBase.addFoodToMealByName("bread");


        diaryPageBase = addFoodPageBase.clickBackButton();
        Assert.assertTrue(diaryPageBase.isFoodAddedToMeal("bread", Meals.LUNCH));

        addFoodPageBase = diaryPageBase.clickAddFoodButton(Meals.DINNER);
        Assert.assertTrue(addFoodPageBase.isPageOpened(Meals.DINNER.getMeal()), "[ DINNER PAGE ] Dinner page is not opened!");

        addFoodPageBase.addFoodToMealByName("milk");


        diaryPageBase = addFoodPageBase.clickBackButton();
        Assert.assertTrue(diaryPageBase.isFoodAddedToMeal("milk", Meals.DINNER));

        addFoodPageBase = diaryPageBase.clickAddFoodButton(Meals.SNACKS);
        Assert.assertTrue(addFoodPageBase.isPageOpened(Meals.SNACKS.getMeal()), "[ SNACKS PAGE ] Snacks page is not opened!");

        addFoodPageBase.addFoodToMealByName("water");


        diaryPageBase = addFoodPageBase.clickBackButton();
        Assert.assertTrue(diaryPageBase.isFoodAddedToMeal("water", Meals.SNACKS));


        diaryPageBase.deleteAllFood();

        for (Meals meals : Meals.values()) {
            Assert.assertTrue(diaryPageBase.isAllFoodDeleted(meals));
        }


    }


}
