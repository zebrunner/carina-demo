package koval.mobile.myfitnesspal.gui.common.searchFood;

import com.qaprosoft.carina.core.gui.AbstractPage;
import koval.mobile.myfitnesspal.gui.MyAbstractPage;
import koval.mobile.myfitnesspal.gui.common.downMenuPages.DiaryPageBase;
import koval.mobile.myfitnesspal.service.enums.ActionsFromTabsSearchFood;
import koval.mobile.myfitnesspal.service.enums.Meals;
import koval.mobile.myfitnesspal.service.enums.TabsFromSearchFoodPage;
import org.openqa.selenium.WebDriver;


public abstract class SearchFoodPageBase extends MyAbstractPage {

    public SearchFoodPageBase(WebDriver driver) {
        super(driver);
    }

    public abstract boolean isPageOpened(String mealText);


    public abstract SearchFoodPageBase changeMealByName(Meals meals);

    public abstract SearchFoodPageBase addFoodToMealByName(String food);

    public abstract DiaryPageBase clickBackButton();

    public abstract SearchFoodPageBase searchFood(String food);

    public abstract SearchFoodPageBase openTabByName(TabsFromSearchFoodPage tabsFromSearchFoodPage);

    public abstract AbstractPage openActionPageByName(ActionsFromTabsSearchFood actionsFromTabsSearchFood);
}
