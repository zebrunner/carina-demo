package koval.mobile.myfitnesspal.gui.android.downMenuPages.plansPage;


import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.utils.factory.DeviceType;
import koval.mobile.myfitnesspal.gui.common.downMenuPages.plansPage.PlansDetailsPageBase;
import koval.mobile.myfitnesspal.gui.common.downMenuPages.plansPage.PlansTaskManagerScreenBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;


@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = PlansDetailsPageBase.class)
public class PlansDetailsPage extends PlansDetailsPageBase {

    @FindBy(id = "com.myfitnesspal.android.plans:id/btnStartPlan")
    private ExtendedWebElement startPlanButton;

    @FindBy(id = "com.myfitnesspal.android:id/positiveBtn")
    private ExtendedWebElement continueAlertButton;

    @FindBy(xpath = "//*[@resource-id='com.myfitnesspal.android:id/message' and @text='%s']")
    private ExtendedWebElement alertMessage;



    @FindBy(xpath = "//*[@resource-id='com.myfitnesspal.android.plans:id/internalToolbar']/child::*[@text='%s']")
    private ExtendedWebElement title;


    public PlansDetailsPage(WebDriver driver) {
        super(driver);
    }


    @Override
    public boolean isPageOpened(int timeout) {
        return title.format(PLAN_DETAILS).isElementPresent(timeout);
    }


    @Override
    public PlansDetailsPageBase clickOnStartPlan() {
        startPlanButton.click(TIMEOUT_FIFTEEN);
        return initPage(getDriver(), PlansDetailsPageBase.class);
    }

    @Override
    public PlansTaskManagerScreenBase clickOnContinueAlertMessageIfPresent() {
        continueAlertButton.clickIfPresent(TIMEOUT_FIFTEEN);
        return initPage(getDriver(), PlansTaskManagerScreenBase.class);
    }

    @Override
    public boolean isAlertMessageAboutEndingPlanOpen() {
        return alertMessage.format(ENDING_PLAN_MESSAGE).isElementPresent(TIMEOUT_TEN);
    }

}
