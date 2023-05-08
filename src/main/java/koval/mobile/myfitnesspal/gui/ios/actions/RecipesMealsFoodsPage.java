package koval.mobile.myfitnesspal.gui.ios.actions;


import com.zebrunner.carina.utils.exception.NotImplementedException;
import com.zebrunner.carina.utils.factory.DeviceType;
import koval.mobile.myfitnesspal.gui.common.actions.RecipesMealsFoodsPageBase;
import koval.mobile.myfitnesspal.gui.common.downMenuPages.dashboardPage.mePage.MePageBase;
import koval.mobile.myfitnesspal.service.enums.Items;
import koval.mobile.myfitnesspal.service.enums.RecipeMealsFoods;
import org.openqa.selenium.WebDriver;


import java.util.List;



@DeviceType(pageType = DeviceType.Type.IOS_PHONE, parentClass = RecipesMealsFoodsPageBase.class)
public class RecipesMealsFoodsPage extends RecipesMealsFoodsPageBase {


    public RecipesMealsFoodsPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public RecipesMealsFoodsPageBase openTabByName(Items items) {
        throw new NotImplementedException();
    }

    @Override
    public RecipesMealsFoodsPageBase deleteAllItemsByName(RecipeMealsFoods recipeMealsFoods) {
        throw new NotImplementedException();
    }

    @Override
    public MePageBase clickBackButton() {
        throw new NotImplementedException();
    }

    @Override
    public List<String> getItemElementsToList() {
        throw new NotImplementedException();
    }
}