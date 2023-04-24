package koval.mobile.myfitnesspal.gui.common.downMenuPages.diaryPageBase;

import com.qaprosoft.carina.core.gui.AbstractPage;
import koval.mobile.myfitnesspal.gui.MyAbstractPageBase;

import koval.mobile.myfitnesspal.gui.common.downMenuPages.diaryPageBase.addFood.SearchFoodPageBase;
import koval.mobile.myfitnesspal.service.enums.DownMenuElement;
import koval.mobile.myfitnesspal.service.enums.ExercisesType;
import koval.mobile.myfitnesspal.service.enums.Meals;
import org.openqa.selenium.WebDriver;


public abstract class DiaryPageBase extends MyAbstractPageBase {

    public DiaryPageBase(WebDriver driver) {
        super(driver);
    }


    public abstract AbstractPage openPageFromDownMenuByName(DownMenuElement downMenuElement);


    public abstract int getCaloriesFromCategory(String category);

    public abstract AbstractPage clickAddExerciseButton(ExercisesType exercisesType);


    public abstract boolean isAllFoodDeletedForMeal(Meals meals);

    public abstract SearchFoodPageBase clickAddFoodButton(Meals meals);

    public abstract boolean isFoodAddedToMeal(String food, Meals meals);


    public abstract SearchFoodPageBase closePromoMessagesIfPresent();

    public abstract DiaryPageBase deleteAllItems();

}
