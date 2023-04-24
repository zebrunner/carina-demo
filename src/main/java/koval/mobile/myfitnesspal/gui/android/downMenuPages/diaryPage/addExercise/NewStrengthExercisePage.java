package koval.mobile.myfitnesspal.gui.android.downMenuPages.diaryPage.addExercise;


import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.utils.factory.DeviceType;
import koval.mobile.myfitnesspal.gui.common.downMenuPages.diaryPageBase.DiaryPageBase;
import koval.mobile.myfitnesspal.gui.common.downMenuPages.diaryPageBase.addExercise.NewStrengthExercisePageBase;
import koval.mobile.myfitnesspal.service.factories.exerciseFactory.StrengthExercise;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;


@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = NewStrengthExercisePageBase.class)
public class NewStrengthExercisePage extends NewStrengthExercisePageBase {


    @FindBy(xpath = "//*[@text='%s']")
    private ExtendedWebElement itemByText;

    @FindBy(id = "com.myfitnesspal.android:id/description")
    private ExtendedWebElement descriptionField;


    @FindBy(id = "com.myfitnesspal.android:id/inputSetCount")
    private ExtendedWebElement setCountField;


    @FindBy(id = "com.myfitnesspal.android:id/inputRepetitionsPerSet")
    private ExtendedWebElement repetitionsPerSetField;

    public NewStrengthExercisePage(WebDriver driver) {
        super(driver);
    }


    @Override
    public DiaryPageBase createAnExercise(StrengthExercise strengthExercise) {

        descriptionField.type(strengthExercise.getDescription());
        setCountField.type(String.valueOf(strengthExercise.getSets()));
        repetitionsPerSetField.type(String.valueOf(strengthExercise.getReps()));

        itemByText.format(SAVE).click(TIMEOUT_FIVE);

        return initPage(getDriver(), DiaryPageBase.class);
    }
}
