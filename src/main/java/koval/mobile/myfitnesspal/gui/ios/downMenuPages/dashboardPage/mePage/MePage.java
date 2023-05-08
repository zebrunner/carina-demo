package koval.mobile.myfitnesspal.gui.ios.downMenuPages.dashboardPage.mePage;


import com.qaprosoft.carina.core.gui.AbstractPage;
import com.zebrunner.carina.utils.exception.NotImplementedException;
import com.zebrunner.carina.utils.factory.DeviceType;
import koval.mobile.myfitnesspal.gui.common.actions.RecipesMealsFoodsPageBase;
import koval.mobile.myfitnesspal.gui.common.downMenuPages.dashboardPage.DashboardPageBase;
import koval.mobile.myfitnesspal.gui.common.downMenuPages.dashboardPage.mePage.MePageBase;
import koval.mobile.myfitnesspal.service.enums.Items;
import koval.mobile.myfitnesspal.service.enums.MePageMenuTab;
import org.openqa.selenium.WebDriver;


@DeviceType(pageType = DeviceType.Type.IOS_PHONE, parentClass = MePageBase.class)
public class MePage extends MePageBase {

    public MePage(WebDriver driver) {
        super(driver);
    }

    @Override
    public MePageBase openTabFromMenuByName(MePageMenuTab mePageMenuTab) {
        throw new NotImplementedException();
    }

    @Override
    public DashboardPageBase clickBackButton() {
        throw new NotImplementedException();
    }

    @Override
    public RecipesMealsFoodsPageBase openItemByName(Items items) {
        throw new NotImplementedException();
    }

    @Override
    public AbstractPage clickCreateButtonByItemName(Items items) {
        throw new NotImplementedException();
    }

    @Override
    public int getItemValueByName(Items items) {
        throw new NotImplementedException();
    }


}
