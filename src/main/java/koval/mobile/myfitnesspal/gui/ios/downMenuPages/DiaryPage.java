package koval.mobile.myfitnesspal.gui.ios.downMenuPages;


import com.qaprosoft.carina.core.gui.AbstractPage;
import com.zebrunner.carina.utils.exception.NotImplementedException;
import com.zebrunner.carina.utils.factory.DeviceType;
import koval.mobile.myfitnesspal.gui.common.AddFoodPageBase;
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
    public boolean isFoodAddedToMeal(String food, Meals meals) {
        throw new NotImplementedException();
    }

    @Override
    public boolean isAllFoodDeleted(Meals meals) {
        throw new NotImplementedException();
    }

    @Override
    public AddFoodPageBase closePromoMessages() {
        throw new NotImplementedException();
    }


    @Override
    public AddFoodPageBase clickAddFoodButton(Meals meals) {
        throw new NotImplementedException();
    }

    @Override
    public int getMealLocationByDownY(Meals meals) {
        throw new NotImplementedException();
    }

    @Override
    public AddFoodPageBase clickAddButtonByMeal(Meals meals) {
        throw new NotImplementedException();
    }

    @Override
    public int getAddFoodButtonLocationByUpperY(Meals meals) {
        throw new NotImplementedException();
    }

    @Override
    public int getFoodLocationByUpperY(String text) {
        throw new NotImplementedException();
    }


    @Override
    public DiaryPageBase deleteAllFood() {
        throw new NotImplementedException();
    }


}
