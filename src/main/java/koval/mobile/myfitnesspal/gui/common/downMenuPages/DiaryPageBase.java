package koval.mobile.myfitnesspal.gui.common.downMenuPages;

import com.qaprosoft.carina.core.gui.AbstractPage;
import koval.mobile.myfitnesspal.gui.MyAbstractPage;

import koval.mobile.myfitnesspal.gui.common.searchFood.SearchFoodPageBase;
import koval.mobile.myfitnesspal.service.enums.DownMenuElement;
import koval.mobile.myfitnesspal.service.enums.Meals;
import org.openqa.selenium.WebDriver;


public abstract class DiaryPageBase extends MyAbstractPage {

    public DiaryPageBase(WebDriver driver) {
        super(driver);
    }


    public abstract AbstractPage openPageFromDownMenuByName(DownMenuElement downMenuElement);


    public abstract boolean isFoodAddedToMeal(String food, Meals meals);

    public abstract boolean isAllFoodDeletedForMeal(Meals meals);

    public abstract SearchFoodPageBase closePromoMessagesIfPresent();

    public abstract SearchFoodPageBase clickAddFoodButton(Meals meals);


    public abstract DiaryPageBase deleteAllFood();

}
