package koval.mobile.myfitnesspal.gui.ios.actions.addExercise;


import com.zebrunner.carina.utils.factory.DeviceType;
import koval.mobile.myfitnesspal.gui.common.actions.addExercise.WorkoutRoutinesPageBase;
import org.openqa.selenium.WebDriver;


@DeviceType(pageType = DeviceType.Type.IOS_PHONE, parentClass = WorkoutRoutinesPageBase.class)
public class WorkoutRoutinesPage extends WorkoutRoutinesPageBase {


    public WorkoutRoutinesPage(WebDriver driver) {
        super(driver);
    }
}
