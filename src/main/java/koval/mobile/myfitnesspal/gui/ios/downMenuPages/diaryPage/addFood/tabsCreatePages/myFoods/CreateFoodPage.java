package koval.mobile.myfitnesspal.gui.ios.downMenuPages.diaryPage.addFood.tabsCreatePages.myFoods;



import com.zebrunner.carina.utils.exception.NotImplementedException;
import com.zebrunner.carina.utils.factory.DeviceType;
import koval.mobile.myfitnesspal.gui.common.downMenuPages.diaryPageBase.DiaryPageBase;
import koval.mobile.myfitnesspal.gui.common.downMenuPages.diaryPageBase.addFood.tabsCreatePages.myFoods.CreateFoodPageBase;
import koval.mobile.myfitnesspal.service.factories.foodFactory.Food;
import org.openqa.selenium.WebDriver;


@DeviceType(pageType = DeviceType.Type.IOS_PHONE, parentClass = CreateFoodPageBase.class)
public class CreateFoodPage extends CreateFoodPageBase {


    public CreateFoodPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isPageOpened() {
        throw new NotImplementedException();
    }

    @Override
    public DiaryPageBase createFood(Food food) {
        throw new NotImplementedException();
    }


}
