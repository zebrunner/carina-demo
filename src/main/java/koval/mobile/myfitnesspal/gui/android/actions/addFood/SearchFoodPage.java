package koval.mobile.myfitnesspal.gui.android.actions.addFood;


import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import com.zebrunner.carina.utils.factory.DeviceType;
import koval.mobile.myfitnesspal.gui.common.actions.addFood.SearchFoodPageBase;
import koval.mobile.myfitnesspal.gui.common.downMenuPages.DiaryPageBase;
import koval.mobile.myfitnesspal.service.enums.ActionsFromTabsSearchFood;
import koval.mobile.myfitnesspal.service.enums.Meals;
import koval.mobile.myfitnesspal.service.enums.ReturnPages;
import koval.mobile.myfitnesspal.service.enums.TabsFromSearchFoodPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

import java.util.*;
import java.util.stream.Collectors;


@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = SearchFoodPageBase.class)
public class SearchFoodPage extends SearchFoodPageBase {

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

    /* appears after clicking on plus button */
    @FindBy(xpath = "//*[@resource-id='com.myfitnesspal.android:id/mealName' and @text='%s']")
    private ExtendedWebElement mealName;

    @FindBy(id = "com.myfitnesspal.android:id/text_primary")
    private ExtendedWebElement myFoodsTitle;

    @FindBy(xpath = "//*[@resource-id='com.myfitnesspal.android:id/listItemViewContainer']/child::*//*[@resource-id='com.myfitnesspal.android:id/text_primary']")
    private List<ExtendedWebElement> foodTitleList;

    @FindBy(id = "com.myfitnesspal.android:id/quickLogAddRemoveIcon")
    private List<ExtendedWebElement> addFoodPlusButtonList;

    @FindBy(id = "com.myfitnesspal.android:id/mealName")
    private List<ExtendedWebElement> mealNameTextList;

    @FindBy(id = "com.myfitnesspal.android:id/text_primary")
    private List<ExtendedWebElement> listOfMyFoods;


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
    public List<String> getListOfFoodElementsToList(int listSize) {

        waitUntil(ExpectedConditions.visibilityOfElementLocated(myFoodsTitle.getBy()), TIMEOUT_FIFTEEN);

        if (listOfMyFoods.isEmpty()) {
            Assert.fail("[SEARCH FOOD PAGE] List is of foods empty!");
        }


        List<String> myFoodsList = new ArrayList<>();

        int attemp = 3;
        while (myFoodsList.size() < listSize && attemp > 0) {
            myFoodsList.addAll(listOfMyFoods.stream().map(ExtendedWebElement::getText).distinct().collect(Collectors.toList()));
            myFoodsList = myFoodsList.stream().distinct().collect(Collectors.toList());
            swipeUp(MEDIUM_SPEED);

            LOGGER.info("[ SEARCH FOOD PAGE ] Attempt left: {} for getting items to my foods list", attemp);
            attemp--;
        }
        return myFoodsList;
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
            mealName.format(Meals.BREAKFAST.getMeal()).clickIfPresent(TIMEOUT_FIVE);
        }

        return initPage(getDriver(), DiaryPageBase.class);
    }


    @Override
    public AbstractPage clickBackButton(ReturnPages returnPage) {

        backButton.click();

        return initPage(getDriver(), returnPage.getClassName());
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
