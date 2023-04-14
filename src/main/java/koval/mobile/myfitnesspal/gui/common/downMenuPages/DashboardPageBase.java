package koval.mobile.myfitnesspal.gui.common.downMenuPages;

import com.qaprosoft.carina.core.gui.AbstractPage;
import koval.mobile.myfitnesspal.gui.MyAbstractPage;
import koval.mobile.myfitnesspal.gui.common.loginPages.SignUpPageBase;
import koval.mobile.myfitnesspal.gui.common.searchFood.SearchFoodPageBase;
import koval.mobile.myfitnesspal.service.enums.DownMenuElement;
import org.openqa.selenium.WebDriver;


public abstract class DashboardPageBase extends MyAbstractPage {

    public DashboardPageBase(WebDriver driver) {
        super(driver);
    }

    public abstract AbstractPage openPageFromDownMenuByName(DownMenuElement downMenuElement);

    public abstract SearchFoodPageBase clickSearchForFoodContainer();

    public abstract boolean isUserPremium();

    public abstract SignUpPageBase lastMealPopUpSkip();



}
