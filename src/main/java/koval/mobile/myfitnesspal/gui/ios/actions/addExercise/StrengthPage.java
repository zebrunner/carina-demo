package koval.mobile.myfitnesspal.gui.ios.actions.addExercise;


import com.zebrunner.carina.utils.exception.NotImplementedException;
import com.zebrunner.carina.utils.factory.DeviceType;
import koval.mobile.myfitnesspal.gui.android.actions.addExercise.NewStrengthExercisePage;
import koval.mobile.myfitnesspal.gui.common.actions.addExercise.StrengthPageBase;
import org.openqa.selenium.WebDriver;


@DeviceType(pageType = DeviceType.Type.IOS_PHONE, parentClass = StrengthPageBase.class)
public class StrengthPage extends StrengthPageBase {


    public StrengthPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public NewStrengthExercisePage clickOnCreateExerciseButton() {
        throw new NotImplementedException();
    }
}
