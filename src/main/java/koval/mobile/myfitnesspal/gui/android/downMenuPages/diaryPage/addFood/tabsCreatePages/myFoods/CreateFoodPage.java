package koval.mobile.myfitnesspal.gui.android.downMenuPages.diaryPage.addFood.tabsCreatePages.myFoods;


import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.utils.factory.DeviceType;
import koval.mobile.myfitnesspal.gui.common.downMenuPages.diaryPageBase.DiaryPageBase;
import koval.mobile.myfitnesspal.gui.common.downMenuPages.diaryPageBase.addFood.tabsCreatePages.myFoods.CreateFoodPageBase;
import koval.mobile.myfitnesspal.service.factories.foodFactory.Food;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.invoke.MethodHandles;


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

    private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());


    public CreateFoodPage(WebDriver driver) {
        super(driver);
    }


    @Override
    public boolean isPageOpened() {
        return itemByText.format(CREATE_FOOD_TITLE).isElementPresent(TIMEOUT_FIVE);
    }


    @Override
    public DiaryPageBase createFood(Food food) {

        brandNameTextBox.type(food.getBrandName(), TIMEOUT_FIVE);
        descriptionTextBox.type(food.getDescription(), TIMEOUT_FIVE);
        servingSizeTextBox.type(String.valueOf(food.getServingsSize()), TIMEOUT_FIVE);
        servingSizeQuantityTextBox.type(food.getServingsSizeQuantity(), TIMEOUT_FIVE);
        servingsPerContainerTextBox.type(String.valueOf(food.getServingsPerContainer()), TIMEOUT_FIVE);

        itemByText.format(NEXT).click();

        caloriesTextBox.type(String.valueOf(food.getCalories()), TIMEOUT_TEN);

        int attemp = 3;
        while (itemByText.format(SAVE).isElementPresent(TIMEOUT_FIVE) && attemp > 0) {
            itemByText.format(SAVE).click();

            LOGGER.info("[ CREATE FOOD PAGE ] Attempt: {} for clicking on SAVE button", attemp);
            attemp--;
        }

        itemByText.format(NO_THANKS_ANSWER).clickIfPresent(TIMEOUT_FIVE);
        return initPage(getDriver(), DiaryPageBase.class);
    }

}
