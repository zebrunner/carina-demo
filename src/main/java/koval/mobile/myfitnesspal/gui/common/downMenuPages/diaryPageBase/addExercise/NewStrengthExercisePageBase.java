package koval.mobile.myfitnesspal.gui.common.downMenuPages.diaryPageBase.addExercise;

import koval.mobile.myfitnesspal.gui.MyAbstractPageBase;
import koval.mobile.myfitnesspal.gui.common.downMenuPages.diaryPageBase.DiaryPageBase;
import koval.mobile.myfitnesspal.service.factories.exerciseFactory.StrengthExercise;
import org.openqa.selenium.WebDriver;


public abstract class NewStrengthExercisePageBase extends MyAbstractPageBase {

    public NewStrengthExercisePageBase(WebDriver driver) {
        super(driver);
    }


    public abstract DiaryPageBase createAnExercise(StrengthExercise strengthExercise);
}
