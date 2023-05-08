package koval.mobile.myfitnesspal.gui.common.actions;

import koval.mobile.myfitnesspal.gui.MyAbstractPageBase;
import koval.mobile.myfitnesspal.gui.common.downMenuPages.dashboardPage.mePage.MePageBase;
import koval.mobile.myfitnesspal.service.enums.Items;
import koval.mobile.myfitnesspal.service.enums.RecipeMealsFoods;
import org.openqa.selenium.WebDriver;

import java.util.List;


public abstract class RecipesMealsFoodsPageBase extends MyAbstractPageBase {

    public RecipesMealsFoodsPageBase(WebDriver driver) {
        super(driver);
    }


    public abstract RecipesMealsFoodsPageBase openTabByName(Items items);

    public abstract RecipesMealsFoodsPageBase deleteAllItemsByName(RecipeMealsFoods recipeMealsFoods);

    public abstract MePageBase clickBackButton();

    public abstract List<String> getItemElementsToList();
}
