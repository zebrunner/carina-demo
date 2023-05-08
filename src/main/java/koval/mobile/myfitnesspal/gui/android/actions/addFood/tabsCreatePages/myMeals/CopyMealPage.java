package koval.mobile.myfitnesspal.gui.android.actions.addFood.tabsCreatePages.myMeals;


import com.zebrunner.carina.utils.factory.DeviceType;
import koval.mobile.myfitnesspal.gui.common.downMenuPages.DiaryPageBase;
import koval.mobile.myfitnesspal.gui.common.actions.addFood.tabsCreatePages.myMeals.CopyMealPageBase;
import org.openqa.selenium.WebDriver;


@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = CopyMealPageBase.class)
public class CopyMealPage extends CopyMealPageBase {


    public CopyMealPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isPageOpened() {
        return itemByText.format(ADD_MEAL).isElementPresent(TIMEOUT_FIVE);
    }

    @Override
    public DiaryPageBase copyMeal() {

        itemByContent.format(ADD_STRING).click(TIMEOUT_TEN);

        return initPage(getDriver(), DiaryPageBase.class);
    }

}
