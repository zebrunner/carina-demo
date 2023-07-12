package koval.web.myfitnesspal.pages.menuPages.mainMenu.exerciseMenu.myExercise;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import koval.web.myfitnesspal.pages.MyAbstractPage;
import koval.web.myfitnesspal.pages.menuPages.mainMenu.exerciseMenu.ExerciseDiary;
import koval.web.myfitnesspal.service.factories.exerciseFactory.Exercise;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class CreateExercise extends MyAbstractPage {

    @FindBy(id = "exercise_description")
    ExtendedWebElement descriptionField;

    @FindBy(id = "exercise_exercise_type")
    ExtendedWebElement typeField;

    @FindBy(xpath = "//*[@id='exercise_exercise_type']//child::*[text()='%s']")
    ExtendedWebElement typeOptionField;

    @FindBy(xpath = "//*[@id=\"exercise_exercise_type\"]/option[2]")
    ExtendedWebElement selectedOptionField;

    @FindBy(id = "exercise_sets")
    ExtendedWebElement setsField;

    @FindBy(id = "exercise_quantity")
    ExtendedWebElement repetitionField;

    @FindBy(xpath = "//input[@value=\"Add Exercise\"]")
    ExtendedWebElement addExerciseButton;

    public CreateExercise(WebDriver driver) {
        super(driver);
    }

    public ExerciseDiary createExercise(Exercise exercise) {
        descriptionField.type(exercise.getDescription());
        typeField.click();
        typeOptionField.format(exercise.getType()).click();
        selectedOptionField.click();
        setsField.type(String.valueOf(exercise.getSets()));
        repetitionField.type(String.valueOf(exercise.getRepetitions()));
        addExerciseButton.click();
        return new ExerciseDiary(driver);
    }

}
