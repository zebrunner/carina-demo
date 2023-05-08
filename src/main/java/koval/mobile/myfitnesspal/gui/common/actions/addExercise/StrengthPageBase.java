package koval.mobile.myfitnesspal.gui.common.actions.addExercise;

import koval.mobile.myfitnesspal.gui.MyAbstractPageBase;
import koval.mobile.myfitnesspal.gui.android.actions.addExercise.NewStrengthExercisePage;
import org.openqa.selenium.WebDriver;


public abstract class StrengthPageBase extends MyAbstractPageBase {

    public StrengthPageBase(WebDriver driver) {
        super(driver);
    }

    public abstract NewStrengthExercisePage clickOnCreateExerciseButton();
}
