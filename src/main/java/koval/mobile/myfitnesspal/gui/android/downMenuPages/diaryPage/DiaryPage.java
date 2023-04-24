package koval.mobile.myfitnesspal.gui.android.downMenuPages.diaryPage;


import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import com.zebrunner.carina.utils.factory.DeviceType;
import koval.mobile.myfitnesspal.gui.android.modal.DownMenuModal;
import koval.mobile.myfitnesspal.gui.common.downMenuPages.diaryPageBase.addFood.SearchFoodPageBase;
import koval.mobile.myfitnesspal.gui.common.downMenuPages.diaryPageBase.DiaryPageBase;
import koval.mobile.myfitnesspal.service.enums.DownMenuElement;
import koval.mobile.myfitnesspal.service.enums.ExercisesType;
import koval.mobile.myfitnesspal.service.enums.Meals;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


import java.lang.invoke.MethodHandles;
import java.util.List;


@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = DiaryPageBase.class)
public class DiaryPage extends DiaryPageBase {


    @FindBy(id = "com.myfitnesspal.android:id/toolbar")
    private ExtendedWebElement upperToolbar;


    @FindBy(id = "com.myfitnesspal.android:id/bottomNavigationBar")
    private DownMenuModal downMenuModal;

    @FindBy(xpath = "//*[@content-desc='MainActivity']/android.widget.LinearLayout//android.widget.TextView")
    private ExtendedWebElement title;

    @FindBy(id = "com.myfitnesspal.android:id/txtSectionHeader")
    private ExtendedWebElement mealTitle;

    @FindBy(xpath = "//*[@resource-id='com.myfitnesspal.android:id/content_container']/child::*[@text='%s']")
    private ExtendedWebElement mealTitleByText;

    @FindBy(id = "com.myfitnesspal.android:id/edit_action_item")
    private ExtendedWebElement editActionPenButton;

    @FindBy(id = "com.myfitnesspal.android:id/select_all")
    private ExtendedWebElement selectAllCheckBox;

    /*main delete button*/
    @FindBy(xpath = "//android.widget.Button[@content-desc='Delete']")
    private ExtendedWebElement deleteFoodButton;

    @FindBy(xpath = "//*[@text='%s']")
    private ExtendedWebElement itemByText;

    /*deletePopUpMessage - confirm deleting*/
    @FindBy(xpath = "//android.widget.Button[@text='Delete']")
    private ExtendedWebElement deleteTextButton;

    @FindBy(id = "com.myfitnesspal.android:id/parentPanel")
    private ExtendedWebElement deletePopUpMessage;

    @FindBy(xpath = "//android.widget.LinearLayout/android.view.ViewGroup/android.widget.TextView[1]")
    private ExtendedWebElement foodViewItemTitle;

    @FindBy(id = "com.myfitnesspal.android:id/imagePromoClose")
    private ExtendedWebElement closePromoImageButton;

    @FindBy(id = "com.myfitnesspal.android:id/promo_dismiss")
    private ExtendedWebElement promoDismissButton;

    @FindBy(id = "com.myfitnesspal.android:id/add_food")
    private List<ExtendedWebElement> addFoodButtonList;

    @FindBy(id = "com.myfitnesspal.android:id/diary_recycler_view")
    private ExtendedWebElement diaryRecyclerViewContainer;

    @FindBy(xpath = "//*[@resource-id='com.myfitnesspal.android:id/content_container']")
    private List<ExtendedWebElement> mealContainerList;

    @FindBy(xpath = "//*[@resource-id='com.myfitnesspal.android:id/foodSearchViewFoodItem']")
    private List<ExtendedWebElement> foodViewContainerList;

    @FindBy(id = "com.myfitnesspal.android:id/footer_container")
    private List<ExtendedWebElement> addFoodButtonContainerList;


    @FindBy(xpath = "//*[@resource-id='com.myfitnesspal.android:id/txtSectionHeader' and @text='%s']//following-sibling::*[@resource-id = 'com.myfitnesspal.android:id/txtSectionCalories']")
    private ExtendedWebElement sectionCaloriesField;

    @FindBy(xpath = "//*[@resource-id='com.myfitnesspal.android:id/txtSectionHeader' and @text='%s']/parent::*/parent::*/following-sibling::*//*[@resource-id='com.myfitnesspal.android:id/footer_container']//*[@resource-id='com.myfitnesspal.android:id/add_food']")
    private ExtendedWebElement addFoodButton;


