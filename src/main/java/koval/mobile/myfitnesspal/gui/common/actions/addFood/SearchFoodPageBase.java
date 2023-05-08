package koval.mobile.myfitnesspal.gui.common.actions.addFood;

import com.qaprosoft.carina.core.gui.AbstractPage;
import koval.mobile.myfitnesspal.gui.MyAbstractPageBase;
import koval.mobile.myfitnesspal.gui.common.downMenuPages.DiaryPageBase;
import koval.mobile.myfitnesspal.service.enums.ActionsFromTabsSearchFood;
import koval.mobile.myfitnesspal.service.enums.Meals;
import koval.mobile.myfitnesspal.service.enums.ReturnPages;
import koval.mobile.myfitnesspal.service.enums.TabsFromSearchFoodPage;
import org.openqa.selenium.WebDriver;

import java.util.List;
import java.util.Set;


public abstract class SearchFoodPageBase extends MyAbstractPageBase {

    public SearchFoodPageBase(WebDriver driver) {
        super(driver);
    }

    public abstract boolean isPageOpened(String mealText);


    public abstract List<String> getListOfFoodElementsToList(int listSize);

    public abstract SearchFoodPageBase changeMealByName(Meals meals);

    public abstract String getFoodTitleText();

    public abstract DiaryPageBase addFoodToMealByName(String food);

    public abstract AbstractPage clickBackButton(ReturnPages returnPage);

    public abstract SearchFoodPageBase searchFood(String food);

    public abstract SearchFoodPageBase searchForFoodTitle();

    public abstract SearchFoodPageBase openTabByName(TabsFromSearchFoodPage tabsFromSearchFoodPage);

    public abstract AbstractPage openActionPageByName(ActionsFromTabsSearchFood actionsFromTabsSearchFood);
}
