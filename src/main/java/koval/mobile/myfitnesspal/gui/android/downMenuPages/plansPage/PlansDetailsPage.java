package koval.mobile.myfitnesspal.gui.android.downMenuPages.plansPage;


import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.utils.factory.DeviceType;
import koval.mobile.myfitnesspal.gui.common.downMenuPages.plansPage.PlansDetailsPageBase;
import koval.mobile.myfitnesspal.gui.common.downMenuPages.plansPage.PlansPageBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;


@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = PlansPageBase.class)
public class PlansDetailsPage extends PlansDetailsPageBase {

    @FindBy(id = "com.myfitnesspal.android.plans:id/btnStartPlan")
    private ExtendedWebElement startPlanButton;


    @FindBy(id ="com.myfitnesspal.android:id/positiveBtn")
    private ExtendedWebElement continueAlertButton;


    @FindBy(xpath ="//*[@resource-id='com.myfitnesspal.android:id/message' and @text='%s']")
    private ExtendedWebElement alertMessage;

    public PlansDetailsPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isPageOpened(int timeout) {
        return false;
    }


    @Override
    public PlansDetailsPage clickOnStartPlan() {
        startPlanButton.click(TIMEOUT_FIFTEEN);
        return initPage(getDriver(), PlansDetailsPage.class);
    }

    @Override
    public PlansPageBase clickOnContinueAlertMessage() {
        continueAlertButton.click(TIMEOUT_FIFTEEN);
        return initPage(getDriver(), PlansPageBase.class);
    }

    @Override
    public boolean isAlertMessageAboutEndingPlanOpen() {
        return alertMessage.format("If you join this new plan, your current active plan will end. Do you want to continue?").isElementPresent(TIMEOUT_TEN);
    }

}
