package koval.mobile.myfitnesspal.gui.android.downMenuPages;


import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.utils.mobile.IMobileUtils;
import koval.mobile.myfitnesspal.gui.android.modal.DownMenuModal;
import koval.mobile.myfitnesspal.gui.common.AddFoodPageBase;
import koval.mobile.myfitnesspal.gui.common.downMenuPages.DiaryPageBase;
import koval.mobile.myfitnesspal.service.enums.DownMenuElement;
import koval.mobile.myfitnesspal.service.enums.Meals;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.invoke.MethodHandles;
import java.util.List;


@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = DiaryPageBase.class)
public class DiaryPage extends DiaryPageBase {


    @FindBy(id = "com.myfitnesspal.android:id/bottomNavigationBar")
    private DownMenuModal downMenuModal;


    @FindBy(xpath = "//android.widget.ScrollView[@content-desc='MainActivity']/android.widget.LinearLayout//android.widget.TextView")
    private ExtendedWebElement title;


    @FindBy(id = "com.myfitnesspal.android:id/txtSectionHeader")
    private List<ExtendedWebElement> mealTitle;


    @FindBy(id = "com.myfitnesspal.android:id/add_food")
    private List<ExtendedWebElement> addFoodButton;


    @FindBy(id = "com.myfitnesspal.android:id/edit_action_item")
    private ExtendedWebElement editActionPenButton;


    @FindBy(id = "com.myfitnesspal.android:id/select_all")
    private ExtendedWebElement selectAllCheckBox;


    @FindBy(xpath = "//android.widget.Button[@content-desc='Delete']")
    private ExtendedWebElement deleteFoodButton;

    @FindBy(xpath = "//*[@text='%s']")
    private ExtendedWebElement itemByText;


    @FindBy(xpath = "//android.widget.Button[@text='Delete']")
    private ExtendedWebElement deleteTextButton;

    @FindBy(id = "com.myfitnesspal.android:id/parentPanel")
    private ExtendedWebElement deletePopUpMessage;


    @FindBy(xpath = "//*[@resource-id='com.myfitnesspal.android:id/foodSearchViewFoodItem']/child::*//*[@resource-id='com.myfitnesspal.android:id/txtItemDescription']")
    private ExtendedWebElement foodViewItemTitle;


    @FindBy(id = "com.myfitnesspal.android:id/content_pager")
    private ExtendedWebElement test;

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
        return isPageOpened(title, DIARY_TEXT);
    }

    @Override
    public AddFoodPageBase clickAddFoodButton(Meals meals) {

        //swipe

        for (int i = 0; i < mealTitle.size(); i++) {
            if (mealTitle.get(i).getText().equals(meals.getMeal())) {
                addFoodButton.get(i).click();

            }
        }


        return initPage(getDriver(), AddFoodPageBase.class);
    }

    @Override
    public boolean isFoodAddedToMealByName(Meals meals, String food) {

        //swipe
        // swipe(itemByText.format(meals.getMeal()), Direction.DOWN);

        Direction direction = Direction.UP;
        int desiredMealIndex = meals.getMealIndex();

        for (Meals currentMeal : Meals.values()) {

            if (itemByText.format(currentMeal.getMeal()).isElementPresent(TIMEOUT_FIVE)) {
                int currentMealIndex = currentMeal.getMealIndex();


                LOGGER.info("current " + currentMealIndex);
                LOGGER.info("desire " + desiredMealIndex);


                if (desiredMealIndex < currentMealIndex) {
                    direction = Direction.DOWN;
                }
            }
        }


        swipe(itemByText.format(meals.getMeal()), test, direction);


        boolean result = false;
        for (ExtendedWebElement extendedWebElement : mealTitle) {
            if (extendedWebElement.getText().equals(meals.getMeal())) {
                result = foodViewItemTitle.getText().toLowerCase().equals(food);
            }
        }


        return result;
    }


    @Override
    public DiaryPageBase deleteAllFood() {


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
