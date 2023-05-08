package koval.mobile.myfitnesspal.gui.android.actions.addFood.tabsCreatePages.myMeals;


import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.utils.factory.DeviceType;
import koval.mobile.myfitnesspal.gui.common.actions.addFood.SearchFoodPageBase;
import koval.mobile.myfitnesspal.gui.common.actions.addFood.tabsCreatePages.myMeals.CreateMealPageBase;
import koval.mobile.myfitnesspal.service.enums.ActionsFromTabsSearchFood;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;


@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = CreateMealPageBase.class)
public class CreateMealPage extends CreateMealPageBase {

    @FindBy(id = "com.myfitnesspal.android:id/fab_action_plus")
    private ExtendedWebElement actionPlusButton;

    @FindBy(id = "com.myfitnesspal.android:id/input_meal_name")
    private ExtendedWebElement mealNameTextBox;

    public CreateMealPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isPageOpened() {
        return itemByText.format(ActionsFromTabsSearchFood.CREATE_A_MEAL.getPageName()).isElementPresent(TIMEOUT_FIVE);
    }


    @Override
    public SearchFoodPageBase createMeal(String mealName) {

        mealNameTextBox.type(mealName, TIMEOUT_FIVE);

        hideKeyboard();

        actionPlusButton.click(TIMEOUT_TEN);

        return initPage(getDriver(), SearchFoodPageBase.class);
    }


    @Override
    public SearchFoodPageBase clickSaveButton() {

        itemByText.format(SAVE).click(TIMEOUT_TEN);

        return initPage(getDriver(), SearchFoodPageBase.class);
    }


}
