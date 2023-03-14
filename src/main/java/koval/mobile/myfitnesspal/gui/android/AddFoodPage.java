package koval.mobile.myfitnesspal.gui.android;


import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.utils.factory.DeviceType;
import koval.mobile.myfitnesspal.gui.common.AddFoodPageBase;
import koval.mobile.myfitnesspal.gui.common.downMenuPages.DiaryPageBase;
import koval.mobile.myfitnesspal.service.enums.Meals;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import java.util.List;


@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = AddFoodPageBase.class)
public class AddFoodPage extends AddFoodPageBase {

    @FindBy(id = "com.myfitnesspal.android:id/selectMealText")
    private ExtendedWebElement selectMealText;


    @FindBy(id = "com.myfitnesspal.android:id/mealName")
    private List<ExtendedWebElement> mealNameText;


    @FindBy(id = "com.myfitnesspal.android:id/searchEditText")
    private ExtendedWebElement searchFoodField;


    @FindBy(id = "com.myfitnesspal.android:id/searchForTextView")
    private ExtendedWebElement searchForFoodTextView;

    @FindBy(xpath = "//*[@resource-id='com.myfitnesspal.android:id/toolbar']//android.widget.ImageButton")
    private ExtendedWebElement backButton;

    @FindBy(xpath = "//*[@resource-id='com.myfitnesspal.android:id/listItemViewContainer']/child::*//*[@resource-id='com.myfitnesspal.android:id/text_primary']")
    private List<ExtendedWebElement> foodTitle;


    @FindBy(id = "com.myfitnesspal.android:id/quickLogAddRemoveIcon")
    private List<ExtendedWebElement> addFoodPlusButton;


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

            //assert.fail empty list

            for (ExtendedWebElement extendedWebElement : mealNameText) {
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

        // searchFoodField.click();
        searchFoodField.type(food);
        searchForFoodTextView.click();

        //assert.fail empty list food and add list

        for (int i = 0; i < foodTitle.size(); i++) {
            if (foodTitle.get(i).getText().toLowerCase().equals(food)) {
                addFoodPlusButton.get(i).click();
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
