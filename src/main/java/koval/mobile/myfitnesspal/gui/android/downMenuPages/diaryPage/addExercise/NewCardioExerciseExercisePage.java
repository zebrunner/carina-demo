package koval.mobile.myfitnesspal.gui.android.downMenuPages.diaryPage.addExercise;


import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.utils.factory.DeviceType;
import koval.mobile.myfitnesspal.gui.common.downMenuPages.diaryPageBase.DiaryPageBase;
import koval.mobile.myfitnesspal.gui.common.downMenuPages.diaryPageBase.addExercise.NewCardioExercisePageBase;
import koval.mobile.myfitnesspal.service.factories.exerciseFactory.CardioExercise;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;


@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = NewCardioExercisePageBase.class)
public class NewCardioExerciseExercisePage extends NewCardioExercisePageBase {


    @FindBy(xpath = "//*[@text='%s']")
    private ExtendedWebElement itemByText;

    @FindBy(id = "com.myfitnesspal.android:id/description")
    private ExtendedWebElement descriptionField;

    @FindBy(id = "com.myfitnesspal.android:id/inputExerciseInterval")
    private ExtendedWebElement exerciseIntervalField;

    @FindBy(xpath = "//android.view.ViewGroup[@content-desc=\"NewCardio\"]/android.widget.LinearLayout/android.view.ViewGroup/android.widget.TextView")
    private ExtendedWebElement title;

    @FindBy(id = "com.myfitnesspal.android:id/inputCaloriesBurned")
    private ExtendedWebElement caloriesBurnedField;

    public NewCardioExerciseExercisePage(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isPageOpened() {
        return isPageOpened(title, NEW_EXERCISE_TEXT);
    }


    @Override
    public DiaryPageBase createAnExercise(CardioExercise cardioExercise) {

        descriptionField.type(cardioExercise.getDescription());
        exerciseIntervalField.type(String.valueOf(cardioExercise.getIntervals()));
        caloriesBurnedField.type(String.valueOf(cardioExercise.getCaloriesBurned()));

        itemByText.format(SAVE).click(TIMEOUT_FIFTEEN);

        return initPage(getDriver(), DiaryPageBase.class);
    }
}
