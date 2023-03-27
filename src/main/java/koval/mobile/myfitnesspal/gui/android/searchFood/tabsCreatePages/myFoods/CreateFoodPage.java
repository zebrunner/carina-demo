package koval.mobile.myfitnesspal.gui.android.searchFood.tabsCreatePages.myFoods;


import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.utils.factory.DeviceType;
import koval.mobile.myfitnesspal.gui.common.downMenuPages.DiaryPageBase;
import koval.mobile.myfitnesspal.gui.common.searchFood.tabsCreatePages.myFoods.CreateFoodPageBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;


@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = CreateFoodPageBase.class)
public class CreateFoodPage extends CreateFoodPageBase {


    @FindBy(xpath = "//*[@text='%s']")
    private ExtendedWebElement itemByText;

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
    public boolean isPageOpened() {
        return itemByText.format(CREATE_FOOD_TITLE).isElementPresent(TIMEOUT_FIVE);
    }

    @Override
    public DiaryPageBase createFood(String brandName, String description, int servingsSize, String servingsSizeQuantity, int servingsPerContainer, int calories) {

        brandNameTextBox.type(brandName, TIMEOUT_FIVE);
        descriptionTextBox.type(description, TIMEOUT_FIVE);
        servingSizeTextBox.type(String.valueOf(servingsSize), TIMEOUT_FIVE);
        servingSizeQuantityTextBox.type(servingsSizeQuantity, TIMEOUT_FIVE);
        servingsPerContainerTextBox.type(String.valueOf(servingsPerContainer), TIMEOUT_FIVE);

        itemByText.format(NEXT).click();

        caloriesTextBox.type(String.valueOf(calories), TIMEOUT_TEN);

        while (itemByText.format(SAVE).isElementPresent(TIMEOUT_FIVE)) {
            itemByText.format(SAVE).click();
        }

        itemByText.format(NO_THANKS_ANSWER).clickIfPresent(TIMEOUT_FIVE);
        return initPage(getDriver(), DiaryPageBase.class);
    }

}
