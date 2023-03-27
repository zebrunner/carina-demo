package koval.mobile.myfitnesspal.gui.ios.searchFood.tabsCreatePages.myMeals;


import com.zebrunner.carina.utils.exception.NotImplementedException;
import com.zebrunner.carina.utils.factory.DeviceType;
import koval.mobile.myfitnesspal.gui.common.downMenuPages.DiaryPageBase;
import koval.mobile.myfitnesspal.gui.common.searchFood.tabsCreatePages.myMeals.CopyMealPageBase;
import org.openqa.selenium.WebDriver;



@DeviceType(pageType = DeviceType.Type.IOS_PHONE, parentClass = CopyMealPageBase.class)
public class CopyMealPage extends CopyMealPageBase {


    public CopyMealPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isPageOpened() {
        throw new NotImplementedException();
    }

    @Override
    public DiaryPageBase copyMeal() {
        throw new NotImplementedException();
    }

}
