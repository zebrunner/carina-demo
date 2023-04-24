package koval.mobile.myfitnesspal.gui.common.downMenuPages.diaryPageBase.addExercise;

import koval.mobile.myfitnesspal.gui.MyAbstractPageBase;
import koval.mobile.myfitnesspal.gui.android.downMenuPages.diaryPage.addExercise.NewStrengthExercisePage;
import org.openqa.selenium.WebDriver;


public abstract class StrengthPageBase extends MyAbstractPageBase {

    public StrengthPageBase(WebDriver driver) {
        super(driver);
    }

    public abstract NewStrengthExercisePage clickOnCreateExerciseButton();
}
