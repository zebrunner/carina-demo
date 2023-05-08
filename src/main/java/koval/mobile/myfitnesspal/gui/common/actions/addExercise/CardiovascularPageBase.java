package koval.mobile.myfitnesspal.gui.common.actions.addExercise;

import koval.mobile.myfitnesspal.gui.MyAbstractPageBase;
import org.openqa.selenium.WebDriver;


public abstract class CardiovascularPageBase extends MyAbstractPageBase {

    public CardiovascularPageBase(WebDriver driver) {
        super(driver);
    }


    public abstract NewCardioExercisePageBase clickOnCreateExerciseButton();
}
