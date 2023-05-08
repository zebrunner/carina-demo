package koval.mobile.myfitnesspal.gui.android.downMenuPages.dashboardPage;


import com.qaprosoft.carina.core.gui.AbstractPage;
import com.zebrunner.carina.utils.factory.DeviceType;

import koval.mobile.myfitnesspal.gui.android.modal.DownMenuModal;
import koval.mobile.myfitnesspal.gui.common.downMenuPages.dashboardPage.DashboardPageBase;
import koval.mobile.myfitnesspal.gui.common.downMenuPages.dashboardPage.mePage.MePageBase;
import koval.mobile.myfitnesspal.gui.common.loginPages.SignUpPageBase;
import koval.mobile.myfitnesspal.gui.common.actions.addFood.SearchFoodPageBase;
import koval.mobile.myfitnesspal.service.enums.DownMenuElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;


@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = DashboardPageBase.class)
public class DashboardPage extends DashboardPageBase {

    @FindBy(id = "com.myfitnesspal.android:id/bottomNavigationBar")
    private DownMenuModal downMenuModal;

    public DashboardPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isPageOpened() {

        return itemByText.format(CALORIES_STRING).isElementPresent(TIMEOUT_FIVE);

    }

    @Override
    public MePageBase openMePage() {
        itemByContent.format(USER_AVATAR).click(TIMEOUT_TEN);
        return initPage(getDriver(), MePageBase.class);
    }

    @Override
    public AbstractPage openPageFromDownMenuByName(DownMenuElement downMenuElement) {

        return downMenuModal.openPageByName(downMenuElement);
    }


    @Override
    public SearchFoodPageBase clickSearchForFoodContainer() {

        itemByText.format(SEARCH_FOR_FOOD).click(TIMEOUT_TEN);
        return initPage(getDriver(), SearchFoodPageBase.class);

    }

    @Override
    public boolean isUserPremium() {

        return !itemByText.format(GO_PREMIUM).isElementPresent(TIMEOUT_FIVE);
    }


    @Override
    public SignUpPageBase lastMealPopUpSkip() {

        if (itemByText.format(SELECT_A_MEAL).isElementPresent(TIMEOUT_FIVE)) {
            itemByText.format(SKIP).click(TIMEOUT_TEN);
        }

        return initPage(getDriver(), SignUpPageBase.class);
    }


}
