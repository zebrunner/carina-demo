package koval.mobile.myfitnesspal.gui.common.downMenuPages.dashboardPage;

import com.qaprosoft.carina.core.gui.AbstractPage;
import koval.mobile.myfitnesspal.gui.MyAbstractPageBase;
import koval.mobile.myfitnesspal.gui.common.downMenuPages.dashboardPage.mePage.MePageBase;
import koval.mobile.myfitnesspal.gui.common.loginPages.SignUpPageBase;
import koval.mobile.myfitnesspal.gui.common.actions.addFood.SearchFoodPageBase;
import koval.mobile.myfitnesspal.service.enums.DownMenuElement;
import org.openqa.selenium.WebDriver;


public abstract class DashboardPageBase extends MyAbstractPageBase {

    public DashboardPageBase(WebDriver driver) {
        super(driver);
    }

    public abstract boolean isPageOpened(int timeout);

    public abstract MePageBase openMePage();

    public abstract AbstractPage openPageFromDownMenuByName(DownMenuElement downMenuElement);

    public abstract SearchFoodPageBase clickSearchForFoodContainer();

    public abstract boolean isUserPremium();

    public abstract SignUpPageBase lastMealPopUpSkip();



}
