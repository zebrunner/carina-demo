package koval.mobile.myfitnesspal.gui.android.searchFood;


import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import com.zebrunner.carina.utils.factory.DeviceType;
import koval.mobile.myfitnesspal.gui.common.searchFood.SearchFoodPageBase;
import koval.mobile.myfitnesspal.gui.common.downMenuPages.DiaryPageBase;
import koval.mobile.myfitnesspal.service.enums.ActionsFromTabsSearchFood;
import koval.mobile.myfitnesspal.service.enums.Meals;
import koval.mobile.myfitnesspal.service.enums.TabsFromSearchFoodPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

import java.util.List;


@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = SearchFoodPageBase.class)
public class SearchFoodPage extends SearchFoodPageBase {

    @FindBy(xpath = "//*[@text='%s']")
    private ExtendedWebElement itemByText;

    @FindBy(xpath = "//*[@content-desc='%s']")
    private ExtendedWebElement itemByContent;

    @FindBy(id = "com.myfitnesspal.android:id/selectMealText")
    private ExtendedWebElement selectMealText;

    @FindBy(id = "com.myfitnesspal.android:id/searchEditText")
    private ExtendedWebElement searchFoodField;

    @FindBy(id = "com.myfitnesspal.android:id/searchForTextView")
    private ExtendedWebElement searchForFoodTextView;

    @FindBy(xpath = "//*[@resource-id='com.myfitnesspal.android:id/toolbar']//android.widget.ImageButton")
    private ExtendedWebElement backButton;

    @FindBy(xpath = "//*[@resource-id='com.myfitnesspal.android:id/listItemViewContainer']/child::*//*[@resource-id='com.myfitnesspal.android:id/text_primary']")
    private ExtendedWebElement foodTitle;

    @FindBy(id = "com.myfitnesspal.android:id/quickLogAddRemoveIcon")
    private ExtendedWebElement addFoodPlusButton;

    @FindBy(xpath = "//*[@resource-id='com.myfitnesspal.android:id/listItemViewContainer']/child::*//*[@resource-id='com.myfitnesspal.android:id/text_primary']")
    private List<ExtendedWebElement> foodTitleList;

    @FindBy(id = "com.myfitnesspal.android:id/quickLogAddRemoveIcon")
    private List<ExtendedWebElement> addFoodPlusButtonList;

    @FindBy(id = "com.myfitnesspal.android:id/mealName")
    private List<ExtendedWebElement> mealNameTextList;


    public SearchFoodPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isPageOpened(String mealText) {
        return isPageOpened(selectMealText, mealText);
    }


    @Override
    public boolean isPageOpened() {
        return searchFoodField.isElementPresent(TIMEOUT_TEN);
    }

    @Override
    public SearchFoodPageBase changeMealByName(Meals meals) {

        if (!selectMealText.getText().equals(meals.getMeal())) {
            selectMealText.click();

            if (mealNameTextList.isEmpty()) {
                Assert.fail("[ ADD FOOD PAGE ] List of meals is empty!");
            }

            for (ExtendedWebElement extendedWebElement : mealNameTextList) {
                if (extendedWebElement.getText().equals(meals.getMeal())) {
                    extendedWebElement.click();
                    break;
                }
            }

        }

        return initPage(getDriver(), SearchFoodPageBase.class);
    }

    @Override
    public String getFoodTitleText() {

        waitUntil(ExpectedConditions.visibilityOfElementLocated(foodTitle.getBy()), TIMEOUT_FIVE);

        if (foodTitleList.isEmpty()) {
            Assert.fail("[ SEARCH FOOD PAGE ] List of food is empty!");
        }
        return foodTitleList.get(0).getText();
    }

    @Override
    public DiaryPageBase addFoodToMealByName(String food) {

        waitUntil(ExpectedConditions.visibilityOfElementLocated(addFoodPlusButton.getBy()), TIMEOUT_FIVE);

        if (addFoodPlusButtonList.isEmpty()) {
            Assert.fail("[ SEARCH FOOD PAGE ] List of food is empty!");
        }

        if (getFoodTitleText().contains(food)) {
            addFoodPlusButtonList.get(0).click();
            itemByText.format("Breakfast").clickIfPresent(TIMEOUT_FIVE);
        }

        return initPage(getDriver(), DiaryPageBase.class);
    }


    @Override
    public DiaryPageBase clickBackButton() {

        backButton.click();

        return initPage(getDriver(), DiaryPageBase.class);
    }


    @Override
    public SearchFoodPageBase searchFood(String food) {

        searchFoodField.type(food, TIMEOUT_FIVE);

        swipe(searchForFoodTextView, Direction.UP, TWENTY_COUNT, MEDIUM_SPEED);
        swipeUp(ONE_TIME, MEDIUM_SPEED);
        searchForFoodTextView.click(TIMEOUT_FIVE);

        return initPage(getDriver(), SearchFoodPageBase.class);
    }

    @Override
    public SearchFoodPageBase searchForFoodTitle() {

        searchForFoodTextView.click(TIMEOUT_FIVE);

        return initPage(getDriver(), SearchFoodPageBase.class);
    }

    @Override
    public SearchFoodPageBase openTabByName(TabsFromSearchFoodPage tabsFromSearchFoodPage) {

        itemByContent.format(tabsFromSearchFoodPage.getTabName()).click();

        return initPage(getDriver(), SearchFoodPageBase.class);
    }


    @Override
    public AbstractPage openActionPageByName(ActionsFromTabsSearchFood actionsFromTabsSearchFood) {

        if (!itemByText.format(actionsFromTabsSearchFood.getPageName()).isElementPresent(TIMEOUT_FIVE)) {
            Assert.fail(String.format("[ SEARCH FOOD PAGE ] '%s' action is not present!", actionsFromTabsSearchFood.getPageName()));
        }

        itemByText.format(actionsFromTabsSearchFood.getPageName()).click();

        return initPage(getDriver(), actionsFromTabsSearchFood.getClassName());
    }
}
