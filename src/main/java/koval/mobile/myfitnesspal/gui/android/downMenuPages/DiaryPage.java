package koval.mobile.myfitnesspal.gui.android.downMenuPages;


import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import com.zebrunner.carina.utils.factory.DeviceType;
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
    private ExtendedWebElement mealTitle;

    @FindBy(xpath = "//*[@resource-id='com.myfitnesspal.android:id/content_container']/child::*[@text='%s']")
    private ExtendedWebElement mealTitleByText;
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

    @FindBy(xpath = "//android.widget.LinearLayout/android.view.ViewGroup/android.widget.TextView[1]")
    private ExtendedWebElement foodViewItemTitle;

    @FindBy(id = "com.myfitnesspal.android:id/imagePromoClose")
    private ExtendedWebElement closePromoImageButton;

    @FindBy(id = "com.myfitnesspal.android:id/promo_dismiss")
    private ExtendedWebElement promoDismissButton;

    @FindBy(id = "com.myfitnesspal.android:id/add_food")
    private List<ExtendedWebElement> addFoodButtonList;

    @FindBy(xpath = "//*[@resource-id='com.myfitnesspal.android:id/content_container']")
    private List<ExtendedWebElement> mealContainerList;

    @FindBy(xpath = "//*[@resource-id='com.myfitnesspal.android:id/foodSearchViewFoodItem']")
    private List<ExtendedWebElement> foodViewContainerList;


    @FindBy(id = "com.myfitnesspal.android:id/footer_container")
    private List<ExtendedWebElement> addFoodButtonContainerList;

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
    public boolean isFoodAddedToMeal(String food, Meals meals) {
        return getFoodLocationByUpperY(food) == getMealLocationByDownY(meals);
    }


    @Override
    public AddFoodPageBase closePromoMessages() {

        if (promoDismissButton.isElementPresent(TIMEOUT_FIVE)) {
            promoDismissButton.click();
        }

        if (closePromoImageButton.isElementPresent(TIMEOUT_FIVE)) {
            closePromoImageButton.click();
        }

        return initPage(getDriver(), AddFoodPageBase.class);
    }


    @Override
    public AddFoodPageBase clickAddFoodButton(Meals meals) {

        swipe(itemByText.format(meals.getMeal()), Direction.UP, TWENTY_COUNT, LOW_SPEED);

        clickAddButtonByMeal(meals);

        return initPage(getDriver(), AddFoodPageBase.class);
    }

    @Override
    public AddFoodPageBase clickAddButtonByMeal(Meals meals) {

        for (int i = 0; i < addFoodButtonList.size(); i++) {

            if (addFoodButtonContainerList.get(i).getLocation().getY() == getMealLocationByDownY(meals)) {

                addFoodButtonList.get(i).click();
                break;
            }
        }

        return initPage(getDriver(), AddFoodPageBase.class);
    }


    @Override
    public boolean isAllFoodDeleted(Meals meals) {

        boolean isAllFoodDeleted = false;

        if (meals.getMealIndex() == 3) {
            swipe(mealTitleByText.format(EXERCISE_STRING));
        }

        for (int i = 0; i < addFoodButtonList.size(); i++) {

            if (addFoodButtonContainerList.get(i).getLocation().getY() == getMealLocationByDownY(meals)) {
                isAllFoodDeleted = true;
                break;
            }
        }

        return isAllFoodDeleted;
    }

    @Override
    public int getFoodLocationByUpperY(String text) {

        int locationY = 0;

        for (ExtendedWebElement extendedWebElement : foodViewContainerList) {

            if (extendedWebElement.findExtendedWebElement(foodViewItemTitle.getBy()).getText().toLowerCase().equals(text)) {

                locationY = extendedWebElement.getLocation().getY();
                break;

            }
        }

        return locationY;
    }


    @Override
    public int getMealLocationByDownY(Meals meals) {

        int locationDownY = 0;

        for (ExtendedWebElement extendedWebElement : mealContainerList) {

            if (extendedWebElement.findExtendedWebElement(mealTitle.getBy()).getText().equals(meals.getMeal())) {

                locationDownY = extendedWebElement.getSize().getHeight() + extendedWebElement.getLocation().getY();
                break;
            }

        }

        return locationDownY;
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
