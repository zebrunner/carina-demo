package koval.mobile.myfitnesspal.gui.ios.downMenuPages.diaryPage.addExercise;


import com.zebrunner.carina.utils.exception.NotImplementedException;
import com.zebrunner.carina.utils.factory.DeviceType;
import koval.mobile.myfitnesspal.gui.common.downMenuPages.diaryPageBase.addExercise.CardiovascularPageBase;
import koval.mobile.myfitnesspal.gui.common.downMenuPages.diaryPageBase.addExercise.NewCardioExercisePageBase;
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