    @FindBy(xpath = "//*[@resource-id='com.myfitnesspal.android:id/txtSectionHeader' and @text='Exercise']/parent::*/parent::*/following-sibling::*//*[@resource-id='com.myfitnesspal.android:id/footer_container']//*[@resource-id='com.myfitnesspal.android:id/add_food' and @text='ADD EXERCISE']")
    private ExtendedWebElement addExerciseButton;

    @FindBy(xpath = "//*[@resource-id=\"com.myfitnesspal.android:id/txtSectionHeader\" and @text='%s']/parent::*/parent::*/following-sibling::*//*[@resource-id=\"com.myfitnesspal.android:id/txtItemDescription\" and contains(@text,'%s')]")
    private ExtendedWebElement foodTitle;

    public DiaryPage(WebDriver driver) {
        super(driver);
    }

    private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());


    @Override
    public AbstractPage openPageFromDownMenuByName(DownMenuElement downMenuElement) {

        return downMenuModal.openPageByName(downMenuElement);
    }

    @Override
    public boolean isPageOpened() {
        swipe(upperToolbar, diaryRecyclerViewContainer, Direction.DOWN, TWENTY_COUNT, MEDIUM_SPEED);
        return isPageOpened(title, DIARY_TEXT);
    }

    @Override
    public SearchFoodPageBase clickAddFoodButton(Meals meals) {

        ExtendedWebElement testEl = addFoodButton.format(meals.getMeal());
        swipe(testEl, Direction.UP, TWENTY_COUNT, MEDIUM_SPEED);

        if (meals.getMeal().equals(SNACKS)) {
            ExtendedWebElement snackTitleByText = itemByText.format(CONNECT_A_STEP_TRACKER);
            swipe(snackTitleByText, Direction.UP, TWENTY_COUNT, MEDIUM_SPEED);
        }

        addFoodButton.format(meals.getMeal()).click();

        return initPage(getDriver(), SearchFoodPageBase.class);
    }


    @Override
    public boolean isFoodAddedToMeal(String food, Meals meals) {

        boolean isFoodAddedToMeal;

        if (meals.getMeal().equals(SNACKS)) {
            ExtendedWebElement snackTitleByText = itemByText.format(CONNECT_A_STEP_TRACKER);
            swipe(snackTitleByText, Direction.DOWN, TWENTY_COUNT, MEDIUM_SPEED);
            isFoodAddedToMeal = foodTitle.format(meals.getMeal(), food).isElementPresent(TIMEOUT_TEN);
        } else {
            ExtendedWebElement mealByText = mealTitleByText.format(meals.getMeal());
            swipe(mealByText, diaryRecyclerViewContainer, Direction.DOWN, TWENTY_COUNT, MEDIUM_SPEED);
            isFoodAddedToMeal = foodTitle.format(meals.getMeal(), food).isElementPresent(TIMEOUT_TEN);
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

        swipe(addExerciseButton, Direction.UP, TWENTY_COUNT, LOW_SPEED);

        addExerciseButton.click();

        itemByText.format(exercisesType.getExerciseType()).click();

        return initPage(getDriver(), exercisesType.getClassName());
    }


    @Override
    public boolean isAllFoodDeletedForMeal(Meals meals) {

        boolean isAllFoodDeleted = false;

        if (meals.getMealIndex() == 3) {
            ExtendedWebElement mealByText = mealTitleByText.format(EXERCISE_STRING);
            swipe(mealByText, Direction.UP, TWENTY_COUNT, LOW_SPEED);
        }

        for (int i = 0; i < addFoodButtonList.size(); i++) {

            if (addFoodButtonContainerList.get(i).getLocation().getY() == getMealLocationByDownY(meals.getMeal())) {
                isAllFoodDeleted = true;
                break;
            }
        }

        return isAllFoodDeleted;
    }


    private int getMealLocationByDownY(String meals) {

        int locationDownY = 0;

        ExtendedWebElement mealByText = mealTitleByText.format(meals);
        swipe(mealByText, diaryRecyclerViewContainer, Direction.DOWN, TWENTY_COUNT, MEDIUM_SPEED);

        for (ExtendedWebElement extendedWebElement : mealContainerList) {

            if (extendedWebElement.findExtendedWebElement(mealTitle.getBy()).getText().equals(meals)) {
                locationDownY = extendedWebElement.getSize().getHeight() + extendedWebElement.getLocation().getY();
                break;
            }

        }
        return locationDownY;
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
