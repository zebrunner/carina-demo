package koval.mobile.myfitnesspal.gui.android.downMenuPages;


import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.foundation.webdriver.decorator.annotations.Localized;
import com.qaprosoft.carina.core.gui.AbstractPage;
import com.zebrunner.carina.utils.factory.DeviceType;
import koval.mobile.myfitnesspal.gui.android.modal.DownMenuModal;
import koval.mobile.myfitnesspal.gui.common.actions.addFood.SearchFoodPageBase;
import koval.mobile.myfitnesspal.gui.common.downMenuPages.DiaryPageBase;
import koval.mobile.myfitnesspal.service.enums.DownMenuElement;
import koval.mobile.myfitnesspal.service.enums.ExercisesType;
import koval.mobile.myfitnesspal.service.enums.Meals;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = DiaryPageBase.class)
public class DiaryPage extends DiaryPageBase {


    @FindBy(id = "com.myfitnesspal.android:id/toolbar")
    private ExtendedWebElement upperToolbar;

    @FindBy(id = "com.myfitnesspal.android:id/bottomNavigationBar")
    private DownMenuModal downMenuModal;

    @Localized
    @FindBy(xpath = "//*[@content-desc='MainActivity']/android.widget.LinearLayout//android.widget.TextView")
    private ExtendedWebElement title;

    @FindBy(xpath = "//*[@resource-id='com.myfitnesspal.android:id/content_container']/child::*[@text='%s']")
    private ExtendedWebElement mealTitleByText;

    @FindBy(id = "com.myfitnesspal.android:id/edit_action_item")
    private ExtendedWebElement editActionPenButton;

    @FindBy(id = "com.myfitnesspal.android:id/select_all")
    private ExtendedWebElement selectAllCheckBox;

    /*main delete button*/
    @FindBy(xpath = "//android.widget.Button[@content-desc='{L10N:delete}']")
    private ExtendedWebElement deleteFoodButton;

    /*deletePopUpMessage - confirm deleting*/
    @FindBy(xpath = "//android.widget.Button[@text='{L10N:delete}']")
    private ExtendedWebElement deleteTextButton;

    @FindBy(id = "com.myfitnesspal.android:id/parentPanel")
    private ExtendedWebElement deletePopUpMessage;

    @FindBy(id = "com.myfitnesspal.android:id/imagePromoClose")
    private ExtendedWebElement closePromoImageButton;

    @FindBy(id = "com.myfitnesspal.android:id/promo_dismiss")
    private ExtendedWebElement promoDismissButton;

    @FindBy(id = "com.myfitnesspal.android:id/diary_recycler_view")
    private ExtendedWebElement diaryRecyclerViewContainer;

    @FindBy(xpath = "//*[@resource-id='com.myfitnesspal.android:id/txtSectionHeader' and @text='%s']//following-sibling::*[@resource-id = 'com.myfitnesspal.android:id/txtSectionCalories']")
    private ExtendedWebElement sectionCaloriesField;

    @FindBy(xpath = "//*[@resource-id='com.myfitnesspal.android:id/txtSectionHeader' and @text='%s']/parent::*/parent::*/following-sibling::*//*[@resource-id='com.myfitnesspal.android:id/footer_container']//*[@resource-id='com.myfitnesspal.android:id/add_food']")
    private ExtendedWebElement addFoodButton;

    @FindBy(xpath = "//*[@resource-id='com.myfitnesspal.android:id/txtSectionHeader' and @text='{L10N:exercise}']/parent::*/parent::*/following-sibling::*//*[@resource-id='com.myfitnesspal.android:id/footer_container']//*[@resource-id='com.myfitnesspal.android:id/add_food' and @text='{L10N:add_exercise_caps}']")
    private ExtendedWebElement addExerciseButton;

    @FindBy(xpath = "//*[@resource-id=\"com.myfitnesspal.android:id/txtSectionHeader\" and @text='%s']/parent::*/parent::*/following-sibling::*//*[@resource-id=\"com.myfitnesspal.android:id/txtItemDescription\" and contains(@text,'%s')]")
    private ExtendedWebElement itemByNameTitle;

    public DiaryPage(WebDriver driver) {
        super(driver);
    }


