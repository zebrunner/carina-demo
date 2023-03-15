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
        return false;
    }

    @Override
    public boolean isAllFoodDeleted(Meals meals) {
        return false;
    }

    @Override
    public AddFoodPageBase closePromoMessages() {
        return null;
    }


    @Override
    public AddFoodPageBase clickAddFoodButton(Meals meals) {
        return null;
    }

    @Override
    public int getMealLocationByDownY(Meals meals) {
        return 0;
    }

    @Override
    public int getAddFoodButtonLocationByUpperY(Meals meals) {
        return 0;
    }

    @Override
    public int getFoodLocationByUpperY(String text) {
        return 0;
    }


    @Override
    public DiaryPageBase deleteAllFood() {
        return null;
    }



}
