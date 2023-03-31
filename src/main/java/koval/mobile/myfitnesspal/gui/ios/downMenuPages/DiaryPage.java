package koval.mobile.myfitnesspal.gui.ios.downMenuPages;


import com.qaprosoft.carina.core.gui.AbstractPage;
import com.zebrunner.carina.utils.exception.NotImplementedException;
import com.zebrunner.carina.utils.factory.DeviceType;
import koval.mobile.myfitnesspal.gui.common.searchFood.SearchFoodPageBase;
import koval.mobile.myfitnesspal.gui.common.downMenuPages.DiaryPageBase;
import koval.mobile.myfitnesspal.service.enums.DownMenuElement;
import koval.mobile.myfitnesspal.service.enums.Meals;
import org.openqa.selenium.WebDriver;


@DeviceType(pageType = DeviceType.Type.IOS_PHONE, parentClass = DiaryPageBase.class)
public class DiaryPage extends DiaryPageBase {


    public DiaryPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public AbstractPage openPageFromDownMenuByName(DownMenuElement downMenuElement) {
        throw new NotImplementedException();
    }

    @Override
    public SearchFoodPageBase clickAddFoodButtonByLocation(Meals meals) {
        throw new NotImplementedException();
    }

    @Override
    public boolean isFoodAddedToMeal(String food, Meals meals) {
        throw new NotImplementedException();
    }

    @Override
    public boolean isFoodAddedToMealByLocation(String food, Meals meals) {
        throw new NotImplementedException();
    }

    @Override
    public boolean isAllFoodDeletedForMeal(Meals meals) {
        throw new NotImplementedException();
    }

    @Override
    public SearchFoodPageBase closePromoMessagesIfPresent() {
        throw new NotImplementedException();
    }


    @Override
    public SearchFoodPageBase clickAddFoodButton(Meals meals) {
        throw new NotImplementedException();
    }


    @Override
    public DiaryPageBase deleteAllFood() {
        throw new NotImplementedException();
    }


}
