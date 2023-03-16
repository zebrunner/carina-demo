package koval.mobile.myfitnesspal.gui.android;


import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.utils.factory.DeviceType;
import koval.mobile.myfitnesspal.gui.common.AddFoodPageBase;
import koval.mobile.myfitnesspal.gui.common.downMenuPages.DiaryPageBase;
import koval.mobile.myfitnesspal.service.enums.Meals;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import java.util.List;


@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = AddFoodPageBase.class)
public class AddFoodPage extends AddFoodPageBase {

    @FindBy(id = "com.myfitnesspal.android:id/selectMealText")
    private ExtendedWebElement selectMealText;

    @FindBy(id = "com.myfitnesspal.android:id/searchEditText")
    private ExtendedWebElement searchFoodField;

    @FindBy(id = "com.myfitnesspal.android:id/searchForTextView")
    private ExtendedWebElement searchForFoodTextView;

    @FindBy(xpath = "//*[@resource-id='com.myfitnesspal.android:id/toolbar']//android.widget.ImageButton")
    private ExtendedWebElement backButton;

    @FindBy(xpath = "//*[@resource-id='com.myfitnesspal.android:id/listItemViewContainer']/child::*//*[@resource-id='com.myfitnesspal.android:id/text_primary']")
    private List<ExtendedWebElement> foodTitleList;

    @FindBy(id = "com.myfitnesspal.android:id/quickLogAddRemoveIcon")
    private List<ExtendedWebElement> addFoodPlusButtonList;

    @FindBy(id = "com.myfitnesspal.android:id/mealName")
    private List<ExtendedWebElement> mealNameTextList;

    public AddFoodPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isPageOpened(String mealText) {
        return isPageOpened(selectMealText, mealText);
    }


    @Override
    public AddFoodPageBase changeMealByName(Meals meals) {

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

        return initPage(getDriver(), AddFoodPageBase.class);
    }


    @Override
    public AddFoodPageBase addFoodToMealByName(String food) {

        searchFoodField.type(food);
        searchForFoodTextView.click();

        for (int i = 0; i < foodTitleList.size(); i++) {
            if (foodTitleList.get(i).getText().toLowerCase().equals(food)) {
                addFoodPlusButtonList.get(i).click();
                break;

            }
        }

        return initPage(getDriver(), AddFoodPageBase.class);
    }

    @Override
    public DiaryPageBase clickBackButton() {

        backButton.click();

        return initPage(getDriver(), DiaryPageBase.class);
    }

}
