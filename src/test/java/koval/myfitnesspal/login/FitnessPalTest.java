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

        //    Assert.assertTrue(diaryPageBase.isAllFoodDeleted());

        AddFoodPageBase addFoodPageBase = diaryPageBase.clickAddFoodButton(Meals.BREAKFAST);
        Assert.assertTrue(addFoodPageBase.isPageOpened(Meals.BREAKFAST.getMeal()), "[ BREAKFAST PAGE ] Dinner page is not opened!");

        addFoodPageBase.addFoodToMealByName("bread");


        addFoodPageBase.changeMealByName(Meals.LUNCH);
        Assert.assertTrue(addFoodPageBase.isPageOpened(Meals.LUNCH.getMeal()), "[ LUNCH PAGE ] Breakfast page is not opened!");

        addFoodPageBase.addFoodToMealByName("apple");


        addFoodPageBase.changeMealByName(Meals.DINNER);
        Assert.assertTrue(addFoodPageBase.isPageOpened(Meals.DINNER.getMeal()), "[ DINNER PAGE ] Dinner page is not opened!");

        addFoodPageBase.addFoodToMealByName("milk");

        addFoodPageBase.changeMealByName(Meals.SNACKS);
        Assert.assertTrue(addFoodPageBase.isPageOpened(Meals.SNACKS.getMeal()), "[ SNACKS PAGE ] Dinner page is not opened!");

        addFoodPageBase.addFoodToMealByName("apple");





        diaryPageBase = addFoodPageBase.clickBackButton();

        Assert.assertTrue(diaryPageBase.isPageOpened(), "[ DIARY PAGE ] Diary page is not opened!");


        Assert.assertTrue(diaryPageBase.isFoodAddedToMealByName(Meals.SNACKS, "apple"));
        Assert.assertTrue(diaryPageBase.isFoodAddedToMealByName(Meals.DINNER, "milk"));
        Assert.assertTrue(diaryPageBase.isFoodAddedToMealByName(Meals.LUNCH, "apple"));
        Assert.assertTrue(diaryPageBase.isFoodAddedToMealByName(Meals.BREAKFAST, "bread"));

        diaryPageBase.deleteAllFood();

        //  Assert.assertTrue(diaryPageBase.isAllFoodDeleted());

    }

    @Test()
    @MethodOwner(owner = "koval")
    @TestLabel(name = "feature", value = {"mobile", "regression"})
    public void test() {

        DashboardPageBase dashboardPageBase = initPage(getDriver(), DashboardPageBase.class);
        dashboardPageBase.closeNoSubscriptionsPopUp();
        dashboardPageBase.closeUserTutorialBox();

        Assert.assertTrue(dashboardPageBase.isPageOpened(), "[ DASHBOARD PAGE ] Dashboard page is not opened!");

        DiaryPageBase diaryPageBase = (DiaryPageBase) dashboardPageBase.openPageFromDownMenuByName(DownMenuElement.DIARY);
        Assert.assertTrue(diaryPageBase.isPageOpened(), "[ DIARY PAGE ] Diary page is not opened!");


        diaryPageBase.deleteAllFood();

        //    Assert.assertTrue(diaryPageBase.isAllFoodDeleted());



        AddFoodPageBase addFoodPageBase = diaryPageBase.clickAddFoodButton(Meals.LUNCH);
        // addFoodPageBase.changeMealByName(Meals.LUNCH);
        Assert.assertTrue(addFoodPageBase.isPageOpened(Meals.LUNCH.getMeal()), "[ LUNCH PAGE ] Breakfast page is not opened!");

        addFoodPageBase.addFoodToMealByName("apple");


        addFoodPageBase.changeMealByName(Meals.DINNER);
        Assert.assertTrue(addFoodPageBase.isPageOpened(Meals.DINNER.getMeal()), "[ DINNER PAGE ] Dinner page is not opened!");

        addFoodPageBase.addFoodToMealByName("milk");

        addFoodPageBase.changeMealByName(Meals.SNACKS);
        Assert.assertTrue(addFoodPageBase.isPageOpened(Meals.SNACKS.getMeal()), "[ SNACKS PAGE ] Dinner page is not opened!");

        addFoodPageBase.addFoodToMealByName("apple");


        addFoodPageBase.changeMealByName(Meals.BREAKFAST);
        Assert.assertTrue(addFoodPageBase.isPageOpened(Meals.BREAKFAST.getMeal()), "[ BREAKFAST PAGE ] Dinner page is not opened!");

        addFoodPageBase.addFoodToMealByName("bread");


        diaryPageBase = addFoodPageBase.clickBackButton();

        Assert.assertTrue(diaryPageBase.isPageOpened(), "[ DIARY PAGE ] Diary page is not opened!");

        Assert.assertTrue(diaryPageBase.isFoodAddedToMealByName(Meals.BREAKFAST, "bread"));
        // Assert.assertTrue(diaryPageBase.isFoodAddedToMealByName(Meals.LUNCH, "apple"));
        Assert.assertTrue(diaryPageBase.isFoodAddedToMealByName(Meals.DINNER, "milk"));
        Assert.assertTrue(diaryPageBase.isFoodAddedToMealByName(Meals.SNACKS, "apple"));


        diaryPageBase.deleteAllFood();

        //  Assert.assertTrue(diaryPageBase.isAllFoodDeleted());

    }

}
