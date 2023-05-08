package koval.mobile.myfitnesspal.gui.common.downMenuPages.dashboardPage.mePage;

import com.qaprosoft.carina.core.gui.AbstractPage;
import koval.mobile.myfitnesspal.gui.MyAbstractPageBase;
import koval.mobile.myfitnesspal.gui.common.actions.RecipesMealsFoodsPageBase;
import koval.mobile.myfitnesspal.service.enums.Items;
import koval.mobile.myfitnesspal.service.enums.MePageMenuTab;
import org.openqa.selenium.WebDriver;


public abstract class MePageBase extends MyAbstractPageBase {

    public MePageBase(WebDriver driver) {
        super(driver);
    }


    public abstract MePageBase openTabFromMenuByName(MePageMenuTab mePageMenuTab);

    public abstract RecipesMealsFoodsPageBase openItemByName(Items items);

    public abstract AbstractPage clickCreateButtonByItemName(Items items);

    public abstract int getItemValueByName(Items items);
}
