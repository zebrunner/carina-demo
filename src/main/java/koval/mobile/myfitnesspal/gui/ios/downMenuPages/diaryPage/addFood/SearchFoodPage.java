package koval.mobile.myfitnesspal.gui.ios.downMenuPages.diaryPage.addFood;


import com.qaprosoft.carina.core.gui.AbstractPage;
import com.zebrunner.carina.utils.exception.NotImplementedException;
import com.zebrunner.carina.utils.factory.DeviceType;
import koval.mobile.myfitnesspal.gui.common.downMenuPages.diaryPageBase.DiaryPageBase;
import koval.mobile.myfitnesspal.gui.common.downMenuPages.diaryPageBase.addFood.SearchFoodPageBase;
import koval.mobile.myfitnesspal.service.enums.ActionsFromTabsSearchFood;
import koval.mobile.myfitnesspal.service.enums.Meals;
import koval.mobile.myfitnesspal.service.enums.TabsFromSearchFoodPage;
import org.openqa.selenium.WebDriver;



@DeviceType(pageType = DeviceType.Type.IOS_PHONE, parentClass = SearchFoodPageBase.class)
public class SearchFoodPage extends SearchFoodPageBase {

    public SearchFoodPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isPageOpened(String mealText) {
        throw new NotImplementedException();
    }

    @Override
    public SearchFoodPageBase changeMealByName(Meals meals) {
        throw new NotImplementedException();
    }

    @Override
    public String getFoodTitleText() {
        throw new NotImplementedException();
    }

    @Override
    public DiaryPageBase addFoodToMealByName(String food) {
        throw new NotImplementedException();
    }

    @Override
    public DiaryPageBase clickBackButton() {
        throw new NotImplementedException();
    }

    @Override
    public SearchFoodPageBase searchFood(String food) {
        throw new NotImplementedException();
    }

    @Override
    public SearchFoodPageBase searchForFoodTitle() {
        throw new NotImplementedException();
    }

    @Override
    public SearchFoodPageBase openTabByName(TabsFromSearchFoodPage tabsFromSearchFoodPage) {
        throw new NotImplementedException();
    }

    @Override
    public AbstractPage openActionPageByName(ActionsFromTabsSearchFood actionsFromTabsSearchFood) {
        throw new NotImplementedException();
    }

}
