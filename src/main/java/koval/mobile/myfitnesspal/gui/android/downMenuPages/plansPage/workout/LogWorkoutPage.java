package koval.mobile.myfitnesspal.gui.android.downMenuPages.plansPage.workout;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.utils.factory.DeviceType;
import koval.mobile.myfitnesspal.gui.common.downMenuPages.plansPage.PlansTaskManagerPageBase;
import koval.mobile.myfitnesspal.gui.common.downMenuPages.plansPage.workout.LogWorkoutPageBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;


@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = LogWorkoutPageBase.class)
public class LogWorkoutPage extends LogWorkoutPageBase {

    public LogWorkoutPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//android.widget.Button[@content-desc=\"Done\"]")
    private ExtendedWebElement checkmarkByContentDesc;


    @Override
    public PlansTaskManagerPageBase clickOnCheckmark() {
        checkmarkByContentDesc.click(TIMEOUT_FIFTEEN);
        return initPage(getDriver(), PlansTaskManagerPageBase.class);
    }

}
