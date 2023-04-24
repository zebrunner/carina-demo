package koval.mobile.myfitnesspal.gui.android.downMenuPages.diaryPage.addExercise;


import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.utils.factory.DeviceType;
import koval.mobile.myfitnesspal.gui.common.downMenuPages.diaryPageBase.addExercise.CardiovascularPageBase;
import koval.mobile.myfitnesspal.gui.common.downMenuPages.diaryPageBase.addExercise.NewCardioExercisePageBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;


@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = CardiovascularPageBase.class)
public class CardiovascularPage extends CardiovascularPageBase {


    @FindBy(xpath = "//android.widget.ScrollView[@content-desc=\"ExerciseSearchActivity\"]/android.widget.LinearLayout/" +
            "android.view.ViewGroup/android.widget.TextView")
    private ExtendedWebElement title;

    @FindBy(id = "com.myfitnesspal.android:id/createNewExercise")
    private ExtendedWebElement createNewExerciseButton;


    public CardiovascularPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isPageOpened() {
        return isPageOpened(title, CARDIO_TEXT);
    }


    @Override
    public NewCardioExercisePageBase clickOnCreateExerciseButton() {

        createNewExerciseButton.click();
        return initPage(getDriver(), NewCardioExercisePageBase.class);
    }

}
