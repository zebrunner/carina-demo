package koval.mobile.myfitnesspal.gui.android.actions.addFood.tabsCreatePages.myFoods;


import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.utils.factory.DeviceType;
import koval.mobile.myfitnesspal.gui.common.downMenuPages.DiaryPageBase;
import koval.mobile.myfitnesspal.gui.common.actions.addFood.tabsCreatePages.myFoods.CreateFoodPageBase;
import koval.mobile.myfitnesspal.service.factories.foodFactory.Food;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;


@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = CreateFoodPageBase.class)
public class CreateFoodPage extends CreateFoodPageBase {

    @FindBy(id = "com.myfitnesspal.android:id/editTxtBrandName")
    private ExtendedWebElement brandNameTextBox;

    @FindBy(id = "com.myfitnesspal.android:id/editTxtDescription")
    private ExtendedWebElement descriptionTextBox;


    @FindBy(id = "com.myfitnesspal.android:id/editTxtServingSizeQuantity")
    private ExtendedWebElement servingSizeTextBox;

    @FindBy(id = "com.myfitnesspal.android:id/servingSizeAutoTxt")
    private ExtendedWebElement servingSizeQuantityTextBox;

    @FindBy(id = "com.myfitnesspal.android:id/editTxtServingsPerContainer")
    private ExtendedWebElement servingsPerContainerTextBox;

    @FindBy(id = "com.myfitnesspal.android:id/editTxtCalories")
    private ExtendedWebElement caloriesTextBox;


    public CreateFoodPage(WebDriver driver) {
        super(driver);
    }


    @Override
    public DiaryPageBase createFood(Food food) {

        brandNameTextBox.type(food.getBrandName(), TIMEOUT_FIVE);
        descriptionTextBox.type(food.getDescription(), TIMEOUT_FIVE);
        servingSizeTextBox.type(String.valueOf(food.getServingsSize()), TIMEOUT_FIVE);
        servingSizeQuantityTextBox.type(food.getServingsSizeQuantity(), TIMEOUT_FIVE);
        servingsPerContainerTextBox.type(String.valueOf(food.getServingsPerContainer()), TIMEOUT_FIVE);

        itemByText.format(NEXT).click(TIMEOUT_TEN);

        caloriesTextBox.type(String.valueOf(food.getCalories()), TIMEOUT_TEN);

        int attemp = 3;
        while (itemByText.format(SAVE).isElementPresent(TIMEOUT_FIVE) && attemp > 0) {
            itemByText.format(SAVE).click(TIMEOUT_TEN);

            LOGGER.info("[ CREATE FOOD PAGE ] Attempt: {} for clicking on SAVE button", attemp);
            attemp--;
        }

        itemByText.format(NO_THANKS_ANSWER).clickIfPresent(TIMEOUT_FIVE);
        return initPage(getDriver(), DiaryPageBase.class);
    }

}
