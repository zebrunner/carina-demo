package koval.mobile.myfitnesspal.gui.android.downMenuPages;


import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import com.zebrunner.carina.utils.factory.DeviceType;

import koval.mobile.myfitnesspal.gui.android.modal.DownMenuModal;
import koval.mobile.myfitnesspal.gui.common.downMenuPages.DashboardPageBase;
import koval.mobile.myfitnesspal.gui.common.loginPages.SignUpPageBase;
import koval.mobile.myfitnesspal.service.enums.DownMenuElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;


@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = DashboardPageBase.class)
public class DashboardPage extends DashboardPageBase {


    @FindBy(id = "com.myfitnesspal.android:id/bottomNavigationBar")
    private DownMenuModal downMenuModal;

    @FindBy(xpath = "//*[@text='%s']")
    private ExtendedWebElement itemByText;

    @FindBy(xpath = "//android.view.View[@content-desc='%s']")
    private ExtendedWebElement itemByContentDesc;


    public DashboardPage(WebDriver driver) {
        super(driver);
    }


    @Override
    public boolean isPageOpened() {

        return itemByContentDesc.format(CALORIES_CARD).isElementPresent(TIMEOUT_FIVE);
    }

    @Override
    public AbstractPage openPageFromDownMenuByName(DownMenuElement downMenuElement) {

        return downMenuModal.openPageByName(downMenuElement);
    }


    @Override
    public boolean isUserPremium() {

        return !itemByText.format(GO_PREMIUM).isElementPresent(TIMEOUT_FIVE);
    }


    @Override
    public SignUpPageBase lastMealPopUpSkip() {

        if (itemByText.format(SELECT_A_MEAL).isElementPresent(TIMEOUT_FIVE)) {
            itemByText.format(SKIP).click();
        }

        return initPage(getDriver(), SignUpPageBase.class);
    }


}
