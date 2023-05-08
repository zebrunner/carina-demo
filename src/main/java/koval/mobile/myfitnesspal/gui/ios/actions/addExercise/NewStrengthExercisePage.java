package koval.mobile.myfitnesspal.gui.ios.actions.addExercise;


import com.zebrunner.carina.utils.exception.NotImplementedException;
import com.zebrunner.carina.utils.factory.DeviceType;
import koval.mobile.myfitnesspal.gui.common.downMenuPages.DiaryPageBase;
import koval.mobile.myfitnesspal.gui.common.actions.addExercise.NewStrengthExercisePageBase;
import koval.mobile.myfitnesspal.service.factories.exerciseFactory.StrengthExercise;
import org.openqa.selenium.WebDriver;


@DeviceType(pageType = DeviceType.Type.IOS_PHONE, parentClass = NewStrengthExercisePageBase.class)
public class NewStrengthExercisePage extends NewStrengthExercisePageBase {


    public NewStrengthExercisePage(WebDriver driver) {
        super(driver);
    }

    @Override
    public DiaryPageBase createAnExercise(StrengthExercise strengthExercise) {
        throw new NotImplementedException();
    }
}
