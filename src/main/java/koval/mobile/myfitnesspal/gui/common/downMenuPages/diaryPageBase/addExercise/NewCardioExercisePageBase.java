package koval.mobile.myfitnesspal.gui.common.downMenuPages.diaryPageBase.addExercise;

import koval.mobile.myfitnesspal.gui.MyAbstractPageBase;
import koval.mobile.myfitnesspal.gui.common.downMenuPages.diaryPageBase.DiaryPageBase;
import koval.mobile.myfitnesspal.service.factories.exerciseFactory.CardioExercise;
import org.openqa.selenium.WebDriver;


public abstract class NewCardioExercisePageBase extends MyAbstractPageBase {

    public NewCardioExercisePageBase(WebDriver driver) {
        super(driver);
    }


    public abstract DiaryPageBase createAnExercise(CardioExercise cardioExercise);
}
