package koval.mobile.myfitnesspal.gui.common.downMenuPages.diaryPageBase.addFood;

import com.qaprosoft.carina.core.gui.AbstractPage;
import koval.mobile.myfitnesspal.gui.MyAbstractPageBase;
import koval.mobile.myfitnesspal.gui.common.downMenuPages.diaryPageBase.DiaryPageBase;
import koval.mobile.myfitnesspal.service.enums.ActionsFromTabsSearchFood;
import koval.mobile.myfitnesspal.service.enums.Meals;
import koval.mobile.myfitnesspal.service.enums.TabsFromSearchFoodPage;
import org.openqa.selenium.WebDriver;


public abstract class SearchFoodPageBase extends MyAbstractPageBase {

    public SearchFoodPageBase(WebDriver driver) {
        super(driver);
    }

    public abstract boolean isPageOpened(String mealText);


    public abstract SearchFoodPageBase changeMealByName(Meals meals);

    public abstract String getFoodTitleText();

    public abstract DiaryPageBase addFoodToMealByName(String food);

    public abstract AbstractPage clickBackButton();

    public abstract SearchFoodPageBase searchFood(String food);

    public abstract SearchFoodPageBase searchForFoodTitle();

    public abstract SearchFoodPageBase openTabByName(TabsFromSearchFoodPage tabsFromSearchFoodPage);

    public abstract AbstractPage openActionPageByName(ActionsFromTabsSearchFood actionsFromTabsSearchFood);
}
