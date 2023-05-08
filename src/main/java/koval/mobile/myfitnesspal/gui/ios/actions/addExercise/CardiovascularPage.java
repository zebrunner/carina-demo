package koval.mobile.myfitnesspal.gui.ios.actions.addExercise;


import com.zebrunner.carina.utils.exception.NotImplementedException;
import com.zebrunner.carina.utils.factory.DeviceType;
import koval.mobile.myfitnesspal.gui.common.actions.addExercise.CardiovascularPageBase;
import koval.mobile.myfitnesspal.gui.common.actions.addExercise.NewCardioExercisePageBase;
import org.openqa.selenium.WebDriver;


@DeviceType(pageType = DeviceType.Type.IOS_PHONE, parentClass = CardiovascularPageBase.class)
public class CardiovascularPage extends CardiovascularPageBase {


    public CardiovascularPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public NewCardioExercisePageBase clickOnCreateExerciseButton() {
        throw new NotImplementedException();
    }
}
