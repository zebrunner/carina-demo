package koval.mobile.myfitnesspal.gui.ios;


import com.zebrunner.carina.utils.exception.NotImplementedException;
import com.zebrunner.carina.utils.factory.DeviceType;
import koval.mobile.myfitnesspal.gui.common.AddFoodPageBase;
import koval.mobile.myfitnesspal.gui.common.downMenuPages.DiaryPageBase;
import koval.mobile.myfitnesspal.service.enums.Meals;
import org.openqa.selenium.WebDriver;


@DeviceType(pageType = DeviceType.Type.IOS_PHONE, parentClass = AddFoodPageBase.class)
public class AddFoodPage extends AddFoodPageBase {


    public AddFoodPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isPageOpened(String mealText) {
        throw new NotImplementedException();
    }

    @Override
    public AddFoodPageBase changeMealByName(Meals meals) {
        throw new NotImplementedException();
    }

    @Override
    public AddFoodPageBase addFoodToMealByName(String food) {
        throw new NotImplementedException();
    }

    @Override
    public DiaryPageBase clickBackButton() {
        throw new NotImplementedException();
    }


}
