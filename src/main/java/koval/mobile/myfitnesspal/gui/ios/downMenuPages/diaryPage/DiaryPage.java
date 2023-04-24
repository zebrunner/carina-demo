package koval.mobile.myfitnesspal.gui.ios.downMenuPages.diaryPage;


import com.qaprosoft.carina.core.gui.AbstractPage;
import com.zebrunner.carina.utils.exception.NotImplementedException;
import com.zebrunner.carina.utils.factory.DeviceType;
import koval.mobile.myfitnesspal.gui.common.downMenuPages.diaryPageBase.addFood.SearchFoodPageBase;
import koval.mobile.myfitnesspal.gui.common.downMenuPages.diaryPageBase.DiaryPageBase;
import koval.mobile.myfitnesspal.service.enums.DownMenuElement;
import koval.mobile.myfitnesspal.service.enums.ExercisesType;
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
    public int getCaloriesFromCategory(String category) {
        throw new NotImplementedException();
    }

    @Override
    public AbstractPage clickAddExerciseButton(ExercisesType exercisesType) {
        throw new NotImplementedException();
    }

    @Override
    public boolean isFoodAddedToMeal(String food, Meals meals) {
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
    public DiaryPageBase deleteAllItems() {
        throw new NotImplementedException();
    }


}
