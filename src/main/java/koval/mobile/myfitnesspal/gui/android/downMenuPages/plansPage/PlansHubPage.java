package koval.mobile.myfitnesspal.gui.android.downMenuPages.plansPage;


import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.utils.factory.DeviceType;
import koval.mobile.myfitnesspal.gui.common.downMenuPages.plansPage.PlansDetailsPageBase;
import koval.mobile.myfitnesspal.gui.common.downMenuPages.plansPage.PlansHubPageBase;
import koval.mobile.myfitnesspal.gui.common.downMenuPages.plansPage.PlansPageBase;
import koval.mobile.myfitnesspal.service.enums.Filters;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;


@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = PlansPageBase.class)
public class PlansHubPage extends PlansHubPageBase {


    @FindBy(xpath = "//*[@resource-id='com.myfitnesspal.android.plans:id/plans_segment_header' and @text=\"Available Plans\"]//following-sibling::*//android.view.ViewGroup")
    private ExtendedWebElement availablePlan;

    @FindBy(xpath ="//*[@resource-id='com.myfitnesspal.android.plans:id/chipGroupFilterTags']/child::*[@text='%s']")
    private ExtendedWebElement filterTagButton;


    public PlansHubPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isPageOpened(int timeout) {
        return false;
    }

    @Override
    public PlansDetailsPageBase clickOnAvailablePlan(Filters filters) {
        filterTagButton.format(filters.getFilters()).click(TIMEOUT_FIFTEEN);
        availablePlan.click(TIMEOUT_FIFTEEN);

        return initPage(getDriver(), PlansDetailsPageBase.class);
    }



}
