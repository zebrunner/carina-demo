package koval.mobile.myfitnesspal.gui.android.downMenuPages.plansPage;


import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import com.zebrunner.carina.utils.factory.DeviceType;
import koval.mobile.myfitnesspal.gui.android.modal.DownMenuModal;
import koval.mobile.myfitnesspal.gui.common.downMenuPages.plansPage.PlansPageBase;
import koval.mobile.myfitnesspal.service.enums.DownMenuElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;


@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = PlansPageBase.class)
public class PlansPage extends PlansPageBase {

    @FindBy(xpath = "//*[@resource-id='com.myfitnesspal.android:id/toolbar']/child::*[@class='android.widget.TextView']")
    private ExtendedWebElement title;

    @FindBy(id = "com.myfitnesspal.android:id/bottomNavigationBar")
    private DownMenuModal downMenuModal;


    public PlansPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isPageOpened(int timeout) {
        return isPageOpened(title, DownMenuElement.PLANS.getPageName(), timeout);
    }

    @Override
    public boolean isPlansHubScreenOpen() {
        return itemByText.format(FIND_PLAN).isElementPresent(TIMEOUT_TEN);
    }

    @Override
    public AbstractPage openPageFromDownMenuByName(DownMenuElement downMenuElement) {
        return downMenuModal.openPageByName(downMenuElement);
    }
}
