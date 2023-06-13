package koval.mobile.myfitnesspal.gui.common.downMenuPages.plansPage.workout;

import koval.mobile.myfitnesspal.gui.MyAbstractPageBase;
import koval.mobile.myfitnesspal.gui.common.downMenuPages.plansPage.PlansTaskManagerPageBase;
import org.openqa.selenium.WebDriver;


public abstract class LogWorkoutPageBase extends MyAbstractPageBase {

    public LogWorkoutPageBase(WebDriver driver) {
        super(driver);
    }


    public abstract PlansTaskManagerPageBase clickOnCheckmark();
}