    @Override
    public AbstractPage openPageFromDownMenuByName(DownMenuElement downMenuElement) {

        return downMenuModal.openPageByName(downMenuElement);
    }

    @Override
    public boolean isPageOpened() {
        swipe(upperToolbar, diaryRecyclerViewContainer, Direction.DOWN, TWENTY_COUNT, MEDIUM_SPEED);
        return isPageOpened(title, DownMenuElement.DIARY.getPageName());
    }

    @Override
    public SearchFoodPageBase clickAddFoodButton(Meals meals) {

        ExtendedWebElement testEl = addFoodButton.format(meals.getMeal());
        swipe(testEl, Direction.UP, TWENTY_COUNT, MEDIUM_SPEED);

        if (meals.getMeal().equals(Meals.SNACKS.getMeal())) {
            ExtendedWebElement snackTitleByText = itemByText.format(CONNECT_A_STEP_TRACKER);
            swipe(snackTitleByText, Direction.UP, TWENTY_COUNT, MEDIUM_SPEED);
        }

        addFoodButton.format(meals.getMeal()).click();

        return initPage(getDriver(), SearchFoodPageBase.class);
    }


    @Override
    public boolean isExerciseAdded() {
        return itemByNameTitle.format(EXERCISE_STRING, GYM_WORKOUT).isElementPresent(TIMEOUT_TEN);
    }

    @Override
    public boolean isFoodAddedToMeal(String food, Meals meals) {

        boolean isFoodAddedToMeal;

        if (meals.getMeal().equals(Meals.SNACKS.getMeal())) {
            ExtendedWebElement snackTitleByText = itemByText.format(CONNECT_A_STEP_TRACKER);
            swipe(snackTitleByText, Direction.DOWN, TWENTY_COUNT, MEDIUM_SPEED);
            isFoodAddedToMeal = itemByNameTitle.format(meals.getMeal(), food).isElementPresent(TIMEOUT_TEN);
        } else {
            ExtendedWebElement mealByText = mealTitleByText.format(meals.getMeal());
            swipe(mealByText, diaryRecyclerViewContainer, Direction.DOWN, TWENTY_COUNT, MEDIUM_SPEED);
            isFoodAddedToMeal = itemByNameTitle.format(meals.getMeal(), food).isElementPresent(TIMEOUT_TEN);
        }


        return isFoodAddedToMeal;
    }


    @Override
    public SearchFoodPageBase closePromoMessagesIfPresent() {

        promoDismissButton.clickIfPresent(TIMEOUT_FIVE);

        closePromoImageButton.clickIfPresent(TIMEOUT_FIVE);

        return initPage(getDriver(), SearchFoodPageBase.class);
    }


    @Override
    public int getCaloriesFromCategory(String category) {

        swipe(mealTitleByText.format(category), Direction.UP, TWENTY_COUNT, LOW_SPEED);

        int caloriesFromCategoryValue = Integer.parseInt(sectionCaloriesField.format(category).getText());
        LOGGER.info("Calories from category {} value: {}", category, caloriesFromCategoryValue);


        return caloriesFromCategoryValue;
    }

    @Override
    public AbstractPage clickAddExerciseButton(ExercisesType exercisesType) {

        swipe(mealTitleByText.format(WATER), Direction.UP, TWENTY_COUNT, LOW_SPEED);

        addExerciseButton.click();

        itemByText.format(exercisesType.getExerciseType()).click();

        return initPage(getDriver(), exercisesType.getClassName());
    }


    @Override
    public boolean isAllFoodDeletedForMeal() {

        return !editActionPenButton.isElementPresent(TIMEOUT_FIFTEEN);
    }

    @Override
    public DiaryPageBase deleteAllItems() {

        if (editActionPenButton.isElementPresent(TIMEOUT_FIVE)) {

            editActionPenButton.click();
            selectAllCheckBox.click();
            deleteFoodButton.click();

            if (deletePopUpMessage.isElementPresent(TIMEOUT_TWO)) {
                itemByText.format(DO_NOT_ASK_ME_AGAIN).check();
                deleteTextButton.click();
            }
        }

        return initPage(getDriver(), DiaryPageBase.class);
    }


}
