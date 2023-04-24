package koval.mobile.myfitnesspal.gui.android.downMenuPages.diaryPage.addFood.tabsCreatePages.myMeals;


import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.utils.factory.DeviceType;
import koval.mobile.myfitnesspal.gui.common.downMenuPages.diaryPageBase.addFood.SearchFoodPageBase;
import koval.mobile.myfitnesspal.gui.common.downMenuPages.diaryPageBase.addFood.tabsCreatePages.myMeals.CreateMealPageBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;


@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = CreateMealPageBase.class)
public class CreateMealPage extends CreateMealPageBase {

    @FindBy(xpath = "//*[@text='%s']")
    private ExtendedWebElement itemByText;

    @FindBy(id = "com.myfitnesspal.android:id/fab_action_plus")
    private ExtendedWebElement actionPlusButton;

    @FindBy(id = "com.myfitnesspal.android:id/input_meal_name")
    private ExtendedWebElement mealNameTextBox;

    public CreateMealPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isPageOpened() {
        return itemByText.format(CREATE_MEAL).isElementPresent(TIMEOUT_FIVE);
    }


    @Override
    public SearchFoodPageBase createMeal(String mealName) {

        mealNameTextBox.type(mealName, TIMEOUT_FIVE);

        hideKeyboard();

        actionPlusButton.click();

        return initPage(getDriver(), SearchFoodPageBase.class);
    }


    @Override
    public SearchFoodPageBase clickSaveButton() {

        itemByText.format(SAVE).click();

        return initPage(getDriver(), SearchFoodPageBase.class);
    }


}
