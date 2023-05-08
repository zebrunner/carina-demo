package koval.mobile.myfitnesspal.gui.common.actions;

import koval.mobile.myfitnesspal.gui.MyAbstractPageBase;
import koval.mobile.myfitnesspal.gui.common.downMenuPages.dashboardPage.mePage.MePageBase;
import koval.mobile.myfitnesspal.service.enums.Items;
import org.openqa.selenium.WebDriver;

import java.util.List;
import java.util.Set;


public abstract class RecipesMealsFoodsPageBase extends MyAbstractPageBase {

    public RecipesMealsFoodsPageBase(WebDriver driver) {
        super(driver);
    }


    public abstract RecipesMealsFoodsPageBase openTabByName(Items items);

    public abstract MePageBase clickBackButton();

    public abstract List<String> getItemElementsToList();
}
