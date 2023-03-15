package koval.mobile.myfitnesspal.gui.common.downMenuPages;

import com.qaprosoft.carina.core.gui.AbstractPage;
import koval.mobile.myfitnesspal.gui.MyAbstractPage;

import koval.mobile.myfitnesspal.gui.common.AddFoodPageBase;
import koval.mobile.myfitnesspal.service.enums.DownMenuElement;
import koval.mobile.myfitnesspal.service.enums.Meals;
import org.openqa.selenium.WebDriver;


public abstract class DiaryPageBase extends MyAbstractPage {

    public DiaryPageBase(WebDriver driver) {
        super(driver);
    }


    public abstract AbstractPage openPageFromDownMenuByName(DownMenuElement downMenuElement);


    public abstract boolean isFoodAddedToMeal(String food, Meals meals);

    public abstract boolean isAllFoodDeleted(Meals meals);

    public abstract AddFoodPageBase closePromoMessages();

    public abstract AddFoodPageBase clickAddFoodButton(Meals meals);



    public abstract int getMealLocationByDownY(Meals meals);

    public abstract int getAddFoodButtonLocationByUpperY(Meals meals);

    public abstract int getFoodLocationByUpperY(String text);

    public abstract DiaryPageBase deleteAllFood();

}
