package koval.mobile.myfitnesspal.gui.ios.downMenuPages.diaryPage.addExercise;


import com.zebrunner.carina.utils.factory.DeviceType;
import koval.mobile.myfitnesspal.gui.common.downMenuPages.diaryPageBase.addExercise.WorkoutRoutinesPageBase;
import org.openqa.selenium.WebDriver;


@DeviceType(pageType = DeviceType.Type.IOS_PHONE, parentClass = WorkoutRoutinesPageBase.class)
public class WorkoutRoutinesPage extends WorkoutRoutinesPageBase {


    public WorkoutRoutinesPage(WebDriver driver) {
        super(driver);
    }
}
